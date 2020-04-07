package kr.or.connect.project3.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import static kr.or.connect.project3.dao.MainpageDaoSqls.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.introspect.WithMember;

import kr.or.connect.project3.dto.ProductImage;
import kr.or.connect.project3.dto.Promotion;

@Repository
public class PromotionDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("promotion");
        		
        		
	}
	
	public List<Promotion> selectPromotion(){
		
		return jdbc.query(PROMOTION_SELECT,Collections.emptyMap(),rowMapper);
	}
	
	
	public int promotionCount() {
		return jdbc.queryForObject(PROMOTION_COUNT, Collections.emptyMap(), Integer.class);
	}
	
}
