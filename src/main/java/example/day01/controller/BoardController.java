package example.day01.controller;

import example.day01.model.dao.BoardDao;
import example.day01.model.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class BoardController {

    // 싱글톤
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }

    // dao 싱글톤 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // (1) 등록 기능 구현
    @PostMapping
    public boolean boardWrite( String bcontent , String bwriter ){
        // 1. 여러가지 유효성검사 (패스!)

        // 2. 데이터문제 없으면 묶음(객체)으로 만들기
        BoardDto boardDto = new BoardDto(bcontent , bwriter);   // 두개만 있는 생성자 없으면 빨간줄 뜸.
        // 생성자 없으면 ()안에 bno 자리에 의미없는 기본값 0 ,null 넣어줘도 됨.

        // 3. 객체화 된 dto를 dao에게 전달후 결과를 받는다.
        boolean result = boardDao.boardWrite( boardDto );

        // 4. 결과를 view에게 반환/리턴한다.
        return result;
    } // func e

    // (2) 전체 조회 기능 구현
    @GetMapping
    public ArrayList<BoardDto> boardPrint(){
        // 유효성 검사 패스
        // dao에게 요청후 결과 받기
        ArrayList<BoardDto> result = boardDao.boardPrint();
        return result;
    } // func e


}// class e
