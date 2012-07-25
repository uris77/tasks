package org.hexagonal.converters

import groovy.json.JsonBuilder

class JsonService {
    
    def projectRepository

    def render(instance=null){
        if(!instance){
            return instance
        }else{
        def builder = new JsonBuilder(instance)
        builder{
            id "${instance.id}"
            name instance.name
            description instance.description
        }
        }
        
    }

    def renderProjectList(){
        def builder = new JsonBuilder()
        def projectLists = projectRepository.list()
        def jsonList = []
        for(project in projectLists){
            jsonList.add(render(project))
        }
        builder(jsonList)
    }
}
