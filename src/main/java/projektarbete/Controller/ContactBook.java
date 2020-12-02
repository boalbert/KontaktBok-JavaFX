package projektarbete.Controller;
import projektarbete.Main.MainMenu;
import projektarbete.Model.WorkContact;

import java.util.HashMap;

public class ContactBook {

    public static String searchContact(String key) {
        String result = null;
            if (MainMenu.workContactHashMap.containsKey(key)) {
                result = "\n" +
                        "Firstname: " + MainMenu.workContactHashMap.get(key).getFirstName() + "\n" +
                        "Lastname: " + MainMenu.workContactHashMap.get(key).getLastName() + "\n" +
                        "Phone number private: " + MainMenu.workContactHashMap.get(key).getPhoneNumber() + "\n" +
                        "Phone Number Work: " + MainMenu.workContactHashMap.get(key).getJobPhoneNumber() + "\n" +
                        "Email-Address: " + MainMenu.workContactHashMap.get(key).getEmail() + "\n" +
                        "Company: " + MainMenu.workContactHashMap.get(key).getCompany() + "\n" +
                        "Job title: " + MainMenu.workContactHashMap.get(key).getTitle() + "\n";
            }
        else System.out.println("Something went wrong...");
        return result;
    }

    public static void removeContact(String key) {
        MainMenu.workContactHashMap.remove(key);
    }

    public static void updateContactBook(int choice, String key, String change) {
        switch (choice) {
            case 1: {
                MainMenu.workContactHashMap.get(key).setCompany(change);
                break;
            }
            case 2: {
                MainMenu.workContactHashMap.get(key).setTitle(change);
                break;
            }
            case 3: {
                MainMenu.workContactHashMap.get(key).setJobPhoneNumber(change);
                break;
            }
            case 4: {
                WorkContact wc1 = MainMenu.workContactHashMap.get(key);
                wc1.setFirstName(change);
                MainMenu.workContactHashMap.remove(key);
                MainMenu.workContactHashMap.put(wc1.getFirstName(), wc1);
                break;
            }
            case 5: {
                MainMenu.workContactHashMap.get(key).setLastName(change);
                break;
            }
            case 6: {
                MainMenu.workContactHashMap.get(key).setPhoneNumber(change);
                break;
            }
            case 7: {
                MainMenu.workContactHashMap.get(key).setEmail(change);
                break;
            }
         /*   case 8 : {  ifall vi vill ha en som man kan uppdatera allt. T.ex köra Jannis metod igen genom FX?-GUI?
                break;
            }
        */
            case 9: {
                return;
            }
        }
    }

    public static String printContactBook() {

        String errorMessage = "Contact list is empty";

        if (MainMenu.workContactHashMap != null) {
            MainMenu.workContactHashMap.forEach((key, value) -> System.out.println("\n" +
                    "Firstname: " + value.getFirstName() + "\n" +
                    "Lastname: " + value.getLastName() + "\n" +
                    "Phone number private: " + value.getPhoneNumber() + "\n" +
                    "Phone Number Work: " + value.getJobPhoneNumber() + "\n" +
                    "Email-Address: " + value.getEmail() + "\n" +
                    "Company: " + value.getCompany() + "\n" +
                    "Job title: " + value.getTitle() + "\n"));

        } else {

            System.out.println(errorMessage);
            return errorMessage;
        }
        return null;
    }

    public static void addWorkContactToContactBook(String firstName, String lastName, String phoneNumber,
                                                   String email, String company, String title, String jobPhoneNumber) {
        //initiera ny objekt workContact
        WorkContact workContact = new WorkContact(firstName, lastName, phoneNumber, email, company, title, jobPhoneNumber);
        //lägga till ny objekt till hashmappen
        MainMenu.workContactHashMap.put(workContact.getFirstName(), workContact);

    }

    //adding psvm for testing purpose
    public static void main(String[] args) {
        addWorkContactToContactBook("Jannis", "Mueller", "12345", "jannis@test.de", "Senab", "monkey", "1223");
        addWorkContactToContactBook("Albert", "Andersson", "43423", "alber@test.se", "VetInte", "VD", "244234");
        addWorkContactToContactBook("Joakim", "liden", "0876", "joakim@test.com", "DontKnow", "teamleader", "44234");
        addWorkContactToContactBook("Casper", "ckokealot", "93837", "ckokealot@choke.se", "Hell Production", "stagehand", "8765453");

        System.out.println(searchContact("casper"));


    }
}




