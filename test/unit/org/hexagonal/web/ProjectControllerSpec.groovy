package org.hexagonal.web

import spock.lang.Specification

import grails.test.mixin.*
import org.hexagonal.models.Project
import org.hexagonal.persistence.Repository
import org.hexagonal.persistence.ProjectGormRepository
import org.hexagonal.converters.JsonService
import groovy.mock.interceptor.MockFor
import org.hexagonal.converters.JsonService
import grails.converters.JSON

@TestFor(ProjectController)
class ProjectControllerSpec extends Specification{

    def "should create a new project"(){
        given:
            def _params = [name: 'Project1', description: 'Description']
            def projectInstance = new Project(_params)
            ProjectGormRepository repository = Mock()
            JsonService jsonService = Mock()
            def controller = new ProjectController()
            controller.params.putAll(_params)
            controller.projectRepository = repository
            controller.jsonService = jsonService

        when:
            controller.save()

        then:
            1 * repository.save(_) >> { [name: 'Should Return Project Instance'] }
            1 * jsonService.render(_) >> { [name: "Saved Project"] }
    } 


    def "should list all projects as json"(){
        given:
            Repository repository = Mock()
            def controller = new ProjectController()
            controller.projectRepository = repository

        when:
            controller.list()

        then:
            1 * repository.list() >> { ["Mock List"] }
    }


}
