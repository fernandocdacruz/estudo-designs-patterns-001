package model;

import java.util.ArrayList;
import java.util.List;

import enums.StatusPedido;
import enums.TipoFaturamento;

public class Pedido {
	
	private int id;
	private StatusPedido status;
	private double valorTotal;
	private TipoFaturamento tipoFaturamento;
	
	public Pedido() {
	}
	
	public Pedido(int id, StatusPedido status) {
		this.id = id;
		this.status = status;
	}

	private List<Lanche> lanches = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public TipoFaturamento getTipoFaturamento() {
		return tipoFaturamento;
	}

	public void setTipoFaturamento(TipoFaturamento tipoFaturamento) {
		this.tipoFaturamento = tipoFaturamento;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", staus=" + status + ", valorTotal=" + valorTotal + ", lanches=" + lanches + "]";
	}
	
	public double valorTotalPedido() {
		return lanches.stream().mapToDouble(pedido -> pedido.getValor()).sum();
	}
	
	public int quantidadeDeLanchesNoPedido() {
		return lanches.size();
	}
	
	public void adicionarLanche(Lanche lanche) {
		lanches.add(lanche);
	}
	
	public void removerLanche(Lanche lanche) {
		lanches.remove(lanche);
	}
	
}
