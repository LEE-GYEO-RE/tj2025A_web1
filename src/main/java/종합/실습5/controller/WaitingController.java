package 종합.실습5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.실습5.model.dto.WaitingDto;
import 종합.실습5.service.WaitingService;

import java.util.List;

@RestController
@RequestMapping("/waiting")
public class WaitingController {
    @Autowired private WaitingService waitingService;


    // 등록
    @PostMapping("")
    public boolean waitingAdd(@RequestBody WaitingDto waitingDto){
        System.out.println("WaitingController.waitingAdd");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingAdd(waitingDto);
        return result;
    } // func e

    // 전체 조회
    @GetMapping("")
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingController.waitingPrint");
        List<WaitingDto> result = waitingService.waitingPrint();
        return result;
    } // func e

    // 개별 조회
    @GetMapping("/find")
    public WaitingDto waitingFind(@RequestParam int wno ){
        System.out.println("WaitingController.waitingFind");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingService.waitingFind(wno);
        return result;
    } // func e

    // 개별 삭제
    @DeleteMapping("")
    public boolean waitingDelete(@RequestParam int wno ){
        System.out.println("WaitingController.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingService.waitingDelete(wno);
        return result;
    } // func e

    // 개별 수정
    @PutMapping("")
    public boolean waitingUpdate(@RequestBody WaitingDto waitingDto){
        System.out.println("WaitingController.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingUpdate(waitingDto);
        return result;
    } // func e


} // class e











