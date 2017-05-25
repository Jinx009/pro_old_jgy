package common.wechat;

import common.helper.MD5Util;

public class WechatData {
	
	public static final String APP_ID = "wx1c0b240b67b3873e";
	public static final String APP_SECRET = "c93f64984555059f2d93e614b97b2c19";
	public static final String TOKEN = "test";
	public static final String CHAR_SET = "utf-8";
	public static final String OAUTH_URL_ONE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+APP_ID+"&redirect_uri=";
	public static final String OAUTH_URL_TWO = "http://www.jinxq.club";
	public static final String OAUTH_URL_THREE = "&response_type=code&scope=snsapi_base&state=state#wechat_redirect";
	
	/**
	 * 重定向链接
	 * @return
	 */
	public static String getTeacherOauthUrl(){
		StringBuffer buffer = new StringBuffer();
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		String pwd = MD5Util.toMD5("admin");
		System.out.println(pwd);
	}
}
