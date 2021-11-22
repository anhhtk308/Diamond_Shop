package Lab_DiamondShop.DAO;

import org.springframework.stereotype.Repository;

import Lab_DiamondShop.Entity.MapperUser;
import Lab_DiamondShop.Entity.User;

@Repository
public class UserDao extends BaseDao{
	
	public int addAccount(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO users(user, password, display_name, address)"
				+ " VALUES ('"+user.getUser()+"','"+user.getPassword()+"','"+user.getDisplay_name()+"','"+user.getAddress()+"')");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public User getUser(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM users WHERE user = '"+user.getUser()+"'");
		User userEntity = _jdbcTemplate.queryForObject(sql.toString(),new MapperUser());
		return userEntity;
	}
}
