package chainOfResponsibility;

public abstract class AbstractCashHandler implements CashHandler {

    protected CashHandler next;
    protected int denomination;

    public AbstractCashHandler(int denomination) {
        this.denomination = denomination;
    }

    @Override
    public void setNext(CashHandler next) {
        this.next = next;
    }

    // PHASE 1: check feasibility
    @Override
    public int canHandle(int amount) {
        if (amount >= denomination) {
            int remainder = amount % denomination;

            if (remainder != 0 && next != null) {
                return next.canHandle(remainder);
            }
            return remainder;
        } else {
            if (next != null) {
                return next.canHandle(amount);
            }
            return amount;
        }
    }

    // PHASE 2: actual dispensing
    @Override
    public void dispense(int amount) {
        if (amount >= denomination) {
            int count = amount / denomination;
            int remainder = amount % denomination;

            if (count > 0) {
                System.out.println("Dispensing " + count + " notes of " + denomination);
            }

            if (remainder > 0 && next != null) {
                next.dispense(remainder);
            }
        } else {
            if (next != null) {
                next.dispense(amount);
            }
        }
    }
}