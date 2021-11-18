package Lab_DiamondShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	@RequestMapping(value = {"/","/trang-chu"})
	public ModelAndView Index() {
//		ModelAndView mv = new ModelAndView("user/index");
//		mv.setView("user/index");
		_mvShare.addObject("slides", _homeServiceImpl.GetDataSlide());
		_mvShare.addObject("categories", _homeServiceImpl.GetDataCategory());
		_mvShare.addObject("highlightProducts", _homeServiceImpl.GetHighLightProduct());
		_mvShare.addObject("newProducts", _homeServiceImpl.GetNewProduct());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
	@RequestMapping(value = {"/product"})
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/product");
		return mv;
	}
	
}
