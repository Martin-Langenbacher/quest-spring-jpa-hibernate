package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SchoolController {

    // TODO : get school repository by dependency injection
	@Autowired
	private SchoolRepository repository;
	
	
	// read all ...
	@GetMapping("/schools")
	public String getAll(Model model) {
		
		// TODO : find all schools
		model.addAttribute("schools", repository.findAll());
		
		return "schools";
	}
	
	
	// read one...
    @GetMapping("/school")
    public String getSchool(Model model,
                            @RequestParam(required = false) Long id) {

        // TODO : find one school by id
    	School school = new School();
    	if (id != null) {
    		Optional<School> optionalSchool = repository.findById(id);
    		if (optionalSchool.isPresent()) {
    			school = optionalSchool.get();
    		}
    	}
    	model.addAttribute("school", school);

        return "school";
    }
    
/* additional information out of the quest:    
    
    
--> This is significantly different from the code that we have written before
    particularly with the use of the methods: isPresent and get when calling for
    repository.findById(id).
    
    The reason for this is as follows: findById does not return a Wizard but an Optional<Wizard>!
    The class java.util.Optional "wraps" a class and adds (among other things) the following methods:
    
    - isPresent: returns true if an element has been found in the database, false if not
    - get: if an element has been found, it returns its value, otherwise it raises an exception
    
    You will find additional information about the class Optional in the resources section.
    When displaying a wizard, the following text will appear in the console of Spring:
    
*/
    
        

    // create / update ...
    @PostMapping("/school")
    public String postSchool(@ModelAttribute School school) {

        // TODO : create or update a school
    	repository.save(school);
    	return "redirect:/schools";
    }
    
/*  Additional INFO:  
    
    There are two possibilities when it comes to the POSTed Wizard wizard.
    
    - either it has an id of null and the wizard is created in a database
    - or it already has an id and the data of the corresponding wizard is modified
    
*/    
    
    

    // delete...
    // --> This is also no different to what you've been doing so far.
    @GetMapping("/school/delete")
    public String deleteSchool(@RequestParam Long id) {

        // TODO : delete a school
    	repository.deleteById(id);

        return "redirect:/schools";
    }
}



