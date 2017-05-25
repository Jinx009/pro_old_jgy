package database.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 微信用户
 * @author Jinx
 *
 */
@Entity
@Table(name="jgy_user")
public class User {

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nick_name")
	private String nickName;
	@Column(name = "head_img")
	private String headImg;
	@Column(name = "add_time")
	private Date addTime;
	@Column(name = "login_time")
	private Date loginTime;
	@Column(name = "login_times")
	private Integer loginTimes;
	@Column(name = "age")
	private Integer age;
	@Column(name = "email")
	private String email;
	@Column(name = "status")
	private Integer status;
	@Column(name = "real_name")
	private String realName;
	@Column(name = "mobile_phone")
	private String mobilePhone;
	@Column(name = "job_info")
	private String jobInfo;
	@Column(name = "open_id")
	private String openid;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Integer getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(String jobInfo) {
		this.jobInfo = jobInfo;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
