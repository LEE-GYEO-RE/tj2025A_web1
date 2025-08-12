package 종합.실습5.model.dao;

import org.springframework.stereotype.Repository;
import 종합.실습5.model.dto.WaitingDto;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaitingDao extends Dao {

    // 등록
    public boolean waitingAdd(WaitingDto waitingDto){
        System.out.println("WaitingDao.waitingAdd");
        System.out.println("waitingDto = " + waitingDto);
        try {
            String sql = "INSERT INTO waiting (phone, count) VALUES ( ? , ? ) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1 , waitingDto.getPhone());
            ps.setInt(2,waitingDto.getCount());
            int count = ps.executeUpdate();
            if(count ==1)return true;

        }catch (Exception e ){
            System.out.println(e);
        }
        return false;
    } // func e

    // 전체 조회
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingDao.waitingPrint");
        List<WaitingDto> list = new ArrayList<>();
        try {
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno(rs.getInt("wno"));
                waitingDto.setPhone(rs.getString("phone"));
                waitingDto.setCount(rs.getInt("count"));
                list.add(waitingDto);
            }
        }catch (Exception e ){
            System.out.println(e);
        }
        return list;
    } // func e

    // 개별 조회
    public WaitingDto waitingFind(int wno){
        System.out.println("WaitingDao.waitingFind");
        System.out.println("wno = " + wno);
        try {
            String sql = "select * from waiting where wno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno(rs.getInt(1));
                waitingDto.setPhone(rs.getString(2));
                waitingDto.setCount(rs.getInt(3));
                return waitingDto;
            }
        }catch (Exception e ){
            System.out.println(e );
        }
        return null;
    } // func e

    // 개별 삭제
    public boolean waitingDelete(int wno){
        System.out.println("WaitingDao.waitingDelete");
        System.out.println("wno = " + wno);
        try {
            String sql = "delete from waiting where wno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, wno);
            int count = ps.executeUpdate();
            if(count ==1 )return true;
        }catch (Exception e ){
            System.out.println(e);
        }
        return false;
    } // func e

    // 개별 수정
    public boolean waitingUpdate(WaitingDto waitingDto){
        System.out.println("WaitingDao.waitingUpdate");
        System.out.println("WaitingDao.waitingUpdate");
        try {
            String sql = "update waiting set phone = ? , count = ? where wno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,waitingDto.getPhone());
            ps.setInt(2,waitingDto.getCount());
            ps.setInt(3,waitingDto.getWno());
            int count = ps.executeUpdate();
            if(count ==1 )return true;
        }catch (Exception e ){
            System.out.println(e);
        }
        return false;
    } // func e




} // class e
