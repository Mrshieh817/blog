package com.src.model;

import com.jfinal.plugin.activerecord.Model;

/**
* @author 作者:大飞
* @version 创建时间：2018年5月22日 下午4:53:02
* 类说明
*/

@SuppressWarnings("serial")
public class igxemodel extends Model<igxemodel>{
 public static final igxemodel dao=new igxemodel().dao();
	private Integer ID_int;
	private String Orderid_int;
	private String ServerName_nvarchar;
	private String Serverid_int;
	private String BuyerCharacter_nvarchar;
	private String AmountQty_int;
	private String UnitPrice_float;
	private String Company_nvarchar;
	private String Total_float;
	private String Pattern_nvarchar;
	private String orderstate;
	private String OrderUserKey_nvarchar;
	private String CreateTime_datetime;
	
	public Integer getID_int() {
		return ID_int;
	}

	public void setID_int(Integer iD_int) {
		ID_int = iD_int;
	}

	public String getOrderid_int() {
		return Orderid_int;
	}

	public void setOrderid_int(String orderid_int) {
		Orderid_int = orderid_int;
	}

	public String getServerNmae_nvarchar() {
		return ServerName_nvarchar;
	}

	public void setServerNmae_nvarchar(String serverNmae_nvarchar) {
		ServerName_nvarchar = serverNmae_nvarchar;
	}

	public String getServerName_nvarchar() {
		return ServerName_nvarchar;
	}

	public void setServerName_nvarchar(String serverName_nvarchar) {
		ServerName_nvarchar = serverName_nvarchar;
	}

	public String getServerid_int() {
		return Serverid_int;
	}

	public void setServerid_int(String serverid_int) {
		Serverid_int = serverid_int;
	}

	public String getBuyerCharacter_nvarchar() {
		return BuyerCharacter_nvarchar;
	}

	public void setBuyerCharacter_nvarchar(String buyerCharacter_nvarchar) {
		BuyerCharacter_nvarchar = buyerCharacter_nvarchar;
	}

	public String getAmountQty_int() {
		return AmountQty_int;
	}

	public void setAmountQty_int(String amountQty_int) {
		AmountQty_int = amountQty_int;
	}

	public String getUnitPrice_float() {
		return UnitPrice_float;
	}

	public void setUnitPrice_float(String unitPrice_float) {
		UnitPrice_float = unitPrice_float;
	}

	public String getCompany_nvarchar() {
		return Company_nvarchar;
	}

	public void setCompany_nvarchar(String company_nvarchar) {
		Company_nvarchar = company_nvarchar;
	}

	public String getTotal_float() {
		return Total_float;
	}

	public void setTotal_float(String total_float) {
		Total_float = total_float;
	}

	public String getPattern_nvarchar() {
		return Pattern_nvarchar;
	}

	public void setPattern_nvarchar(String pattern_nvarchar) {
		Pattern_nvarchar = pattern_nvarchar;
	}

	public String getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public String getOrderUserKey_nvarchar() {
		return OrderUserKey_nvarchar;
	}

	public void setOrderUserKey_nvarchar(String orderUserKey_nvarchar) {
		OrderUserKey_nvarchar = orderUserKey_nvarchar;
	}

	public String getCreateTime_datetime() {
		return CreateTime_datetime;
	}

	public void setCreateTime_datetime(String createTime_datetime) {
		CreateTime_datetime = createTime_datetime;
	}
}
