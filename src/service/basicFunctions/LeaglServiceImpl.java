package service.basicFunctions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import database.basicFunctions.dao.LeaglDao;
import database.models.Leagl;

@Service("leaglService")
public class LeaglServiceImpl implements LeaglService{

	@Autowired
	private LeaglDao leaglDao;
	
	
	public List<Leagl> findAllPublic() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" FROM Leagl WHERE isPublic  = 1 ");
		return leaglDao.getByHql(buffer.toString());
	}

	public List<Leagl> getByOpenId(String openid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" FROM Leagl WHERE customerOpenid = '");
		buffer.append(openid);
		buffer.append("'  ");
		return leaglDao.getByHql(buffer.toString());
	}

	public void save(Leagl leagl) {
		leaglDao.save(leagl);
	}

	
}
