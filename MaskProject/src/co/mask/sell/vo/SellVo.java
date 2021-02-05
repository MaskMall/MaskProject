package co.mask.sell.vo;

import java.sql.Date;

public class SellVo {
	private int sellProductNum;
	private int sellNum;
	private Date sellDate;
	private String memberId;
	private int productNum;
	private String productName;
	private int productQunt;
	private int productPrice;
	private String ProductSeller;



	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQunt() {
		return productQunt;
	}

	public void setProductQunt(int productQunt) {
		this.productQunt = productQunt;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSeller() {
		return ProductSeller;
	}

	public void setProductSeller(String productSeller) {
		ProductSeller = productSeller;
	}

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
