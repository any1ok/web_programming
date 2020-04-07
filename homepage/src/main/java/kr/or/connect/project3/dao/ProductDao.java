package kr.or.connect.project3.dao;

import static kr.or.connect.project3.dao.MainpageDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.project3.dto.DisplayInfo;
import kr.or.connect.project3.dto.Product;
import kr.or.connect.project3.dto.Promotion;
@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("product");
        		
        		
	}
	
	public List<Product> allProduct(){
		return jdbc.query(PRODUCT_ALL,Collections.emptyMap(),rowMapper);
	}
	public List<Product> selectProduct(int categoryId){
		Map<String,?> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.query(PRODUCT_SELECT,params,rowMapper);
	}
	
	
	
	
}
