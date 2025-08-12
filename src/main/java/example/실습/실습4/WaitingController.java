package example.실습.실습4;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waiting")
public class WaitingController {

    // dao 싱글톤 불러오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 대기 등록
    @PostMapping("/add")
    public boolean addWaiting(@RequestBody WaitingDto waitingDto) {
        System.out.println("WaitingController.addWaiting");
        System.out.println("waitingDto = " + waitingDto);
        return waitingDao.addWaiting(waitingDto);
    } // func e

    // 대기 등록 현황 조회
    @GetMapping("/print")
    public List<WaitingDto> waitingPrint() {
        System.out.println("WaitingController.waitingPrint");
        return waitingDao.waitingPrint();
    } // func e

}
