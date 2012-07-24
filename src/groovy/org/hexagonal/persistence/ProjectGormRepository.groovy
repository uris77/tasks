package org.hexagonal.persistent

import org.hexagonal.models.Project
import org.hexagonal.models.Task

class ProjectGormRepository implements Repository{

    def save(instance){
        instance.save(flush:true)
    }

    def list(){
        Project.list()
    }

    def add(instance){
    }

}
