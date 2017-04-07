package thesis.web.rule;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import thesis.app.dao.DataResponsory;
import thesis.app.mRule.mCondition;
import thesis.app.mRule.mConsequence;
import thesis.app.mRule.mRule;

@Controller
public class RuleAddController {

	private static Logger log = LoggerFactory.getLogger(RuleAddController.class);
	
	@Autowired
	private DataResponsory dataResponsory;
	private final RuleAddService dService;

	@Autowired
	public RuleAddController(RuleAddService dService) {
		 this.dService = dService;
	}

	@RequestMapping(value = "/rule/add", method = RequestMethod.GET) // ,
	// produces = "application/json")
	public String addRule(Model model, HttpSession session) {

		mRule mRule = new mRule();
		mCondition mCondition = new mCondition();
		mConsequence mConsequence = new mConsequence();
		session.setAttribute("mRule", mRule);
		model.addAttribute("mCondition", mCondition);
		model.addAttribute("mConsequence", mConsequence);
		return "rule/add";
	}

	@RequestMapping(value = "/rule/add", method = RequestMethod.POST) // ,
	public String createCond(@RequestParam(required = false) String action, @ModelAttribute mCondition condition,
			@ModelAttribute mConsequence consequence, @SessionAttribute mRule mRule, BindingResult errors, Model model,
			HttpSession session) {

		// System.out.println(condition.getObject());
		// System.out.println(condition.getOperator());

		// System.out.println(condition.getValue());
		// System.out.println(consequence.getValue());

		switch (action) {
		case "cond":

			if (condition.getObject() != null) {
				//mRule.addConditions(condition);
			}
			break;
		case "cons":
//			if (consequence.getObject() != null) {
//				mRule.addConsequences(consequence);
//			}
			break;
		case "save":
			int out = dataResponsory.getJdbcTemplate().queryForObject("select count(*) from thesis.rule", Integer.class);
			
			log.info(String.valueOf(out));
			break;
		default:
			break;
		}

		session.setAttribute("mRule", mRule);
		model.addAttribute("mCondition", new mCondition());
		model.addAttribute("mConsequence", new mConsequence());
		return "rule/add";
	}

	// @RequestMapping(value = "/rules/create/consequence", method =
	// RequestMethod.POST) // ,
	// public String createCons(@ModelAttribute mConsequence consequence,
	// @SessionAttribute mRule mRule, BindingResult errors, Model
	// model,HttpSession session) {
	//
	//// System.out.println(consequence.getName());
	// System.out.println(consequence.getObject());
	//
	//
	// if (consequence.getObject() != "") {
	// mRule.addConsequences(consequence);
	// consequence = new mConsequence();
	// }
	//
	// session.setAttribute("mRule", mRule);
	// model.addAttribute("mCondition", new mCondition());
	// model.addAttribute("mConsequence", consequence);
	//
	// return "rulesadd";
	// }
}
