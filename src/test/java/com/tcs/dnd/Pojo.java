package com.tcs.dnd;

import java.util.List;
class DeleteOrderResp{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
class Data{
	private String _id,orderById,orderBy,productOrderedId,productName,country,productDescription,productImage,orderPrice,__v;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getOrderById() {
		return orderById;
	}

	public void setOrderById(String orderById) {
		this.orderById = orderById;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getProductOrderedId() {
		return productOrderedId;
	}

	public void setProductOrderedId(String productOrderedId) {
		this.productOrderedId = productOrderedId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String get__v() {
		return __v;
	}

	public void set__v(String __v) {
		this.__v = __v;
	}
}
class CreateOrderResp{
	private List<String> orders,productOrderId;
	public List<String> getOrders() {
		return orders;
	}
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	public List<String> getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(List<String> productOrderId) {
		this.productOrderId = productOrderId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
}
class Orders{
	private List<Addr> orders;

	public List<Addr> getOrders() {
		return orders;
	}

	public void setOrderList(List<Addr> orderList) {
		this.orders = orderList;
	}
}
class Addr{
	private String productOrderedId,country;	

	public String getProductOrderedId() {
		return productOrderedId;
	}

	public void setProductOrderedId(String productOrderid) {
		this.productOrderedId = productOrderid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
class CreateProduct{
	private String productId,message;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
class LoginResponse{
	private String token,userId,message;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
class LoginRequest{
	private String userEmail,userPassword;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
class Course{
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
public class Pojo {
	private String url,services,expertise,Instructor,linkedIn;
	private CourseList courses;

	public CourseList getCourses() {
		return courses;
	}

	public void setCourses(CourseList courses) {
		this.courses = courses;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getInstructor() {
		return Instructor;
	}

	public void setInstructor(String instructor) {
		Instructor = instructor;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
}
