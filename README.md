# jpay-java-exercise
## jpay-java-exercise
## the folder contains two folder

1-folder for front-end (jpay-java-exercise-front-end) contain the front-end (angular)

2-folder for back-end (jpay-java-exercise) contain the back-end (springboot) 

## import the back-end

you can import the back-end from eclipse  `import->existing maven project>browse to a directory`  and you pom file will import the project


## run the back-end

go to jpay-java-exercise directory

run  `mvn clean install` 

run `nohup java -jar target/jpay-java-exercise-0.0.1-SNAPSHOT.jar > jpay-java.log &`

## make sure project run successfully 

run `tail -f jpay-java.log` to view logs 

## get page  of customer phone using this curl 

curl --location --request GET 'localhost:8040/api/customer?page=0&size=5' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'

## import the front-end

go to jpay-java-exercise-front-end directory

run `code .`

## run the front-end


run `npm install`


Run `npm start ` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

the page of customer phone reloaded with pagination 

the user can filter by country name and then we gen the prefix of phone by country name and get the page of customer phone by this prefix 
