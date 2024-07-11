import java.util.Scanner;

public class Main {
	static Banco banco;
	public static void main(String[] args) {
		iniciarBanco();
	}

	private static void iniciarBanco(){
		banco = new Banco();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem vindo!");
		System.out.println("Vamos criar o banco. Qual nome deseja colocar? ");
		banco.setNome(scanner.next());
		System.out.println("Banco "+banco.getNome()+" criado");
		Option option = Option.CRIAR_CONTA;
		while (option.equals(Option.EXTRATO)) {
			
		}
		scanner.close();
	}

}
