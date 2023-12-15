package dev.knodeln.chuddy.model;

import dev.knodeln.chuddy.controller.ForumController;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ChatForumGUI extends JFrame {

    private Forum forum;
    private JTextArea messageTextArea;
    private JTextArea messageDisplayArea;

    private DiscussionThread selectedThread;

    private ChuddyUser currentUser = new ChuddyUser("Senja");

    public ChatForumGUI() {

        messageTextArea = new JTextArea(10, 30);
        messageDisplayArea = new JTextArea(30, 30);

        JButton postButton = new JButton("Post Message");
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ForumController.addMessage(messageTextArea.getText(), currentUser);
                viewSelectedThread();
                messageTextArea.setText("");
            }
        });

        JButton threadButton = new JButton("View Threads");
        threadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllThreads();
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

        JButton myThreadsButton = new JButton("My Threads");
        myThreadsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMyThreads();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newThreadButton);
        buttonPanel.add(myThreadsButton);
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
        JDialog viewMyThreadsDialog = new JDialog(this, "My threads", true);
        viewMyThreadsDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        viewMyThreadsDialog.setLayout(new BorderLayout());

        JTextArea myThreadsTextArea = new JTextArea();
        myThreadsTextArea.setEditable(false);

        List<DiscussionThread> userThreads = ForumController.getUserThreads(currentUser);

        for (DiscussionThread thread : userThreads) {
            myThreadsTextArea.append("Thread: " + thread.getThreadName() + "\n");
        }

        viewMyThreadsDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                selectedThread = null;
            }
        });

        myThreadsTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = new Point(e.getX(), e.getY());
                int offset = myThreadsTextArea.viewToModel2D(p);
                try {
                    int line = myThreadsTextArea.getLineOfOffset(offset);
                    String threadName = myThreadsTextArea.getText().split("\n")[line].replace("Thread: ", "").trim();
                    ForumController.selectThread(threadName);
                    viewSelectedThread();
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(myThreadsTextArea);
        viewMyThreadsDialog.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMyThreadsDialog.dispose();
                viewAllThreads();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        viewMyThreadsDialog.add(buttonPanel, BorderLayout.SOUTH);

        viewMyThreadsDialog.setSize(400, 400);
        viewMyThreadsDialog.setLocationRelativeTo(this);
        viewMyThreadsDialog.setVisible(true);
    }

    private void addNewThread() {
        String threadname = JOptionPane.showInputDialog(this, "Enter a name for the new thread");

        if (threadname != null && !threadname.isEmpty()) {
            ForumController.createThread(threadname);
            viewSelectedThread();
        }
    }

    private void viewSelectedThread() {
        System.out.println("viewSelectedThread() called");
        selectedThread = ForumController.getSelectedThread();
        System.out.println("Selected Thread: " + selectedThread);

        if (selectedThread != null) {
            messageDisplayArea.setText("");

            List<Message> messages = selectedThread.getMessagesCopy();


            if (messages.isEmpty()) {
                System.out.println("No messages in the selected thread.");
            } else {
                for (Message message : messages) {
                    message.getContent();
                    if (message != null) {
                        messageDisplayArea.append(message.getSender().getName() + ": " + message.getContent() + " "
                                + message.getTimeStamp() + "\n");
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
