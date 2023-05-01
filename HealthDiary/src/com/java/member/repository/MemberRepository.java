package com.java.member.repository;

import java.util.ArrayList;
import java.util.List;

import com.java.member.domain.Member;

public class MemberRepository {

	private List<Member> members;
	
	public MemberRepository(List<Member> members) {
		this.members = members;
	}
	
	public MemberRepository() {}

	public List<Member> findByMemberName(String name) {
		List<Member> result = new ArrayList<>();
		for(Member member : members) {
			if(member.getName().equals(name)) {
				result.add(member);
			}
		}
		return result;
	}

}
