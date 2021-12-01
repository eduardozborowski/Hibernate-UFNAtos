package crudandview;

import javax.swing.JOptionPane;

import models.Clientes;
import models.Fornecedores;

public class View {

	public static void main(String[] args) {
		Crud crud = new Crud();
		Fornecedores fornecedores = new Fornecedores();
		Clientes clientes = new Clientes();
		crud.setup();
		int num;
		String menu = "Menu de Opções\n" +
				"[1] Cadastro de Fornecedor\n"  +
				"[2] Cadastro de Cliente" +
				"[3] Leitura de Fornecedor\n"  +
				"[4] Leitura de Cliente\n";
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		System.out.println("Op:" + op);
		switch (op) {
		case 1:
		{
			fornecedores.setNome(JOptionPane.showInputDialog("Digite o nome do fornecedor:"));
			crud.create(fornecedores);
			break;
		}
		case 2:
		{
			clientes.setNome(JOptionPane.showInputDialog("Digite o nome do cliente:"));
			crud.create(clientes);
			break;
		}
		case 3:
		{
			num = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID:"));
            crud.read2(num);
			break;
		}
		case 4:
		{
			System.out.println("Leitura de Clientes:");
			crud.read1(op);
		}
		break;
		}

	}
}
