package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "";

	/**
	 * Connect.
	 *
	 * @return the connection
	 */
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Adds the contact.
	 *
	 * @param contact the contact
	 */
	public void addContact(JavaBeans contact) {
		String create = "INSERT INTO contatos (nome, fone, email) values (?, ?, ?)";

		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contact.getNome());
			pst.setString(2, contact.getFone());
			pst.setString(3, contact.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	/**
	 * List contact.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listContact() {
		ArrayList<JavaBeans> contact = new ArrayList<>();
		String read = "SELECT * FROM contatos ORDER BY nome";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contact.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contact;
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return null;
		}
	}

	/**
	 * Gets the contact.
	 *
	 * @param contact the contact
	 * @return the contact
	 */
	public void getContact(JavaBeans contact) {
		String readForId = "select * from contatos where idcon = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(readForId);
			pst.setString(1, contact.getIdcon());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				contact.setIdcon(rs.getString(1));
				contact.setNome(rs.getString(2));
				contact.setFone(rs.getString(3));
				contact.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	/**
	 * Update contact.
	 *
	 * @param contact the contact
	 */
	public void updateContact(JavaBeans contact) {
		String update = "update contatos set nome = ?, fone = ?, email = ? WHERE idcon = ?";
		try {

			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contact.getNome());
			pst.setString(2, contact.getFone());
			pst.setString(3, contact.getEmail());
			pst.setString(4, contact.getIdcon());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	/**
	 * Removes the contact.
	 *
	 * @param contact the contact
	 */
	public void removeContact(JavaBeans contact) {
		String delet = "delete from contatos where idcon = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(delet);
			pst.setString(1, contact.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
