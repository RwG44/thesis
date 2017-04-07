package thesis.web.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thesis.app.entity.Factor;
import thesis.app.entity.Questionaire;

@Controller
public class RunController {

	private static Logger log = LoggerFactory.getLogger(RunController.class);

	private final RunService dService;

	@Autowired
	public RunController(RunService dService) {
		this.dService = dService;
	}

	@RequestMapping(value = "/run") // , method = RequestMethod.GET) //,
										// produces = "application/json")
	public String design(@RequestParam(required = false, defaultValue = "1") int area,
			@RequestParam(required = false, defaultValue = "1") int stype,
			@RequestParam(required = false, defaultValue = "1") int object,
			@RequestParam(required = false, defaultValue = "1") int casing, Model model) {

		// Factor factor = new Factor( Integer.parseInt(area),
		// Integer.parseInt(stype), Integer.parseInt(object),
		// Integer.parseInt(casing));
		Factor factor = new Factor(area, stype, object, casing);

		log.info("Factors request received for: " + factor.getArea() + ", " + factor.getStype() + ", "
				+ factor.getObject() + ", " + factor.getCasing());

		Questionaire questionaire = dService.getQuestionaire(factor);
		model.addAttribute("questionaire", questionaire);
		
		return "run";
	}

}
