package Lab_DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import Lab_DiamondShop.DTO.CartDto;

@Service
public interface ICartService {
	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> editCart(long id,int quatity, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart);
	public int totalQuatity(HashMap<Long, CartDto> cart);
	public double totalPrice(HashMap<Long, CartDto> cart);
}
