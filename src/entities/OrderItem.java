package entities;

public class OrderItem {

	private Integer quantidade;
	private Double price;
	private Product produto;
	
	public OrderItem(Integer quantidade, Double price, Product produto) {
		this.quantidade = quantidade;
		this.price = price;
		this.produto = produto;
	}
	
	public Product getProduto() {
		return produto;
	}

	public void setProduto(Product produto) {
		this.produto = produto;
	}

	public Integer getQuantity() {
		return quantidade;
	}

	public void setQuantity(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public double subTotal() {
		return quantidade * price;
	}
	
	public String toString() {
		
		StringBuilder ordemItens = new StringBuilder();
		
		ordemItens.append(produto.getNome());
		ordemItens.append(", R$" + produto.getPrice());
		ordemItens.append(", Quantidade: " + quantidade);
		ordemItens.append(", Subtotal: $" + subTotal());
		
		return ordemItens.toString();
	}
}
