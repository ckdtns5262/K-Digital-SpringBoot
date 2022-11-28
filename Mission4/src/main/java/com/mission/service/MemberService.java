package com.mission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mission.domain.MemberDTO;
// controller에서 service로 

import Member.dao.MemberDAOH2Impl;
import Member.dao.MemberInterface;

@Service
public class MemberService {

	private MemberInterface memberDAO;
	
	
	public MemberService() {
		memberDAO = new MemberDAOH2Impl();
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
	public int deleteMember(int id) {
		return memberDAO.deleteMember(id);
	}
}
