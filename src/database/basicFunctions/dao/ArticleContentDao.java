package database.basicFunctions.dao;

import java.util.List;

import database.common.BaseDao;
import database.models.ArticleContent;

public interface ArticleContentDao extends BaseDao<ArticleContent>{

	public List<ArticleContent> getByHql(String hql);
	
}
