import lombok.Data;

@Data
public class Transacao {
    int numeroAgencia;
    int numeroConta;
    TipoTransacao TipoTransacao;
}
