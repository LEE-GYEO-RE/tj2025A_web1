package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class BoardDao extends Dao { // extends Dao 할 경우 db연동 상속받아 사용한다.
    // 다음 레이어(계층) 없어서 @AutoWired 없다.
    public void method(){
        System.out.println("BoardDao");
        try{
            String sql ="select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("var1");
            }
        } catch (Exception e) { System.out.println(e);   }
    } // try e

    // 게시물 등록
    public boolean boardWrite(BoardDto boardDto){
        try {
            String sql = "insert into board ( bcontent , bwriter ) values (? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int count = ps.executeUpdate();
            if(count==1) return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    } // func e
} // func e
