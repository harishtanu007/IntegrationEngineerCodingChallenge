package com.mend.projects.demo.models;

import java.util.List;

public class Response {
	private List<Member> members;

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Response [members=" + members + "]";
	}


}
