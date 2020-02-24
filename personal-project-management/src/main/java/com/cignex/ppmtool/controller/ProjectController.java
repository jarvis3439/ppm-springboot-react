package com.cignex.ppmtool.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.ppmtool.model.Project;
import com.cignex.ppmtool.services.ProjectService;

@RestController
@RequestMapping("api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

		/*
		 * logic for getting invalid object response in better format
		 * 
		 * { "field" : "defaultMessage" "field" : "defaultMessage" }
		 */

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		Project projectOne = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
}
