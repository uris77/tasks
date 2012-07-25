package org.hexagonal.web

import org.hexagonal.models.Project
import grails.converters.JSON

class ProjectController{

    def projectRepository
    def jsonService

    def index(){ }
    
    def save(){
        Project projectInstance = new Project(params)
        projectInstance = projectRepository.save(projectInstance)
        render jsonService.render(projectInstance) as JSON
    }


    def list(){
        //render jsonService.renderProjectList() as JSON
        render projectRepository.list() as JSON
    }

}
