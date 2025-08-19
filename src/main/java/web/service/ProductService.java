package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.ProductDao;
import web.model.dto.ProductDto;

import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductDao productDao;

    // 제품 등록
    public int createProduct(ProductDto productDto){
        // DB에 제품 저장
        return productDao.createProduct(productDto);
    } // func e

    // [1-2] 제품 이미지 등록
    public boolean createProductImage( int pno , String fileName ){
        return productDao.createProductImage(pno , fileName ); // DB에 제품 이미지 저장
    }

    // 제품 전체 조회 + 이미지 포함
    public List<ProductDto> getAllProduct(){
        // 모든 제품의 정보 조회
        List<ProductDto> productDtoList = productDao.getAllProduct();
        // 모든 제품의 이미지 조회
        for( ProductDto productDto : productDtoList ){ // 조회된 모든 제품dto를 반복
            List<String> images =
                productDao.getProductImages(productDto.getPno()); // 특정한 제품의 pno를 이용하여 모든 제품 이미지 조회
            productDto.setImages(images); // 조회한 모든 이미지명을 특정한 제품의 dto 포함
        } // for e

        // 반환
        return productDtoList;
    } // func e

    // 제품 상세 조회
    public ProductDto getProduct( int pno ){
        // 특정 제품 조회
        ProductDto dto = productDao.getProduct(pno);
        // 만약 조회 했으면 제품의 이미지명 조회
        if( dto != null ){
            List<String> productimg = productDao.getProductImages(dto.getPno());
            dto.setImages(productimg);
        }
        return dto;
    } // func e

} // class e
