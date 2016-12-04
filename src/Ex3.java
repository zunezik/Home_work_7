import java.util.Scanner;

public class Ex3 {
    public static final int MAX_NUMBER_OF_CONTACTS = 10000;

    public static void main(String[] args) {
        ContactInfo[] contactInfo = new ContactInfo[MAX_NUMBER_OF_CONTACTS];
        Scanner scanner = new Scanner(System.in);
        int numberOfRecords = 0;

        while (true) {
            System.out.println("1) Print all yours contacts");
            System.out.println("2) Add new contact");
            System.out.println("Any other key to exit.");

            System.out.print("Select action: ");
            String finish = scanner.nextLine();

            if (finish.equals("1")) {
                printInfoAboutAllContants(contactInfo, numberOfRecords);
            } else if(finish.equals("2")) {
                contactInfo[numberOfRecords++] = addContact();
            } else {
                break;
            }
        }
    }

    private static void printInfoAboutAllContants(ContactInfo[] contactInfo, int numberOfRecords) {
        System.out.println("==============================");
        for (int i = 0; i < numberOfRecords; i++) {
            printInfo(contactInfo[i]);
            System.out.println();
        }
        System.out.println("==============================");
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
