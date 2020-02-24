package com.cignex.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.ppmtool.exceptions.ProjectIdException;
import com.cignex.ppmtool.model.Project;
import com.cignex.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	// save/update project service
	public Project saveOrUpdateProject(Project project) {

		// Custom exception
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException(
					"Project identifier '" + project.getProjectIdentifier().toUpperCase() + "' is already exists");
		}

	}
	
	// find project by identifier
	public Project findProjectByIdentifier(String projectId) {
		return projectRepository.findByProjectIdentifier(projectId);
	}

}
