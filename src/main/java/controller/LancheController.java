package controller;

import java.util.Optional;

import enums.TipoLanche;
import model.Lanche;
import service.LancheService;

public class LancheController {

	private LancheService lancheService;
	
	public LancheController() {
	}
	
	public LancheController(LancheService lancheService) {
		this.lancheService = lancheService;
	}

	public Lanche executarMenuOp(int op) {
		
		Lanche lanche = null;
		
		switch (op) {
		case 1: lanche = lancheService.criarLanche(TipoLanche.X_BURGUER);
			break;
		case 2: lanche = lancheService.criarLanche(TipoLanche.X_SALADA);
			break;
		case 3: lanche = lancheService.criarLanche(TipoLanche.VEGANO);
			break;
		}
		return lanche;
	}
	
}
