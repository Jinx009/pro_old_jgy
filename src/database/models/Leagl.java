package database.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="jgy_legal_q_a")
public class Leagl{
	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "customer_openid")
	private String customerOpenid;
	
	@Column(name = "customer_question")
	private String customerQuestion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "customer_question_date")
	private Date customerQuestionDate;

	@Column(name = "customer_nick_name")
	private String customerNickName;
	
	@Column(name = "customer_icon_url")
	private String customerIconUrl;
	
	@Column(name = "customer_real_name")
	private String customerRealName;
	
	@Column(name = "customer_age")
	private Integer customerAge;
	
	@Column(name = "customer_gender")
	private Integer customerGender;
	
	@Column(name = "reply")
	private String reply;
	
	@Column(name = "replyer")
	private String replyer;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "reply_date")
	private Date replyDate;
	
	@Column(name = "is_public")
	private Integer isPublic;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerOpenid() {
		return customerOpenid;
	}
	public void setCustomerOpenid(String customerOpenid) {
		this.customerOpenid = customerOpenid;
	}
	public String getCustomerQuestion() {
		return customerQuestion;
	}
	public void setCustomerQuestion(String customerQuestion) {
		this.customerQuestion = customerQuestion;
	}
	public Date getCustomerQuestionDate() {
		return customerQuestionDate;
	}
	public void setCustomerQuestionDate(Date customerQuestionDate) {
		this.customerQuestionDate = customerQuestionDate;
	}
	public String getCustomerNickName() {
		return customerNickName;
	}
	public void setCustomerNickName(String customerNickName) {
		this.customerNickName = customerNickName;
	}
	public String getCustomerIconUrl() {
		return customerIconUrl;
	}
	public void setCustomerIconUrl(String customerIconUrl) {
		this.customerIconUrl = customerIconUrl;
	}
	public String getCustomerRealName() {
		return customerRealName;
	}
	public void setCustomerRealName(String customerRealName) {
		this.customerRealName = customerRealName;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	public Integer getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(Integer customerGender) {
		this.customerGender = customerGender;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Integer getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}
}
