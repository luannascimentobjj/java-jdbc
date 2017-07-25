package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.dao.ProdutosDAO;
import br.com.caelum.modelo.Produto;

public class TestaProdutoDAO {

	public static void main(String[] args) throws SQLException {
		Produto mesa = new Produto("Mesa Vermelha", "Mesa 4 pés");
		
		try(Connection con = new ConnectionPool().getConnection()){
			ProdutosDAO dao = new ProdutosDAO(con);
			dao.salva(mesa);
			
			List<Produto> lista = dao.lista();
			for (Produto produto : lista) {
				System.out.println("Existe o produto: " + produto);
			}
		}
	}


}
