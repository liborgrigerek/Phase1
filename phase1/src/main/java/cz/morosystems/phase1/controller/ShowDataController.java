package cz.morosystems.phase1.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Morosystem test code - phase1
 * ShowDataController.java
 * Purpose: Controller to show sample data.
 *
 * @author Libor Grigerek
 */
@Controller
public class ShowDataController {
	/**
     * Control part when /showdata is entered.
     *
     * @param model
     * @return showdata - view name
     */	
	@RequestMapping("/showdata")
	public String showData(Model model) {
		// vlozeni pole s ruznymi prvky do modelu
		List<Object> commonArray = new ArrayList<Object>();
		commonArray.add("Pokusny retezec");
		commonArray.add(new Date());
		commonArray.add(new ArrayList<String>(Arrays.asList("place1", "place2", "place3")));
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(12, "Twelve");
		hmap.put(2, "Two");
		hmap.put(7, "Seven");
		hmap.put(49, "Forty-nine");
		hmap.put(3, "Three");
		commonArray.add(hmap);
		model.addAttribute("commonArray", commonArray);
		return "showdata";
	}
}