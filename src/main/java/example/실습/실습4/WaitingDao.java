package example.실습.실습4;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {

    // 싱글톤
    @Getter
    private static final WaitingDao instance = new WaitingDao();

    private WaitingDao() {
        connect();
    }

    private String db_url = "jdbc:mysql://localhost:3306/exam04";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    // 연동 함수
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (Exception e) {
            System.out.println(e);
        }
    } // db 연동 func e


    // 대기 번호 등록
    public boolean addWaiting(WaitingDto waitingDto) {
        try {
            String sql = "insert into waiting (phone , count) values (? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getPhone());
            ps.setInt(2, waitingDto.getCount());

            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    } // func e

    // 대기 현황 조회
    public List<WaitingDto> waitingPrint() {
        List<WaitingDto> list = new ArrayList<>();
        try {
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WaitingDto waitingDto = new WaitingDto(
                        rs.getInt(1),
                        rs.getString("phone"),
                        rs.getInt("count"),
                        rs.getString("wdate")
                );
                list.add(waitingDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    } // func e

} // class e
