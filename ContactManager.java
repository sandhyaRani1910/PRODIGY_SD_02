import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ContactManager extends JFrame {
    JTextField nameField, phoneField, emailField;
    JButton addBtn, viewBtn, updateBtn, deleteBtn;

    Connection con;
    
    ContactManager() {
        setTitle("Contact Manager");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));
        
        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        
        addBtn = new JButton("Add");
        viewBtn = new JButton("View");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        
        add(new JLabel("Name:")); add(nameField);
        add(new JLabel("Phone:")); add(phoneField);
        add(new JLabel("Email:")); add(emailField);
        
        add(addBtn); add(viewBtn);
        add(updateBtn); add(deleteBtn);

        // DB Connection
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContactManager", "root", "password");
        } catch (Exception e) { e.printStackTrace(); }
        
        // Button Listeners
        addBtn.addActionListener(e -> addContact());
    }

    void addContact() {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO contacts(name, phone, email) VALUES(?,?,?)");
            ps.setString(1, nameField.getText());
            ps.setString(2, phoneField.getText());
            ps.setString(3, emailField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Contact Added!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        new ContactManager().setVisible(true);
    }
}


