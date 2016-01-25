package cz.morosystems.phase1.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.morosystems.phase1.utils.PropertyPlaceholderConfig;

/**
 * Morosystem test code - phase1
 * ShowPictureController.java
 * Purpose: Controller to show picture.
 *
 * @author Libor Grigerek
 */
@Configuration
@Import(PropertyPlaceholderConfig.class)
@Controller
public class ShowPictureController {
	
	// nacti z configu jmeno adresare
	@Value("${pictureDirectory}") private String dirname;
	// mozne koncovky souboru
	String[] pictExtensions = { "jpg", "png", "gif", "bmp"};
	
	/**
     * Control part when no filename parameter is used.
     *
     * @param model
     * @return showpicture - view name
     */	
	@RequestMapping("/showpicture")
	public String showData(Model model) {
		model.addAttribute("message", "No picture entered. Please enter the parameter filename=picture to URL.");
		model.addAttribute("showpicture", "false");
		return "showpicture";
	}
	
	/**
     * Control part when filename parameter is used.
     *
     * @param model
     * @param filename - name of the picture to be shown
     * @return showpicture - view name
     */	
	@RequestMapping(value = "/showpicture", method = RequestMethod.GET, params={"filename"})
	public String showData(@RequestParam("filename") String filename, Model model) {
		// nacteni obrazku po bytech
		File file = new File(String.format("%s%s%s", dirname, "/", filename));
		model.addAttribute("filename", file.getAbsolutePath());
		// otestuj, zda se jedna o obrazek
		int lastDotInx = filename.lastIndexOf(".");
		String ext = filename.substring(lastDotInx+1,filename.length());
		if (!(Arrays.asList(pictExtensions).contains(ext))) {
			model.addAttribute("message", "Error: It seems not to be a picture file.");
			model.addAttribute("showpicture", "false");
		} else {
			FileInputStream fis;
			int b;
			byte[] buffer = new byte[1024];
			try {
				fis = new FileInputStream(file);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				while ((b = fis.read(buffer)) != -1) {
					bos.write(buffer, 0, b);
				}
				fis.close();
				bos.close();
				byte[] fileBytes = bos.toByteArray();
				byte[] encoded = Base64.getEncoder().encode(fileBytes);
				String encodedString = new String(encoded);
				// ulozeni do modelu jako EncodedString
				model.addAttribute("image", encodedString);
				// ulozeni cesty do modelu
				model.addAttribute("showpicture", "true");
				model.addAttribute("message", "Picture loaded.");
			} catch (FileNotFoundException e) {
				model.addAttribute("message", "Error: No picture found.");
				model.addAttribute("showpicture", "false");
			} catch (IOException e) {
				model.addAttribute("message", "Error: Some problem occured while reading file.");
				model.addAttribute("showpicture", "false");
			}
		}
		//
		return "showpicture";
	}
	

}
