package builder;

import enums.StatusPedido;
import model.Lanche;

public class LancheXisBurgerBuilder implements LancheBuilderInterface {

	@Override
	public Lanche construir() {
		return new Lanche.LancheBuilder()
				.nomeLanche("X-Burguer")
				.comPao("brioche")
				.comCarne("bovina 150g")
				.comQueijo("cheddar")
				.comMolho("maionese")
				.comVegetais("cebola")
				.valorLanche(22.00)
				.build();
	}

}
