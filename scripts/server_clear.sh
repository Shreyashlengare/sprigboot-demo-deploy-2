#!/usr/bin/env bash
rm -rf /home/ec2-user/server
sudo systemctl daemon-reload
sudo systemctl restart BackendApp
sudo systemctl enable BackendApp
