package controller;

import model.Pedido;
import service.FaturarPedidoStrategyService;
import strategy.FaturarAVista;
import strategy.FaturarCartao;
import strategy.FaturarPromocao;

public class FaturarPedidoStrategyController {
	
	FaturarPedidoStrategyService faturarPedidoStrategyService;
	
	public FaturarPedidoStrategyController() {
	}
	
	public FaturarPedidoStrategyController(FaturarPedidoStrategyService faturarPedidoStrategyService) {
		this.faturarPedidoStrategyService = faturarPedidoStrategyService;
	}

	public void executarOp(int op, Pedido pedido) {
		switch (op) {
		case 1: faturarPedidoStrategyService = new FaturarPedidoStrategyService(new FaturarAVista());
				faturarPedidoStrategyService.faturarPedido(pedido);
			break;
		case 2: faturarPedidoStrategyService = new FaturarPedidoStrategyService(new FaturarCartao());
				faturarPedidoStrategyService.faturarPedido(pedido);
			break;
		case 3: faturarPedidoStrategyService = new FaturarPedidoStrategyService(new FaturarPromocao());
				faturarPedidoStrategyService.faturarPedido(pedido);
			break;
		}
	}
	
}
