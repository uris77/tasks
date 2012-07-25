package org.hexagonal.models

import static org.junit.Assert.*
import org.hexagonal.persistence.*

class ProjectSpec extends spock.lang.Specification{


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

        when: "A task is removed from a project"
            project.removeTask(task)

        then: "the project is told to persist in order to reflect the change in the db"
            assertFalse project.getTasks().contains(task)
    } 



}
