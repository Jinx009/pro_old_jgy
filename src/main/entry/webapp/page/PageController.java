package main.entry.webapp.page;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.basicFunctions.UserService;
import common.helper.HttpWebIOHelper;
import common.wechat.WechatData;
import common.wechat.WechatUtil;

import database.models.User;

@Controller
public class PageController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/adminArticle")
	public String adminArticle(){
		return "/adminArticle";
	}
	
	@RequestMapping(value = "/adminAdd")
	public String adminAdd(){
		return "/adminAdd";
	}
	
	@RequestMapping(value="/active")
	public String active(){
		return "/active/index";
	}
	
	@RequestMapping(value = "/coming")
	public String coming(){
		return "/coming";
	}
	
	@RequestMapping(value = "/detail")
	public String detail(){
		return "/detail";
	}
	
	@RequestMapping(value = "/hot")
	public String hot(){
		return "/hot";
	}
	
	@RequestMapping(value = "/index")
	public String index(){
		return "/index";
	}
	
	@RequestMapping(value = "/matrix")
	public String matrix(){
		return "/matrix";
	}
	
	@RequestMapping(value = "/train")
	public String train(){
		return "/train";
	}
	
	@RequestMapping(value = "/volunteer")
	public String volunteer(){
		return "/volunteer";
	}
	
	@RequestMapping(value = "/housekeeping")
	public String housekeeping(){
		return "/housekeeping";
	}
	
	@RequestMapping(value = "/public")
	public String publicPage(){
		return "/public";
	}
	
	@RequestMapping(value = "/rights")
	public String rights(HttpServletRequest request){
		String code = request.getParameter("code");;
		User user = (User) request.getSession().getAttribute("user");
		if(null==user){
			if (null != code && !"".equals(code)) {
				JSONObject result = WechatUtil.getUserInfoFirst(code,WechatData.APP_ID, WechatData.APP_SECRET);
				if(null!=result){
					System.out.println("第一次微信授权获取信息："+result.toString());
					String accessToken = result.get("access_token").toString();
					String openid = result.get("openid").toString();
					System.out.println(accessToken+"---"+openid);
					user = userService.getByOpenId(openid);
					JSONObject json = WechatUtil.getRealUserInfo(accessToken, openid);
					System.out.println("userInfo:" + json);
					System.out.println("userInfo:" + json.toString());
					if(null==user){
						user = new User();
						user.setAddTime(new Date());
						user.setHeadImg(json.getString("headimgurl").toString());
						user.setLoginTime(new Date());
						user.setNickName(getRealNickName(json.getString("nickname").toString()));
						user.setLoginTimes(1);
						user.setOpenid(openid);
						user.setStatus(1);
						
						user =  userService.save(user);
						request.getSession().setAttribute("user",user);
					}else{
						user.setNickName(getRealNickName(json.getString("nickname").toString()));
						user.setHeadImg(json.getString("headimgurl").toString());
						user.setLoginTimes(user.getLoginTimes()+1);
						
						userService.update(user);
						request.getSession().setAttribute("user",user);
					}
				}
			} 
		}
		return "/rights";
	}
	
	@RequestMapping(value = "/uploadArticleFile")
	public void uploadFileHandler(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String,Object> data = new HashMap<String,Object>();
		if (!file.isEmpty()) {
			InputStream in = null;
			OutputStream out = null;

			try {
				Date date = new Date();
				String rootPath = request.getSession().getServletContext().getRealPath("");
				File dir = new File(rootPath + File.separator + "themes/data/article");
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir.getAbsolutePath() + File.separator + date.getTime()+file.getOriginalFilename());
				in = file.getInputStream();
				out = new FileOutputStream(serverFile);
				byte[] b = new byte[1024];
				int len = 0;
				while ((len = in.read(b)) > 0) {
					out.write(b, 0, len);
				}
				out.close();
				in.close();
				data.put("data","/themes/data/article/"+date.getTime()+file.getOriginalFilename());
				HttpWebIOHelper._printWebJson(data, response);
			} catch (Exception e) {
				data.put("data","fail");
				HttpWebIOHelper._printWebJson(data, response);
			} finally {
				if (out != null) {
					out.close();
					out = null;
				}

				if (in != null) {
					in.close();
					in = null;
				}
			}
		} else {
			data.put("data","fail");
			HttpWebIOHelper._printWebJson(data, response);
		}
	}
	
	@RequestMapping(value = "/woman")
	public String woman(){
		return "/woman";
	}
	
	public static String getRealNickName(String nick){
		StringBuilder nicksb = new StringBuilder();
		int l = nick.length();
		for (int i = 0; i < l; i++) {
			char _s = nick.charAt(i);
			if (isEmojiCharacter(_s)) {
				nicksb.append(_s);
			}
		}
		return nicksb.toString();
	}
	 
	public static boolean isEmojiCharacter(char codePoint){
	     return (codePoint==0x0)||(codePoint==0x9)||
	    		(codePoint==0xA)||(codePoint==0xD)||
	    		((codePoint>=0x20)&&(codePoint<= 0xD7FF))||
	    		((codePoint>=0xE000)&&(codePoint<= 0xFFFD))||
	    		((codePoint>=0x10000)&&(codePoint<=0x10FFFF));
	    }
}
