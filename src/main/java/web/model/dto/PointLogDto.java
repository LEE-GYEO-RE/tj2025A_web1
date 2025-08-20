package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class PointLogDto {
    private int plno;   // 포인트 로그번호
    private int mno;    // 회원번호
    private int plpoint;    // 포인트 금액
    private String plcomment; // 사유
    private String pldate;  // 포인트 업데이트 날짜
}
