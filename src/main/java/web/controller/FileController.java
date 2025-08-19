package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController // 스프링 컨테이너의 빈 등록
@RequestMapping("/file")
public class FileController {
    @Autowired // 스프링 컨테이너에서 빈 꺼내오기
    private FileService fileService;

    // [1] 업로드
    // POST : http://localhost:8080/file/upload
    // [HEADER] : Content-Type : multipart/form-data
    // BODY : Add form parameter : multipart/form-data
    // name : multipartFile  , file 로 선택!
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile ){
        System.out.println("multipartFile = " + multipartFile);
        System.out.println("FileController.fileUpload");
        String result = fileService.fileUpload(multipartFile);
        return result;
    } // func e

    // [2] 다운로드
    // GET : http://localhost:8080/file/download?fileName=1d0f2775-6d82-4969-bf66-5629eacf2808_지피티.png
    @GetMapping("/download")
    public void fileDownload(@RequestParam String fileName , HttpServletResponse response ){
        fileService.fileDownload(fileName , response );
    } // func e

    // [3] 삭제
    // GET : http://localhost:8080/file/delete?fileName=1d0f2775-6d82-4969-bf66-5629eacf2808_지피티.png
    @GetMapping("/delete")
    public boolean fileDelete(@RequestParam String fileName ){
        boolean result = fileService.fileDelete(fileName);
        return result;
    } // func e

} // class e
