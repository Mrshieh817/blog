package com.src.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.src.model.citymodel;
import com.src.model.igxemodel;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年5月15日 上午10:41:38 类说明
 */

public class HelloController extends Controller {

	public void index() {
		Map<String, Object> list = new HashMap<String, Object>();
		list.put("id", 123456);
		list.put("name", "hello_jfinal");
		renderJson("Hello", list);

	}

	public void update() {
		Map<String, Object> list = new HashMap<String, Object>();
		list.put("id", 123456);
		list.put("name", "hello_jfinal_update");
		renderJson("Hello", list);
	}

	public void view() {
		Map<String, Object> list = new HashMap<String, Object>();
		list.put("id", 123456);
		list.put("name", "hello_jfinal_view");

		List<Object> sList = new ArrayList<Object>();
		sList.add(list);
		sList.add(list);

		setAttr("schoolPage", sList);
		renderTemplate("hello.html");
	}

	/* 回去数据库的数据,使用此方法需要在配置文件与数据库映射实体信息,需要mysql包 */
	public void getdata() {
		String from = "from newGXE_OrderFiFaApiInformation ";
		String totalRowSql = "select count(*) " + from; 
		String findSql = "select * " + from + " order by id_int desc ";
		//List<Record> record =Db.query("");
		Page<igxemodel> list = new igxemodel().dao().paginateByFullSql(2, 10, totalRowSql, findSql);
		renderJson(list);
	}

	/* 事物级别批量更改数据 */
	@Before(Tx.class)
	public void updatebysql() {
		boolean succeed = false;
		Map<String, Object> list = new HashMap<String, Object>();
		try {
			succeed = Db.tx(new IAtom() {
				public boolean run() throws SQLException {
					Db.update("update newGXE_OrderFiFaApiInformation set orderid_int = orderid_int - ? where id_int = ?",100, 0);
					Db.update("update newGXE_OrderFiFaApiInformation set orderid_int = orderid_int + ? where d_int = ?",100, 0);
					return true;
				}
			});
			list.put("resultstatus", succeed);
			list.put("resultstinfo", succeed == true ? "成功" : "失败");
		} catch (Exception e) {
			succeed = false;
			list.put("resultstatus", succeed);
			list.put("resultstinfo", e.getMessage());
		}
		renderJson("结果", list);
	}

}
