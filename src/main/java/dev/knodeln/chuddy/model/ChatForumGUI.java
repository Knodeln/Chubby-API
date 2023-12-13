package dev.knodeln.chuddy.model;

import dev.knodeln.chuddy.controller.ForumController;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ChatForumGUI extends JFrame {

    private Forum forum;
    private JTextArea messageTextArea;
    private JTextArea messageDisplayArea;
    // ta bort den här skiten, byt ut mot det i forum. forum.getselectedthread
    private DiscussionThread selectedThread;

    private ChuddyUser currentUser = new ChuddyUser("Senja");

    public ChatForumGUI() {
        messageTextArea = new JTextArea(10, 30);
        messageDisplayArea = new JTextArea(30, 30);

        // ForumInitializer.initializeDefaultThreads(forum);

        JButton postButton = new JButton("Post Message");
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ForumController.addMessage(messageTextArea.getText(), currentUser);
                viewSelectedThread();
            }
        });

        JButton threadButton = new JButton("View Threads");
        threadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllThreads();
            }
        });

        JButton myThreadsButton = new JButton("My Threads");
        myThreadsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMyThreads();
            }
        });

        // sent messages display
        JPanel messagesPanel = new JPanel();
        messagesPanel.setLayout(new BorderLayout());
        messagesPanel.add(new JScrollPane(messageDisplayArea), BorderLayout.CENTER);

        // text-area and post button
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.add(new JScrollPane(messageTextArea), BorderLayout.CENTER);
        textAreaPanel.add(postButton, BorderLayout.EAST);

        // combo-box and view threads button
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new BorderLayout());
        comboBoxPanel.add(threadButton, BorderLayout.WEST);

        // main-panel for text-area panel and combo-box panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(messagesPanel, BorderLayout.NORTH);
        mainPanel.add(comboBoxPanel, BorderLayout.SOUTH);
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);

        // container-panel for mainPanel
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(mainPanel, BorderLayout.NORTH);

        add(containerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // private void postMessage() {
    // String content = messageTextArea.getText();
    // ChuddyUser currentUser = new ChuddyUser("Senja");

    // if (forum.getThreads().isEmpty()) {
    // forum.addMessage(currentUser, content);
    // String threadname = JOptionPane.showInputDialog(this, "bajs");

    // if (threadname != null && !threadname.isEmpty()) {
    // selectedThread = forum.createThread(threadname);
    // System.out.println("New thread created: " + selectedThread.getThreadName());

    // }
    // } else {

    // forum.addMessage(currentUser, content);
    // System.out.println("Message added to the selected thread: " +
    // selectedThread.getThreadName());
    // messageTextArea.setText("");

    // }
    // viewSelectedThread();
    // }

    private void viewAllThreads() {
        JDialog viewThreadsDialog = new JDialog(this, "View Threads", true);
        viewThreadsDialog.setLayout(new BorderLayout());

        JTextArea threadsTextArea = new JTextArea();
        threadsTextArea.setEditable(false);

        for (DiscussionThread thread : ForumController.getDiscussionThreads()) {
            threadsTextArea.append("Thread: " + thread.getThreadName() + "\n");
        }

        JButton newThreadButton = new JButton("New Thread");
        newThreadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewThread();
                viewThreadsDialog.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newThreadButton);
        viewThreadsDialog.add(buttonPanel, BorderLayout.SOUTH);

        threadsTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = new Point(e.getX(), e.getY());
                int offset = threadsTextArea.viewToModel2D(p);
                try {
                    int line = threadsTextArea.getLineOfOffset(offset);
                    String threadName = threadsTextArea.getText().split("\n")[line].replace("Thread: ", "").trim();
                    ForumController.selectThread(threadName);
                    //selectedThread = forum.getThreadByName(threadName);
                    viewSelectedThread();
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(threadsTextArea);
        viewThreadsDialog.add(scrollPane, BorderLayout.CENTER);

        viewThreadsDialog.setSize(400, 400);
        viewThreadsDialog.setLocationRelativeTo(this);
        viewThreadsDialog.setVisible(true);
    }

    private void viewMyThreads() {

    }

    private void addNewThread() {
        String threadname = JOptionPane.showInputDialog(this, "bajs");

        if (threadname != null && !threadname.isEmpty()) {
            ForumController.createThread(threadname);
            viewSelectedThread();
        }
    }

    private void viewSelectedThread() {
        System.out.println("viewSelectedThread() called");
        selectedThread = ForumController.getSelectedThread();
        if (selectedThread != null) {
            messageDisplayArea.setText("");

            List<Message> messages = selectedThread.getMessagesCopy();

            if (messages.isEmpty()) {
                System.out.println("No messages in the selected thread.");
            } else {
                for (Message message : messages) {
                    System.out.println("Processing message: " + message.getContent());
                    if (message != null) {
                        messageDisplayArea.append(message.getSender().getName() + ": " + message.getContent() + " "
                                + message.timeStamp() + "\n");
                    }
                }
            }
        } else {
            System.out.println("No selected thread.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ForumController.initDefaultForums();
                new ChatForumGUI();
            }
        });
    }
}
