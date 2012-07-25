package org.hexagonal.web

import spock.lang.Specification

import grails.test.mixin.*
import org.hexagonal.models.Project
import org.hexagonal.persistent.Repository
import org.hexagonal.persistent.ProjectGormRepository
import groovy.mock.interceptor.MockFor
import org.hexagonal.converters.JsonService

@TestFor(ProjectController)
class ProjectControllerSpec extends Specification{

    def "should create a new project"(){
        given:
            def _params = [name: 'Project1', description: 'Description']
            def projectInstance = new Project(_params)
            def controller = new ProjectController()
            controller.params.putAll(_params)
            ProjectGormRepository repository = Mock()
            JsonService jsonService = Mock()
            def mockProject = new Project(_params)
            mockProject.id = 1
            repository.save() >> mockProject
            controller.projectRepository = repository
            controller.jsonService = jsonService

        when:
            controller.save()

        then:
            1 * repository.save(_)
            1 * jsonService.render(_)
    } 


    def "should list all projects as json"(){
        given:
            JsonService jsonService = Mock()
            controller.jsonService = jsonService

        when:
            controller.list()

        then:
            1 * jsonService.renderProjectList()
    }


}
