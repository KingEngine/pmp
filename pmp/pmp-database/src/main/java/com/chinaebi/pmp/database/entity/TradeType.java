package com.chinaebi.pmp.database.entity;

/**
 * 对应表 trade_type
 * 
 * @author king
 *
 */
public class TradeType implements java.io.Serializable {

	private static final long serialVersionUID = -3537594491481357140L;
	private String tradeCode;/* 对应表中trade_code */
	private String tradeName;/* 对应表中trade_name */
	private String tradeTypeCategoryId;/* 对应表中trade_type_category_id */

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getTradeTypeCategoryId() {
		return tradeTypeCategoryId;
	}

	public void setTradeTypeCategoryId(String tradeTypeCategoryId) {
		this.tradeTypeCategoryId = tradeTypeCategoryId;
	}
}
