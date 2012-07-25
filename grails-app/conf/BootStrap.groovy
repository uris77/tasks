import org.hexagonal.models.*
import grails.converters.JSON

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        def project = new Project(name:"Project 1", description:" Hexagonal Grails").save()
        def task1 = new Task(name: 'Task1')
        def task2 = new Task(name: 'Task2') 
        project.addTask(task2)
        project.addTask(task1)
        project.save()
        /*       

        Project.list().each{
            println "${it.id} | ${it.name} | ${it.description}"
            println "project tasks: ${it.getTasks()}"
        }

        print "Tasks: "
        Task.list().each{task->
            println "${task.name} | ${task.project.name}"
        }
        */


        JSON.registerObjectMarshaller(Task){
            def returnArray = [:]
            returnArray['id'] = it.id
            returnArray['name'] = it.name
            returnArray['project'] = [id: it.project.id, name: it.project.name, description: it.project.description]

            return returnArray
        }

        JSON.registerObjectMarshaller(Project){
            def returnArray = [:]
            returnArray['id'] = it.id
            returnArray['name'] = it.name
            returnArray['description'] = it.description
            returnArray['tasks'] = it.getTasks()

            return returnArray
        }
    }
    def destroy = {
    }
}
