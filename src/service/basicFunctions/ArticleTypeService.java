package service.basicFunctions;

import java.util.List;

import database.models.ArticleType;

public interface ArticleTypeService {

	public List<ArticleType> getByParentId(Integer parentId);
	
	public List<ArticleType> findAll();
	
}
