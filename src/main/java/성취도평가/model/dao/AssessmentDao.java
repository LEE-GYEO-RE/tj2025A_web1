package 성취도평가.model.dao;

import org.springframework.stereotype.Repository;
import 성취도평가.model.dto.AssessmentDto;
import 성취도평가.model.dto.MemberDto;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AssessmentDao extends Dao {

    // 회원 등록
    public boolean memberAdd(MemberDto memberDto){
        System.out.println("AssessmentDao.memberAdd");
        System.out.println("memberDto = " + memberDto);
        try {
            String sql = "insert into member( custname , phone , address, grade , city ) values ( ? , ? , ? , ? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,memberDto.getCustname());
            ps.setString(2,memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getGrade());
            ps.setString(5,memberDto.getCity());
            int count = ps.executeUpdate();
            if(count == 1 )return true;
        }catch (Exception e ){
            System.out.println(e );
        }
        return false;
    } // func e

    // 회원 정보 조회
    public List<MemberDto> memberPrint(){
        System.out.println("AssessmentDao.memberPrint");
        List<MemberDto> list = new ArrayList<>();
        try {
            String sql = "select * from member";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                MemberDto memberDto = new MemberDto();
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setCustname(rs.getString("custname"));
                memberDto.setPhone(rs.getString("phone"));
                memberDto.setAddress(rs.getString("address"));
                memberDto.setGrade(rs.getString("grade"));
                memberDto.setCity(rs.getString("city"));
                list.add(memberDto);
            }
        }catch (Exception e ){
            System.out.println(e);
        }
        return list;
    } // func e

    // 회원 정보 수정
    public boolean memberUpdate(MemberDto memberDto){
        System.out.println("AssessmentDao.memberUpdate");
        System.out.println("memberDto = " + memberDto);
        try {
            String sql = "update member set custname = ? , phone = ? , address = ?, grade = ? , city = ? where custno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getCustname());
            ps.setString(2, memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getGrade());
            ps.setString(5, memberDto.getCity());
            ps.setInt(6, memberDto.getCustno());
            int count = ps.executeUpdate();
            if(count == 1 ) return true;

        }catch (Exception e ){
            System.out.println(e);
        }
        return false;
    } // func e

    // 회원 매출 조회
    public List<AssessmentDto> moneyPrint(){
        System.out.println("AssessmentDao.moneyPrint");
        List<AssessmentDto> list = new ArrayList<>();
        try {
            String sql = "SELECT m.custno, m.custname, m.grade, IFNULL(SUM(mm.price), 0) AS sales " +
                    "FROM member m " +
                    "LEFT JOIN money mm ON m.custno = mm.custno " +
                    "GROUP BY m.custno, m.custname, m.grade " +
                    "HAVING sales > 0 " +
                    "ORDER BY sales DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                AssessmentDto dto = new AssessmentDto();
                dto.setCustno(rs.getInt("custno"));
                dto.setCustname(rs.getString("custname"));
                dto.setGrade(rs.getString("grade"));
                dto.setSales(rs.getInt("sales"));
                list.add(dto);
            }
        }catch (Exception e ){
            System.out.println(e);
        }
        return list;
    } // func e

} // class e
