package Lab_DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab_DiamondShop.DTO.ProductsDto;
import Lab_DiamondShop.Entity.Category;
import Lab_DiamondShop.Entity.Menu;
import Lab_DiamondShop.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Category> GetDataCategory();
	public List<Menu> GetDataMenu();
	public List<ProductsDto> GetHighLightProduct();
	public List<ProductsDto> GetNewProduct();
}
