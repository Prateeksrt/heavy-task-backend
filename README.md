# heavy-task-backend
Rest apis to generate and view stats for some heavy task.

Frontend client for the api : http://heavy-task.online-profile.me/

### Stack

* Is a __Spring boot__ rest api.
* __Gradle__ is used for depenedency management and building.
* The Application is hosted on __aws EC2 beanStalk (Free tier)__.

### How it works

* New task can be created by making a __Post__ call to /task.
* Which tries to find the Highest common factor of a randomly generated number.
* which is than saved with all the stats for that task.
* overall stats can be fetched by making a __Get__ call to /task.
* all the task can be removed by making a __Delete__ call to /task.
* Currently the tasks are not persisted they are stored in memory, i.e every time the server starts the it resets the task stats. Also currenlty the limit is set to 50. After 50 entitries every new entry pushs the first entry out.

__Note__: This repo has postman collection json which can be imported into the postman. It has all three sample request. 
