package Lab_DiamondShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import Lab_DiamondShop.Service.User.HomeServiceImpl;

@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeServiceImpl;
	public ModelAndView _mvShare = new ModelAndView();
	
	//annotation run first
	@PostConstruct
	public ModelAndView Init() {
		_mvShare.addObject("menus", _homeServiceImpl.GetDataMenu());
		return _mvShare;
	}
}
