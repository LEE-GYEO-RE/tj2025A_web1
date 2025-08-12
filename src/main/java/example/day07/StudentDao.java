package example.day07;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    // 싱글톤
    @Getter // 롬복 : 해당하는 멤버변수에만 getter 제공받을 수 있다.
    private static final StudentDao instance = new StudentDao();

    private StudentDao() {
        connect();
    }

    private String db_url = "jdbc:mysql://localhost:3306/spring07";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (Exception e) {
            System.out.println(e);
        }
    } // 연동 func e


    // 등록
    public boolean save(StudentDto studentDto) {
        // Controller 로부터 studentDto 를 매개변수로 받아서 처리후 boolean(true/false) 반환 메소드
        try {
            String sql = "insert into student (sname , skor , smath )values( ? , ? , ? )";  // sql 작성
            PreparedStatement ps = conn.prepareStatement(sql);  // 연동된 db에 작성한 sql 기재
            ps.setString(1, studentDto.getSname()); // 기재된 sql에 매개변수 대입
            ps.setInt(2, studentDto.getSkor());      // 1/2/3 : sql 내 물음표 번호
            ps.setInt(3, studentDto.getSmath());     // .set타입() :
            // sql문법내 3번째 물음표에 수학점수 대입한다.
            int count = ps.executeUpdate();                     // sql 실행
            // insert , delete , update -> executeUpdate();
            // select -> executeQuery();
            if (count == 1) return true;                        // 1개 저장했으면 true 반환

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;                                           // 아니면 false
    } // class e


    // 전체 조회
    public List<StudentDto> find() {
        List<StudentDto> list = new ArrayList<>();
        try {
            String sql = "select * from student ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();   // 기재된 sql 실행한다 . 실행결과의 모든 레코드를 (ResultSet) 인터페이스 조작
            // rs.next() : sql 조회 결과중 다음 레코드 이동함수 , 주로 하나 조회 :  if((rs.next))  , 다수 조회 : while(rs.next())
            // rs.get타입( 필드명 혹은 번호 ) : 현재 조회중인 레코드의 필드값 호출
            while (rs.next()) {
                StudentDto studentDto = new StudentDto( // 하나의 레코드 준비
                        rs.getInt(1),    // 현재 조회중인 레코드의 첫번째 필드/속성/제목/열/컬럼 = 회원번호
                        rs.getString("sname"), // 현재 조회중인 레코드의 "sname" 이라는 필드/속성/제목/열/컬럼 = 회원명
                        rs.getInt("skor"),
                        rs.getInt("smath"),
                        rs.getString("sdate")
                );
                list.add(studentDto);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


} // class e
