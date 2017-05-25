package database.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章类别
 * @author Jinx
 *
 */
@Entity
@Table(name="jgy_article_type")
public class ArticleType {

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "parent_id")
	private Integer parentId;
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
