package example.day08._2MVC.controller;

import example.day08._2MVC.service.MvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // [1] Controller 빈 등록
public class MvcController {
    // 스프링 아키텍쳐 구조 파악

    // MVC 패턴의 기본적인 단계에서 IOC DI 가 들어감
    // JS 통신 -> controller -> service -> dao -> 외부 DB connect
    // dao 결과물 return -> service -> controller -> js 결과 송신

    // JS fetch : wep , app
    // js 와  controller는 json 이동
    // db 와 dao 는 sql 이동
    // 나머지는 dto 이동
    @Autowired // [2] Service 빈 주입
    private MvcService mvcService;

    // [3] 기능 처리
    @GetMapping("/day08/mvc")
    public void method(){
        System.out.println("MvcController.method");
        mvcService.method(); // 서비스의 메소드 호출
    }
}
