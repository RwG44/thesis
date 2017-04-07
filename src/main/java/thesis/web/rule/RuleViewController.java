package thesis.web.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thesis.app.entity.*;

@Controller
public class RuleViewController {

	private static Logger log = LoggerFactory.getLogger(RuleViewController.class);

	private final RuleViewService dService;

	@Autowired
	public RuleViewController(RuleViewService dService) {
		this.dService = dService;
	}

	@RequestMapping(value = "/rules/view") // , method = RequestMethod.GET) //,
										// produces = "application/json")
	public String design(@RequestParam(required = false, defaultValue = "1") int area,
			@RequestParam(required = false, defaultValue = "1") int stype,
			@RequestParam(required = false, defaultValue = "1") int object,
			@RequestParam(required = false, defaultValue = "1") int casing, Model model) {

		Factor factor = new Factor(area, stype, object, casing);

		log.info("Factors request received for: " + factor.getArea() + ", " + factor.getStype() + ", "
				+ factor.getObject() + ", " + factor.getCasing());

		//model.addAttribute("questionaire", questionaire);
		
		
		return "/rulesview";
	}

}
