package Q7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

		
		JLabel idLabel = new JLabel("User ID:");
		JTextField idTF = new JTextField(10);
		
		JLabel passLabel = new JLabel("Password:");
		JTextField passTF = new JTextField(10);
		
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameTF = new JTextField(10);

		
		JButton submit = new JButton("Submit");
		
		
		Login(String title){
			super(title);
			setLayout(new GridLayout(0, 2));
			setVisible(true);
			add(idLabel);
			add(idTF);
			add(passLabel);
			add(passTF);
			add(nameLabel);
			add(nameTF);
			add(submit);
			
			submit.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String db = "jdbc:mysql://localhost:3306/loginDb";
				String pass = "password";
				String dir = "root";
				Connection c = (Connection)DriverManager.getConnection(db, dir, pass);
				Statement smt = c.createStatement();
				String query = "insert into login values ("+ "'"+idTF.getText() +  "','" + passTF.getText() +  "','" + nameTF.getText() +  "');";
				smt.executeUpdate(query);	// insert, delete, update
				
				ResultSet res = smt.executeQuery("select * from login;");
				while(res.next()) {
					System.out.println(res.getString("id"));
					System.out.println(res.getString("pass"));
					System.out.println(res.getString("name"));
				}
			}
			catch (ClassNotFoundException ex) {
				ex.getStackTrace();
			}
			catch (SQLException ex1) {
				ex1.getStackTrace();
			}
		}

		public static void main(String arg[]) {
			Login l = new Login("Login");
		}
}