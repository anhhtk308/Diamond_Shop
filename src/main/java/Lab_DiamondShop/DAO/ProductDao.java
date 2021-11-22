package Lab_DiamondShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Lab_DiamondShop.DTO.ProductsDto;
import Lab_DiamondShop.DTO.ProductsDtoMapper;

@Repository
public class ProductDao extends BaseDao {

	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.id as id_product,p.id_category,p.sizes,p.name,p.price,p.sale, ");
		sql.append("p.title,p.highlight,p.new_product,p.detail,p.created_at,p.update_at,c.id as id_color, ");
		sql.append("c.name as name_color, c.code,c.img from products as p INNER join colors as c on ");
		sql.append("p.id = c.id_product ");
		return sql;
	}
	
	private String sqlProduct(boolean newProduct, boolean hightlight) {
		StringBuffer sql = sqlString();
		if(hightlight) {
			sql.append("where p.highlight = true ");
		}
		if(newProduct) {
			sql.append("where p.new_product = true ");
		}
		
		sql.append("GROUP by p.id, c.id_product order by rand() ");
		if(hightlight) {
			sql.append("LIMIT 6");
		}
		if(newProduct) {
			sql.append("LIMIT 12");
		}
		return sql.toString();
	}
	private StringBuffer sqlProductsByCategoryId(int id) {
		StringBuffer sql = sqlString();
		sql.append("where p.id_category = " + id);
		sql.append(" GROUP by p.id, c.id_product");
		return sql;
	}
	private String sqlProductsPaginate(int id,int start,int end) {
		StringBuffer sql = sqlProductsByCategoryId(id);
		sql.append(" LIMIT " + start + ", " + end);
		return sql.toString();
	}
	
	private String sqlProductById(long id) {
		StringBuffer sql = sqlString();
		sql.append("where p.id = " + id);
		sql.append(" GROUP by p.id, c.id_product");
		return sql.toString();
	}

	public List<ProductsDto> GetHighLightProduct() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		list = _jdbcTemplate.query(sqlProduct(false,true), new ProductsDtoMapper());
		return list;
	}
	public List<ProductsDto> GetNewProduct() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		list = _jdbcTemplate.query(sqlProduct(true,false), new ProductsDtoMapper());
		return list;
	}
	public List<ProductsDto> GetAllProductByCateID(int id) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		list = _jdbcTemplate.query(sqlProductsByCategoryId(id).toString(), new ProductsDtoMapper());
		return list;
	}
	public List<ProductsDto> GetDataProductPaginate(int id, int start,int end) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		list = _jdbcTemplate.query(sqlProductsPaginate(id,start,end), new ProductsDtoMapper());
		return list;
	}

	public List<ProductsDto> GetProductByID(long id) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		list = _jdbcTemplate.query(sqlProductById(id), new ProductsDtoMapper());
		return list;
	}
	public ProductsDto FindProductByID(long id) {
		ProductsDto product = _jdbcTemplate.queryForObject(sqlProductById(id), new ProductsDtoMapper());
		return product;
	}
}
