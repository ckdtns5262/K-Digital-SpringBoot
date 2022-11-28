package com.mission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mission.domain.MemberDAO;
import com.mission.domain.MemberDTO;
// controller에서 service로 

@Service
public class MemberService {

	private MemberDAO memberDAO;
	
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	public List<MemberDTO> getMembers() {
		return memberDAO.getMembers();
	}

	public MemberDTO getMember(int id) {
		return memberDAO.getMember(id);
	}
	public MemberDTO addMember(MemberDTO m) {
		return memberDAO.addMember(m);
	}
	public MemberDTO updateMembers(MemberDTO m) {
		return memberDAO.updateMember(m);
	}
	public boolean deleteMembers(int id) {
		return memberDAO.deleteMember(id);
	}
}
