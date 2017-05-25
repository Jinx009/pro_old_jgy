package database.basicFunctions.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import database.common.BaseDaoImpl;
import database.models.ArticleContent;

@Repository("articleContentDao")
public class ArticleContentDaoImpl extends BaseDaoImpl<ArticleContent> implements ArticleContentDao{

	@SuppressWarnings("unchecked")
	public List<ArticleContent> getByHql(String hql) {
		Query query = em.createQuery(hql);
		List<ArticleContent> list = query.getResultList();
		if(null!=list&&!list.isEmpty()){
			return list;
		}
		return null;
	}

}
