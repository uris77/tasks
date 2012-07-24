package org.hexagonal.persistent

import org.hexagonal.models.Task

class TaskGormRepository implements Repository{

    def save(taskInstance){
        def task = taskInstance.save()
        println "Saved task: ${task.name} for project ${task.project.name}"
        return task
    }


   def list(){}

   def add(instance){}
}
