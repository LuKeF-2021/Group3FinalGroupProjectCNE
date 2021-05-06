# Group3FinalGroupProjectCNE

## Brief:

The assignment given to us was to create a Help Queue web application for use in the Academy. This program would be deployed using a CI Pipeline, with the inclusion of rolling updates. 

The purpose of the application will tb be used as a hands-up tool to alert trainers to who in their class needs help. The idea is for trainees to be able to post help tickets to a queue with oldest tickets on top. 

Trainers can then go through the list and choose a ticket to work on, post a solution, and then tick as completed. 

Tickets that have been marked as completed are then moved into a “Completed” list and the list of tickets rearranges itself. 

We also had a list of extra features to implement, and we decided to and succeeded in implementing the following:  Solutions, Urgency, Filtering

We attempted to implement key word searching and was able to find the solution to implement it but with our time constraint and making sure we left enough time for the dev ops portion of the assignment we were unable to do so. 


## Links:

- Jira Board - [Jira Board](https://fundementalscrum.atlassian.net/secure/RapidBoard.jspa?projectKey=FIN&rapidView=2)
- Github - [Github Repo](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE)

## Technologies
- Database Technologies: AWS RDS, MySQL, H2
- Backend Services: Java, Maven, Spring
- Service Registry: Eureka
- Java Testing: JUnit, Spring Boot Test, Spring Test, Mockito
## Brief
## React Architecture
Our React Files are organised as such, Displayed using Visual Studio Code:

![React File Structure](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/React%20File%20Structure.PNG)

We structured our code with clearly named .jsx files to compartmentalise our front end. This clarity ensures that when working as a team, other memebers don't waste time deducing what the code does. The jsx files include snippits of HTML so that it can be rendered seperately from the whole webpage, as such the index.html file is almost empty. 

## Java Architecture
### Monolithic
This is the original monolithic architecture: 

![Monolithic architecture diagram](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/Monolith%20Architecture%20Diagram.png)

This was quick to set up and was built and ready to be used with Postman within a day. We were able to use this as a base for our final microservice based springboot app. 
### Microservices
![Microservices architecture diagram](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/Microservices%20Architecture%20Diagram.png)
## Microservices Unit and Integration Test Coverage
We used a Microservice architecture for our final project because of its key Benefits:
- Improved Scalability
- Better Fault Isolation and More Resilient Applications
- Programming Language and Technology Agnostic
- Better Data Security and Compliance
- Faster Time to Market and Future-Proofing
- Greater Business Agility and Support for DevOps
- Support for "Two-Pizza Development Teams.

## JIRA board

![JiraBoard](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/jirasnap.PNG)

Our completed Jira tasks.

## Testing
### Microservice Testing
[Test coverage report](https://htmlpreview.github.io/?https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/MicroserviceTestOutput/index.html)

[Test coverage spreadsheet](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/TestCoverageReport.xlsx)
#### Test Coverage Table
![Test coverage table](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/BackendCoverageReportTable.png)
#### Test Coverage Graph
![Test coverage graph](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/BackendTestCoverage.png)
### Front-End Testing
JEST testing Axios statements using expect().toMatchSnapshot

![JEST TEST Coverage](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/jesttestsnaps.PNG)

All snapshots passsed and both test suits reported no failures.
## Automated Devlopment

- Terraform:- Provisioning Resources
- ansible:- Allocation of Resources
- Kubernetes:- Managing Services
- Nginx:- Reverse Proxy

## Manual Development

- sudo visudo to give jenkins sudoers
- aws configure entered im user
- change the ip address in the playbook
- setup credentials in Jenkins credentials manager 
- ssh keygen in jenkins machine so setup vm can access it 

## Acknowledgements

We would like to Acknowledge all the QA Teaching team as well various online sources:.

## Authors

Luke Foster
Zonaria Hussain
Dylan Ritchings
Thomas Glynn
