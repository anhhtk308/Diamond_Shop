package Lab_DiamondShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Lab_DiamondShop.Service.User.ProductServiceImpl;


@Controller
public class DetailController extends BaseController{
	@Autowired
	private ProductServiceImpl _productServiceImpl;
	
	@RequestMapping(value = "/chi-tiet-san-pham/{id}")
	public ModelAndView Detail(@PathVariable String id) {
		_mvShare.setViewName("user/products/detail");
		_mvShare.addObject("product",_productServiceImpl.GetProductsById(Long.parseLong(id)));
		_mvShare.addObject("productsRela",_productServiceImpl.GetProductsByCateID(_productServiceImpl.GetProductsById(Long.parseLong(id)).get(0).getId_category()));
		return _mvShare;
	}
}
