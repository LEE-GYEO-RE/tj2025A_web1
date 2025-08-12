package 종합.실습5.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    // db 연결
    private String db_url = "jdbc:mysql://localhost:3306/example5";
    private String db_user = "root";
    private String db_password = "1234";
    public Connection conn;

    // db연동 생성자
    public Dao() {
        connect();
    }

    // db 연동 메소드
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("(waiting)Dao.connect");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} // class e
