package log.dao;

public interface LogDao {
	
	void addLog(String method, String sqlstring, boolean success);
	// addLog 메소드는 방법, sql문 , 성공여부
}
