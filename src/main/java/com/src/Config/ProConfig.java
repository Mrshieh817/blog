package com.src.Config;

import com.jfinal.config.*;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.src.Controller.HelloController;

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
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}
