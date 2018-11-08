package com.src;

import com.jfinal.core.JFinal;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年5月15日 上午10:50:48 类说明
 */

public class JFinalMain {
	public static void main(String[] args) {
		JFinal.start("/src/main/webapp", 80, "/", 5);
		//JFinal.start("WebRoot", 8080, "/", 5);
	}
}
