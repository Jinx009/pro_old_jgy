package service.basicFunctions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import database.basicFunctions.dao.ArticleTypeDao;
import database.models.ArticleType;

@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService{

	@Autowired
	private ArticleTypeDao articleTypeDao;
	
	public List<ArticleType> getByParentId(Integer parentId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" FROM ArticleType WHERE parentId = ");
		buffer.append(parentId);
		return articleTypeDao.getByHql(buffer.toString());
	}

	public List<ArticleType> findAll() {
		return articleTypeDao.findAll();
	}

}
