package thesis.app.dao;


import thesis.app.mRule.mCondition;
import thesis.app.mRule.mConsequence;
import thesis.app.mRule.mRule;
import thesis.app.dao.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public class DataResponsory {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<mRule> getAllRule() {		
		return jdbcTemplate.query("Select * from rule", MapperResponsory.ruleMapper);		
	}
	public List<mCondition> getAllConditions(int rule_id) {
		return jdbcTemplate.query("Select * from condition", MapperResponsory.conditionMapper);
	}
	public List<mConsequence> getAllConsequences(int rule_id) {
		return jdbcTemplate.query("Select * from consequence", MapperResponsory.consequenceMapper);
	}
	
}
