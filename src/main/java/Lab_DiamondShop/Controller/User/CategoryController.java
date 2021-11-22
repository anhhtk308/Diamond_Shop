package Lab_DiamondShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Lab_DiamondShop.DTO.PaginatesDto;
import Lab_DiamondShop.Service.User.CategoryServiceImpl;
import Lab_DiamondShop.Service.User.PaginatesServiceImpl;

@Controller
public class CategoryController extends BaseController{

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private PaginatesServiceImpl paginatesServiceImpl;
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView ProductByCate(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("allProductsById",categoryServiceImpl.GetProductsByCateId(Integer.parseInt(id)));
		PaginatesDto paginatesDto = paginatesServiceImpl.GetInfoPaginates(categoryServiceImpl.GetProductsByCateId(Integer.parseInt(id)).size(), 9, 1);
		_mvShare.addObject("paginateInfo",paginatesDto);
		_mvShare.addObject("idCate",id);
		_mvShare.addObject("productPaginate",categoryServiceImpl.GetDataProductPaginate(Integer.parseInt(id),0, 9));
		return _mvShare;
	}
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView ProductByCate(@PathVariable String id,@PathVariable String currentPage) {
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("allProductsById",categoryServiceImpl.GetProductsByCateId(Integer.parseInt(id)));
		PaginatesDto paginatesDto = paginatesServiceImpl.GetInfoPaginates(categoryServiceImpl.GetProductsByCateId(Integer.parseInt(id)).size(), 9, Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo",paginatesDto);
		_mvShare.addObject("idCate",id);
		_mvShare.addObject("productPaginate",categoryServiceImpl.GetDataProductPaginate(Integer.parseInt(id),paginatesDto.getStart(), 9));
		return _mvShare;
	}
}
