angular.module('Project',['ngResource']);
function ProjectController($scope, $http){
  $scope.fetch = function(){
     $http({method: 'GET', url:'http://localhost:8080/tasks/project/list'}).
      success(function(data,status){
         $scope.projects = data;
      }).
      error(function(data, status){
         console.log("Request failed");
      });
   };

   $scope.fetch();
}

