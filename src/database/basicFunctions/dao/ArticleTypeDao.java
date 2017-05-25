package database.basicFunctions.dao;

import java.util.List;

import database.common.BaseDao;
import database.models.ArticleType;

public interface ArticleTypeDao extends BaseDao<ArticleType>{

	public List<ArticleType> getByHql(String hql);
	
}
