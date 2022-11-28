package com.mission.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mission.domain.MemberDTO;
import com.mission.service.MemberService;

@RestController // restAPI 형식 
public class Member2Controller {

	private MemberService memberService;
	
	private static final Logger Log = LoggerFactory.getLogger(Member2Controller.class);
	//생성자에서 초기데이터 세팅
	public Member2Controller(MemberService memberService) {
		System.out.println("MemberController() 생성자가 호출됨.");
		Log.info("MemberController() 생성자가 호출됨");
		this.memberService = memberService;
	}
	
	@GetMapping("/member2") // url을 호출
	public List<MemberDTO> getMembers(){
		System.out.println("Controller - getMembers()");
		return memberService.getMembers();
	}
	
	@GetMapping("/member2/{id}")
	public MemberDTO getMember(@PathVariable int id) {
		System.out.printf("Controller - getMember(%d)\n", id);
		return memberService.getMember(id);
	}
	
	@PostMapping("/member2")
	public MemberDTO addMember(MemberDTO m){
		System.out.println("Controller - addMember()");;
		return memberService.addMember(m);
	}
	
	@PutMapping("/member2")
	public MemberDTO updateMembers(MemberDTO m) {
		System.out.println("Controller - updateMembers()");;
		return memberService.updateMembers(m);
	}
	
	@DeleteMapping("/member2/{id}")
	public int removeMember(@PathVariable int id){
		System.out.printf("Controller - removeMember(%d)\n", id);
		return memberService.deleteMember(id);
	}
}
