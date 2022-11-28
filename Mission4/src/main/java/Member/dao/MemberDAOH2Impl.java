package Member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mission.domain.MemberDTO;

public class MemberDAOH2Impl implements MemberInterface {
	private Connection con = null;

	public MemberDAOH2Impl() {
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
	public List<MemberDTO> getMembers() {
		Statement st = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<>();

		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from Member");
			while (rs.next()) {
				MemberDTO m = new MemberDTO();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getInt("pass"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public MemberDTO getMember(int id) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		// 비교하는 if문이 필요없음
		String query = "select * from Member where id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			rs.next();
			MemberDTO g = new MemberDTO();
			g.setId(rs.getInt("id"));
			g.setName(rs.getString("name"));
			g.setPass(rs.getInt("pass"));
			g.setRegidate(rs.getDate("regidate"));
			return g;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberDTO addMember(MemberDTO m) {

		String query = "INSERT INTO member(id,pass,name) values(?,?,?)";
		m.setRegidate(new Date());
		try {
			PreparedStatement g = con.prepareStatement(query);
			g.setInt(1, m.getId());
			g.setInt(2, m.getPass());
			g.setString(3, m.getName());
			g.executeUpdate();

		} catch (SQLException e) {
			System.out.println("추가중에 예외발생");
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public MemberDTO updateMember(MemberDTO m) {

		String query = "Update member set name=?, pass=? where id=?";
		m.setRegidate(new Date());
		try {
			PreparedStatement g = con.prepareStatement(query);
			g.setString(1,m.getName());
			g.setInt(2, m.getPass());
			g.setInt(3, m.getId());
			g.executeUpdate();

			return getMember(m.getId());

		} catch (SQLException e) {
			System.out.println("추가중에 예외발생");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteMember(int id) {
		PreparedStatement psmt = null;
		String query = "Delete from member where id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			if (psmt.executeUpdate() == 0) // query에서 받아오는 id값이 없으면 0 false를 반환
				return 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1; // query에서 받아오는 id 값이 있으면 true반환해서 삭제
	}
}
