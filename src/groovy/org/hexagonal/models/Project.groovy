package org.hexagonal.models

/**
Projects
**/

class Project{

    //def projectRepository
    
    def id
    String name
    String description
    private Set<Task> tasks  = new HashSet<Task>()


    def addTask(task){
        task.project = this
        tasks.add(task)
    }


    def removeTask(task){
        tasks.remove(task)
    }

    public Set<Task> getTasks(){
        return tasks
    }

    public void setTasks(tasks){
        this.tasks = tasks
    }

}
