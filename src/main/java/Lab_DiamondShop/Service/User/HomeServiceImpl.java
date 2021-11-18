package Lab_DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab_DiamondShop.DAO.CategoryDao;
import Lab_DiamondShop.DAO.MenuDao;
import Lab_DiamondShop.DAO.ProductDao;
import Lab_DiamondShop.DAO.SlidesDao;
import Lab_DiamondShop.DTO.ProductsDto;
import Lab_DiamondShop.Entity.Category;
import Lab_DiamondShop.Entity.Menu;
import Lab_DiamondShop.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ProductDao productDao;
	
	public List<Menu> GetDataMenu() {
		// TODO Auto-generated method stub
		return menuDao.GetDataMenu();
	}
	public List<Slides> GetDataSlide() {
		// TODO Auto-generated method stub
		return slidesDao.GetDataSlide();
	}
	public List<Category> GetDataCategory() {
		// TODO Auto-generated method stub
		return categoryDao.GetDataCategory();
	}
	public List<ProductsDto> GetHighLightProduct() {
		// TODO Auto-generated method stub
		return productDao.GetHighLightProduct();
	}
	public List<ProductsDto> GetNewProduct() {
		// TODO Auto-generated method stub
		return productDao.GetNewProduct();
	}
	
	

}
