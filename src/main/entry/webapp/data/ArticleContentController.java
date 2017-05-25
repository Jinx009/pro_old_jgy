package main.entry.webapp.data;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.helper.ConstantUtil;
import common.helper.HttpWebIOHelper;
import database.models.ArticleContent;
import service.basicFunctions.ArticleContentService;

@Controller
public class ArticleContentController {

	@Autowired
	private ArticleContentService articleContentService;
	
	private Map<String,Object> data;

	/**
	 * 全部文章
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/data/articleContent/list")
	public void contentAll(HttpServletRequest request,HttpServletResponse response) throws IOException{
		List<ArticleContent> list = articleContentService.findAll();
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		data.put(ConstantUtil.MSG,"文章列表");
		data.put(ConstantUtil.DATA,list);
		
		HttpWebIOHelper._printWebJson(data, response);
	}
	
	/**
	 * 首页文章显示
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/data/articleContent/index")
	public void indexContent(HttpServletResponse response) throws IOException{
		List<ArticleContent> list = articleContentService.findIndex();
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		data.put(ConstantUtil.MSG,"首页推荐文章");
		data.put(ConstantUtil.DATA,list);
		
		HttpWebIOHelper._printWebJson(data, response);
	}
	
	/**
	 * 删除文章
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/data/articleContent/delete")
	public void dele(HttpServletRequest request,HttpServletResponse response) throws IOException{
		articleContentService.delete(Integer.valueOf(request.getParameter("id")));
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		
		HttpWebIOHelper._printWebJson(data, response);
	}
	
	/**
	 * 根据类别选文章
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = "/data/articleContent/type")
	public void typeContent(HttpServletResponse response,HttpServletRequest request) throws IOException{
		Integer typeId = Integer.valueOf(request.getParameter("typeId"));
		List<ArticleContent> list = articleContentService.findByType(typeId);
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		data.put(ConstantUtil.MSG,"根据类别选文章");
		data.put(ConstantUtil.DATA,list);
		
		HttpWebIOHelper._printWebJson(data, response);
	}
	
	
	/**
	 * 保存
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = "/data/articleContent/add")
	public void add(HttpServletResponse response,HttpServletRequest request) throws IOException{
		Integer typeId = Integer.valueOf(request.getParameter("typeId"));
		String imgUrl = request.getParameter("imgUrl");
		String typeName = request.getParameter("typeName");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(typeName);
		ArticleContent articleContent  = new ArticleContent();
		articleContent.setAddTime(new Date());
		articleContent.setContent(content);
		articleContent.setImgUrl(imgUrl);
		articleContent.setIndexStatus(0);
		articleContent.setTitle(title);
		articleContent.setTypeId(typeId);
		articleContent.setTypeName(typeName);
		articleContent.setViewStatus(1);
		articleContent.setUpdateTime(new Date());
		articleContentService.save(articleContent);
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		
		HttpWebIOHelper._printWebJson(data, response);
	}
	
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
