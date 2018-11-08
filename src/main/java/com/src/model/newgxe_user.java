package com.src.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年11月8日 上午10:25:33 类说明
 */

@SuppressWarnings("serial")
public class newgxe_user extends Model<newgxe_user> {

	public static final newgxe_user dao = new newgxe_user().dao();
	private String userid_int;
	private String FisrtName_nvarchar;
	private String LastName_nvarchar;

	public String getUserid_int() {
		return userid_int;
	}

	public void setUserid_int(String userid_int) {
		this.userid_int = userid_int;
	}

	public String getFirstname_nvarchar() {
		return FisrtName_nvarchar;
	}

	public void setFirstname_nvarchar(String firstname_nvarchar) {
		this.FisrtName_nvarchar = firstname_nvarchar;
	}

	public String getLastname_nvarchar() {
		return LastName_nvarchar;
	}

	public void setLastname_nvarchar(String lastname_nvarchar) {
		this.LastName_nvarchar = lastname_nvarchar;
	}
}
