package 종합.예제12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

@RestController
@RequestMapping("/board") // 공통 URL
public class BoardController {
    @Autowired // service 의존성 주입
    private BoardService boardService;

    // 게시물 등록
    @PostMapping("") // 주소 생략
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("boardDto = " + boardDto);
        System.out.println("BoardController.boardWrite");
        boolean result = boardService.boardWrite(boardDto);
        return result;
    } // func e

} // class e
