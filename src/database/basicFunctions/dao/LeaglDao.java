package database.basicFunctions.dao;

import java.util.List;

import database.common.BaseDao;
import database.models.Leagl;

public interface LeaglDao extends BaseDao<Leagl>{

	public List<Leagl> getByHql(String hql);
	
}
