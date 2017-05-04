import java.util.ArrayList;

import edu.univas.si4.bi.OrderBI;
import edu.univas.si4.bi.OrderException;
import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Item;


public class OrderCreateTest {
	
	public static void main(String[] args) {
		
		try {
			Cliente client = new Cliente();
			client.setCod(1);

			ArrayList<Item> items = new ArrayList<Item>();
			
			Item item1 = new Item();
			item1.setProductCode(1);
			item1.setQuantity(3);
			
			items.add(item1);
			
			// Inserindo o Item 2 do pedido
			Item item2 = new Item();
			item2.setProductCode(2);
			item2.setQuantity(7);
			
			items.add(item2);
			
			OrderBI.createOrder(client, items);
			
			
		} catch (OrderException exception) {
			System.out.println("Produto " + exception.getProduct().getName() + " não tem saldo suficiente para a venda de " + exception.getQuantity() + " itens");
		}
		
	}

}
