package Lab_DiamondShop.Controller.User;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Lab_DiamondShop.Entity.User;
import Lab_DiamondShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	
	@RequestMapping(value="dang-ky",method = RequestMethod.GET)
	public ModelAndView register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user",new User());
		return _mvShare;
	}
	
	@RequestMapping(value="dang-ky",method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") User user) {
		int count = accountServiceImpl.addAccount(user);
		if(count > 0) {
			_mvShare.addObject("status","Register successfull");
		}else {
			_mvShare.addObject("status","Register fail");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	@RequestMapping(value="dang-nhap",method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("user") User user) {
		boolean checkLogin = accountServiceImpl.checkAccount(user);
		if(checkLogin) {
			_mvShare.setViewName("redirect:/trang-chu");
			session.setAttribute("LoginInfo", user);
		}else {
			_mvShare.setViewName("user/account/register");
			_mvShare.addObject("statusLogin","Login fail");
		}
		
		return _mvShare;
	}
}
