package com.ppe.assessment.assessment1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ppe.assessment.assessment1.entities.Tutorial;
import com.ppe.assessment.assessment1.exception.TaskAlreadyExists;
import com.ppe.assessment.assessment1.exception.TaskNotFound;
import com.ppe.assessment.assessment1.services.TutorialService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class TutorialController {
//TODO  Please create a service class called TutorialService and implement the current controller methods

    private TutorialService tutorialService;
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Tutorial> retrieve(@PathVariable("id") Long id) throws TaskNotFound  {

    	final Optional<Tutorial> response = tutorialService.fetch(id);
    	if (response.isPresent()) {
    		return new ResponseEntity<>(response.get(), HttpStatus.OK);
    	} else {
    		throw new TaskNotFound(id); 
    	}	
    }
    
    @PostMapping("/post")
    public ResponseEntity<String> save(@RequestBody Tutorial tutorial) throws TaskAlreadyExists {
    	tutorialService.save(tutorial);
    	return new ResponseEntity<>("Save Success", HttpStatus.OK);
    }

    @GetMapping("/tutorials")
    public String getAll(Model model, @Param("keyword") String keyword) {
        try {
            List<Tutorial> tutorials = new ArrayList<>();

            if (keyword == null) {
             //TODO return all tutorials by creating and implementing a corresponding service method in TutorialService
            } else {
            //TODO add service method call to find all tutorials by the supplied keyword

                model.addAttribute("keyword", keyword);
            }
            model.addAttribute("tutorials", tutorials);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "tutorials";
    }

    @GetMapping("/tutorials/new")
    public String addTutorial(Model model) {
        Tutorial tutorial = new Tutorial();
        tutorial.setPublished(true);

        model.addAttribute("tutorial", tutorial);
        model.addAttribute("pageTitle", "Create new Tutorial");

        return "tutorial_form";
    }

    @PostMapping("/tutorials/save")
    public String saveTutorial(Tutorial tutorial, RedirectAttributes redirectAttributes) {
        try {
          //TODO implement this method by creating a service method in TutorialService.java and saving the tutorial data to the H2 database

            redirectAttributes.addFlashAttribute("message", "The Tutorial has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }

        return "redirect:/tutorials";
    }

//    @GetMapping("/tutorials/{id}")
//    public String editTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
//        try {
//          //TODO implement this method by calling a findTutorialsById method in the TutorialService class
//
//
//            model.addAttribute("tutorial", tutorial);
//            model.addAttribute("pageTitle", "Edit Tutorial (ID: " + id + ")");
//
//            return "tutorial_form";
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("message", e.getMessage());
//
//            return "redirect:/tutorials";
//        }
//    }

    @GetMapping("/tutorials/delete/{id}")
    public String deleteTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            //TODO implement this method by calling a new deleteTutorialById method in the TutorialService class you created.

           redirectAttributes.addFlashAttribute("message", "The Tutorial with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/tutorials";
    }

}
