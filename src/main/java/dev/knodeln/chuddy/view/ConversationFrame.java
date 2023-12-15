package dev.knodeln.chuddy.view;

import dev.knodeln.chuddy.controller.ChatController;
import dev.knodeln.chuddy.controller.ViewController;
import dev.knodeln.chuddy.model.Message;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversationFrame extends JFrame {

    private JTextPane chatPane;
    private JTextField messageField;
    private JButton sendButton;
    private JButton backButton;

    public ConversationFrame() {
        setTitle("User Conversation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create components
        chatPane = new JTextPane();
        chatPane.setEditable(false);

        messageField = new JTextField();
        sendButton = new JButton("Send");
        backButton = new JButton("Back");

        // Set layout
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(chatPane);
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.add(backButton, BorderLayout.WEST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners
        sendButton.addActionListener(e -> sendMessage());
        backButton.addActionListener(e -> goBack());
        updateChatPane();

        setVisible(true);
    }

    private void sendMessage() {
        String messageText = messageField.getText().trim();
        if (!messageText.isEmpty()) {
            ChatController.addMessage(messageText);
            updateChatPane();
            messageField.setText("");
        }
    }

    private void goBack() {
        ViewController.setMyFriendsView();
        this.dispose();
    }
    private void updateChatPane() {
        chatPane.setText("");
        for (Message message: ChatController.getMessages()) {
            appendMessage(message.getSender().getName(), message.getContent(), message.getTimeStamp());
        }
    }

    private void appendMessage(String user, String message, String timestamp) {


        String formattedMessage = String.format("[%s] %s: %s%n", timestamp, user, message);

        SimpleAttributeSet attributes = new SimpleAttributeSet();
        //StyleConstants.setAlignment(attributes, isUser1 ? StyleConstants.ALIGN_LEFT : StyleConstants.ALIGN_RIGHT);

        Document doc = chatPane.getDocument();
        try {
            doc.insertString(doc.getLength(), formattedMessage, attributes);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Scroll to the bottom of the chat area
        chatPane.setCaretPosition(doc.getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConversationFrame());
    }
}


