import java.text.SimpleDateFormat;
import java.util.Set;

import edu.univas.si4.dao.ClienteDAO;
import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Item;
import edu.univas.si4.entity.Pedido;

public class TestDAO {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = clienteDAO.findByPK(504);
		System.out.println("Nome: " + cliente.getNome());

		
		Set<Pedido> pedidos = cliente.getPedidos();
		for (Pedido pedido : pedidos) {
			System.out.println("Pedido do dia: " + dateFormat.format(pedido.getData()));
			
			Set<Item> items = pedido.getItems();
			for (Item item : items) {
				System.out.println("Produto: " + item.getProduto().getNome());
				System.out.println("Quantidade: " + item.getQuantidade());
				
				System.out.println();
			}
			
			System.out.println();
		}
	}
}
