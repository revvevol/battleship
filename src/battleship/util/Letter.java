package battleship.util;

public enum Letter {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7),
    I(8),
    J(9);

    private final int letterCode;

    private Letter(int letterCode) {
        this.letterCode = letterCode;
    }

    public int getLetterCode() {
        return this.letterCode;
    }

}
