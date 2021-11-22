package Lab_DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import Lab_DiamondShop.Entity.User;

@Service
public interface IAccountService {
	public int addAccount(User user);
	public boolean checkAccount(User user);
}
