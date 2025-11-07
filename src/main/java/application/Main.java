package application;

import java.util.Locale;
import java.util.Scanner;

import controller.PedidoController;
import service.PedidoService;
import util.MenuPrincipalUtil;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		try (Scanner scanner = new Scanner(System.in)) {
			MenuPrincipalUtil menuPrincipal = new MenuPrincipalUtil(scanner);
			PedidoService pedidoService = new PedidoService(scanner);
			PedidoController pedidoController = new PedidoController(pedidoService);
			System.out.println("Bem vindo a lancheria S A T O L E P !!!");
			int menuOp = 0;
			do {
				menuPrincipal.mostrarMenu();
				menuOp = menuPrincipal.obterMenuOp();
				pedidoController.executarMenuOp(menuOp);
			} while (menuOp != 0);
			System.out.println("\nPrograma encerrado. Volte sempre!");
		}

	}

}
