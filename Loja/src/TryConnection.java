import java.util.Date;

import edu.univas.si4.dao.ConnectionFactory;
import edu.univas.si4.dao.DAOException;
import edu.univas.si4.dao.ItemDAO;
import edu.univas.si4.dao.OrderDAO;
import edu.univas.si4.entity.Item;
import edu.univas.si4.entity.Pedido;


public class TryConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			ConnectionFactory.createConnection();
			System.out.println("Connection OK");
			
			Pedido order = new Pedido();
			order.setData(new Date());
			
			OrderDAO orderDAO = new OrderDAO();
			orderDAO.insert(order);
			
			System.out.println("Order inserted");
			
			
			Item item = new Item();
			item.setOrderCode(101);
			item.setProductCode(1);
			item.setQuantity(10);
			
			ItemDAO itemDAO = new ItemDAO();
			itemDAO.insert(item);
			
			System.out.println("Item inserted");
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

}
