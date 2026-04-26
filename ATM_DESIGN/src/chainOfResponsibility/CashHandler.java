package chainOfResponsibility;

public interface CashHandler {
    void setNext(CashHandler next);

    // check if possible
    int canHandle(int amount);

    // actual dispense
    void dispense(int amount);
}