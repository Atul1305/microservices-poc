package com.quest.us.VO;

import com.quest.us.entity.User;

public class ResponseTemplateVo {

	private User user;
	private Department department;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseTemplateVo [user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	
}
