package 종합.예제12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제12.model.dao.BoardDao;
import 종합.예제12.model.dto.BoardDto;

@Service
public class BoardService {
    @Autowired // dao 의존성 주입
    private BoardDao boardDao;

    // 게시물 등록
    public boolean boardWrite(BoardDto boardDto){
        System.out.println("BoardService.boardWrite");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    } // func e

} // class e
