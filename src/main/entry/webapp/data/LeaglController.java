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
import database.models.Leagl;
import database.models.User;
import service.basicFunctions.LeaglService;

@Controller
public class LeaglController {

	@Autowired
	private LeaglService leaglService;
	
	private Map<String,Object> data;

	@RequestMapping(value = "/data/leagl")
	public void getData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		User user = (User) request.getSession().getAttribute("user");
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		data.put(ConstantUtil.MSG,"问答信息");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user",null);
		List<Leagl> list = leaglService.findAllPublic();
		map.put("list",list);
		if(null!=user){
			List<Leagl> list2 = leaglService.getByOpenId(user.getOpenid());
			map.put("user",list2);
		}
		data.put(ConstantUtil.DATA,map);
		
		HttpWebIOHelper._printWebJson(data, response);
	}
	
	@RequestMapping(value = "/data/leagl/save")
	public void save(HttpServletRequest request,HttpServletResponse response) throws IOException{
		User user = (User) request.getSession().getAttribute("user");
		Leagl leagl = new Leagl();
		leagl.setCustomerNickName(user.getNickName());
		leagl.setCustomerIconUrl(user.getHeadImg());
		leagl.setCustomerOpenid(user.getOpenid());
		leagl.setIsPublic(0);
		leagl.setCustomerQuestion(request.getParameter("question"));
		leagl.setCustomerQuestionDate(new Date());
		leagl.setCustomerAge(1);
		leagl.setCustomerGender(1);
		
		leaglService.save(leagl);
		data = new HashMap<String, Object>();
		data.put(ConstantUtil.CODE,ConstantUtil.CODE_RIGHT);
		data.put(ConstantUtil.MSG,"保存问答");
		
		HttpWebIOHelper._printWebJson(data, response);
	}
	
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
