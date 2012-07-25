package org.hexagonal.web

import spock.lang.*
import org.hexagonal.models.Project
import grails.test.mixin.*
import grails.plugin.spock.IntegrationSpec
import grails.converters.JSON
import groovy.json.JsonSlurper
import static org.junit.Assert.*

class ProjectControllerIntegrationSpec extends IntegrationSpec{

    def "should create a new project"(){
        given:
            def controller = new ProjectController()
            def params = [
                name: 'Project1',
                description: 'Description']
            controller.params.putAll(params)

        when:
            controller.save()
            println "contentAsString: ${controller.response.contentAsString}\n"

        then:
            def jsonResponse = JSON.parse(controller.response.contentAsString)
            println jsonResponse
            assertEquals params.name, jsonResponse.name
    } 

}
