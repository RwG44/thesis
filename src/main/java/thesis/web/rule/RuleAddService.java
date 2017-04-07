package thesis.web.rule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import thesis.app.dao.DataResponsory;
import thesis.app.mRule.mRule;



@Service
public class RuleAddService {

	private static Logger log = LoggerFactory.getLogger(RuleAddService.class);

	// @Autowired
	// public DesignService(KieContainer kieContainer) {
	// super();
	// log.info("Initialising a session.");
	// this.kieContainer = kieContainer;
	// }

	public RuleAddService() {
		// log.info("Initialising a session.");
		// this.kieContainer =
		// KieServices.Factory.get().getKieClasspathContainer();
	}
	public void saveRule() {
		DataResponsory dataResponsory = new DataResponsory();
		int out = dataResponsory.getJdbcTemplate().queryForObject("select count(*) from thesis.rule", Integer.class);
		
		log.info(String.valueOf(out));
	}
	
}
