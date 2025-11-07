package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuFaturarPedidoUtil {

	private Scanner scanner;
	
	public MenuFaturarPedidoUtil() {
	}
	
	public MenuFaturarPedidoUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public void mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[0] - Sair");
		sb.append("\n[1] - A Vista");
		sb.append("\n[2] - Cartão");
		sb.append("\n[3] - Promoção");
		System.out.println(sb.toString());
	}
	
	public int obterMenuOp() {
		int menuOp = 0;
		boolean menuOpvalido = false;
		while (!menuOpvalido) {
			try {
				System.out.print("\nDigite a opção desejada: ");
				menuOp = scanner.nextInt();
				validarMenuOp(menuOp);
				menuOpvalido = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInput inválido. Tente novamente.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return menuOp;
	}
	
	public void validarMenuOp(int menuOp) {
		if (menuOp < 0 || menuOp > 3) {
			throw new IllegalArgumentException("\nOpção inválida. Tente novamente.");
		}
	}
	
}
