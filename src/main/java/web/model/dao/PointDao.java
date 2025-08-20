package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.PointLogDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PointDao extends Dao {

    // [1-2] 회원가입 완료 시 포인트 적립
    public boolean signPoint(PointLogDto pointLogDto){
        try {
            String sql = "insert into pointlog ( mno , plpoint , plcomment  )" +
                    "values( ? , ? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pointLogDto.getMno() );
            ps.setInt(2,1000);
            ps.setString(3,"회원가입");
            int count = ps.executeUpdate();
            if(count == 1) return true;

        }catch (Exception e ){
            System.out.println(e);
        }
        return false;
    } // func e

    // [2-1] 로그인 완료 시 포인트 적립
    public boolean loginPoint(PointLogDto pointLogDto){
        try {
            String sql = "insert into pointlog ( mno , plpoint , plcomment )" +
                    "values( ? , ? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pointLogDto.getMno() );
            ps.setInt(2,10);
            ps.setString(3,"로그인");
            int count = ps.executeUpdate();
            if(count == 1) return true;

        }catch (Exception e ){
            System.out.println(e);
        }
        return false;
    } // func e

    // [3] 포인트 지급 내역 전체 조회
    public List<PointLogDto> myPointLog(int mno){
        List<PointLogDto> list = new ArrayList<>();
        try {
            String sql = "select * from pointlog where mno = ? order by pldate desc ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PointLogDto dto = new PointLogDto();
                dto.setMno(rs.getInt("mno"));
                dto.setPlpoint(rs.getInt("plpoint"));
                dto.setPlcomment(rs.getString("plcomment"));
                dto.setPldate(rs.getString("pldate"));
                list.add(dto);
            }
            rs.close();
            ps.close();
        }catch (Exception e ){
            System.out.println(e);
        }
        return list;
    } // func e

} // class e
