package main.entry.webapp.data;

import java.io.IOException;
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
import database.models.User;
import service.basicFunctions.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	private Map<String,Object> data;

	/*
	 * 根据用户id获取用户信息
	 */
	@RequestMapping(value = "/data/user/byId")
	public void userList(HttpServletResponse response,HttpServletRequest request) throws IOException{
		Integer id = Integer.valueOf(request.getParameter("id"));
		List<User> list = userService.getById(id);
		
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		data.put(ConstantUtil.MSG,"根据id取用户");
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
