package builder;

import enums.StatusPedido;
import model.Lanche;

public class LancheVeganoBuilder implements LancheBuilderInterface {

	@Override
	public Lanche construir() {
		return new Lanche.LancheBuilder()
				.nomeLanche("X-Vegano")
				.comPao("integral")
				.comCarne("hambúrguer de grão-de-bico")
				.comQueijo("vegano")
				.comMolho("mostarda e ketchup")
				.comVegetais("alface, tomate, pepino, cebola roxa")
				.valorLanche(24.00)
				.build();
	}

}
