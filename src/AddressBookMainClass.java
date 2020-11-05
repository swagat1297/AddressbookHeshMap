import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //here hash map is used store string value from address book
        HashMap<String, AddressBook> addressBookList = new HashMap<String, AddressBook>();

        AddressBook familyAddressBook = new AddressBook();
        AddressBook friendsAddressBook = new AddressBook();
        addressBookList.put("Family", familyAddressBook);
        addressBookList.put("Friends", friendsAddressBook);

        while (true) {
            System.out.println("1: for family \n" +
                    "2: for friend \n" +
                    "3: for terminate the program");
            int selectedOption = scanner.nextInt();
            if (selectedOption == 1) {
                familyAddressBook.getUserChoice();
            }
            else if (selectedOption == 2) {
                friendsAddressBook.getUserChoice();
            }
            else if(selectedOption == 3) {
                break;
            }
        }
        scanner.close();
    }
}