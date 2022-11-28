package Member.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mission.domain.MemberDTO;

public class MemberDAOListImpl implements MemberInterface {
	private List<MemberDTO> memberList;
	
	public MemberDAOListImpl() {
		memberList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			MemberDTO member = new MemberDTO();
			member.setId(i);
			member.setName("이름" + i);
			member.setPass(123+i);
			member.setRegidate(new Date());
			memberList.add(member);
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

