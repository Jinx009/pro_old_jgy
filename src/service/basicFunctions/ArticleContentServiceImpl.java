package service.basicFunctions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import database.basicFunctions.dao.ArticleContentDao;
import database.models.ArticleContent;

@Service("articleContentService")
public class ArticleContentServiceImpl implements ArticleContentService{

	@Autowired
	private ArticleContentDao articleContentDao;
	
	public List<ArticleContent> findAll() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" FROM ArticleContent ORDER BY updateTime DESC ");
		return articleContentDao.getByHql(buffer.toString());
	}

	public List<ArticleContent> findIndex() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" FROM ArticleContent WHERE indexStatus = 1 AND viewStatus = 1 ORDER BY updateTime DESC ");
		return articleContentDao.getByHql(buffer.toString());
	}

	public List<ArticleContent> findByType(Integer typeId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" FROM ArticleContent WHERE typeId =");
		buffer.append(typeId);
		buffer.append(" AND viewStatus = 1 ORDER BY updateTime DESC ");
		return articleContentDao.getByHql(buffer.toString());
	}

	public void delete(Integer id) {
		articleContentDao.delete(id);
	}

	public void save(ArticleContent articleContent) {
		articleContentDao.save(articleContent);
	}

}
