import org.hexagonal.models.*

class BootStrap {

    def init = { servletContext ->
        /*       
        def project = new Project(name:"Project 1", description:" Hexagonal Grails").save()
        def task1 = new Task(name: 'Task1')
        def task2 = new Task(name: 'Task2') 
        project.addTask(task2)
        project.addTask(task1)
        project.save()

        Project.list().each{
            println "${it.id} | ${it.name} | ${it.description}"
            println "project tasks: ${it.getTasks()}"
        }

        print "Tasks: "
        Task.list().each{task->
            println "${task.name} | ${task.project.name}"
        }
        */
    }
    def destroy = {
    }
}
