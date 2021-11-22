package Lab_DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab_DiamondShop.DAO.ProductDao;
import Lab_DiamondShop.DTO.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private ProductDao productDao;
	
	public List<ProductsDto> GetProductsByCateId(int id) {
		// TODO Auto-generated method stub
		return productDao.GetAllProductByCateID(id);
	}
	
	public List<ProductsDto> GetDataProductPaginate(int id,int start, int end) {
		// TODO Auto-generated method stub
		List<ProductsDto> products = productDao.GetDataProductPaginate(id,start, end);
		return products;
	}

	

}
