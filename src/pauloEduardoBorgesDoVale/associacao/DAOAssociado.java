package pauloEduardoBorgesDoVale.associacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOAssociado {
	public void inserir(Associado a) throws SQLException {
		Connection con = Conexao.getConexao();
		// insert into associacao (numero, nome) values (1, 'ADUFPI')
		String cmd = "insert into associado (numeroAssociado, nome, telefone, dataAssociacao, nascimento) values ('"
				+ a.getNumeroAssociado() + "', \'" + a.getNome() + "', \'" + a.getTelefone() + "', \'"
				+ a.getDataAssociacao() + "', \'" + a.getNascimento() + "\')";
		System.out.println(cmd);
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	public void alterar(Associado a) {

	}

	public void remover(int n) {

	}

	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		String cmd = "delete from associado";
		System.out.println(cmd);
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	public Associado recuperar(int n) throws SQLException, ValorInvalido {
		Connection con = Conexao.getConexao();
		// select * from associacao where numero = 2
		String cmd = "select * from associado where numeroAssociado = " + n;
		System.out.println(cmd);
		Associado a = null;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		if (rs.next()) {
			int num = rs.getInt("numeroAssociado");
			String nome = rs.getString("nome");
			String telefone = rs.getString("telefone");
			Long dataAssociacao = rs.getLong("dataAssociacao");
			Long nascimento = rs.getLong("nascimento");
			a = new Associado(num, nome, telefone, dataAssociacao, nascimento);
		}
		st.close();
		return a;
	}

	public ArrayList<Associado> recuperarTodos() {
		return null;
	}

}
