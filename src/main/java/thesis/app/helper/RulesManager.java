/**
 * 
 */
package thesis.app.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.definition.rule.Rule;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Admin
 *
 */
import thesis.app.entity.Factor;
import thesis.app.entity.Questionaire;

//@SuppressWarnings("deprecation")
public class RulesManager {

	/**
	 * a
	 */
	private static Logger log = LoggerFactory.getLogger(RulesManager.class);

	public RulesManager() {
		// TODO Auto-generated constructor stub
	}

	public static Questionaire getQuestionaire(Factor factor) {
		try {

			log.info("Initialising a kbase.");

			// -------------------------------------
			KieServices kieServices = KieServices.Factory.get();

			// Create File System services
			KieFileSystem kFileSystem = kieServices.newKieFileSystem();

			File file1 = new File("src/main/resources/rules/Rules.drl");
			File file2 = new File("src/main/resources/rules/Helper.drl");
			File file3 = new File("src/main/resources/rules/EnvSetup.drl");
			
			Resource resource1 = kieServices.getResources().newFileSystemResource(file1)
					.setResourceType(ResourceType.DRL);
			kFileSystem.write(resource1);

			Resource resource2 = kieServices.getResources().newFileSystemResource(file2)
					.setResourceType(ResourceType.DRL);
			kFileSystem.write(resource2);

			kFileSystem.write(kieServices.getResources().newFileSystemResource(file3)
					.setResourceType(ResourceType.DRL));

//			mRule rule = new mRule(20);
//
//			mCondition c1 = new mCondition("factor_cond", "area == " + factor.getArea());
//			mCondition c2 = new mCondition("item_cond", "ID == 1");
//			mCondition c3 = new mCondition("question_cond", "ID == 1");
//			// Condition c1 = new Condition("item_cond", "ID = 1");
//
//			mConsequence cs1 = new mConsequence("rule_cons", "addElementToList(options, new Option(2,'Place 2', 1));");
//
//			rule.addConditions(c1, c2, c3);
//			rule.addConsequences(cs1);
//
//			//log.info(rule.toString());
//
//			Resource resource3 = kieServices.getResources().newByteArrayResource(rule.toString().getBytes())
//					.setResourceType(ResourceType.DRL);
//
//			kFileSystem.write("src/main/resources/simple.drl", resource3);
//			
			
			// kieModule is automatically deployed to KieRepository if
			// successfully built.
			KieBuilder kbuilder = kieServices.newKieBuilder(kFileSystem);
			kbuilder.buildAll();  

			if (kbuilder.getResults().hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
				throw new RuntimeException("Build time Errors: " + kbuilder.getResults().toString());
			}

			KieContainer kContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());

			KieSession kSession = kContainer.newKieSession();

			Rule rule1 = kContainer.getKieBase().getRule("thesis.app.rules", "Rule #20");
			log.info(String.valueOf(rule1 == null));

			// Create a initial questionaire
			Questionaire qn = new Questionaire();

			// Insert facts into rules base
			kSession.insert(factor);
			kSession.insert(qn);

			log.info(String.valueOf(qn == null));
			// fire all rules to add items to questionaire, get back the number
			// of run rules
			int fired = kSession.fireAllRules();
			qn = findFact(kSession);
			// log.info(String.valueOf(qn == null));
			// Print out for logging
			log.info("Number of Items: " + qn.getItemList().size() + "; Number of Rules: " + fired);

			return qn;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	private static Questionaire findFact(KieSession kieSession) {

		// Find all facts and 1st generation child classes of Questionaire.
		ObjectFilter qFilter = new ObjectFilter() {
			public boolean accept(Object object) {
				if (Questionaire.class.equals(object.getClass()))
					return true;
				if (Questionaire.class.equals(object.getClass().getSuperclass()))
					return true;
				return false;
			}
		};

		// printFactsMessage(kieSession);

		List<Questionaire> facts = new ArrayList<Questionaire>();
		for (FactHandle handle : kieSession.getFactHandles(qFilter)) {
			facts.add((Questionaire) kieSession.getObject(handle));
		}
		if (facts.size() == 0) {
			return null;
		}
		// Assumes that the rules will always be generating a single
		// Questionaire.
		return facts.get(0);
	}
}
