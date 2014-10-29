package conectionDb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.sql2o.Sql2o;

import windowInformationFromUser.WindowErrorInformation;


public class ConectionSql2o {

	
	private static Sql2o sql2o;
	
	 public void setConectionDataBase(){
		Properties propFile = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream("conectionDB/dataBase.properties");
		try {
			propFile.load(input);
			String db = propFile.getProperty("database.url");
			String userName = propFile.getProperty("database.username");
			String password = propFile.getProperty("database.password");
			String dbDriver = propFile.getProperty("database.driverClassName");
			
			try {
				Class.forName(dbDriver).newInstance();
				sql2o = new Sql2o(db, userName, password);
			} catch (InstantiationException e) {
				WindowErrorInformation.windowShow("Brak połczenia z baza danych");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				WindowErrorInformation.windowShow("Brak połczenia z baza danych");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				WindowErrorInformation.windowShow("Brak sterownika do bazy danych");
				e.printStackTrace();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static Sql2o getSql2o() {
		return sql2o;
	}

	public static void setSql2o(Sql2o sql2o) {
		ConectionSql2o.sql2o = sql2o;
	}
	
	



}
