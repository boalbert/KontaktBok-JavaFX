package projektarbete.Controller;
import projektarbete.Main.MainMenu;
import projektarbete.Model.WorkContact;


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
        } else System.out.println("Something went wrong...");
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

    /**
     * Prints out the contact list
     *
     * @return message if printout was done or if errormessage when Hasmap is empty
     */
    public static String printContactBook() {

        String errorMessage = "Contact list is empty";
        String message = "Contact List printed";

        if (!MainMenu.workContactHashMap.isEmpty()) {
            MainMenu.workContactHashMap.forEach((key, value) -> System.out.println("\n" +
                    "Firstname: " + value.getFirstName() + "\n" +
                    "Lastname: " + value.getLastName() + "\n" +
                    "Phone number private: " + value.getPhoneNumber() + "\n" +
                    "Phone Number Work: " + value.getJobPhoneNumber() + "\n" +
                    "Email-Address: " + value.getEmail() + "\n" +
                    "Company: " + value.getCompany() + "\n" +
                    "Job title: " + value.getTitle() + "\n"));

            return message;

        } else {
            return errorMessage;
        }
    }

    /**
     * adds a new work contact to the HashMap
     * <p>
     * Input:
     *
     * @param firstName      First name of the contact
     * @param lastName       Last name of the contact
     * @param phoneNumber    Phone number of the contact
     * @param email          Email of the contact
     * @param company        company name of company the contact is at
     * @param title          work tile  of the contact
     * @param jobPhoneNumber work related phone number of the contact
     */

    public static void addWorkContactToContactBook(String firstName, String lastName, String phoneNumber,
                                                   String email, String company, String title, String jobPhoneNumber) throws Exception{
        //init of a new workContact object
        WorkContact workContact = new WorkContact(firstName, lastName, phoneNumber, email, company, title, jobPhoneNumber);

        //illegalArgumentException if Firstname is null
        if (workContact.getFirstName()== null) {
            throw new IllegalArgumentException("Firstname cannot be blank");
        }
        //adds object to hashmap
        MainMenu.workContactHashMap.put(workContact.getFirstName(), workContact);

    }
}




