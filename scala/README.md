This is a project developed in scala of a CLI ToDo app. 

It uses [scalamock](scalamock.org), [scalatest](http://www.scalatest.org/)
and [scaldi](scaldi.org). 
If you want to try it for yourself just use the docker-compose to start the compiling/live watch/test  service 

 `docker-compose up`
 
 then using bash inside the container
 
 `docker-compose exec scala_build /bin/bash`
 
 and then you can simply run the tests or the app
 
 `sbt run` or `sbt test`
 
 More often than not bash will not export it's dimensions so before runnning the app ( inside the container) export the `COLUMNS`
 env variable as it is used by the application
 
 `export COLUMNS`
 
 
 
 
