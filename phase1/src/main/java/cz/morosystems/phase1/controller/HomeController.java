package cz.morosystems.phase1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Morosystem test code - phase1
 * HomeController.java
 * Purpose: Controller to show welcome page.
 *
 * @author Libor Grigerek
 */
@Controller
public class HomeController {
	/**
     * Control part when / is entered.
     *
     * @param model
     * @return welcome - view name
     */	
	@RequestMapping("/")
	public String welcome(Model model) {
		return "welcome";
	}
}