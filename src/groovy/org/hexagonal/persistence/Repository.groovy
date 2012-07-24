package org.hexagonal.persistent

interface Repository{
   
   /**
   Persist an instance to the underlying database
   **/
   def save(instance)

   /**
   List all items in the database
   **/
   def list()

}
