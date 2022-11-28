package com.mission.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mission.domain.MemberDTO;

public class MemberService {

	// 생성자에서 초기데이터 세팅
	public MemberService() {
		
		List<MemberDTO> memberList;
		memberList = new ArrayList<MemberDTO>();
		for (int i = 1; i <= 10; i++) {
			MemberDTO member = new MemberDTO();
			member.setId(String.valueOf(i));
			member.setName("이름" + i);
			member.setPass(123+i);
			member.setRegidate(new Date());
			memberList.add(member);
		}
	}
}
