package Q5;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;



public class UserLoginValidation {
    private Map < String, String > userCredentials = new HashMap < > ();
    private Map < String, String > customers = new HashMap < > ();
    private Map < String, Double > items = new HashMap < > ();
    private JTextField customerIdField, mobileNumberField, itemIdField, quantityField,
    itemNameField, totalCostField;
    public static void main(String[] args) {
        UserLoginValidation userLoginValidation = new UserLoginValidation();
        userLoginValidation.createUI();
    }
    private void createUI() {
        // Dummy user credentials
        userCredentials.put("123", "123");
        
        
        // Dummy customer data
        customers.put("1234567890", "CustomerID1");
        customers.put("0987654321", "CustomerID2");
        
        
        // Dummy item data
        items.put("ItemID1", 10.0);
        items.put("ItemID2", 20.0);
        items.put("ItemID3", 30.0);
        
        
        
        JFrame frame = new JFrame("User Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 100, 20);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 30, 150, 20);
        
        
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 60, 100, 20);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 60, 150, 20);
        
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 100, 100, 30);
        loginButton.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) {
        		
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                        JOptionPane.showMessageDialog(frame, "Login Successful!");
                        showCustomerInfo();
                } 
                else {
                      JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                      
                }
           }
        }); 
        frame.add(usernameLabel);
        frame.add(usernameField); 
        frame.add(passwordLabel);
        frame.add(passwordField); 
        frame.add(loginButton);
        frame.setVisible(true);
        }
    
    
        private void showCustomerInfo() {
            JFrame infoFrame = new JFrame("Customer Information");
            infoFrame.setSize(400, 400);
            infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            infoFrame.setLayout(null);
            
            
            JLabel customerIdLabel = new JLabel("Customer ID:");
            customerIdLabel.setBounds(50, 30, 100, 20);
            customerIdField = new JTextField();
            customerIdField.setBounds(150, 30, 150, 20);
            
            
            JLabel mobileNumberLabel = new JLabel("Mobile Number:");
            mobileNumberLabel.setBounds(50, 60, 100, 20);
            mobileNumberField = new JTextField();
            mobileNumberField.setBounds(150, 60, 150, 20);
            
            
            JLabel itemIdLabel = new JLabel("Item ID:");
            itemIdLabel.setBounds(50, 90, 100, 20);
            itemIdField = new JTextField();
            itemIdField.setBounds(150, 90, 150, 20);
            
            
            JLabel quantityLabel = new JLabel("Quantity:");
            quantityLabel.setBounds(50, 120, 100, 20);
            quantityField = new JTextField();
            quantityField.setBounds(150, 120, 150, 20);
            
            
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setBounds(150, 150, 100, 30);
            calculateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calculateTotalCost();
                }
            });
            JLabel itemNameLabel = new JLabel("Item Name:");
            itemNameLabel.setBounds(50, 190, 100, 20);
            itemNameField = new JTextField();
            itemNameField.setBounds(150, 190, 150, 20);
            itemNameField.setEditable(false);
            
            JLabel totalCostLabel = new JLabel("Total Cost:");
            totalCostLabel.setBounds(50, 220, 100, 20);
            totalCostField = new JTextField();
            totalCostField.setBounds(150, 220, 150, 20);
            totalCostField.setEditable(false);
            
            
            JButton printButton = new JButton("Print");
            printButton.setBounds(150, 250, 100, 30);
            printButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    printDetails();
                }
            });
            infoFrame.add(customerIdLabel);
            infoFrame.add(customerIdField);
            
            
            infoFrame.add(mobileNumberLabel);
            infoFrame.add(mobileNumberField);
            
            infoFrame.add(itemIdLabel);
            infoFrame.add(itemIdField);
            
            infoFrame.add(quantityLabel);
            infoFrame.add(quantityField);
            
            infoFrame.add(calculateButton);
            
            infoFrame.add(itemNameLabel);
            infoFrame.add(itemNameField);
            
            infoFrame.add(totalCostLabel);
            infoFrame.add(totalCostField);
            
            infoFrame.add(printButton);
            infoFrame.setVisible(true);
        }
        private void calculateTotalCost() {
            String mobileNumber = mobileNumberField.getText();
            String itemId = itemIdField.getText();
            System.out.print(itemId);
            int quantity = Integer.parseInt(quantityField.getText());
            String customerId = customers.getOrDefault(mobileNumber, "New Customer");
            customerIdField.setText(customerId);
            Double itemCost = items.getOrDefault(itemId, 0.0);
            String itemName = (itemCost != 0.0) ? itemId : "Item Not Found";
            itemNameField.setText(itemName);
            double totalCost = itemCost * quantity;
            totalCostField.setText(String.valueOf(totalCost));
        }
        private void printDetails() {
            String customerId = customerIdField.getText();
            String itemName = itemNameField.getText();
            String totalCost = totalCostField.getText();
            Object[] discountOptions = {
                "10% Discount",
                "20% Discount",
                "No Discount"
            };
            String selectedDiscount = (String)
            	JOptionPane.showInputDialog(null, "Choose Discount Option: ",
                "Discount", JOptionPane.PLAIN_MESSAGE, null, discountOptions,
                discountOptions[1]);
            String message = "Customer ID: " + customerId + "\nItem Name: " + itemName +"\nTotal Cost: "+totalCost 							 					 		+"\nDiscount: " + selectedDiscount;
            JOptionPane.showMessageDialog(null, message, "Print Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }































