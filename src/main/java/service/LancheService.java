package service;

import enums.TipoLanche;
import factory.LancheFactory;
import model.Lanche;

public class LancheService {
	
	public LancheService() {
	}
	
	public Lanche criarLanche(TipoLanche tipo) {
		return LancheFactory.criarLanche(tipo);
	}
	
}
