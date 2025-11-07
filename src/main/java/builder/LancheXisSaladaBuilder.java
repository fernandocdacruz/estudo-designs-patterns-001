package builder;

import enums.StatusPedido;
import model.Lanche;

public class LancheXisSaladaBuilder implements LancheBuilderInterface {

	@Override
	public Lanche construir() {
		return new Lanche.LancheBuilder()
				.nomeLanche("X-Salada")
				.comPao("integral")
				.comCarne("bovina 120g")
				.comQueijo("mussarela")
				.comMolho("maionese light")
				.comVegetais("alface, tomate")
				.valorLanche(20.00)
				.build();
	}

}
