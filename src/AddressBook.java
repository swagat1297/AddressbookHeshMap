import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    HashMap <String, Person> contactList = new HashMap<String, Person>();
    Scanner scanner = new Scanner(System.in);
    static AddressBook addressBook = new AddressBook();

    public void getUserChoice() {
        boolean isTerminate = false;
        while (!isTerminate) {
            System.out.println("1: for adding new person \n" +
                    "2: for update person \n" +
                    "3: for print address book \n" +
                    "4: For delete \n" +
                    "5: For exit");
            int option = scanner.nextInt();
            switch (option)
            {
                case 1:
                    Person person = addressBook.getUserInput();
                    contactList.put(person.getEmailId(), person);
                    break;
                case 2:
                    addressBook.updateContact();
                    break;
                case 3:
                    System.out.println(contactList);
                    break;
                case 4:
                    addressBook.deletePerson();
                    break;
                case 5:
                    isTerminate = true;
                    break;
                default:
                    System.out.println("please select valid option");
                    break;
            }
        }
    }

    private void deletePerson() {
        System.out.println("Enter EmailId to delete");
        String email = scanner.next();
        if (!contactList.containsKey(email)) {
            System.out.println("Provided email Id is not found");
            deletePerson();
        }
        contactList.remove(email);
    }

    @Override
    protected void finalize() throws Throwable {
        scanner.close();
    }

    private void updateContact() {
        System.out.println("Enter emailId to update");
        String emailId = scanner.next();

        if ( contactList.containsKey(emailId) == false) {
            System.out.println("provided email Id is wrong !");
            updateContact();
        }

        Person person = contactList.get(emailId);
        System.out.println("1: For first name \n" +
                "2: For Last Name \n" +
                "3: For Address \n" +
                "4: For city \n" +
                "5: For state \n" +
                "6: For zip \n " +
                "7: For phoneNumber");

        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                System.out.println("Enter First Name ");
                String fName = scanner.next();
                person.setfirstName(fName);
                break;
            case 2:
                System.out.println("Enter Last Name");
                String lName = scanner.next();
                person.setlastName(lName);
                break;
            case 3:
                System.out.println("Enter Address");
                String address = scanner.next();
                person.setAddress(address);
                break;
            case 4:
                System.out.println("Enter City");
                String city = scanner.next();
                person.setCity(city);
                break;
            case 5:
                System.out.println("Enter State");
                String state = scanner.next();
                person.setState(state);
                break;
            case 6:
                System.out.println("Enter Zip Code");
                int zip=scanner.nextInt();
                person.setZip(zip);
                break;
            case 7:
                System.out.println("Enter Phone Number");
                long phone = scanner.nextLong();
                person.setPhoneNumber(phone);
                break;
            default:
                System.out.println("please select valid option");
                break;
        }
    }

    private Person getUserInput() {
        System.out.println("Enter First Name");
        String firstName = scanner.next();
        System.out.println("Enter Last Name");
        String lastName = scanner.next();
        System.out.println("Enter Address");
        String address = scanner.next();
        System.out.println("Enter City Name");
        String city = scanner.next();
        System.out.println("Enter the Zip Code");
        int zip = scanner.nextInt();
        System.out.println("Enter State Name");
        String state = scanner.next();
        System.out.println("Enter Phone Number");
        long phone = scanner.nextLong();
        System.out.println("Enter Email Id");
        String emailId = scanner.next();
        Person person = new Person();
        person.setfirstName(firstName);
        person.setlastName(lastName);
        person.setAddress(address);
        person.setCity(city);
        person.setZip(zip);
        person.setState(state);
        person.setPhoneNumber(phone);
        person.setEmailId(emailId);

        return person;
    }
}