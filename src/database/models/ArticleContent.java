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

/**
 * 文章内容
 * @author Jinx
 *
 */
@Entity
@Table(name="jgy_article_content")
public class ArticleContent {

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Temporal(TemporalType.DATE)
	@Column(name = "add_time")
	private Date addTime;
	@Column(name = "content_type")
	private Integer contentType;
	@Column(name = "type_id")
	private Integer typeId;
	@Column(name = "content_base")
	private String contentBase;
	@Column(name = "update_time")
	private Date updateTime;
	@Column(name = "img_url")
	private String imgUrl;
	@Column(name = "view_status")
	private Integer viewStatus;
	@Column(name = "index_status")
	private Integer indexStatus;
	@Column(name = "type_name")
	private String typeName;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getContentBase() {
		return contentBase;
	}
	public void setContentBase(String contentBase) {
		this.contentBase = contentBase;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getViewStatus() {
		return viewStatus;
	}
	public void setViewStatus(Integer viewStatus) {
		this.viewStatus = viewStatus;
	}
	public Integer getIndexStatus() {
		return indexStatus;
	}
	public void setIndexStatus(Integer indexStatus) {
		this.indexStatus = indexStatus;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
