package co.mask.product.vo;

public class ProductVo {
	private int productNum;
	private String productName;
	private int productQunt;
	private int productPrice;
	private String ProductSeller;

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
}
