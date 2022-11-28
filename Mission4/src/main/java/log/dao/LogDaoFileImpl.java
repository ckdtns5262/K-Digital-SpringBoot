package log.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// 파일 접근 객체
public class LogDaoFileImpl implements LogDao {

	@Override
	public void addLog(String method, String sqlstring, boolean success) {
		
		File file = new File("log.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(file, true);
			fw.write(method + "," + sqlstring + "," + success +",");
			fw.close();
		} catch (IOException e) {
			System.out.println("로그 작성중 예외발생");
			e.printStackTrace();
		}
	}

}
