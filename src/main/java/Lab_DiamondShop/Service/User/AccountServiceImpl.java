package Lab_DiamondShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab_DiamondShop.DAO.UserDao;
import Lab_DiamondShop.Entity.User;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	UserDao userDao = new UserDao();
	
	public int addAccount(User user) {
		user.setPassword(BCrypt.hashpw( user.getPassword(), BCrypt.gensalt(12)));
		return userDao.addAccount(user);
	}

	public boolean checkAccount(User user) {
		// TODO Auto-generated method stub
		String pass = user.getPassword();
		user = userDao.getUser(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

}
