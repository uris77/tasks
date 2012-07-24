package org.hexagonal.models

import static org.junit.Assert.*
import org.hexagonal.persistent.*

class ProjectSpec extends spock.lang.Specification{


    def "should persist project to database"(){

        given: "a project is instantiated"
            Repository projectRepository = Mock()
            def project = new Project(name: "Hex Grails", description:"Hexagonal architecture w/ grails")

            project.projectRepository = projectRepository

        when: "project is told to persist"
            project.persist()

        then:
            1 * projectRepository.save(project)
    } 


    def "should add a task to a project"(){
        given: "A project and task exist"
            def project = new Project()
            project.name = "Hex Grails"
            project.description = "Hex Arch w/ Grails"
            def task = new Task()
            task.name = "Create portable models"

        when: "A task is added to a project"
            project.addTask(task)

        then:
            assertTrue project.getTasks().contains(task)
    } 


    def "remove a task from a project"(){
        given: "A project has a task"
            def project = new Project()
            project.name = "Hex Grails"
            project.description = "Hex Arch w/ Grails"
            def task = new Task()
            task.name = "Create portable models"
            project.addTask(task)

            Repository projectRepository = Mock()
            project.projectRepository = projectRepository

        when: "A task is removed from a project"
            project.removeTask(task)

        then: "the project is told to persist in order to reflect the change in the db"
            1 * projectRepository.save(project)
    } 


}
