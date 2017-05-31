import java.util.ArrayList;

import edu.univas.si4.dao.ClienteDAO;
import edu.univas.si4.dao.PedidoDAO;
import edu.univas.si4.dao.ProdutoDAO;
import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Pedido;
import edu.univas.si4.entity.Produto;

public class TestProdutoDAO {

	public static void main(String[] args) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.findByPK(504);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayList<Produto> produtos = produtoDAO.findByClient(cliente);
		
		for (Produto produto : produtos) {
			
			System.out.println("Produto: " + produto.getNome());
			
		}
	}
}
