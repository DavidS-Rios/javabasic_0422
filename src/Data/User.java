package Data;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final Account account;

    public User(String firstName, String lastName, String username, String password, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.account = account;
        this.id = count.incrementAndGet();
    }

    @Override
    public String toString() {
        return "id=" + id + ", nombre=" + firstName + ", apellido=" + lastName + ", numero de cuenta=" + this.account.getAccountNumber() + "\n";
    }

    public Account getAccount() {
        return account;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
