package Lab_DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Lab_DiamondShop.DTO.ProductsDto;

@Service
public interface IProductService {
	public List<ProductsDto> GetProductsById(long id);
	public List<ProductsDto> GetProductsByCateID(int id);
}
