package dao;

import java.util.HashMap;

public class Session {
	private final static HashMap<String, Object> datas = new HashMap<String, Object>();
	//Session.getDatas().put("key","value")

	//Session.setData("key","value")
	public static void setData(String key,Object value) {
		datas.put(key,value);
	}
	
	//Session.getData("key")
	public static Object getData(String key) {
		return datas.get(key);
	}
}
