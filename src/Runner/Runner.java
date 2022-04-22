package Runner;

import Data.Account;
import Data.Bank;
import Data.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Runner {

    public static void BankRunner(Bank bank){
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();

        String firstName, lastName, username, password;
        int accountNumber, optionBank;
        boolean runnerBank = true;

        do {
            System.out.println("---------------*empleados*---------------");
            System.out.println("ingresa la opcion que desees.");
            System.out.println("1. Ver la lista de usuarios.");
            System.out.println("2. Crear usuario.");
            System.out.println("3. atras.");
            System.out.println("---------------*empleados*---------------");
            optionBank = scanner.nextInt();
            switch (optionBank){
                case 1:
                    System.out.println(bank.UserList());
                    break;
                case 2:
                    System.out.println("ingresa el nombre");
                    scanner.nextLine();
                    firstName = scanner.nextLine();
                    System.out.println("ingresa el apellido");
                    lastName = scanner.nextLine();
                    System.out.println("ingresa el usuario");
                    username = scanner.nextLine();
                    System.out.println("ingresa la contraseña");
                    password = scanner.nextLine();

                    accountNumber = (int)Math.floor(Math.random()*(9999999-1000000+1)+1000000);
                    bank.addUser(new User(firstName, lastName, username, password,
                            new Account(accountNumber, formatter.format(date), 0)));
                    break;
                case 3:
                    runnerBank = false;
                    break;
            }

        } while (runnerBank);
    }

    public static void UserRunner(Bank bank){
        Scanner scanner = new Scanner(System.in);

        String username, password;
        boolean runnerUser = false;
        int optionUser, accountNumber;
        float amount;

        System.out.println("---------------*usuarios*---------------");
        System.out.println("Ingresa tus datos para ingresar al sistema");
        System.out.println("---------------*usuarios*---------------");
        System.out.println("ingresa el usuario");
        username = scanner.nextLine();
        System.out.println("ingresa la contraseña");
        password = scanner.nextLine();
        User user = bank.userLogin(username, password);
        if(user == null){
            System.out.println("\n---------------*---------------");
            System.out.println("No existe un usuario con esos datos");
            System.out.println("---------------*---------------\n");
        }else{
            runnerUser = true;
            do {
                System.out.println("---------------*usuarios*---------------");
                System.out.println("1. para ver tu balance");
                System.out.println("2. para depositar dinero");
                System.out.println("3. para retirar dinero");
                System.out.println("4. para transferir dinero");
                System.out.println("5. atras.");
                System.out.println("---------------*usuarios*---------------");
                optionUser = scanner.nextInt();
                switch (optionUser){
                    case 1:
                        System.out.println("tu balance es: " + user.getAccount().getBalance());
                        break;
                    case 2:
                        System.out.println("ingrese el dinero a depositar");
                        amount = scanner.nextInt();
                        System.out.println(user.getAccount().deposit(amount));
                        break;
                    case 3:
                        System.out.println("ingrese el dinero a retirar");
                        amount = scanner.nextInt();
                        System.out.println(user.getAccount().withdraw(amount));
                        break;
                    case 4:
                        System.out.println("ingrese el numero de cuenta a transferir");
                        accountNumber = scanner.nextInt();
                        System.out.println("ingrese el monto a transferir");
                        amount = scanner.nextInt();
                        bank.transfer(amount, accountNumber);
                        System.out.println(user.getAccount().transfer(amount));
                        break;
                    case 5:
                        runnerUser = false;
                        break;
                }
            }while (runnerUser);
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        int option;
        boolean runner = true;

        do {
            System.out.println("---------------*---------------");
            System.out.println("ingresa la opcion que desees.");
            System.out.println("1. si empleado del banco.");
            System.out.println("2. si eres usuario del banco.");
            System.out.println("3. salir.");
            System.out.println("---------------*---------------");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    BankRunner(bank);
                    break;
                case 2:
                    UserRunner(bank);
                    break;
                case 3:
                    runner = false;
                    break;
            }

        } while (runner);

    }
}
