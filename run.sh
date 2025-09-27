#!/bin/bash

# Run script for Java Swing Chat Box Application

echo "Starting Java Swing Chat Box Application..."

# Check if the application is built
if [ ! -f "build/com/chatbox/ChatBoxApp.class" ]; then
    echo "Application not built. Building now..."
    ./build.sh
    if [ $? -ne 0 ]; then
        echo "Build failed. Cannot run the application."
        exit 1
    fi
fi

# Run the application
echo "Launching Chat Box..."
java -cp build com.chatbox.ChatBoxApp