package com.src.Config;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.config.*;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.SqlServerDialect;
import com.jfinal.plugin.activerecord.tx.TxByActionKeyRegex;
import com.jfinal.plugin.activerecord.tx.TxByActionKeys;
import com.jfinal.plugin.activerecord.tx.TxByMethodRegex;
import com.jfinal.plugin.activerecord.tx.TxByMethods;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.src.Controller.HelloController;
import com.src.model.igxemodel;
import com.src.model.newgxe_user;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年5月15日 上午10:29:59 类说明
 */

public class ProConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		// 设置视图模板
		me.setDevMode(true);
		me.setViewType(ViewType.JFINAL_TEMPLATE);
	}

	public void configRoute(Routes me) {
		// 添加视图的html位置
		me.add("/hello", HelloController.class);
		me.setBaseViewPath("/templates");
	}

	public void configEngine(Engine me) {
		me.setDevMode(true);

	}

	public void configPlugin(Plugins me) {
		// 配置mysql
		// DruidPlugin dp = new DruidPlugin("jdbc:mysql://IP:3306/数据库", "账号",
		// "密码");
		// me.add(dp);
		// ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		// me.add(arp);
		// arp.addMapping("city", citymodel.class);//
		// 可以自己指定需要生成的数据库，前面是table名称，后面实体是映射到表的字段

		// c3p0连接池插件 (配置sqlserver)
		C3p0Plugin C3p0Plugin = createC3p0Plugin();
		me.add(C3p0Plugin);
		// 数据库操作插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
		me.add(arp);
		// 设置方言（很重要，一定要设置）
		arp.setDialect(new SqlServerDialect()); // 也可以是:SqlServerDialect
												// AnsiSqlDialect
		arp.setShowSql(true);
		arp.addMapping("newGXE_OrderFiFaApiInformation", igxemodel.class);
		arp.addMapping("newgxe_user", newgxe_user.class);
	}

	/* 增加事物级别的操作 */
	public void configInterceptor(Interceptors me) {
		// actionKey 正则 实现方式---拦截器
		// me.add(new TxByActionKeyRegex("/user.*"));
		me.add(new ClassInterceptorA());
		me.add(new TxByMethodRegex("(.*save.*|.*update.*)"));
		me.add(new TxByMethods("save", "update"));

		me.add(new TxByActionKeyRegex("/trans.*"));
		me.add(new TxByActionKeys("/tx/save", "/tx/update"));
	}

	public class ClassInterceptorA implements Interceptor {
		public void intercept(Invocation inv) {
			
			System.out.println("调用前的操作");
			System.out.println("请求地址:"+inv.getController().getRequest().getRequestURI());
			Controller ctl = inv.getController();
			String isLogin = (String) ctl.getSession().getAttribute("deindex");
			if(isLogin != null && !isLogin.equals("deindex")){
				System.out.println("wtf!");
				
				ctl.render("/index.jsp");
			}
			inv.invoke();
			System.out.println("调用后的操作");
		}
	}

	public void configHandler(Handlers me) {
	}

	// 获取配置文件的数据
	public static C3p0Plugin createC3p0Plugin() {
		PropKit.use("sqljdbc.properties");
		return new C3p0Plugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.username"),
				PropKit.get("jdbc.password").trim(), PropKit.get("jdbc.driver"));
	}
}
