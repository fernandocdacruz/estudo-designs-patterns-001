package strategy;

import enums.StatusPedido;
import enums.TipoFaturamento;
import model.Lanche;
import model.Pedido;

public class FaturarCartao implements FaturarPedidoStrategy {

	@Override
	public void faturar(Pedido pedido) {
		
		if (pedido.getStatus().equals(StatusPedido.ENTREGUE)) {
			System.out.println("\nPedido já foi faturado e entregue!");
		} else {
			pedido.setTipoFaturamento(TipoFaturamento.CARTAO);
			double valorPedido = pedido.valorTotalPedido();
			double valorPedidoFaturado = valorPedido + (valorPedido * 0.2);
			pedido.setValorTotal(valorPedidoFaturado);
			System.out.println("\nPedido #" + pedido.getId()
			+ " faturado. Pagamento: " 
			+ pedido.getTipoFaturamento() 
			+ ". Valor total: R$ " + String.format("%.2f", valorPedidoFaturado) 
			+ "\n\nAproveite seu lanche e volte sempre !!");
			pedido.setStatus(StatusPedido.ENTREGUE);
		}
		
	}

}
