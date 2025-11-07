package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import controller.FaturarPedidoStrategyController;
import controller.LancheController;
import enums.StatusPedido;
import model.Lanche;
import model.Pedido;
import util.MenuFaturarPedidoUtil;
import util.MenuLanchesUtil;

public class PedidoService {

	private List<Pedido> pedidos = new ArrayList<>();
	private int sequenciaId;
	private Scanner scanner;
	
	public PedidoService() {
	}
	
	public PedidoService(Scanner scanner) {
		this.scanner = scanner;
	}

	public void adicionarPedidoLista(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void removerPedidoLista(Pedido pedido) {
		pedidos.remove(pedido);
	}
	
	
	public int getSequenciaId() {
		return sequenciaId;
	}

	public void setSequenciaId(int sequenciaId) {
		this.sequenciaId = sequenciaId;
	}

	public void atualizarSequenciaId() {
		sequenciaId++;
	}
	
	public void listarTodosPedidos() {
		if (pedidos.isEmpty()) {
			System.out.println("\nNão há pedidos cadastrados ainda.");
		} else {
			pedidos.forEach(System.out::println);
		}
	}
	
	public void adicionarPedido() {
		MenuLanchesUtil menuLanches = new MenuLanchesUtil(scanner);
		LancheService lancheService = new LancheService();
		LancheController lancheController = new LancheController(lancheService);
		atualizarSequenciaId();
		Pedido pedido = new Pedido(getSequenciaId(), StatusPedido.PENDENTE);
		int menuOp = 0;
		do {
			menuLanches.mostrarMenu();
			menuOp = menuLanches.obterMenuOp();
			Lanche lanche = lancheController.executarMenuOp(menuOp);
			if (lanche != null) {
				pedido.adicionarLanche(lanche);
				System.out.println("\nLanche adicionado !!");
			}
		} while (menuOp != 0);
		adicionarPedidoLista(pedido);
		System.out.println("\nPedido criado com sucesso !! Valor total: R$" + String.format("%.2f", pedido.valorTotalPedido()));
	}
	
	public void removerPedido() {
		if (pedidos.isEmpty()) {
			System.out.println("\nNão há pedidos cadastrados ainda.");
		} else {
			int id = obterIdPedido();
			Optional<Pedido> pedido = obterPedidoPeloId(id);
			if (pedido.isPresent()) {
				if (confirmarRemoverPedido(pedido)) {
					removerPedidoLista(pedido.get());
					System.out.println("\nPedido removido com sucesso.");
				}
			} else {
				System.out.println("\nID de pedido inexistente. Tente novamente.");
			}
		}
	}
	
	public int obterIdPedido() {
		int id = 0;
		boolean idPedidoValido = false;
		while (!idPedidoValido) {
			try {
				System.out.print("\nDigite o #ID: ");
				id = scanner.nextInt();
				validarIdPedido(id);
				idPedidoValido = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInput inválido. Tente novamente.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return id;
	}
	
	public void validarIdPedido(int id) {
		if ( id < 1) {
			throw new IllegalArgumentException("\nID de pedido inválido. Tente novamente.");
		}
	}
	
	public Optional<Pedido> obterPedidoPeloId(int id) {
		return pedidos.stream().filter(p -> p.getId() == id).findFirst();
	}
	
	public boolean confirmarRemoverPedido(Optional<Pedido> pedido) {
		boolean confirmar = false;
		boolean opRemoverPedidoValido = false;
		int opRemoverPedido = 0;
		while (!opRemoverPedidoValido) {
			try {
				System.out.println("\n" + pedido.get());
				System.out.println("Você deseja remover o pedido #" + pedido.get().getId());
				System.out.print("[0] - Sim [1] - Não: ");		
				opRemoverPedido = scanner.nextInt();
				validarOpRemoverPedido(opRemoverPedido);
				opRemoverPedidoValido = true;
			} catch (InputMismatchException e) {
				System.out.println();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		if (opRemoverPedido == 0) {
			confirmar = true;
		}
		return confirmar;
	}
	
	public void validarOpRemoverPedido(int op) {
		if (op < 0 || op > 1) {
			throw new IllegalArgumentException("\nOpção inválida. Tente novamente.");
		}
	}
	
	public void faturarPedido() {
		MenuFaturarPedidoUtil menuFaturarPedido = new MenuFaturarPedidoUtil(scanner);
		FaturarPedidoStrategyController faturarPedidoStrategyController = new FaturarPedidoStrategyController();
		if (pedidos.isEmpty()) {
			System.out.println("\nNão há pedidos cadastrados ainda.");
		} else {
			int id = obterIdPedido();
			Optional<Pedido> pedido = obterPedidoPeloId(id);
			if (pedido.isPresent()) {
				menuFaturarPedido.mostrarMenu();
				int menuOp = menuFaturarPedido.obterMenuOp();
				faturarPedidoStrategyController.executarOp(menuOp, pedido.get());
			} else {
				System.out.println("\nID de pedido inexistente. Tente novamente.");
			}
		}
	}
		
}
