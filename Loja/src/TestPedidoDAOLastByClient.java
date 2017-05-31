import java.util.ArrayList;
import java.util.Set;

import edu.univas.si4.dao.ClienteDAO;
import edu.univas.si4.dao.PedidoDAO;
import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Item;
import edu.univas.si4.entity.Pedido;

public class TestPedidoDAOLastByClient {

	public static void main(String[] args) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.findByPK(504);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.findLastByClient(cliente);
		
		System.out.println("Pedido: " + pedido.getCod());
		System.out.println("Data: " + pedido.getData());
		
		Set<Item> items = pedido.getItems();
		for (Item item : items) {
			System.out.println("Produto: " + item.getProduto().getNome() + 
					" Quantidade: " + item.getQuantidade());
		}
		
		
	}
}
