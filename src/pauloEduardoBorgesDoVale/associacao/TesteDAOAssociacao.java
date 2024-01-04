package pauloEduardoBorgesDoVale.associacao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

public class TesteDAOAssociacao {

	@Test
	public void testarIncluirRecuperarAssociacao() throws SQLException, ValorInvalido {
		Associacao a = new Associacao(10, "Adufpi");
		Associado b = new Associado(1, "Samuel", "323335856", 2200, 1000);
		DAOAssociacao dao = new DAOAssociacao();
		DAOAssociado h = new DAOAssociado();
		dao.removerTodos();
		dao.inserir(a);
		h.removerTodos();
		b.setNAssociacao(a.getNumero());
		h.inserir(b);
		Associacao outra = dao.recuperar(10);
		assertEquals(10, outra.getNumero());
		assertEquals("hello", outra.getNome());
		Associado outr = h.recuperar(1);
		assertEquals(1, outr.getNumeroAssociado());
		assertEquals("Samuel", outr.getNome());
	}
}
