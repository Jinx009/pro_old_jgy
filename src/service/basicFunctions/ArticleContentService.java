package service.basicFunctions;

import java.util.List;

import database.models.ArticleContent;

public interface ArticleContentService {

	public List<ArticleContent> findAll();

	public List<ArticleContent> findIndex();

	public List<ArticleContent> findByType(Integer typeId);

	public void delete(Integer id);

	public void save(ArticleContent articleContent);

}
