import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.Getter;

public enum Option {
    CRIAR_CONTA(1), EXTRATO(2), SAIR(0), LISTAR_CONTAS(3), TRANSACAO(4), SALDO(5),SELECIONAR_CONTA(6);

    @Getter
    private int value;

    private static Map<Integer, Option> valueEnum = new HashMap<>();

    Option(int value) {
        this.value = value;
    }

    public static Optional<Option> enumOfValue(int value) {
        if (valueEnum.isEmpty()) {
            for (Option option : values()) {
                valueEnum.put(option.value, option);
            }
        }
        Option  o = valueEnum.get(value);
        return Optional.of(o);
    }

}
