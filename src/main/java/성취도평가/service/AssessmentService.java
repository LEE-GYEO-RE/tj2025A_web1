package 성취도평가.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 성취도평가.model.dao.AssessmentDao;
import 성취도평가.model.dto.AssessmentDto;
import 성취도평가.model.dto.MemberDto;

import java.util.List;

@Service
public class AssessmentService {
    @Autowired private AssessmentDao assessmentDao;

    // 등록
    public boolean memberAdd(MemberDto memberDto){
        System.out.println("AssessmentService.memberAdd");
        System.out.println("memberDto = " + memberDto);
        boolean result = assessmentDao.memberAdd(memberDto);
        return result;
    } // func e

    // 회원 전체 조회
    public List<MemberDto> memberPrint(){
        System.out.println("AssessmentService.memberPrint");
        List<MemberDto> result = assessmentDao.memberPrint();
        return result;
    } // func e

    // 회원 정보 수정
    public boolean memberUpdate(MemberDto memberDto){
        System.out.println("AssessmentService.memberUpdate");
        System.out.println("memberDto = " + memberDto);
        boolean result = assessmentDao.memberUpdate(memberDto);
        return result;
    } // func e

    // 회원 매출 조회
    public List<AssessmentDto> moneyPrint(){
        System.out.println("AssessmentService.moneyPrint");
        List<AssessmentDto> result = assessmentDao.moneyPrint();
        return result;
    } // func e

} // class e
