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
public class DisplayInfoDao {



	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("display_info");
        		
        		
	}
	
	public List<DisplayInfo> displayInfoAll(){
		
		return jdbc.query(DISPLAY_INFO_ALL,Collections.emptyMap(),rowMapper);
	}
	public List<DisplayInfo> selectDisplayInfo(int productId){
		Map<String,?> params = Collections.singletonMap("productId", productId);
		return jdbc.query(DISPLAYINFO_SELECT,params,rowMapper);
	}
	
	


}
