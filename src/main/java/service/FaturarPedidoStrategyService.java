package service;

import model.Pedido;
import strategy.FaturarPedidoStrategy;

public class FaturarPedidoStrategyService {
	
	FaturarPedidoStrategy faturar;

	public FaturarPedidoStrategyService(FaturarPedidoStrategy faturar) {
		this.faturar = faturar;
	}
	
	public void faturarPedido(Pedido pedido) {
		faturar.faturar(pedido);
	}
	
}
