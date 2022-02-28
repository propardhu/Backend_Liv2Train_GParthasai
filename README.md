##Prerequisite
mongodb needs to be up and running on port **27017**

_Before running the Project please build the build.gradle file on the respective IDE's
Now we are ready to run our project_

## Testing Data model

`{ "centerName":"hello", "studentCapacity":3, "courseOffered":["java","c","c++"], "email":"parthasai@gmail.com", "phone":"8500541540", "address":{ "addressLine1":"heelo", "addressLine2":"heelo2", "city":"hyd", "pinCode":"80023" } }`

## Endpoints

**_/apis/training_** -> Get for the list of Training Centers.

_**/apis/training**_ -> Post Request with Body of data to save the Training Center Data

if we have any improper data we will get 400 status code with invalid information as below

`"title": "Constraint Violation", "status": 400, "path": "/apis/training", "violations": [ { "field": "email", "message": "Email is not valid" } ], "message": "error.validation"`
