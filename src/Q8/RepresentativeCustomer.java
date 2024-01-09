package Q8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RepresentativeCustomer extends JFrame implements ActionListener {

    private JTextField repNoTF, repNameTF, repStateTF, custNoTF, custNameTF, custStateTF, custLimitTF;
    private JButton insertRepBtn, insertCustBtn, displayStateBtn;
    private JTextArea displayArea;

    private Connection conn;

    // Constructor to set up the GUI
        public RepresentativeCustomer() {
        // Set up the GUI layout
        setTitle("Customer & Representative App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Initialize Swing components
        repNoTF = new JTextField(10);
        repNameTF = new JTextField(10);
        repStateTF = new JTextField(10);
        custNoTF = new JTextField(10);
        custNameTF = new JTextField(10);
        custStateTF = new JTextField(10);
        custLimitTF = new JTextField(10);

        insertRepBtn = new JButton("Insert Representative");
        insertCustBtn = new JButton("Insert Customer");
        displayStateBtn = new JButton("Display by State");
        displayArea = new JTextArea();

        // Add components to the frame
        add(new JLabel("Rep No:"));
        add(repNoTF);
        add(new JLabel("Rep Name:"));
        add(repNameTF);
        add(new JLabel("Rep State:"));
        add(repStateTF);
        add(new JLabel("Cust No:"));
        add(custNoTF);
        add(new JLabel("Cust Name:"));
        add(custNameTF);
        add(new JLabel("Cust State:"));
        add(custStateTF);
        add(new JLabel("Cust Limit:"));
        add(custLimitTF);
        add(insertRepBtn);
        add(insertCustBtn);
        add(displayStateBtn);
        add(displayArea);

        // Add action listeners for buttons
        insertRepBtn.addActionListener(this);
        insertCustBtn.addActionListener(this);
        displayStateBtn.addActionListener(this);

        // Establish database connection
        conn = connectDB();

        pack();
        setVisible(true);
    }


    // Method to handle button clicks
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == insertRepBtn) {
            // Insert representative data into the database
            insertRepresentative(conn, repNoTF.getText(), repNameTF.getText(), repStateTF.getText(), 5, 5);
        } else if (e.getSource() == insertCustBtn) {
            // Insert customer data into the database
            insertCustomer(conn, custNoTF.getText(), custNameTF.getText(), custStateTF.getText(), custLimitTF.getText(), repNoTF.getText());
        } else if (e.getSource() == displayStateBtn) {
            // Display customers and representatives by state
            displayByState(conn, custStateTF.getText());
        }
    }

    // Method to connect to the MySQL database
    public Connection connectDB() {
        Connection conn = null;
        try {
            // Establish a connection to the MySQL database
        	//Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/CustomerDetails";
            String user = "root";
            String password = "Mysql@6913";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to insert representative details into the database
    // Insert representative into the database
public void insertRepresentative(Connection conn, String repNo, String repName, String repState, int i, int j) {
    try {
        // Prepare SQL statement for representative insertion
        String insertRepQuery = "INSERT INTO Representative (RepNo, RepName, State, Commission, Rate) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insertRepQuery);
        ps.setString(1, repNo);
        ps.setString(2, repName);
        ps.setString(3, repState);
        ps.setLong(4, i);
        ps.setLong(5, j);

        // Execute SQL statement
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Representative inserted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert representative.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Method to insert customer details into the database
    // Insert customer into the database
public void insertCustomer(Connection conn, String custNo, String custName, String custState, String custLimit, String repNo) {
    try {
        // Prepare SQL statement for customer insertion
        String insertCustomerQuery = "INSERT INTO Customer (CustNo, CustName, State, Credit_Limit, RepNo) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insertCustomerQuery);
        ps.setString(1, custNo);
        ps.setString(2, custName);
        ps.setString(3, custState);
        ps.setString(4, custLimit);
        ps.setString(5, repNo);

        // Execute SQL statement
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Customer inserted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert customer.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Display customers and representatives by a specific state
public void displayByState(Connection conn, String state) {
    try {
        // Prepare SQL statement for fetching customers and representatives by state
        String displayQuery = "SELECT * FROM Customer WHERE State = ? UNION SELECT * FROM Representative WHERE State = ?";
        PreparedStatement ps = conn.prepareStatement(displayQuery);
        ps.setString(1, state);
        ps.setString(2, state);

        // Execute SQL query
        ResultSet rs = ps.executeQuery();

        // Display results in the JTextArea
        displayArea.setText(""); // Clear previous data
        while (rs.next()) {
            String info = "ID: " + rs.getString("CustNo") + ", Name: " + rs.getString("CustName") +
                    ", State: " + rs.getString("State") + ", RepNo: " + rs.getString("RepNo") + "\n";
            displayArea.append(info);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RepresentativeCustomer();
            }
        });
    }
}