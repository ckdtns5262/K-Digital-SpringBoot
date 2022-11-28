package log.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// h2 데이터베이스 접근 객체
public class LogDaoH2Impl implements LogDao {
	private Connection con = null;
	public LogDaoH2Impl() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");

			// DB에 연결
			String url = "jdbc:h2:tcp://localhost/~/mission3";
			String id = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공(기본 생성자)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addLog(String method, String sqlstring, boolean success) {
	
		String query = "Insert into dblog(method,sqlstring,success) values(?,?,?)";

		try {
			PreparedStatement g = con.prepareStatement(query);
			g.setString(1, method);
			g.setString(2, sqlstring);
			g.setBoolean(3, success);
			g.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("dblog 추가중 예외발생");
			e.printStackTrace();
		}
		
	}

}
