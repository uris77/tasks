<!DOCTYPE html>
<html lang="en">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
   <title><g:layoutTitle default="Hexagonal Grails"/></title>
   <meta name="viewport" content="width=device-width, initial-scale=1.9">
   <meta name="description" content="">
   <meta name="author" content="">
   <g:layoutHead/>
   <g:javascript library="jquery" />
   <r:layoutResources />

   <style>
      body{
         padding-top: 60px;
      }
   </style>
</head>

<body>
   <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
         <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Hexagonal Grails</a>
            <div class="nav-collapse">
               <ul class="nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#about">About</a></li>
                  <li><a href="#contact">Contact</a></li>
               </ul>
            </div>
         </div>
      </div>
   </div>

   <div class="container">
      <g:layoutBody />
   </div>

   <r:layoutResources />
</body>

</html>
