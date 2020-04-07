package kr.or.connect.payment.dao;


import static kr.or.connect.payment.dao.PaymentDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.payment.dto.Payment;


@Repository
public class PaymentDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	private RowMapper<Payment> rowMapper = BeanPropertyRowMapper.newInstance(Payment.class);
	public PaymentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        		.withTableName("payment");
        		
        		
	}
	
	public List<Payment> allpayment(){
		return jdbc.query(ALL_PAYMENT,Collections.emptyMap(),rowMapper);
	}
	
}
