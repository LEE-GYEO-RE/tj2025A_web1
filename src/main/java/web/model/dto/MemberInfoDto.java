package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.model.dao.PointDao;

import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Data
public class MemberInfoDto {
    private MemberDto memberDto;
    private List<PointLogDto> pointLogDtos;
}
