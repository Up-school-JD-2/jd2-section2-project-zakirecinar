import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TelephoneManagerApplication application = new TelephoneManagerApplication();
        Scanner scanner = new Scanner(System.in);

        Telephone telephone1 = new Telephone("Samsung", "Galaxy S10", "123456789", 128, "Android");
        Telephone telephone2 = new Telephone("Apple", "iPhone 14 Pro Max", "987654321", 256, "IOS");
        Telephone telephone3 = new Telephone("Apple", "iPhone 14 Plus", "987654561", 256, "IOS");

        Application application1 = new Application("WhatsApp", "2.5.3", 50);
        Application application2 = new Application("Instagram", "3.1.3", 70);

        Contacts contact1 = new Contacts("Ahmet", "Gultekin", "ahmet.gultekin@gmail.com", "05300000000");
        Contacts contact2 = new Contacts("Asim", "Kilic", "asim.kilic@gmail.com", "05400000000");

        application.addTelephone(telephone1);
        application.addTelephone(telephone2);
        application.addTelephone(telephone3);

        application.addApplication(application1);
        application.addApplication(application2);

        application.addContacts(contact1);
        application.addContacts(contact2);

        System.out.println("Telephones:");
        application.showTelephones();

        System.out.println("Applications:");
        application.showApplication();

        System.out.println("Contacts:");
        application.showContacts();

        System.out.println("Total Storage Space: " + application.totalStorageSpace());

        System.out.println("Samsung:");
        List<Telephone> samsungTelefonlar = application.filterByBrand("Samsung");
        samsungTelefonlar.forEach(System.out::println);

        System.out.println("Search with Telephone Number:");
        List<Contacts> searchContacts = application.searchByPhoneNumber("05300000000");
        searchContacts.forEach(System.out::println);

        System.out.println("Filter brand: ");
        List<Telephone> filterBrand=application.filterByBrand("Apple");
        filterBrand.forEach(System.out::println);

        System.out.println("Enter the filename with the phone data:(enter a) ");
        String phoneFileName = scanner.nextLine();//----> please enter a

        System.out.println("Enter the file name with the contact data:(enter s) ");
        String contactFileName = scanner.nextLine();//-----> please enter s


        application.restoreData(phoneFileName, contactFileName);


        while (true) {
            System.out.println("Select the action you want to take:");
            System.out.println("1. Add Telephone");
            System.out.println("2. Add Application");
            System.out.println("3. Add Contacts");
            System.out.println("4. Show Telephones");
            System.out.println("5. Show Applications");
            System.out.println("6. Show contacts");
            System.out.println("7. Backup Data");
            System.out.println("8. Restore Data");
            System.out.println("9. Remove Telephone");
            System.out.println("10. Remove Contact");
            System.out.println("11. Remove Application");
            System.out.println("0. Exit");

            int select = scanner.nextInt();
            scanner.nextLine();

            switch (select) {
                case 1:
                    application.addTelephone();
                    break;
                case 2:
                    application.addApplication();
                    break;
                case 3:
                    application.addContacts();
                    break;
                case 4:
                    System.out.println("Telephones:");
                    application.showTelephones();
                    //application.telephones.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Applications:");
                    application.applications.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Contacts:");
                    application.contacts.forEach(System.out::println);
                    break;
                case 7:
                    application.backupData(phoneFileName, contactFileName);
                    break;
                case 8:
                    application.restoreData(phoneFileName, contactFileName);
                    break;
                case 9:
                    application.removeTelephone();
                    break;
                case 10:
                    application.removeContact();
                    break;
                case 11:
                    application.removeApplication();
                    break;

                case 0:
                    application.restoreData(phoneFileName, contactFileName);
                    System.out.println("System Exit...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }
    }
    }

