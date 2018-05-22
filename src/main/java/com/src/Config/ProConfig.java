package com.src.Config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.src.Controller.HelloController;
import com.src.model.citymodel;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年5月15日 上午10:29:59 类说明
 */

public class ProConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JFINAL_TEMPLATE);
	}

	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
		me.setBaseViewPath("/templates");
	}

	public void configEngine(Engine me) {
		me.setDevMode(true);

	}

	public void configPlugin(Plugins me) {
		DruidPlugin dp = new DruidPlugin("jdbc:mysql://192.168.139.128:3306/Movie", "root", "Root-123");
		me.add(dp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		me.add(arp);
		arp.addMapping("city", citymodel.class);// 可以自己指定需要生成的数据库，前面是table名称，后面实体是映射到表的字段
		// arp.addMapping("article", "article_id",
		// Article.class);//前面是table名称，紧接着是字段的主键，后面实体是映射到表的字段
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}
