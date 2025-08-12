package 성취도평가.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AssessmentDto {
    private int custno;
    private String custname;
    private String grade;
    private int sales;
}
