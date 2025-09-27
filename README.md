# Java Swing Chat Box - One Line Input

A simple Java Swing desktop chat application featuring a clean interface with a one-line input field for typing messages.

## Features

- **Clean User Interface**: Modern-looking chat interface with proper spacing and colors
- **One-Line Input**: Simple text field for typing messages
- **Message Display**: Scrollable chat area showing all messages with timestamps
- **Keyboard Support**: Press Enter to send messages or use the Send button
- **Auto-scroll**: Chat area automatically scrolls to show latest messages
- **System Messages**: Welcome message and system notifications

## Screenshots

The application features:
- A main chat display area showing messages with timestamps
- A one-line input field at the bottom for typing messages
- A Send button for submitting messages
- Clean, professional styling with system look and feel

## Requirements

- Java 8 or higher
- No external dependencies required (uses only Java Standard Library)

## Building and Running

### Quick Start

1. **Build and run in one step:**
   ```bash
   ./run.sh
   ```

### Using the Build Script

1. **Build the application:**
   ```bash
   ./build.sh
   ```

2. **Run the application:**
   ```bash
   java -cp build com.chatbox.ChatBoxApp
   ```

### Manual Compilation

1. **Compile the Java files:**
   ```bash
   mkdir -p build
   javac -d build src/main/java/com/chatbox/*.java
   ```

2. **Run the application:**
   ```bash
   java -cp build com.chatbox.ChatBoxApp
   ```

### Testing

Run the basic functionality test:
```bash
javac -d build src/main/java/com/chatbox/ChatBoxTest.java
java -cp build com.chatbox.ChatBoxTest
```

## Usage

1. Launch the application
2. You'll see a welcome message in the chat area
3. Type your message in the text field at the bottom
4. Press Enter or click the "Send" button to send the message
5. Your message will appear in the chat area with a timestamp
6. Continue typing and sending messages as needed

## Project Structure

```
project-04-javaswing-box-chat-one-line/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── chatbox/
│                   ├── ChatBoxApp.java      # Main application class
│                   └── ChatBoxTest.java     # Basic functionality test
├── build/                                   # Compiled class files (auto-generated)
├── build.sh                                # Build script
├── run.sh                                  # Run script (build + execute)
├── README.md                               # This file
└── .gitignore                              # Git ignore rules
```

## Technical Details

- **Framework**: Java Swing
- **Layout Manager**: BorderLayout for main window, with nested panels
- **Components Used**:
  - `JTextArea` for message display
  - `JTextField` for one-line input
  - `JButton` for send functionality
  - `JScrollPane` for scrollable chat area
- **Event Handling**: ActionListener for button clicks and Enter key presses
- **Styling**: Custom colors and fonts for a modern appearance

## License

This project is open source and available under the MIT License.
