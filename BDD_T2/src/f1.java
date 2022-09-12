import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import oracle.jdbc.OracleDriver;

import javax.swing.DropMode;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.border.LineBorder;

public class f1 extends JFrame {

	private JFrame frmGestionDesUtilisateurs;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f1 window = new f1();
					window.frmGestionDesUtilisateurs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			//DriverManager.registerDriver(new OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "houcine");
			
			//String rs = "create table utilisateur_java ( id int primary key , nom varchar2(20) , prenom varchar2(20) , age int , numero int )";
			
			
			 Statement stmt = con.createStatement();
			
			//stmt.executeUpdate(rs);
			
			
			
			System.out.println("done");
			/*while(rs.next())
				System.out.println(rs.getInt(1)+ "  " + rs.getString(2)+ "  " + rs.getString(3) + "  " + rs.getInt(4)+ "  " + rs.getInt(5)+ "  " );
			*/
			con.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	}

	/**
	 * Create the application.
	 */
	public f1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesUtilisateurs = new JFrame();
		frmGestionDesUtilisateurs.setTitle("Gestion des Utilisateurs");
		frmGestionDesUtilisateurs.setBackground(Color.BLACK);
		frmGestionDesUtilisateurs.setBounds(100, 100, 744, 407);
		frmGestionDesUtilisateurs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmGestionDesUtilisateurs.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 53, 172, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(25, 111, 172, 26);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(25, 172, 172, 26);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(25, 229, 172, 26);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(25, 286, 172, 26);
		panel.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(25, 34, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(25, 90, 46, 14);
		panel.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(25, 147, 46, 14);
		panel.add(lblPrenom);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(25, 209, 46, 14);
		panel.add(lblAge);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setBounds(25, 266, 46, 14);
		panel.add(lblNumro);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nom", "prenom", "age", "numero"
			}
		));
		table.setBackground(Color.WHITE);
		table.setBounds(242, 53, 464, 259);
		panel.add(table);
		
		
		
		//table.setModel(new DefaultTableModel(null , new String[] {"id","nom","prenom","age","numero"}));
		
		
		JButton btnNewButton = new JButton("Nouveau");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id;
					int age;
					int num;
					String id2 ="";
					String nom ="";
					String prenom ="";
					String age2 ="";
					String num2 ="";
					
					
					id2 = textField.getText().toString();
					id = Integer.parseInt(id2);
					
					nom = textField_1.getText();
					
					prenom = textField_2.getText();
					
					age2 = textField_3.getText().toString();
					age = Integer.parseInt(age2);
					
					num2 = textField_4.getText().toString();
					num = Integer.parseInt(num2);
					
					//System.out.println(id+" "+nom+" "+prenom+" "+age+" "+num);
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					
					//DriverManager.registerDriver(new OracleDriver());
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "houcine");
					
					String rs = "INSERT INTO utilisateur_java "
							+ "VALUES ( " +id+ ", "
							+ " '"+nom+"', "
							+ " '"+prenom+"', "
							+ " "+age+", "
							+ " "+num+")";
					
					Statement stmt = con.createStatement();
					
					stmt.executeUpdate(rs);
					
					System.out.println("added");
					
					con.close();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(233, 334, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnMaj = new JButton("M.A.J");
		btnMaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					int id;
					int age;
					int num;
					String id2 ="";
					String nom ="";
					String prenom ="";
					String age2 ="";
					String num2 ="";
					
					
					id2 = textField.getText().toString();
					id = Integer.parseInt(id2);
					
					nom = textField_1.getText();
					
					prenom = textField_2.getText();
					
					age2 = textField_3.getText().toString();
					age = Integer.parseInt(age2);
					
					num2 = textField_4.getText().toString();
					num = Integer.parseInt(num2);
					
					//System.out.println(id+" "+nom+" "+prenom+" "+age+" "+num);
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					
					//DriverManager.registerDriver(new OracleDriver());
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "houcine");
					
					//bel id
					String rs = "update utilisateur_java set nom = '"+nom+"' , prenom = '"+prenom+"' , age = "+age+" , numero = "+num+" where ID = "+id+" ";
					
					Statement stmt = con.createStatement();
					
					stmt.executeUpdate(rs);
					
					System.out.println("m-a-j");
					
					con.close();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnMaj.setBounds(332, 334, 89, 23);
		panel.add(btnMaj);
		
		JButton btnSupprim = new JButton("Supprim\u00E9");
		btnSupprim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id;
					int age;
					int num;
					String id2 ="";
					String nom ="";
					String prenom ="";
					String age2 ="";
					String num2 ="";
					
					
					id2 = textField.getText().toString();
					id = Integer.parseInt(id2);
					
					/*nom = textField_1.getText();
					
					prenom = textField_2.getText();
					
					age2 = textField_3.getText().toString();
					age = Integer.parseInt(age2);
					
					num2 = textField_4.getText().toString();
					num = Integer.parseInt(num2);*/
					
					//System.out.println(id+" "+nom+" "+prenom+" "+age+" "+num);
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					
					//DriverManager.registerDriver(new OracleDriver());
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "houcine");
					
					//bel id
					String rs = "delete from utilisateur_java where ID = "+id+" ";
					
					Statement stmt = con.createStatement();
					
					stmt.executeUpdate(rs);
					
					System.out.println("deleted");
					
					con.close();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnSupprim.setBounds(431, 334, 89, 23);
		panel.add(btnSupprim);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int id = 0;
					int age = 0;
					int num = 0;
					String id2 ="";
					String nom ="" ;
					String prenom ="";
					String age2 ="";
					String num2 ="";
					
					
					if(textField.getText().toString().isEmpty()) { System.out.println("n");}else {
					id2 = textField.getText();
					id = Integer.parseInt(id2);}
					System.out.println("1");
					
					if(textField_1.getText().toString().isEmpty()) { System.out.println("n");}else {
					nom = textField_1.getText();}
					System.out.println("2");
					
					if(textField_2.getText().toString().isEmpty()) { System.out.println("n");}else {
					prenom = textField_2.getText();}
					System.out.println("3");
					
					if(textField_3.getText().toString().isEmpty()) { System.out.println("n");}else {
					age2 = textField_3.getText();
					age = Integer.parseInt(age2);}
					System.out.println("4");
					
					if(textField_4.getText().toString().isEmpty()) { System.out.println("n");}else {
					num2 = textField_4.getText();
					num = Integer.parseInt(num2);}
					System.out.println("5");
					
					System.out.println(id+" "+nom+" "+prenom+" "+age+" "+num);
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					
					//DriverManager.registerDriver(new OracleDriver());
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "houcine");
					
					
					 Statement stmt = con.createStatement();
					 
					 
					 if (id != 0) {
						 
						 ResultSet myrs = stmt.executeQuery("select * from  utilisateur_java where id = "+id+" ");
						 DefaultTableModel tm = (DefaultTableModel)table.getModel();
						 tm.setRowCount(0);
						 while(myrs.next()) {
							 Object o[]={myrs.getString("id"),myrs.getString("nom"),myrs.getString("prenom"),myrs.getString("age"),myrs.getString("numero")};
							 tm.addRow(o);
						 }
						
						System.out.println("list search");
					 }
					 if (nom !="") {
						 ResultSet myrs = stmt.executeQuery("select * from  utilisateur_java where nom like '"+nom+"' ");
						 DefaultTableModel tm = (DefaultTableModel)table.getModel();
						 tm.setRowCount(0);
						 while(myrs.next()) {
							 Object o[]={myrs.getString("id"),myrs.getString("nom"),myrs.getString("prenom"),myrs.getString("age"),myrs.getString("numero")};
							 tm.addRow(o);
						 }
						
						System.out.println("list search");
					 }
					 else if (prenom !="") {
						 ResultSet myrs = stmt.executeQuery("select * from  utilisateur_java where prenom like '"+prenom+"' ");
						 DefaultTableModel tm = (DefaultTableModel)table.getModel();
						 tm.setRowCount(0);
						 while(myrs.next()) {
							 Object o[]={myrs.getString("id"),myrs.getString("nom"),myrs.getString("prenom"),myrs.getString("age"),myrs.getString("numero")};
							 tm.addRow(o);
						 }
						
						System.out.println("list search");
					 }
					 else if (age != 0) {
						 ResultSet myrs = stmt.executeQuery("select * from  utilisateur_java where age = "+age+" ");
						 DefaultTableModel tm = (DefaultTableModel)table.getModel();
						 tm.setRowCount(0);
						 while(myrs.next()) {
							 Object o[]={myrs.getString("id"),myrs.getString("nom"),myrs.getString("prenom"),myrs.getString("age"),myrs.getString("numero")};
							 tm.addRow(o);
						 }
						
						System.out.println("list search");
					 }
					 else if (num != 0) {
						 ResultSet myrs = stmt.executeQuery("select * from  utilisateur_java where numero = "+num+" ");
						 DefaultTableModel tm = (DefaultTableModel)table.getModel();
						 tm.setRowCount(0);
						 while(myrs.next()) {
							 Object o[]={myrs.getString("id"),myrs.getString("nom"),myrs.getString("prenom"),myrs.getString("age"),myrs.getString("numero")};
							 tm.addRow(o);
						 }
						
						System.out.println("list search");
					 }
					 
					 /*ResultSet myrs = stmt.executeQuery("select * from  utilisateur_java where id = "+id+" or nom = '"+nom+"' or prenom = '"+prenom+"' or age = "+age+" or numero = "+num+" ");
					 DefaultTableModel tm = (DefaultTableModel)table.getModel();
					 tm.setRowCount(0);
					 while(myrs.next()) {
						 Object o[]={myrs.getString("id"),myrs.getString("nom"),myrs.getString("prenom"),myrs.getString("age"),myrs.getString("numero")};
						 tm.addRow(o);
					 }
					
					System.out.println("list search");*/
					con.close();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnRecherche.setBounds(530, 334, 89, 23);
		panel.add(btnRecherche);
		
		JButton btnSync = new JButton("Sync");
		btnSync.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					
					//DriverManager.registerDriver(new OracleDriver());
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "houcine");
					
					//String rs = "create table utilisateur_java ( id int primary key , nom varchar2(20) , prenom varchar2(20) , age int , numero int )";
					
					/*String rs = "INSERT INTO utilisateur_java "
							+ "VALUES (1, "
							+ " 'hs', "
							+ " 'houcine', "
							+ " 21, "
							+ " 06)";*/
					
					 Statement stmt = con.createStatement();
					 
					 
					 
					 ResultSet myrs = stmt.executeQuery("select * from utilisateur_java");
					 DefaultTableModel tm = (DefaultTableModel)table.getModel();
					 tm.setRowCount(0);
					 while(myrs.next()) {
						 Object o[]={myrs.getString("id"),myrs.getString("nom"),myrs.getString("prenom"),myrs.getString("age"),myrs.getString("numero")};
						 tm.addRow(o);
					 }
					
					System.out.println("list done");
					con.close();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				//table.setModel(new DefaultTableModel(null , new String[] {"id","nom","prenom","age","numero"}));
				
			}
		});
		btnSync.setBounds(629, 334, 89, 23);
		panel.add(btnSync);
	}
}
