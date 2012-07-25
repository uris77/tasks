package org.hexagonal.persistent

import static org.junit.Assert.*

import org.hexagonal.models.Project
import org.hexagonal.models.Task

class ProjectGormRepositorySpec extends spock.lang.Specification{

    def setup(){
        clearDatabase()
    }

    def cleanup(){
        clearDatabase()
    }


    def "should persist project to database"(){
        given: "An instance of project is created"
            Project project = new Project()
            project.name = "Hex Grails"
            project.description = "Hex Arc in Grails"
            def projectRepository = new ProjectGormRepository()

        when: "the instance of project is told to persist"
            projectRepository.save(project)

        then:
            assertNotNull project.id
        } 


    def "should also save tasks when project is persisted"(){

        given: "An instance of project exists with two tasks"
            Project project = new Project()
            project.name = "Hex Grails"
            project.description = "Hex Arch in Grails"
            
            Task task1 = new Task(name: 'Task 1')
            Task task2 = new Task(name: 'Task2')
            Task task3 = new Task(name: 'Task3')

            project.addTask(task1)
            project.addTask(task2)

            def projectRepository = new ProjectGormRepository()

        when: "Project is told to persist itself"
            projectRepository.save(project)
            def persistedProject = Project.findByName("Hex Grails")
            

        then: "It should also save the tasks"
            assertEquals 2, persistedProject.getTasks().size()

        } 


        def "should list all projects in the database"(){

            given: "Three projects are persisted in the database"
                
                (1..3).each{
                    new Project(name: "Project${it}", description: "Description${it}").save()
                }

            when: "the repository is told to give us all projects"
                ProjectGormRepository repository = new ProjectGormRepository()
                def projectLists = repository.list()

            then: "a list of three projects should be returned"
                assertEquals 3, projectLists.size()
        } 


        def "should remove a task from a project"(){
            
            given: "A project has two tasks"
                ProjectGormRepository repository = new ProjectGormRepository()
                def project = new Project(name:'Project', description:'Description').save()
                def task1 = new Task(name:'Task1')
                def task2 = new Task(name:'Task2')
                project.addTask(task1)
                project.addTask(task2)
                project = repository.save(project)

            when: "A task is removed from the project"
                project.removeTask(task1)

            then: "Project has only 1 task remaining"
                
                assertEquals 1, Project.get(project.id).getTasks().size()
        }


        private clearDatabase(){
            Task.list().each{
                it.delete()
            }

            Project.list().each{
                it.delete(flush:true)
            }
        }

}
