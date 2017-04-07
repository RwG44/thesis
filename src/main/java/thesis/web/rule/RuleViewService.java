package thesis.web.rule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import thesis.app.entity.*;
import thesis.app.helper.RulesManager;



@Service
public class RuleViewService {

	private static Logger log = LoggerFactory.getLogger(RuleViewService.class);

	// @Autowired
	// public DesignService(KieContainer kieContainer) {
	// super();
	// log.info("Initialising a session.");
	// this.kieContainer = kieContainer;
	// }

	public RuleViewService() {
		// log.info("Initialising a session.");
		// this.kieContainer =
		// KieServices.Factory.get().getKieClasspathContainer();
	}
	
}
