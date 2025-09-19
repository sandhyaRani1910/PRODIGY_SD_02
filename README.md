A simple Java Swing + MySQL CRUD application to manage contacts. Users can add, view, update, and delete contacts with a graphical interface.

🚀 Features

Add Contact – Store name, phone, and email into the database.

View Contact – Display stored contacts (to be implemented).

Update Contact – Modify existing contact details (to be implemented).

Delete Contact – Remove a contact permanently (to be implemented).

MySQL Database Integration using JDBC.

Swing-based GUI for a simple and interactive desktop experience.

🛠️ Technologies Used

Java (JDK 8+)

Swing (GUI framework)

MySQL (for persistent storage)

JDBC (Java Database Connectivity)

📂 Project Structure
ContactManager/
│── ContactManager.java    # Main application file
│── README.md              # Documentation

⚙️ Setup Instructions
1. Database Setup

Open MySQL and create a database:

CREATE DATABASE ContactManager;


Create the contacts table:

USE ContactManager;

CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(100)
);

2. Configure Database Connection

Inside ContactManager.java, update the connection string with your credentials:

con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/ContactManager", "root", "your_password"
);

3. Compile & Run
javac ContactManager.java
java ContactManager

🖥️ How It Works

Launch the application.

Enter Name, Phone, Email.

Click Add → Saves to database.

Future scope: View, Update, Delete (buttons already created, can be extended).

📌 Future Enhancements
Implement View → Show all contacts in a JTable.

Implement Update → Select and edit existing contact.

Implement Delete → Remove contact from database.

Add Search functionality.

Better UI/UX with styling.
