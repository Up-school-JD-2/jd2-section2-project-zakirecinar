import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class TelephoneManagerApplication {
    public List<Telephone> telephones;
    public List<Application> applications;
    public List<Contacts> contacts;
    Scanner scanner = new Scanner(System.in);
    /*public TelephoneManagerApplication(List<Telephone> telephones, List<Application> applications, List<Contacts> contacts) {
        this.telephones = telephones;
        this.applications = applications;
        this.contacts = contacts;
    }*/
    public TelephoneManagerApplication() {
        telephones = new ArrayList<>();
        applications = new ArrayList<>();
        contacts = new ArrayList<>();
    }

    public void addTelephone(Telephone telephone) {
        telephones.add(telephone);

    }
    public void addTelephone() {

        System.out.println("Brand: ");
        String brand = scanner.nextLine();

        System.out.println("Model: ");
        String model = scanner.nextLine();

        System.out.println("Serial Number: ");
        String serialNumber = scanner.nextLine();

        System.out.println("Storage Space: ");
        int storageSpace = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Operating System: ");
        String os = scanner.nextLine();

        Telephone telephone = new Telephone(brand, model, serialNumber, storageSpace, os);
        telephones.add(telephone);

        System.out.println("adding the telephone.");
    }


    public void addApplication(Application application) {
        applications.add(application);
    }
    public void addApplication() {

        System.out.println("Application Name: ");
        String appName = scanner.nextLine();

        System.out.println("Version: ");
        String appVersion = scanner.nextLine();

        System.out.println("Size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        Application application = new Application(appName, appVersion, size);
        applications.add(application);

        System.out.println("Application added.");
    }


    public void addContacts(Contacts contact) {
        contacts.add(contact);
    }
    public void addContacts() {

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Surname: ");
        String surname = scanner.nextLine();

        System.out.println("Telephone Number: ");
        String telNo = scanner.nextLine();

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        Contacts contact = new Contacts(name, surname, telNo, email);
        contacts.add(contact);

        System.out.println("added the contact.");
    }


    public void removeTelephone() {
        System.out.println("phone serial number to be deleted: ");
        String serialNumber = scanner.nextLine();
        boolean removed = false;
        Iterator<Telephone> iterator = telephones.iterator();
        while (iterator.hasNext()) {
            Telephone telephone = iterator.next();
            if (telephone.getSerialNo().equals(serialNumber)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Phone successfully removed.");
        } else {
            System.out.println("No phone found with the specified serial number.");
        }

    }

    public void removeApplication() {
        System.out.println("Enter the name of the application to be deleted ");
        String appName = scanner.nextLine();
        boolean removed = false;
        Iterator<Application> iterator = applications.iterator();
        while (iterator.hasNext()) {
            Application application = iterator.next();
            if (application.getName().equals(appName)) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("application has been deleted successfully.");
        } else {
            System.out.println("No application found for the entered application name.");
        }
    }

    public void removeContact() {
        System.out.println("Enter the email address of the user to be deleted ");
        String email = scanner.nextLine();
        boolean removed = false;
        Iterator<Contacts> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contacts contacts1 = iterator.next();
            if (contacts1.getEmail().equals(email)) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("contact has been deleted successfully.");
        } else {
            System.out.println("No user found for the entered e-mail address.");
        }


    }

    public void showTelephones() {
        //telephones.forEach(System.out::println);
        for (Object obj : telephones) {
            if (obj instanceof Telephone) {
                Telephone telephone = (Telephone) obj;
                System.out.println(telephone);
            }
        }
    }

    public void showApplication() {
        applications.forEach(System.out::println);
    }

    public void showContacts() {
        contacts.forEach(System.out::println);
    }
    public int totalStorageSpace() {
        return telephones.stream()
                .mapToInt(Telephone::getStorage)
                .sum();
    }
    public List<Telephone> filterByBrand(String brand) {
        return telephones.stream()
                .filter(t -> t.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
    public List<Contacts> searchByPhoneNumber(String telephoneNumber) {
        return contacts.stream()
                .filter(k -> k.getTel().equals(telephoneNumber))
                .collect(Collectors.toList());
    }
    public void backupData(String phoneFileName, String contactFileName) {
        FileProcess.savePhones(telephones, phoneFileName);
        FileProcess.saveContacts(contacts, contactFileName);

        System.out.println("Data has been backed up.");
    }

    public void restoreData(String phoneFileName, String contactFileName) {
        telephones = FileProcess.loadTelephones(phoneFileName);
        contacts = FileProcess.loadContacts(contactFileName);

        System.out.println("Data restored.");
    }
}

