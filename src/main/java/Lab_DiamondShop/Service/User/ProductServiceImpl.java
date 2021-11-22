package Lab_DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab_DiamondShop.DAO.ProductDao;
import Lab_DiamondShop.DTO.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	ProductDao productDao;

	public List<ProductsDto> GetProductsById(long id) {
		// TODO Auto-generated method stub
		return productDao.GetProductByID(id);
	}

	public List<ProductsDto> GetProductsByCateID(int id) {
		// TODO Auto-generated method stub
		return productDao.GetAllProductByCateID(id);
	}
	
	

}
