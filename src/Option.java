import lombok.Getter;

public enum Option {
    CRIAR_CONTA(1),EXTRATO(2);

    @Getter
    private int value;

    Option(int value){
        this.value = value;
    }
}
