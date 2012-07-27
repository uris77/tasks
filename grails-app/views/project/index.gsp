<!DOCTYPE html>
<html lang="en">
<head>
   <meta name="layout" content="hexagonal">
   <title>Hexagonal Grails</title>
   <r:require modules="projectjs, bootstrap_tooltip, project_popovers "/>
</head>

<body class="container-fluid">
   <h1>My Silly Projects</h1>
   <div ng-app="Project">
   <div ng-controller="ProjectController">
   <div class="well" >
      <span> 
         <a class="btn" id="list_projects_button" ng-click="setRoute('/')">
         <i class="icon-th-list"></i>
         </a>
         <a class="btn" id="add_project_button" ng-click="setRoute('new')">
            <i class="icon-plus"></i>
         </a>
      </span>
   </div>
   <style>
      .message{
         background-color: #5bb75b;
         border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
         color: rgba(255, 255, 255, 0.75);
         margin-bottom: 1em;
      }
   </style>
   <div class="row-fluid message">
      <div class="span12">
         Project has been saved!
         <button class="close"><i class="icon-remove"></i></button>
      </div>
   </div>
   <div ng-view>
   </div>
   </div>
   </div>
</body>

</html>
