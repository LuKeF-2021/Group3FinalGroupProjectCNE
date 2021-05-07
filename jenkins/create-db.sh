#!/bin/bash

sudo apt update -y && sudo apt install mysql-client-core-5.7 -y
mysql -h project-jenkins-db.ceiisdtfp24j.eu-west-1.rds.amazonaws.com -P 3306 -u $DBUSER -p$DBPASS < SQL/create.sql