package common.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class WechatUtil {

	/**
	 * 获取accessToken
	 * @param appId
	 * @param appSecret
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String getAccessToken(String appId, String appSecret)throws ClientProtocolException, IOException {
		StringBuffer buffer = new StringBuffer();
		String accessToken = null;
		
		buffer.append("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential");
		buffer.append("&appid=");
		buffer.append(appId);
		buffer.append("&secret=");
		buffer.append(appSecret);

		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(buffer.toString());
		HttpResponse httpResponse;
		httpResponse = client.execute(httpGet);

		int code = httpResponse.getStatusLine().getStatusCode();
		String strResult = EntityUtils.toString(httpResponse.getEntity(),WechatData.CHAR_SET);
		
		if (code == 200) {
			JSONObject jsonObject = JSONObject.fromObject(strResult);
			
			System.out.println(new StringBuffer().append("获取accessToken").append(jsonObject).toString());
			
			if(null!=jsonObject.getString("access_token")){
				accessToken = jsonObject.getString("access_token");
			}
		}

		return accessToken;
	}

	/**
	 * 获取openid
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String getOauthOpenId(String appId,String appSecret,String code) throws ClientProtocolException, IOException{
		StringBuffer buffer = new StringBuffer();
		String openId = null;
		
		buffer.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		buffer.append(appId);
		buffer.append("&secret=");
		buffer.append(appSecret);
		buffer.append("&code=");
		buffer.append(code);
		buffer.append("&grant_type=authorization_code");
		
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(buffer.toString());
		HttpResponse httpResponse;
		httpResponse = client.execute(httpGet);
		int httpCode = httpResponse.getStatusLine().getStatusCode();
		String strResult = EntityUtils.toString(httpResponse.getEntity(),WechatData.CHAR_SET);
		
		if (httpCode == 200) {
			JSONObject jsonObject = JSONObject.fromObject(strResult);
			
			System.out.println(new StringBuffer().append("获取openid返回码:").append(jsonObject).toString());
			if(jsonObject.has("openid")){
				openId = jsonObject.getString("openid");
			}
		}
		
		return openId;
	}
	
	/**
	 * 解析获取支付id
	 * 
	 * @param xml
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getPrePayId(String xml)throws ClientProtocolException, IOException {
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

		@SuppressWarnings("resource")
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		post.setEntity(new StringEntity(xml, WechatData.CHAR_SET));
		HttpResponse response = httpClient.execute(post);
		String jsonStr = EntityUtils.toString(response.getEntity(),WechatData.CHAR_SET);

		System.out.println(new StringBuffer().append("解析支付id:").append(jsonStr).toString());
		
		return jsonStr;
	}

	/**
	 * 获取jsApiTicket
	 * 
	 * @param appId
	 * @param appsecret
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public static String getJSApiTicket(String appId, String appsecret)
			throws ClientProtocolException, IOException {

		String currentJSApiTicket = null;
		StringBuffer buffer = new StringBuffer();
		Map<String, String> tokenMap;

		String accessToken = getAccessToken(appId, appsecret);

		if(null==accessToken){
			currentJSApiTicket = null;
		}
		else{
			buffer.append("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=");
			buffer.append(accessToken);
			buffer.append("&type=jsapi");

			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(buffer.toString());
			HttpResponse httpResponse;
			httpResponse = client.execute(httpGet);

			int code = httpResponse.getStatusLine().getStatusCode();
			String strResult = EntityUtils.toString(httpResponse.getEntity(),WechatData.CHAR_SET);
			if (code == 200) {
				tokenMap = JSONObject.fromObject(strResult);
				
				System.out.println(new StringBuffer().append("jsApiTicket返回码:").append(tokenMap).toString());
				
				if ("ok".equals(tokenMap.get("errmsg").toString())) {
					currentJSApiTicket = tokenMap.get("ticket").toString();
				}
			}
		}
		return currentJSApiTicket;
	}


	/**
	 * 发送模板消息
	 * 
	 * @param data
	 * @param access_token
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String sendMessage(String data, String access_token)throws ParseException, IOException {
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		post.setEntity(new StringEntity(data, WechatData.CHAR_SET));
		HttpResponse response = httpClient.execute(post);
		String jsonStr = EntityUtils.toString(response.getEntity(),WechatData.CHAR_SET);

		System.out.println(new StringBuffer().append("发送模板消息返回码:").append(jsonStr).toString());

		return jsonStr;
	}

	
	/**
	 * Get UserInfo First step
	 * 
	 * @param code
	 * @param APP_ID
	 * @param APP_SECRET
	 * @return
	 */
	public static JSONObject getUserInfoFirst(String code, String APP_ID,
			String APP_SECRET) {

		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ APP_ID + "&secret=" + APP_SECRET + "&code=" + code
				+ "&grant_type=authorization_code";

		String result = "";
		JSONObject result2 = null;
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			connection.connect();

			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			JSONObject json = JSONObject.fromObject(result);

			if (null != json.get("openid").toString()&& !"".equals(json.get("openid").toString())) {
				result2 = json;
			} else {
				result2 = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result2;
	}
	
	/**
	 * Get Real UserInfo
	 * 
	 * @param code
	 * @param APP_ID
	 * @param APP_SECRET
	 * @return
	 */
	public static JSONObject getRealUserInfo(String ACCESS_TOKEN, String OPEND_ID) {

		String url = "https://api.weixin.qq.com/sns/userinfo?access_token="
				+ ACCESS_TOKEN + "&openid=" + OPEND_ID + "&lang=zh_CN";

		String result = "";
		JSONObject result2 = null;
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			connection.connect();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			JSONObject json = JSONObject.fromObject(result);

			if (null != json.get("openid")) {
				result2 = json;
			} else {
				result2 = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result2;
	}

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static void main(String[] args) throws ClientProtocolException,IOException {

	}
}
