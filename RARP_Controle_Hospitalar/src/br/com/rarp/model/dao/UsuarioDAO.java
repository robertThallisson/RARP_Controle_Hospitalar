package br.com.rarp.model.dao;

import java.sql.SQLException;
import java.sql.Statement;

import br.com.rarp.control.SistemaCtrl;

public class UsuarioDAO {
	
	public static void criarTabela() throws ClassNotFoundException, SQLException, Exception {
		if(!SistemaCtrl.getInstance().tabelaExiste("funcionarios"))
			throw new Exception("Crie a tabela de funcionarios antes de criar a tabela de usuarios");
		
		if(!SistemaCtrl.getInstance().tabelaExiste("perfilUsuario"))
			throw new Exception("Crie a tabela de perfil de usuarios antes de criar a tabela de usuarios");
			
		Statement st = SistemaCtrl.getInstance().getConexao().getConexao().createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS ";
		sql += "usuario(";
		sql += "codigo SERIAL NOT NULL PRIMARY KEY, ";
		sql += "nome VARCHAR(225), ";
		sql += "usuario VARCHAR(225) NOT NULL UNIQUE, ";
		sql += "password VARCHAR(225), ";
		sql += "CONSTRAINT fk_funcionario FOREIGN KEY codigo REFERENCES funcionario(codigo), ";
		sql += "CONSTRAINT fk_perfilUsuario FOREIGN KEY codigo REFERENCES perfilUsuario(codigo), ";
		sql += "status BOOLEAN)";
		st.executeQuery(sql);
	}

}
