package Lab_DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Lab_DiamondShop.DTO.ProductsDto;

@Service
public interface ICategoryService {
	public List<ProductsDto> GetProductsByCateId(int id);
	public List<ProductsDto> GetDataProductPaginate(int id,int start,int end);
}
