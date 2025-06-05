package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do cliente:");
		
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de aniversario (DD/MM/YYYY): ");
		Date aniversario = dataFormatada.parse(sc.next());
		
		Client c1 = new Client(nomeCliente, email, aniversario);
		
		System.out.println("Entre com os dados do(s) pedido(s):");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());
		
		Order ordem = new Order(new Date(), status, c1);
		
		System.out.print("Quantos itens voce deseja?");
		int qntd = sc.nextInt();
		for(int i = 0; i < qntd; i++) {
			System.out.println("Entre com os dados do pedido " + '#' +(i+1));
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nomePedido = sc.nextLine();
			System.out.print("Preço do produto: ");
			Double preco = sc.nextDouble();
			
			Product p1 = new Product(nomePedido, preco);
			
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			
			OrderItem oi = new OrderItem(quantidade, preco, p1);
			
			ordem.addItem(oi);
		}
		
		System.out.println("Dados do cliente: ");
		System.out.println(ordem);
		sc.close();
	}

}
