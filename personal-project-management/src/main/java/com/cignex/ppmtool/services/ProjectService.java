package com.cignex.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.ppmtool.model.Project;
import com.cignex.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	// save/update project service
	public Project saveOrUpdateProject(Project project) {
		
		return projectRepository.save(project);
	}
	
}
