package strategy;

import enums.StatusPedido;
import enums.TipoFaturamento;
import model.Pedido;

public class FaturarAVista implements FaturarPedidoStrategy {

	@Override
	public void faturar(Pedido pedido) {
		
		if (pedido.getStatus().equals(StatusPedido.ENTREGUE)) {
			System.out.println("\nPedido já foi faturado e entregue!");
		} else {
			pedido.setTipoFaturamento(TipoFaturamento.AVISTA);
			double valorPedido = pedido.valorTotalPedido();
			pedido.setValorTotal(valorPedido);
			System.out.println("\nPedido #" + pedido.getId()
			+ " faturado. Pagamento: " 
			+ pedido.getTipoFaturamento() 
			+ ". Valor total: R$ " + String.format("%.2f", valorPedido) 
			+ "\n\nAproveite seu lanche e volte sempre !!");
			pedido.setStatus(StatusPedido.ENTREGUE);
		}
		
	}

}
