/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

public class Produto {
    private String nome;
	private int cod;
	private int qtd_atual;
	private String validade;
	private double preco;
	private int qtd_vendida;
	private int bloqueado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getQtd_atual() {
		return qtd_atual;
	}
	public void setQtd_atual(int qtd) {
		this.qtd_atual = qtd;
	}
	public String getValidade() {
		return validade;	
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQtd_vendida() {
		return qtd_vendida;
	}
	public void setQtd_vendida(int qtd_vendida) {
		this.qtd_vendida = qtd_vendida;
	}
	public int isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(int bloqueado) {
		this.bloqueado = bloqueado;
	}
}

/*
public class Produto {
    private String nome;
	private int cod;
	private int qtd_atual;
	private String validade;
	private double preco;
	private int qtd_vendida;
	private boolean bloqueado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getQtd_atual() {
		return qtd_atual;
	}
	public void setQtd_atual(int qtd) {
		this.qtd_atual = qtd;
	}
	public String getValidade() {
		return validade;	
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQtd_vendida() {
		return qtd_vendida;
	}
	public void setQtd_vendida(int qtd_vendida) {
		this.qtd_vendida = qtd_vendida;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
*/