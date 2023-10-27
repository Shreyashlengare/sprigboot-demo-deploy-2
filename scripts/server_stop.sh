#!/bin/bash
sudo /home/ubuntu/apache-tomcat-10.1.14/bin/shutdown.sh

# Give some time for Tomcat to gracefully shut down
sleep 5

# Find and kill the Tomcat process (adjust the command as needed)
sudo pkill -f "catalina"