package co.mask.sell.vo;

import java.sql.Date;

public class SellVo {
	private int sellProductNum;
	private int sellNum;
	private Date sellDate;

	public int getSellProductNum() {
		return sellProductNum;
	}

	public void setSellProductNum(int sellProductNum) {
		this.sellProductNum = sellProductNum;
	}

	public int getSellNum() {
		return sellNum;
	}

	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
}
