package thesis.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import thesis.app.mRule.mCondition;
import thesis.app.mRule.mConsequence;
import thesis.app.mRule.mRule;

public class MapperResponsory {

	public MapperResponsory() {
		// TODO Auto-generated constructor stub
	}
	public static final RowMapper<mRule> ruleMapper = new RowMapper<mRule>() {
		public mRule mapRow(ResultSet rs, int rowNum) throws SQLException {
			mRule rule = new mRule(rs.getInt("rule_id"), rs.getNString("name"), rs.getNString("description"), rs.getInt("salience")); // ,
			return rule;
		}
	};
	public static final RowMapper<mCondition> conditionMapper = new RowMapper<mCondition>() {
		public mCondition mapRow(ResultSet rs, int rowNum) throws SQLException {
			//mCondition mCondition = new mCondition(rs.getInt("cond_id"), rs.getNString("name"), rs.getNString("description"), rs.getInt("object_id"), rs.getInt("operator_id"), rs.getInt("value_id") ); // ,
			mCondition mCondition = new mCondition( ); // ,
			return mCondition;
		}
	};
	public static final RowMapper<mConsequence> consequenceMapper = new RowMapper<mConsequence>() {
		public mConsequence mapRow(ResultSet rs, int rowNum) throws SQLException {
			//mConsequence mConsequence = new mConsequence(rs.getInt("cons_id"), rs.getNString("name"), rs.getNString("description"), rs.getInt("object_id"), rs.getInt("operator_id"), rs.getInt("value_id") ); // ,
			mConsequence mConsequence = new mConsequence(); // ,
			return mConsequence;
		}
	};
}
