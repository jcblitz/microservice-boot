# Introduction

A proof of concept using some new Java frameworks to create a "Microservice"

## Goals

* A Java based REST webservice using Spring Boot
* Utilize service discovery to announce presence of the service
* Utilize service discovery to find and request data from another service
* Provide health checks for monitoring
* Demonstrate distributed logging
* Demonstrate unit testing and integration testing for a service
* Document the endpoints with Swagger

## Secondary Goals

* Integrate with CI/CD system for pipeline delivery
* Demonstrate using Jira and Confluence to drive requirements and deliverables 
* Demonstrate "build once, deploy anywhere"

## Building

### Run the tests

`mvn install`

### Run the application locally

`mvn spring-boot:run`

It defaults to `8080`


## Deployment (CICD)

### CI using CircleCI

I have CircleCI monitoring `master` and automatically running the tests on commit and automatically running the tests on commit. The results are send to the `#builds` slack channel.

I'm also toying with using gitlab CI if we want to use gitlab for Git hosting and code review.

[CircleCI](https://circleci.com/)


## Delivery / Running

### CD using Heroku 

On successful builds, CircleCI deploys to Heroku. 

* [Heroku](https://dashboard.heroku.com/login)
* [Running Application](https://microservice-learning.herokuapp.com/)
* [Running Documentation](https://microservice-learning.herokuapp.com/v2/api-docs)
