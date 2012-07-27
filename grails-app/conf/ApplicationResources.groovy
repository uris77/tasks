modules = {
    application {
        resource url:'js/application.js'
    }

    angularjs{
        resource url:'js/angular-1.0.1.js'
        resource url:'js/angular-resource-1.0.1.min.js'
    }

    projectjs{
        dependsOn 'angularjs'
        resource url:'js/project.js'
    }

    kickstrap{
        resource url:'css/bootstrap.css'
        resource url:'css/responsive.css'
        resource url:'js/bootstrap-scrollspy.js'
    }


    bootstrap_tooltip{
        dependsOn 'kickstrap'
        resource url:'js/bootstrap-tooltip.js'
    }
    
    bootstrap_popover{
        dependsOn 'bootstrap_tooltip'
        resource url:'js/bootstrap-popover.js'
    }

    project_popovers{
        resource url:'js/project_popovers.js'
    }

}
