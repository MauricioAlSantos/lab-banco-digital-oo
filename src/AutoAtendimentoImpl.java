import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

public class AutoAtendimentoImpl implements AutoAtendimento {

    Banco banco = null;
    @Getter
    @Setter
    private Conta contaAtual = null;
    Scanner scanner = Reader.getInstance().getScanner();

    @Override
    public void exibirOpcoes() {
        for (Option op : Option.values()) {
            System.out.println(op.name() + "(" + op.getValue() + ")");
        }
    }

    @Override
    public void processarOpcao(Option option) {
        switch (option) {
            case LISTAR_CONTAS:
                if (banco.getContas().isEmpty())
                    System.out.println("Não há contas registradas");
                else
                    banco.getContas().forEach(conta -> conta.imprimirInfosComuns());
                break;
            case CRIAR_CONTA:
                criarConta();
                break;
            case TRANSACAO:
                if (contaAtual == null) {
                    if(banco.getContas().isEmpty()){
                        System.out.println("Sem contas cadastradas.");
                        return;
                    } 
                    contaAtual = selecionarConta();
                    
                }
                TipoTransacao tipoTransacao = selecionarTransacao();

                realizarTransacao(contaAtual, tipoTransacao);
                break;
            case SELECIONAR_CONTA:
                contaAtual = selecionarConta();
            default:
                break;
        }

    }

    private Conta selecionarConta() {
        if (banco.getContas().isEmpty())
            return null;
        System.out.println("Selecione a conta: ");
        for (int i = 0; i < banco.getContas().size(); i++) {
            System.out.println(i + ":");
            banco.getContas().get(i).imprimirInfosComuns();
        }
        int posicaoConta = Reader.getInstance().obterInteger();
        return banco.getContas().get(posicaoConta);
    }

    private void realizarTransacao(Conta conta, TipoTransacao tipoTransacao) {
        switch (tipoTransacao) {
            case DEPOSITO:
                System.out.print("valor: ");
                if (conta != null)
                    conta.depositar( Reader.getInstance().obterDouble());
                break;
            case SAQUE:
                System.out.print("valor: ");
                if (conta != null) {
                    Double valor = null;
                    valor = Reader.getInstance().obterDouble();
                    conta.sacar(valor);
                }

                break;
            case TRANSFERENCIA:
                if(banco.getContas().size()==1){
                    System.out.println("Existe apenas uma conta cadastrada...");
                    return;
                }
                System.out.println("qual a conta de destino(diferente da atual)");
                Conta destino = selecionarConta();
                System.out.println("Digite o valor:");
                Double valor = null;
                valor = Reader.getInstance().obterDouble();
                System.out.println("Transferindo "+valor);
                contaAtual.transferir(valor, destino);
                break;
            default:
                break;
        }
    }

    private TipoTransacao selecionarTransacao() {
        System.out.println("Escolha uma opção:");
        for (TipoTransacao tipo : TipoTransacao.values()) {
            System.out.println(tipo + "(" + tipo.getValue() + ")");
        }
        int valor = scanner.nextInt();
        return TipoTransacao.enumOfValue(valor);
    }

    private void criarConta() {
        Cliente cliente = new Cliente();
        System.out.println("Preencha o formulário");
        System.out.print("Nome Cliente: ");
        cliente.setNome(scanner.nextLine());
        System.out.print("Tipo de conta(Corrente(C),Poupança(P)): ");
        String tipoConta = scanner.nextLine();
        Conta conta = null;
        switch (tipoConta) {
            case "C":
            case "c":
                conta = new ContaCorrente(cliente);
                System.out.println("criando conta corrente...");
                break;
            case "P":
            case "p":
                conta = new ContaPoupanca(cliente);
                System.out.println("criando conta poupança...");
                break;
            default:
                break;
        }
        if (conta != null)
            banco.getContas().add(conta);

    }

    @Override
    public void iniciarAutoAtendimento(Banco banco) {
        this.banco = banco;
    }

}
