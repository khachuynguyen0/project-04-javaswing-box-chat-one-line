#!/bin/bash

# Build script for Java Swing Chat Box Application

echo "Building Java Swing Chat Box Application..."

# Create build directory if it doesn't exist
mkdir -p build

# Compile Java source files
echo "Compiling Java files..."
javac -d build src/main/java/com/chatbox/*.java

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
    echo "Run the application with: java -cp build com.chatbox.ChatBoxApp"
else
    echo "✗ Compilation failed!"
    exit 1
fi