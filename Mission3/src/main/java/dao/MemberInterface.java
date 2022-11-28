package dao;

import java.util.List;

import com.mission.domain.MemberDTO;

public interface MemberInterface {
	
	List<MemberDTO> getMembers();
	
	MemberDTO getMember(int id);
	
	MemberDTO addMember(MemberDTO m);
	
	MemberDTO updateMember(MemberDTO m);
	
	int deleteMember(int id);
}
