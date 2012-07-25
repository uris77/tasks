<!DOCTYPE html>
<html lang="en">
<head>
   <meta name="layout" content="hexagonal">
   <title>Hexagonal Grails</title>
   <r:require modules="kickstrap, projectjs"/>
</head>

<body>
   <h1>Bootstrap starter template</h1>
   <p>This is a template for Hexagonal Grails</p>
   <div ng-app="Project">
   <div ng-controller="ProjectController">
      <p>
      <button class="btn"><i class="icon-plus"></i>Add Project</button>
      </p>
      <g:render template="list" />
   </div>
   </div>
</body>

</html>
