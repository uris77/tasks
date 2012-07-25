package org.hexagonal.converters

import spock.lang.Specification
import static org.junit.Assert.*
import org.hexagonal.models.Project
import org.hexagonal.persistence.ProjectGormRepository

class JsonServiceSpec extends Specification{

    def "should render a class as a json"(){
        given:
            def params = [id: 1, name:'Project1', description: 'Description']
            Project projectInstance = new Project(params)

        when:
            def jsonService = new JsonService()
            def projectInstanceJson = jsonService.render(projectInstance)
            println "${projectInstanceJson}"

        then:
            assertNotNull projectInstanceJson
    } 


    def "should render a list of projects"(){
        given:
            def project1 = new Project(id:1, name:'Project1', description:'Description1')
            def project2 = new Project(id:2, name:'Project2', description:'Description2')
            def project3 = new Project(id:3, name:'Project3', description:'Description3')
            def project4 = new Project(id:4, name:'Project4', description:'Description4')

            def jsonService = new JsonService()
            jsonService.projectRepository = [list: {-> [project1,project2,project3, project4]}]

        when:
            def projectList = jsonService.renderProjectList()
            println projectList

        then:
            assertEquals 4, projectList.size()


    }
}
