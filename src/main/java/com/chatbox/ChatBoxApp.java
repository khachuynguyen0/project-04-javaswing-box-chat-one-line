package com.chatbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * A simple Java Swing chat application with a one-line input box.
 * This application provides a basic chat interface where users can type messages
 * and see them displayed in a chat area.
 */
public class ChatBoxApp extends JFrame implements ActionListener {
    private JTextArea chatArea;
    private JTextField messageInput;
    private JButton sendButton;
    private JScrollPane scrollPane;
    
    // Color scheme
    private static final Color BACKGROUND_COLOR = new Color(240, 240, 240);
    private static final Color CHAT_AREA_COLOR = Color.WHITE;
    private static final Color INPUT_COLOR = new Color(250, 250, 250);
    private static final Color SEND_BUTTON_COLOR = new Color(70, 130, 180);
    
    public ChatBoxApp() {
        initializeComponents();
        setupLayout();
        configureWindow();
    }
    
    /**
     * Initialize all GUI components
     */
    private void initializeComponents() {
        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(CHAT_AREA_COLOR);
        chatArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Scroll pane for chat area
        scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        
        // Message input field (one-line)
        messageInput = new JTextField();
        messageInput.setFont(new Font("SansSerif", Font.PLAIN, 14));
        messageInput.setBackground(INPUT_COLOR);
        messageInput.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLoweredBevelBorder(),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        messageInput.addActionListener(this); // Allow Enter key to send message
        
        // Send button
        sendButton = new JButton("Send");
        sendButton.setBackground(SEND_BUTTON_COLOR);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createRaisedBevelBorder());
        sendButton.addActionListener(this);
        sendButton.setPreferredSize(new Dimension(80, 35));
    }
    
    /**
     * Setup the layout of components
     */
    private void setupLayout() {
        setLayout(new BorderLayout(5, 5));
        
        // Main content area
        add(scrollPane, BorderLayout.CENTER);
        
        // Input panel at bottom
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBackground(BACKGROUND_COLOR);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        inputPanel.add(messageInput, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        
        add(inputPanel, BorderLayout.SOUTH);
        
        // Add some padding around the main content
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().setBackground(BACKGROUND_COLOR);
    }
    
    /**
     * Configure the main window properties
     */
    private void configureWindow() {
        setTitle("Chat Box - One Line Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center on screen
        setMinimumSize(new Dimension(350, 200));
        
        // Add welcome message
        appendMessage("System", "Welcome to Chat Box! Type your message below and press Send or Enter.");
    }
    
    /**
     * Handle button clicks and Enter key presses
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton || e.getSource() == messageInput) {
            sendMessage();
        }
    }
    
    /**
     * Send the message from the input field to the chat area
     */
    private void sendMessage() {
        String message = messageInput.getText().trim();
        
        if (!message.isEmpty()) {
            appendMessage("You", message);
            messageInput.setText(""); // Clear input field
            messageInput.requestFocus(); // Keep focus on input field
        }
    }
    
    /**
     * Append a message to the chat area with timestamp
     */
    private void appendMessage(String sender, String message) {
        String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String formattedMessage = String.format("[%s] %s: %s%n", timestamp, sender, message);
        
        chatArea.append(formattedMessage);
        
        // Auto-scroll to bottom
        SwingUtilities.invokeLater(() -> {
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        });
    }
    
    /**
     * Main method to launch the application
     */
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Fall back to default look and feel
            System.out.println("Could not set system look and feel, using default.");
        }
        
        // Create and show the application
        SwingUtilities.invokeLater(() -> {
            new ChatBoxApp().setVisible(true);
        });
    }
}