import java.util.Scanner;

public class Ex3 {
    public static final int NUMBER_OF_CONTACTS = 10;

    public static void main(String[] args) {
        ContactInfo[] contactInfo = new ContactInfo[NUMBER_OF_CONTACTS];
        Scanner scanner = new Scanner(System.in);
        int numberOfRecords = 0;

        for (int i = 0; i < NUMBER_OF_CONTACTS; i++) {
            contactInfo[i] = new ContactInfo();
            contactInfo[i] = addContact();
            System.out.println("Press '1' to finish, or any key to add new contact");
            String finish = scanner.nextLine();
            numberOfRecords++;
            if (finish.equals("1")) {
                break;
            }
        }

        for (int i = 0; i < numberOfRecords; i++) {
            printInfo(contactInfo[i]);
            System.out.println();
        }
    }

    public static ContactInfo addContact() {
        Scanner scanner = new Scanner(System.in);
        ContactInfo contact = new ContactInfo();

        System.out.print("Enter first name: ");
        contact.firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        contact.lastName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        contact.phoneNumber = scanner.nextLine();
        System.out.print("Enter address: ");
        contact.address = scanner.nextLine();
        return contact;
    }

    public static void printInfo(ContactInfo contactInfo) {


        System.out.println(contactInfo.firstName + " " + contactInfo.lastName);
        System.out.println("Phone number: " + contactInfo.phoneNumber);
        System.out.println("Address: " + contactInfo.address);
    }
}
