package 종합.실습5.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class WaitingDto {
    private int wno;
    private String phone;
    private int count;
}
