package thesis.web.run;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import thesis.app.entity.*;
import thesis.app.helper.RulesManager;



@Service
public class RunService {

	private static Logger log = LoggerFactory.getLogger(RunService.class);

	// @Autowired
	// public DesignService(KieContainer kieContainer) {
	// super();
	// log.info("Initialising a session.");
	// this.kieContainer = kieContainer;
	// }

	public RunService() {
		// log.info("Initialising a session.");
		// this.kieContainer =
		// KieServices.Factory.get().getKieClasspathContainer();
	}

	public Questionaire getQuestionaire(Factor factor) {
		try {
			
			log.info("Open Design service");
			Questionaire qn = RulesManager.getQuestionaire(factor);
			 
			return qn;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}
}
