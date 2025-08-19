package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Data
public class ProductDto {
    // 멤버변수는 기본(관례)로 DB 테이블과 동일하게
    private int pno;
    private String pname;
    private int pprice;
    private String pcomment;
    private String pdate;
    private double plat;
    private double plng;
    private int mno;

    // + 커스텀(부가적인) 정보 포함

    // 1) 업로드에 사용할 multipartFile 객체를 list 탕ㅂ으로 여러개 첨부파일 받아오기
    private List<MultipartFile> uploads;
    // 2) 조회시 업로드된 파일명을 문자열로 조회하기
    private List<String> images;
    // 3) 판매자의 아이디
    private int mid;

    // db에 업로드 하는 거 아님 . db에는 이미지파일 이름만 저장함
    // 진짜 파일은 build에 업로드 하는 거임.


}
