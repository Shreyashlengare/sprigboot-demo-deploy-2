#!/usr/bin/env bash
rm -rf /home/ubuntu/server
sudo systemctl daemon-reload
sudo systemctl restart BackendApp
sudo systemctl enable BackendApp
