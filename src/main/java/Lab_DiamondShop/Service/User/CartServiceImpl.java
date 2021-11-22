package Lab_DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab_DiamondShop.DAO.CartDao;
import Lab_DiamondShop.DTO.CartDto;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private CartDao cartDao;
	
	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(id, cart);
	}

	public HashMap<Long, CartDto> editCart(long id, int quatity, HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.editCart(id, quatity, cart);
	}

	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id, cart);
	}

	public int totalQuatity(HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.totalQuatity(cart);
	}

	public double totalPrice(HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.totalPrice(cart);
	}

}
