package Lab_DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import Lab_DiamondShop.DTO.PaginatesDto;

@Service
public interface IPaginatesService {
	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
}
