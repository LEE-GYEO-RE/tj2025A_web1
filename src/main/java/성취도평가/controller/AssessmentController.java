package 성취도평가.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 성취도평가.model.dto.AssessmentDto;
import 성취도평가.model.dto.MemberDto;
import 성취도평가.service.AssessmentService;

import java.util.List;

@RestController
@RequestMapping("/member")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    // 등록
    @PostMapping("/add")
    public boolean memberAdd(@RequestBody MemberDto memberDto) {
        System.out.println("AssessmentController.memberAdd");
        System.out.println("memberDto = " + memberDto);
        boolean result = assessmentService.memberAdd(memberDto);
        return result;
    } // func e

    // 회원번호
    @GetMapping("/next-custno")
    public int getNextCustno() {
        return assessmentService.getNextCustno();
    } // func e

    // 회원 전체 조회
    @GetMapping("")
    public List<MemberDto> memberPrint() {
        System.out.println("AssessmentController.memberPrint");
        List<MemberDto> result = assessmentService.memberPrint();
        return result;
    } // func e

    // 회원 정보 수정
    @PutMapping("/update")
    public boolean memberUpdate(@RequestBody MemberDto memberDto) {
        System.out.println("AssessmentController.memberUpdate");
        boolean result = assessmentService.memberUpdate(memberDto);
        return result;
    } // func e

    // 회원 매출 조회
    @GetMapping("/money")
    public List<AssessmentDto> moneyPrint() {
        System.out.println("AssessmentController.moneyPrint");
        List<AssessmentDto> result = assessmentService.moneyPrint();
        return result;
    } // func e

} // class e
