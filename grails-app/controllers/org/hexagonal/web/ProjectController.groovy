package org.hexagonal.web

import org.hexagonal.models.Project
import grails.converters.JSON

class ProjectController{

    def projectRepository
    def jsonService

    def index(){ }
    
    def save(){
        def projectInstance = new Project(request.JSON)
        projectInstance = projectRepository.save(projectInstance)
        render(contentType: "application/json"){
            jsonService.render(projectInstance)
        }
    }


    def list(){
        render projectRepository.list() as JSON
    }


    def renderAsJson = {item->
        def mocks = [id: 1, name: 'shit']
        render item as JSON
    }

}
