import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	static AutoAtendimento aa = new AutoAtendimentoImpl();

	public static void main(String[] args) {
		Reader r = Reader.getInstance();
		aa.iniciarAutoAtendimento(iniciarBanco());
		Option option = null;
		Scanner scanner = r.getScanner();
		while (option == null || !option.equals(Option.SAIR)) {
			System.out.println("Escolha uma opção:");
			aa.exibirOpcoes();
			option = r.obterOpcao();
			if (option != null)
				aa.processarOpcao(option);
		}
		
		r.getScanner().close();
	}

	private static Banco iniciarBanco() {
		Reader r = Reader.getInstance();
		Banco banco = new Banco();
		System.out.println("Bem vindo!");
		System.out.println("Vamos criar o banco. Qual nome deseja colocar? ");
		banco.setNome(r.getScanner().nextLine());
		System.out.println("Bem vindo ao " + banco.getNome() + " ");
		return banco;
	}

}
