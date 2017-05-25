package main.entry.webapp.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.helper.ConstantUtil;
import common.helper.HttpWebIOHelper;
import database.models.ArticleType;
import service.basicFunctions.ArticleTypeService;

@Controller
public class ArticleTypeController {

	@Autowired
	private ArticleTypeService articleTypeService;
	
	private Map<String,Object> data;
	
	/**
	 * 获取所有文章列别
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/data/articleType/list",method = RequestMethod.GET)
	public void getTypeList(HttpServletResponse response) throws IOException{
		List<ArticleType> list = articleTypeService.findAll();
		
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		data.put(ConstantUtil.MSG,"文章类别列表");
		data.put(ConstantUtil.DATA,list);
		
		HttpWebIOHelper._printWebJson(data, response);
	}

	
	
	
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
