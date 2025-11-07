package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipalUtil {

	private Scanner scanner;
	
	public MenuPrincipalUtil() {
	}
	
	public MenuPrincipalUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public void mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[0] - Sair");
		sb.append("\n[1] - Listar todos pedidos");
		sb.append("\n[2] - Adicionar pedido");
		sb.append("\n[3] - Remover pedido");
		sb.append("\n[4] - Faturar pedido");
		System.out.println(sb.toString());
	}
	
	public int obterMenuOp() {
		int op = 0;
		boolean menuOpValido= false;
		while (!menuOpValido) {
			try {
				System.out.print("\nDigite a opção desejada: ");
				op = scanner.nextInt();
				validarMenuOp(op);
				menuOpValido = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInput inválido. Tente novamente.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return op;
	}
	
	public void validarMenuOp(int op) {
		if (op < 0 || op > 5) {
			throw new IllegalArgumentException("\nOpção inválida. Tente novamente.");
		}
	}
	
}
