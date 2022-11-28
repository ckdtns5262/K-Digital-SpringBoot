package com.mission.controller;


import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mission.domain.MemberDTO;

@RestController
public class MemberController {
	List<MemberDTO> memberList;

	

	@GetMapping("/member/{id}")
	public MemberDTO getmember(@PathVariable String id) {
		for (MemberDTO m : memberList) { // memberList id 루프를 돌면서
			if (m.getId().equals(id)) { //만약 MemberDTO m 이 id면 return m 아니면 null로 반환시킴
				return m;
			}
		}
		return null;
	}

	@PostMapping("/member")
	public MemberDTO addMember(MemberDTO m) {
		// id가 최대값으로 자동부여되게끔 (기존값에서 + 1이 되게끔)
		m.setId(String.valueOf(memberList.size() + 1)); //id는 list최대값에 + 1해주고
		m.setRegidate(new Date());    // regidate는 자동부여
		m.setPass(m.getPass());		  // pass , name은 입력값
		m.setName(m.getName());
		memberList.add(m);
		return memberList.get(memberList.size()-1); 
	}
	
	@PutMapping("/member")
	public MemberDTO updateMembers(MemberDTO m) { // id , pass, name 넣을값을 m에
		for (MemberDTO d : memberList) { // memberList id 루프를 돌면서
			if (d.getId().equals(m.getId())) { //만약 MemberDTO m 이 id를 찾아서 
				d.setName(m.getName());      // d에 name과 pass를 넣어줌
				d.setPass(m.getPass());     
				return d;   // return d를 해서 루프빠짐
			}
		} 	return null;    // id가 없으면 null 값을 줌
	}
	

	
	@DeleteMapping("/member/{id}")
	public boolean removeMember(@PathVariable String id) {
		for(MemberDTO m : memberList) {
			if(m.getId().equals(id)) {
				return memberList.remove(m);
			}
		}
		return false;
	}

	@GetMapping("/getMemberList")
	public List<MemberDTO> getMemberList() {

		return memberList;
	}
}