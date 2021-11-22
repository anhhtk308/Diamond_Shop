package Lab_DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import Lab_DiamondShop.DTO.PaginatesDto;

@Service
public class PaginatesServiceImpl implements IPaginatesService{
	
	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage) {
		PaginatesDto paginatesDto = new PaginatesDto();
		paginatesDto.setLimit(limit);
		int total = SetInfoTotalPage(totalData, limit);
		paginatesDto.setTotalPage(total);
		paginatesDto.setCurrentPage(CheckCurrentPage(currentPage, paginatesDto.getTotalPage()));
		
		int start = FindStart(paginatesDto.getCurrentPage(), limit);
		paginatesDto.setStart(start);
		int end = FindEnd(paginatesDto.getStart(),limit, totalData);
		paginatesDto.setEnd(end);
		return paginatesDto;
	}

	private int FindEnd(int start, int limit, int totalData) {
		// TODO Auto-generated method stub
		return start + limit > totalData ? totalData : (start + limit) - 1;
	}

	private int FindStart(int currentPage, int limit) {
		// TODO Auto-generated method stub
		return ((currentPage - 1)*limit);
	}

	private int SetInfoTotalPage(int totalData, int limit) {
		// TODO Auto-generated method stub
		int totalPage = 0;
		if(totalData % limit == 0) {
			totalPage = totalData/limit;
		}else {
			totalPage = (totalData/limit) + 1;
		}
		return totalPage;
	}
	private int CheckCurrentPage(int currentPage, int totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if(currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
