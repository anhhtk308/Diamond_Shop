package Lab_DiamondShop.DAO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Lab_DiamondShop.DTO.CartDto;
import Lab_DiamondShop.DTO.ProductsDto;

@Repository
public class CartDao extends BaseDao {

	@Autowired
	ProductDao productDao = new ProductDao();

	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productDao.FindProductByID(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuatity(itemCart.getQuatity() + 1);
			itemCart.setTotalPrice(product.getPrice() * itemCart.getQuatity());
		}else {
			itemCart.setProduct(product);
			itemCart.setQuatity(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> editCart(long id, int quatity, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuatity(quatity);
			itemCart.setTotalPrice(quatity * itemCart.getProduct().getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int totalQuatity(HashMap<Long, CartDto> cart) {
		int total = 0;
		for(Map.Entry<Long, CartDto> itemCart: cart.entrySet()) {
			total += itemCart.getValue().getQuatity();
		}
		return total;
	}

	public double totalPrice(HashMap<Long, CartDto> cart) {
		double total = 0;
		for(Map.Entry<Long, CartDto> itemCart: cart.entrySet()) {
			total += itemCart.getValue().getTotalPrice();
		}
		return total;
	}
}
