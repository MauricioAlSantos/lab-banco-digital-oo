import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public enum TipoTransacao {
    SAQUE(1), DEPOSITO(2), TRANSFERENCIA(3);

    @Getter
    private int value;

    private static Map<Integer, TipoTransacao> valueEnum = new HashMap<>();

    TipoTransacao(int i) {
        value = i;
    }

    public static TipoTransacao enumOfValue(int value) {
        if (valueEnum.isEmpty()) {
            for (TipoTransacao option : values()) {
                valueEnum.put(option.value, option);
            }
        }
        return valueEnum.get(value);
    }
}
