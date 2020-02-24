package com.cignex.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cignex.ppmtool.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	Project findByProjectIdentifier(String projectId);
	
}
