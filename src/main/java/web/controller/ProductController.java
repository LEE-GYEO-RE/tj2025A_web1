package web.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.model.dto.ProductDto;
import web.service.FileService;
import web.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired private ProductService productService;
    @Autowired private FileService fileService; // 업로드할때 필요한 서비스

    // [1] 제품 등록
    @PostMapping("/create")
    public int createProduct(ProductDto productDto , HttpSession session ){
        // 1. 로그인 상태 확인 후 , 비로그인이면 0 반환
        if( session.getAttribute("loginMno") == null ) return 0;
        // 2. 로그인 중이라면 제품정보를 DB 처리
        int loginMno = (int)session.getAttribute("loginMno");
        // 현재 로그인된 회원번호를 제품등록 dto에 포함
        productDto.setMno(loginMno);
        int result = productService.createProduct(productDto);

        // 3. 만약에 업로드 파일이 존재하면 업로드 서비스 호출하여 업로드 처리
        // 만약 제품등록 되면서 첨부파일이 비어있지 않고 , 첨부파일 목록에서 첫번째 첨부파일이 비어있지 않으면
        if( result > 0 && !productDto.getUploads().isEmpty() && !productDto.getUploads().get(0).isEmpty()){
            // 파일 업로드 , List 타입을 반복문 이용하여 여러번 업로드
            for( MultipartFile multipartFile : productDto.getUploads()){
                // 업로드 서비스
                String fileName = fileService.fileUpload(multipartFile);
                if(fileName == null ) return 0; // 만약에 파일명이 null 이면 업로드 실패 , 반복문 중지
                // 업로드 성공시 , 업로드 된 파일명을 db에 저장
                boolean result2 = productService.createProductImage( result , fileName ); // result : 제품등록된 pno , fileName : 업로드된 파일명
                if(result2 == false) return 0; // 만약 db에 이미지 저장실패 시 0

            } // for e
        }  // if e
        // 4. 처리된 업로드파일 DB처리
        return result;
    } // func e

    // [2] 제품 전체 조회
    @GetMapping("/list")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    } // func e

    // [3] 제품 상세 조회
    @GetMapping("/find")
    public ProductDto getProduct( @RequestParam int pno){
        return productService.getProduct(pno);
    } // func e

} // class e
