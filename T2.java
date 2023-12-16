interface BankInterface {
    void getBalance();

    void getInterestRate();
}

class BankA implements BankInterface {
    int deposit = 10000;

    public void getBalance() {
        int balance = deposit;
        System.out.println(balance + " of Bank A");
    }

    public void getInterestRate() {
        double rate = 7.0;
        System.out.println(rate + "% of Bank A");
    }
}

class BankB implements BankInterface {
    int deposit = 150000;

    public void getBalance() {
        int balance = deposit;
        System.out.println(balance + " of Bank B");
    }

    public void getInterestRate() {
        double rate = 7.4;
        System.out.println(rate + "% of Bank B");
    }
}

class BankC implements BankInterface {
    int deposit = 200000;

    public void getBalance() {
        int balance = deposit;
        System.out.println(balance + " of Bank C");
    }

    public void getInterestRate() {
        double rate = 7.9;
        System.out.println(rate + "% of Bank C");
    }
}

public class T2 {
    public static void main(String[] args) {
        BankA A = new BankA();
        A.getBalance();
        A.getInterestRate();

        BankB B = new BankB();
        B.getBalance();
        B.getInterestRate();

        BankC C = new BankC();
        C.getBalance();
        C.getInterestRate();
    }
}