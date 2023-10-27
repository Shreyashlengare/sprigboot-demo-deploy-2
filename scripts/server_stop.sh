#!/bin/bash

# Define the port number you want to free
PORT_TO_FREE=8082

# Check if a process is listening on the specified port
LISTENING_PROCESS=$(lsof -i :8082 | awk 'NR==2{print $2}')

if [ -n "$LISTENING_PROCESS" ]; then
  echo "A process is listening on port 8082 (PID: $LISTENING_PROCESS). Stopping it..."
  sudo kill -9 $LISTENING_PROCESS
else
  echo "No process found listening on port 8082."
fi
