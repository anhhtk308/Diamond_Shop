package Lab_DiamondShop.DTO;

public class CartDto {
	private int quatity;
	private double totalPrice;
	private ProductsDto product;
	public CartDto() {
		super();
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ProductsDto getProduct() {
		return product;
	}
	public void setProduct(ProductsDto product) {
		this.product = product;
	}
	public CartDto(int quatity, double totalPrice, ProductsDto product) {
		super();
		this.quatity = quatity;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	
}
