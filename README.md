# Group3FinalGroupProjectCNE

## Links:

- Jira Board - [Jira Board](https://fundementalscrum.atlassian.net/secure/RapidBoard.jspa?projectKey=FIN&rapidView=2)
- Github - [Github Repo](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE)
- -Docker Hub - [Dockerhub Repo](https://hub.docker.com/u/lukef2021)

## Technologies
- Database Technologies: AWS RDS, MySQL, H2
- Frontend Services: JavaScript, React, Jest, Postman, HTML, CCS
- Backend Services: Java, Maven, Spring
- Service Registry: Eureka
- Java Testing: JUnit, Spring Boot Test, Spring Test, Mockito
## Brief

The assignment given to us was to create a Help Queue web application for use in the Academy. This program would be deployed using a CI Pipeline, with the inclusion of rolling updates. 

The purpose of the application will tb be used as a hands-up tool to alert trainers to who in their class needs help. The idea is for trainees to be able to post help tickets to a queue with oldest tickets on top. 

Trainers can then go through the list and choose a ticket to work on, post a solution, and then tick as completed. 

Tickets that have been marked as completed are then moved into a “Completed” list and the list of tickets rearranges itself. 

We also had a list of extra features to implement, and we decided to and succeeded in implementing the following:  Solutions, Urgency, Filtering

We attempted to implement key word searching and was able to find the solution to implement it but with our time constraint and making sure we left enough time for the dev ops portion of the assignment we were unable to do so. 

## Risk Assessment
[Risk Assessment](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/FinalProj_RiskAssessment.xlsx)

## React Architecture
Our React Files are organised as such, Displayed using Visual Studio Code:

![React File Structure](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/React%20File%20Structure.PNG)

We structured our code with clearly named .jsx files to compartmentalise our front end. This clarity ensures that when working as a team, other memebers don't waste time deducing what the code does. The jsx files include snippits of HTML so that the function can be called  rendered seperately from the whole webpage, as such the index.html file is almost empty. 

### Our front end Application entry page:

![Entry Page](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/updated%20webpage%20colour%20scheme%20and%20design.JPG)

### Create ticket screen

![Create Ticket](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/Create%20ticket%20modal%20with%20urgency%20added.JPG)

## Java Architecture
### Monolithic
This is the original monolithic architecture: 

![Monolithic architecture diagram](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/Monolith%20Architecture%20Diagram.png)

This was quick to set up and was built and ready to be used with Postman within a day. We were able to use this as a base for our final microservice based springboot app. 
### Microservices
![Microservices architecture diagram](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/ReadMeFiles/Microservices%20Architecture%20Diagram.png)

We used a Microservice architecture for our final project because of its key Benefits:
- Improved Scalability
- Better Fault Isolation and More Resilient Applications
- Programming Language and Technology Agnostic
- Better Data Security and Compliance
- Faster Time to Market and Future-Proofing
- Greater Business Agility and Support for DevOps
- Support for "Two-Pizza Development Teams.

To Break down Microservices it is simply the method 

## JIRA board

![JiraBoard](https://github.com/LuKeF-2021/Group3FinalGroupProjectCNE/blob/main/sprint%20screenshot2.png)

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

### Terraform:- provisioning of resources

Terraform is an Infrastructure Management technology, it allows for what is known as 'Infrastructure as Code'. Simply put, this means that Terraform can create infrastructure through a command line interface by making use of Terraform (.tf) files. It is used to define a 'final state' allowing the user to define the provisioned resources directly. It follows a JSON-like notation of key and value pairs, and can be split into modules to easily isolate your ec2 code from say your RDS code. Very useful tool for engineers who dont have access to the AWS Console.
### Ansible:- Allocation of Resources

Ansible is a Configuration Management tool that allows tasks to be executed on 'hosts' (ec2 instances etc) in a structured way. Say you needed to put multiple installations on multiple VM instances right upon creation, a lot of the installations would be repetitive and require manually ssh'ing into each instance to run cli commands one by one, waiting for each to finish before applying the next. This equates to a lot of wasted time for developers, and that is where Ansible comes in to simplify that aspect for dev's. As long as Ansible has ssh keys to allow it to communicate with the VM's it needs, then a playbook can be created to neatly organise tasks with names to track the progress easily. Simply specify the hosts within an inventory.yaml file and a playbook of tasks, and Ansible will go away and run all those tasks for you automatically and alert you when it is done. This requires no strict monitoring from a developer and frees them up to work on other things while that playbook is running.

### Kubernetes:- Managing Services

Kubernetes is an Orchestration tool that is very popular in industry as of late. It is a platform for managing workloads and services in containers. The hardware, OS etc. are shared by all container instances on the Kubernetes node. Each node can have one Pod on it, but each pod can contain multiple containers, meaning that a single node in a cluster can run multiple instances of an application. The seperate layers build in a fault tolerance, with the integration of a load balancer, should one container be forced offline.
### NGINX:- Reverse Proxy

The NGINX reverse proxy server is used as a Load Balancer for this project and it is vital for the allocation of traffic to the backend servers. This is done to maintain speed and efficiant capacity utilisation of the provisioned resources. Very useful in the prevention of server overload and performance degredation, it also redirects traffic in the event of a server going down.
### Docker:- Containerisation

Docker is a Containerisation tool largely used in industry for building applications based on containers. The idea is that a container is lightweight and contains only the things needed to run the application successfully. Dependancies and libaries can be packaged up in a docker container and an image made of the application. This makes using and updating the code standardised between different users and terminals, as it ensures that all needed installations are present for all developers.
## Manual Development

- aws configure entered IM user.
- change the ip address in the playbook.
- setup credentials in Jenkins credentials manager .
- ssh into setup VM to intiate Ansible and Terraform.
- install all add-ons in the Jenkis GUI and set up initial admin password. 
- ssh keygen in jenkins machine so setup vm can access it .

## Acknowledgements

We would like to Acknowledge all the QA Teaching team as well various online sources: Stack Overflow, Postman, Google Search, Leigh Halliday.

## Authors

Luke Foster

Zonaria Hussain

Dylan Ritchings

Thomas Glynn
