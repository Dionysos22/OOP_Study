package ch03;

import java.util.Scanner;

/**
 * AccountTest: set/get ve kullanıcıdan isim alma.
 *
 * Konu: Nesne oluşturma, instance variable'a set ile değer atama, get ile okuma.
 */
public class AccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account(); // boş constructor

        System.out.print("Enter the name: ");
        String theName = input.nextLine();
        myAccount.setName(theName);

        System.out.printf("Name in object is: %s%n", myAccount.getName());
    }
}

