package com.ppe.assessment.assessment1.controller;

import com.ppe.assessment.assessment1.entities.Tutorial;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO BONUS POINTS.  Create an accessible api to expose the get tutorial by id method
// which should be visible on the swagger page after implementation at
// http://localhost:<server.port>/swagger-ui.html
//
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TutorialsAPIController {

}
