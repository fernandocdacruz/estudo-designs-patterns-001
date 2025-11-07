package factory;

import builder.LancheBuilderInterface;
import builder.LancheVeganoBuilder;
import builder.LancheXisBurgerBuilder;
import builder.LancheXisSaladaBuilder;
import enums.TipoLanche;
import model.Lanche;

public class LancheFactory {

	public static Lanche criarLanche(TipoLanche tipo) {
		LancheBuilderInterface builder = null;
		
		switch (tipo) {
		case X_BURGUER:
			builder = new LancheXisBurgerBuilder();
			break;
		case X_SALADA:
			builder = new LancheXisSaladaBuilder();
			break;
		case VEGANO:
			builder = new LancheVeganoBuilder();
			break;
		default:
			throw new IllegalArgumentException("Tipo de lanche inválido!");
		}
		
		return builder.construir();
	}
	
}
