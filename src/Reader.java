import java.util.Scanner;

import lombok.Getter;

public final class Reader {
    @Getter
    private Scanner scanner = new Scanner(System.in);
    private static Reader instance;

    private Reader() {
    }

    public static Reader getInstance() {
        if (instance == null)
            instance = new Reader();
        return instance;
    }

    public Double obterDouble() {
        Double valor = null;
        while (valor == null) {
            try {
                valor = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
            }
        }
        return valor;
    }

    public Integer obterInteger() {
        Integer valor = null;
        while (valor == null) {
            try {
                valor = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
        }
        return valor;
    }

    public Option obterOpcao() {
        Option op = null;
        while (op == null) {
            try {
                op = Option.enumOfValue(Integer.parseInt(scanner.nextLine())).orElse(null);
            } catch (Exception e) {
            }
        }
        return op;
    }

}
