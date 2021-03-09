package com.mend.projects.demo.models;

public class Member {
	private String firstName;
	private String lastName;
	private String fullName;
	private String chartId;
	private String mobile;
	private Address address;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getChartId() {
		return chartId;
	}
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Response [firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", chartId="
				+ chartId + ", mobile=" + mobile + ", address=" + address + "]";
	}

}
