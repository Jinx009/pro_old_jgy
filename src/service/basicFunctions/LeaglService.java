package service.basicFunctions;

import java.util.List;

import database.models.Leagl;

public interface LeaglService {

	public List<Leagl> findAllPublic();
	
	public List<Leagl> getByOpenId(String openid);

	public void save(Leagl leagl);
	
}
