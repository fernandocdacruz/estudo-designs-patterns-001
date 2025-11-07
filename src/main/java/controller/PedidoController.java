package controller;

import service.PedidoService;

public class PedidoController {

	private PedidoService pedidoService;
	
	public PedidoController() {
	}
	
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	public void executarMenuOp(int op) {
		switch (op) {
		case 1: pedidoService.listarTodosPedidos();
			break;
		case 2: pedidoService.adicionarPedido();
			break;
		case 3: pedidoService.removerPedido();
			break;
		case 4: pedidoService.faturarPedido();;
			break;
		}
	}
	
}
