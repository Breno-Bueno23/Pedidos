package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entities.enums.OrderStatus;

public class Order {

	SimpleDateFormat dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date momento;
	private OrderStatus status;	
	private Client cliente;
	private ArrayList<OrderItem> itens = new ArrayList<>();
	
	public Order(Date momento, OrderStatus status, Client cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public ArrayList<OrderItem> getItens() {
		return itens;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}
	
	public void setMomento(Date momento) {
		this.momento = momento;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}

	public double total() {
       
		double soma = 0;
		for(OrderItem item : itens) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		
		StringBuilder pedido = new StringBuilder();
		pedido.append("Data do pedido: " + dataAtual.format(momento) + "\n");
		pedido.append("Status do pedido: " + status + "\n");
		pedido.append("Cliente: " + cliente.getNome());
		pedido.append(" (" + dataFormatada.format(cliente.getAniversario()) + ')');
		pedido.append(" - " + cliente.getEmail() + "\n");
		pedido.append("Ordem dos pedidos: " + "\n");
		for (OrderItem item : itens) {
			pedido.append(item + "\n");
		}
		pedido.append("Preço total: R$");
		pedido.append(String.format("%.2f", total()));
		return pedido.toString();
	
	}
}
