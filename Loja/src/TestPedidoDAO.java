import java.util.ArrayList;

import edu.univas.si4.dao.ClienteDAO;
import edu.univas.si4.dao.PedidoDAO;
import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Pedido;

public class TestPedidoDAO {

	public static void main(String[] args) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.findByPK(504);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		ArrayList<Pedido> pedidos = pedidoDAO.findByClient(cliente);
		
		for (Pedido pedido : pedidos) {
			System.out.println("ID: " + pedido.getCod() + " Data: " + pedido.getData());
		}
	}
}
