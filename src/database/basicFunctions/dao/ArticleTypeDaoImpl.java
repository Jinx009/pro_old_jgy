package database.basicFunctions.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import database.common.BaseDaoImpl;
import database.models.ArticleType;

@Repository("articleTypeDao")
public class ArticleTypeDaoImpl extends BaseDaoImpl<ArticleType> implements ArticleTypeDao{

	@SuppressWarnings("unchecked")
	public List<ArticleType> getByHql(String hql) {
		Query query = em.createQuery(hql);
		List<ArticleType> list = query.getResultList();
		if(null!=list&&!list.isEmpty()){
			return list;
		}
		return null;
	}

}
