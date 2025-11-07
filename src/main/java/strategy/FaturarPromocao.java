package strategy;

import enums.StatusPedido;
import enums.TipoFaturamento;
import model.Lanche;
import model.Pedido;
import model.Lanche.LancheBuilder;

public class FaturarPromocao implements FaturarPedidoStrategy {

	@Override
	public void faturar(Pedido pedido) {
		
		if (pedido.getStatus().equals(StatusPedido.ENTREGUE)) {
			System.out.println("\nPedido já foi faturado e entregue!");
		} else {
			pedido.setTipoFaturamento(TipoFaturamento.PROMOCAO);
			double valorPedido = pedido.valorTotalPedido();
			double valorPedidoFaturado = valorPedido + (pedido.quantidadeDeLanchesNoPedido() * 10);
			pedido.setValorTotal(valorPedidoFaturado);
			System.out.println("\nPedido #" + pedido.getId()
			+ " faturado. Pagamento: " + pedido.getTipoFaturamento()
			+ ". Lanche faturado na PROMOÇÃO com Batata e Refri!!"
			+ ". Valor total: R$ " + String.format("%.2f", valorPedidoFaturado) 
			+ "\n\nAproveite seu lanche e volte sempre !!");
			pedido.setStatus(StatusPedido.ENTREGUE);
		}
		
	}


}
