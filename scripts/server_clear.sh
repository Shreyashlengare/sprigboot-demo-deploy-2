#!/usr/bin/env bash
rm -rf /home/ec2-user/server
sudo chown -R ubuntu:ubuntu /home/ec2-user/apache-tomcat-10.1.14/webapps/
sudo chmod -R 750 /home/ec2-user/apache-tomcat-10.1.14/webapps/
sudo systemctl daemon-reload
sudo systemctl restart BackendApp
sudo systemctl enable BackendApp
