package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuLanchesUtil {

	private Scanner scanner;
	
	MenuLanchesUtil() {
	}
	
	public MenuLanchesUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public void mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[0] - Sair");
		sb.append("\n[1] - X-Burguer");
		sb.append("\n[2] - X-Salada");
		sb.append("\n[3] - Vegano");
		System.out.println(sb.toString());
	}
	
	public int obterMenuOp() {
		int op = 0;
		boolean menuOpValido = false;
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
	
	public void validarMenuOp(int menuOp) {
		if (menuOp < 0 || menuOp > 3) {
			throw new IllegalArgumentException("\nOpção inválida. Tente novamente.");
		}
	}
	
}
