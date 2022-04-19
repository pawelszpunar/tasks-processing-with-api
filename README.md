# About
Simple REST API for asynchronous Tasks Processing

#### Author: Paweł Szpunar

## Description
The application allows you to start a new task by accepting two parameters: base and exponent, returning it's id.
It's possible to check certain task using unique id of this task.
User can also view all working and finished tasks.
The result of the task is base^exponent.

## Download
$ git clone https://github.com/pawelszpunar/tasks-processing-with-api.git

## How to Run
The easiest way to run the applications is from an IDE (Intellij for example). Simply import the project into your IDE, browse to the src/ folder, then expand the package you want to test.


## Software required
- OpenJDK Java 17
- Git

## Exploring the Rest APIs
The application contains the following REST APIs:
```
1. POST /tasks - Create new task
Example input 1: {"base": 2, "exponent": 10} Example output: {"id": 1}
Example input 2: {"base": 2, "exponent": 10} Example output: {"id": 1}

2. GET /tasks/{id} - Retrieve task by id
Example output 1: {"id": 1, "status": "running", "progress": "14%"}
Example output 2: {"id": 2, "status": "finished", "progress": "100%", "result": 1024}

3. GET /tasks - Get all tasks
Example output:
[{{"id": 1, "status": "running", "progress": "79%"},
{"id": 2, "status": "finished", "progress": "100%", "result": 1024}]
```

## Contributing
Pull requests are welcome. Feel free to discuss what you would like to change.