package com.src.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年5月22日 下午3:49:24 类说明
 */

@SuppressWarnings("serial")
public class citymodel extends Model<citymodel> {
	public static final citymodel dao=new citymodel().dao();
	private int city_id;
	private String city;
	private int country_id;
	private String last_update;

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}

}
