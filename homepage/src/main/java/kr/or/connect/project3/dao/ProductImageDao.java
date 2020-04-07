package kr.or.connect.project3.dao;

import static kr.or.connect.project3.dao.MainpageDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.project3.dto.DisplayInfo;
import kr.or.connect.project3.dto.ProductImage;

@Repository
public class ProductImageDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("productimage");
        		
        		
	}
	
	public List<ProductImage> selectImage(String type){
		Map<String, ?> params = Collections.singletonMap("type",type);
		return jdbc.query(IMAGE_SELECT,params,rowMapper);
	}
	public List<ProductImage> selectImagebyPid(int productId){
		ProductImage p = new ProductImage();
		p.setType("th");
		p.setProductId(productId);
		SqlParameterSource params = new BeanPropertySqlParameterSource(p);
		
		return jdbc.query(IMAGE_SELECTBYPID ,params,rowMapper);
	}
	
}
