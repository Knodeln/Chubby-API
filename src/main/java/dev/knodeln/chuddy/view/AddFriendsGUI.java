package dev.knodeln.chuddy.view;

import dev.knodeln.chuddy.controller.ChuddyUserController;
import dev.knodeln.chuddy.controller.CurrentUserController;
import dev.knodeln.chuddy.controller.ViewController;
import dev.knodeln.chuddy.model.ChuddyDataHandler;
import dev.knodeln.chuddy.model.ChuddyUser;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddFriendsGUI extends JFrame{
    private JFrame frame;
    private FriendTableModel friendTableModel;
    private JTable friendTable;

    public AddFriendsGUI() {
        frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        friendTableModel = new FriendTableModel(CurrentUserController.getAllUsersNotFriended());
        friendTable = new JTable(friendTableModel);

        // Set custom renderer for the "Action" column
        friendTable.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
        // Set custom editor for the "Action" column
        friendTable.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));

        JScrollPane scrollPane = new JScrollPane(friendTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Profile Page");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.setProfilePageView();
                frame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }


    private class FriendTableModel extends AbstractTableModel {
        private ArrayList<ChuddyUser> friends;

        private String[] columnNames = {"Name", "Add"};

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public FriendTableModel(List<ChuddyUser> initialFriends) {
            this.friends = new ArrayList<>(initialFriends);

        }

        public void removeFriend(ChuddyUser friend) {
            friends.remove(friend);
            fireTableRowsDeleted(friends.size() - 1 , friends.size() - 1);
        }

        @Override
        public int getRowCount() {
            return friends.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ChuddyUser friend = friends.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return friend.getName();
                case 1:
                    return "Add Friend";
                default:
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            // Make the "Action" column editable
            return columnIndex == 1;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            // Handle the action when the but ton is clicked
            if (columnIndex == 1) {
                CurrentUserController.addFriend(friends.get(rowIndex));
                JOptionPane.showMessageDialog(frame, "Added " + friends.get(rowIndex).getName() + " as a friend.");
                removeFriend(friends.get(rowIndex));
            }
        }
    }

    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;

        public ButtonEditor(JTextField textField) {
            super(textField);
            button = new JButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText((value == null) ? "" : value.toString());
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Add Friend";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddFriendsGUI());
    }
}
