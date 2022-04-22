package Data;

import java.util.Date;

public class Account {
    private int accountNumber;
    private String openingDate;
    private float balance;

    public Account(int accountNumber, String openingDate, float balance) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String deposit(float amount){
        this.balance += amount;
        return "Dinero depositado exitosamente. \n Su nuevo balance es: " + this.balance;
    }

    public String withdraw(float amount){
        if(this.balance < amount){
            return "Su cuenta no posee los suficientes fondos para hacer el retiro.";
        }else{
            if(amount <= 1000){
                this.balance -= amount + 200;
                return "Dinero retirado exitosamente. \n Su nuevo balance es: " + this.balance;
            }else{
                this.balance -= amount + 200 + amount*0.15;
                return "Dinero retirado exitosamente. \n Su nuevo balance es: " + this.balance;
            }
        }
    }

    public String transfer(float amount){
        if(this.balance < amount){
            return "Su cuenta no posee los suficientes fondos para hacer la transferencia.";
        }else{
            this.balance -= amount + 100;
            return "Dinero transferido exitosamente. \n Su nuevo balance es: " + this.balance;
        }
    }
}
