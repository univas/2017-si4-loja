import java.util.List;

import edu.univas.si4.dao.ProdutoDAO;
import edu.univas.si4.entity.Produto;

public class TestFindAll {

	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> listProduto = produtoDAO.findAll();
		for (Produto produto : listProduto) {
			System.out.println("Produto: " + produto.getNome() + " | Saldo: " + produto.getSaldo());
		}
	}
}
