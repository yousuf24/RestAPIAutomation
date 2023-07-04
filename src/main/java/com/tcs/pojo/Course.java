package com.tcs.pojo;

import java.util.List;


public class Course{
	private String courseTitle,price;

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
class CourseList{
	private List<Course> webAutomation,api,mobile;

	public List<Course> getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(List<Course> webAutomation) {
		this.webAutomation = webAutomation;
	}

	public List<Course> getApi() {
		return api;
	}

	public void setApi(List<Course> api) {
		this.api = api;
	}

	public List<Course> getMobile() {
		return mobile;
	}

	public void setMobile(List<Course> mobile) {
		this.mobile = mobile;
	}
}