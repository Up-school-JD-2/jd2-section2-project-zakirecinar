import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileProcess
{
    public static void savePhones(List<Telephone> telephones, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(telephones);
            System.out.println("Phones registered successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while registering phones: " + e.getMessage());
        }
    }

    public static List<Telephone> loadTelephones(String fileName) {
        List<Telephone> telephones = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            telephones = (List<Telephone>) ois.readObject();
            System.out.println("Phones installed successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading phones: " + e.getMessage());
        }
        return telephones;
    }

    public static void saveContacts(List<Contacts> contacts, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contacts);
            System.out.println("Contacts successfully saved.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving contacts: " + e.getMessage());
        }
    }

    public static List<Contacts> loadContacts(String fileName) {
        List<Contacts> contacts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            contacts = (List<Contacts>) ois.readObject();
            System.out.println("Contacts uploaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading contacts: " + e.getMessage());
        }
        return contacts;
    }
    }



