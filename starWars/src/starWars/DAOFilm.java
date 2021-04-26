package starWars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DAOFilm {

	String bddName,Login,Password,Host,Port;
	String strClassName = "com.mysql.jdbc.Driver";
	Connection conn;
	Statement stLogin;
	
	public DAOFilm(String bddName , String Login,String Password,String Host,String Port) {
		try {
					
			this.bddName = bddName;
			this.Login = Login;
			this.Password = Password;
			this.Host = Host;
			this.Port = Port;
			this.conn = DriverManager.getConnection("jdbc:mysql://"+Host+":"+Port+"/"+bddName+"?autoReconnect=true&useSSL=false", Login, Password);
			Class.forName(this.strClassName);
			this.stLogin = conn.createStatement();
		}
		catch(ClassNotFoundException e) {  

			System.err.println("Driver non chargé !");  e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println(e);
			}		

		
	}
	public void Close(){
		try {
			this.conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void Lister() {
		try {
			String strQuery = "SELECT * FROM Film;";  
			ResultSet rsUsers = this.stLogin.executeQuery(strQuery);
			while(rsUsers.next()) {
				System.out.println("Id : "+ rsUsers.getInt(1)+" Titre : "+ rsUsers.getString(2)+" Date de sortie : "+ rsUsers.getInt(3)+" Numéro : "+ rsUsers.getString(4)+" coût : "+ rsUsers.getInt(5)+" recette : "+ rsUsers.getInt(6));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
	}
	public void AjouterFilm(int id,String Titre,int sortie,String numero,int cout,int recette) {
		try {
			String query = " insert into film (id,Titre,sortie,numero,cout,recette)"
			        + " values (?,?,?,?,?,?);";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt (1,id);
			preparedStmt.setString (2,Titre);
			preparedStmt.setInt (3,sortie);
			preparedStmt.setString (4,numero);
			preparedStmt.setInt (5,cout);
			preparedStmt.setInt (6,recette);
			preparedStmt.execute();
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void DeleteFilm(int id) {
		try {
			String deleteQuery = "DELETE FROM film where id = "+id+";"; 
			this.stLogin.executeUpdate(deleteQuery);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
	}
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		DAOFilm co = new DAOFilm("starwars","root","","localhost","3306");
		co.Lister();
		System.out.println("Vous voulez supprimez quelle film ? (id) : ");
		String id = sc.nextLine();
		co.DeleteFilm(Integer.parseInt(id));
		co.Lister();
		co.AjouterFilm(2,"L'attaque des clones",2002,"II",500000,560000);
		co.Lister();
	}
	
}
