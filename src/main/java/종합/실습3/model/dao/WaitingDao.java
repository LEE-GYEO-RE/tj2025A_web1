package 종합.실습3.model.dao;


import 종합.실습3.model.dto.WaitingDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WaitingDao {

    // 싱글톤
    private WaitingDao(){
        connect();
    }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }

    // (*) DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/mydb0805";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url , db_user , db_password );
        }catch (Exception e ){ System.out.println(e); }
    }

    // 등록 기능 구현
    public boolean addWaiting(WaitingDto waitingDto){
        try {
            String sql = "insert into waiting (phone , count ) values( ? , ? )";    // sql insert 작성
            PreparedStatement ps = conn.prepareStatement(sql);                      // sql 기재
            ps.setString( 1 , waitingDto.getPhone() );  // sql 내 첫번째 물음표에 매개변수로 받은 phone 값 대입
            ps.setInt( 2, waitingDto.getCount());       // sql 내 두번째 물음표에 매개변수로 받은 count 값 대입
            int count = ps.executeUpdate();             // sql 실행
            if(count >=1 )return  true;                 // sql 결과에 따른 리턴 : 1개 이상 insert 했으면 저장 성공
            return false;                               // 1개 이상 insert 못했으면 저장 실패
        }catch (Exception e){ System.out.println(e);}
        return false;                                   // 예외처리 되면 실패!
    } // func e

    // 전체 조회 기능 구현
    public ArrayList<WaitingDto> waitingPrint(){
        ArrayList<WaitingDto> list = new ArrayList<>();
        try{
            String sql = "select * from waiting";               // sql select 작성
            PreparedStatement ps = conn.prepareStatement(sql);  // sql 기재
            ResultSet rs = ps.executeQuery();                   // sql 실행 select = executeQuery(); 해줘야함
            while (rs.next() ){ // rs.next() : ResultSet 인터페이스가 갖는 결과 테이블에서 다음 레코드로 이동한다는 뜻
                int wno = rs.getInt("wno");                     // rs.get타입("속성명 이나 번호")
                String phone = rs.getString("phone");
                int count = rs.getInt("count");
                WaitingDto waitingDto = new WaitingDto( wno , phone , count );  // 가져온 속성들 새로운 dto 객체에 저장
                list.add(waitingDto);                           // ArrayList 에 dto객체 저장
            } // while e
        }catch (Exception e){System.out.println(e);}
        return list;                                            // ArrayList 반환
    } // func e

    // 대기 취소 기능 구현 (삭제)
    public boolean waitingDelete(int wno){
        try {
            String sql = "delete from waiting where wno = ? ";  // sql delete 작성
            PreparedStatement ps = conn.prepareStatement(sql);  // sql 기재
            ps.setInt( 1 , wno );                               // 첫번째 물음표에 매개변수 대입
            int count = ps.executeUpdate();                     // sql 실행
            if( count == 1)return true;                         // sql 결과값 반환 , 삭제할거 1개면 삭제 성공
            else {return false;}                                // 아니면 삭제 실패
        }catch (Exception e ){System.out.println(e);}
        return false;                                           // 예외 있으면 삭제 실패
    } // func e

    // 대기 정보 수정 기능 구현 (수정)
    public boolean waitingUpdate(WaitingDto waitingDto){
        try {
            String sql = "update waiting set count = ? where wno = ?";        // sql update 작성
            PreparedStatement ps = conn.prepareStatement(sql);                // sql 기재
            ps.setInt( 1 , waitingDto.getCount());                            // 매개변수 dto의 wno 가져와서 첫번째 물음표에 대입
            ps.setInt( 2 , waitingDto.getWno());                              // 매개변수 dto의 count 가져와서 두번째 물음표에 대입

            // System.out.println(">> DAO 디버그: wno = " + waitingDto.getWno());
            // System.out.println(">> DAO 디버그: count = " + waitingDto.getCount());
            int count  = ps.executeUpdate();                                  // sql 실행
            if(count  == 1 ) {
                System.out.println("DB 값 변경 완료");
                return true;                                     // 수정할 거 1개면 수정 성공 반환
            } else if (count == 0) {
                System.out.println("실패");
                return false;
            } else {return false;}                                              // 1개 아니면 수정 실패 반환
            // ---------> 처음에 false 뜨고 , 모든 count 값 = 0 으로 출력됨
            // ----------> if문에 count == 0 이면 true 반환하게 함
            // -----------> 0이면 true인데 콘솔에서 true 뜸 , 근데 수정됨 뭐임?
        }catch (Exception e){System.out.println(e);}
        return false;                                                         // 예외 있으면 수정 실패 반환

    } // func e

} // class e
