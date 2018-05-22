package com.src.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.src.model.citymodel;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年5月15日 上午10:41:38 类说明
 */

public class HelloController extends Controller {
	
	public void index()
	{
		Map<String, Object> list=new HashMap<String, Object>();
		list.put("id", 123456);
		list.put("name", "hello_jfinal");
		renderJson("Hello",list);

	}
	public void update()
	{
		Map<String, Object> list=new HashMap<String, Object>();
		list.put("id", 123456);
		list.put("name", "hello_jfinal_update");
		renderJson("Hello",list);
	}
	
	public void view()
	{ 
		Map<String, Object> list=new HashMap<String, Object>();
		list.put("id", 123456);
		list.put("name", "hello_jfinal_view");		
		
		List<Object> sList = new ArrayList<Object>();  
		sList.add(list);  
		sList.add(list);		
		
		 setAttr("schoolPage", sList);
		renderTemplate("hello.html");
	}
	/*回去数据库的数据,使用此方法需要在配置文件与数据库映射实体信息,需要mysql包*/
	public void getdata()
	{
	  List<citymodel> list=	new citymodel().dao().find("select * from city");
	  renderJson(list);
	}
}
