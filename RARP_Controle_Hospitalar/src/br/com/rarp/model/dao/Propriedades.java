package br.com.rarp.model.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Propriedades {
	private static final Propriedades INSTANCE = new Propriedades();
	private TypedProperties prop;
	private String url;
	private String database;
	private String user;
	private String password;
	private Boolean controleAcesso;
	
	private Propriedades() {
		prop = new TypedProperties();
		try {
			prop.load(new FileInputStream("./properties/RARP.Properties"));
			getPropriedades();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Propriedades getInstance() {
		return INSTANCE;
	}
	
	public void getPropriedades() {
		url = prop.getProperty("conexao.url", "jdbc:postgresql://localhost:5432/");
		database = prop.getProperty("conexao.database", "rarp");
		user = prop.getProperty("conexao.user", "postgres");
		password = prop.getProperty("conexao.password", "1234");
		controleAcesso = prop.getProperty("sistema.controleAcesso", false);
	}
	
	public void setPropriedades() {
		 prop.setProperty("conexao.url", url);
		 prop.setProperty("conexao.database", database);
		 prop.setProperty("conexao.user", user);
		 prop.setProperty("conexao.password", password);
		 
		 //Op��es do sistema
		 prop.setProperty("sistema.controleAcesso", controleAcesso);
	}
	
	public TypedProperties getProp() {
		return prop;
	}

	public void setProp(TypedProperties prop) {
		this.prop = prop;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatabase() {
		return database;
	}

	
	public Boolean getControleAcesso() {
		return controleAcesso;
	}

	public void setControleAcesso(Boolean controleAcesso) {
		this.controleAcesso = controleAcesso;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		setPropriedades();
	}
}
