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

		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("Project identifier '" + projectId + "' doesn't exists");
		}
		return project;
	}
	
	// findAll project
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	// delete project 
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Cannot project with ID " +projectId+ ". This project doesn't exist ");
		}
		projectRepository.delete(project);
	}
}
