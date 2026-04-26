package chainOfResponsibility;

public class CashHandlerFactory {

    public static CashHandler buildChain() {

        CashHandler h500 = new FiveHundredHandler();
        CashHandler h200 = new TwoHundredHandler();
        CashHandler h100 = new HundredHandler();
        CashHandler h50 = new FiftyHandler();
        CashHandler h20 = new TwentyHandler();
        CashHandler h10 = new TenHandler();

        h500.setNext(h200);
        h200.setNext(h100);
        h100.setNext(h50);
        h50.setNext(h20);
        h20.setNext(h10);

        return h500;
    }
}