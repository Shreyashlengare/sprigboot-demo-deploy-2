#!/bin/bash

# Define the port number you want to free
PORT_TO_FREE=8081

# Check if a process is listening on the specified port
LISTENING_PROCESS=$(lsof -i :8081 | awk 'NR==2{print $2}')

if [ -n "$LISTENING_PROCESS" ]; then
  echo "A process is listening on port 8081 (PID: $LISTENING_PROCESS). Stopping it..."
  sudo kill -9 $LISTENING_PROCESS
  echo "(PID: $LISTENING_PROCESS). Stopped it..."
else
  echo "No process found listening on port 8081."
fi
