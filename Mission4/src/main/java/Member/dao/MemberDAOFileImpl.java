package Member.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.mission.domain.MemberDTO;

public class MemberDAOFileImpl implements MemberInterface {
	private List<MemberDTO> memberList;
	
	public MemberDAOFileImpl() {
		memberList = new ArrayList<MemberDTO>();
		try (BufferedReader br = new BufferedReader(new FileReader("list.txt"))) { 
			
			String str;
			while((str = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(str, "");
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				String s3 = st.nextToken();
				
				memberList.add(new MemberDTO(Integer.parseInt(s1),Integer.parseInt(s2), s3, new Date()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberDTO> getMembers() {

		return memberList;
	}

	@Override
	public MemberDTO getMember(int id) {

		for(MemberDTO m : memberList) {
			if(m.getId() == id) {
				return m;
			}
		}
			return null;
	}	

	@Override
	public MemberDTO addMember(MemberDTO m) {
		m.setId(memberList.size() + 1);
		m.setRegidate(new Date());
		m.setPass(m.getPass());
		m.setName(m.getName());
		memberList.add(m);
		return memberList.get(memberList.size()-1);

	}

	@Override
	public MemberDTO updateMember(MemberDTO m) {
		for(MemberDTO d : memberList) {
			if(d.getId()==m.getId()) {
				d.setName(m.getName());
				d.setPass(m.getPass());
				return d;
			}
		} 		return null;
		
	}

	@Override
	public int deleteMember(int id) {
		for(MemberDTO m : memberList) {
			if(m.getId()==id) {
				memberList.remove(m);
				return 1;
			}
		}
		return 0;
	}

	
 }

