package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	
	private String nome;
	private String email;
	private Date aniversario;
	
	public Client(String nome, String email, Date aniversario) {
		this.nome = nome;
		this.email = email;
		this.aniversario = aniversario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	@Override
	public String toString() {
		return "Client [nome=" + nome + ", email=" + email + ", aniversario=" + dataFormatada.format(aniversario) + "]";
	}
	
	
}
