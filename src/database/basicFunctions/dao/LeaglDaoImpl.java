package database.basicFunctions.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import database.common.BaseDaoImpl;
import database.models.Leagl;

@Repository("leaglDao")
public class LeaglDaoImpl extends BaseDaoImpl<Leagl> implements LeaglDao{

	@SuppressWarnings("unchecked")
	public List<Leagl> getByHql(String hql) {
		Query query = em.createQuery(hql);
		List<Leagl> list = query.getResultList();
		if(null!=list&&!list.isEmpty()){
			return list;
		}
		return null;
	}

}
