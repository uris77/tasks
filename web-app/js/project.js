angular.module('Project',['ngResource']).
   config(function($routeProvider){
      $routeProvider.
         when('/new', {templateUrl:'partials/project_form.html'}).
         when('/', {templateUrl: 'partials/project_list.html'}).
         otherwise({redirectTo:'/', template:'/partials/project_list.html'});
});
function ProjectController($scope, $http, $location){

  $scope.fetch = function(){
     $http({method: 'GET', url:'http://localhost:8080/tasks/project/list'}).
      success(function(data,status){
         $scope.projects = data;
      }).
      error(function(data, status){
         console.log("Request failed");
      });
   };

   $scope.add = function(jsonData){
      $http({method:'POST', url:'http://localhost:8080/tasks/project/create', data:jsonData }).
         success(function(data,status){
            console.log("data: " + JSON.stringify(data));
            $scope.projects.push(data);
         });
   };

   $scope.setRoute = function(route){
      $location.path(route);
   }

   $scope.project = {};

   $scope.createProject = function(project){
      $scope.project = angular.copy(project);
      $scope.add($scope.project);
      $scope.saved = true;
      $location.path('/');
   };

   $scope.saved = false;

   $scope.fetch();
}

