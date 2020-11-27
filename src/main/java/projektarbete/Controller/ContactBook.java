package projektarbete.Controller;


import projektarbete.Model.WorkContact;

import java.util.HashMap;

public class ContactBook {

    public static HashMap<String, WorkContact> workContactHashMap = new HashMap<>();//load json-file

    public static void printContactBook(){
        workContactHashMap.forEach((key, value) -> System.out.println("\n" +
                                                                        "Firstname: " + value.getFirstName() + "\n" +
                                                                        "Lastname: " + value.getLastName() + "\n" +
                                                                        "Phone number private: " + value.getPhoneNumber() + "\n" +
                                                                        "Phone Number Work: " + value.getJobPhoneNumber() + "\n" +
                                                                        "Email-Address: " + value.getEmail() + "\n" +
                                                                        "Company: " + value.getCompany() + "\n" +
                                                                        "Job title: " + value.getTitle() + "\n" ));

    }

    public static void addWorkContactToContactBook(String firstName,String lastName, String phoneNumber,
                                                   String email, String company, String title, String jobPhoneNumber){
        //initiera ny objekt workContact
        WorkContact workContact = new WorkContact(firstName,lastName,phoneNumber,email,company,title,jobPhoneNumber);
        //lägga till ny objekt till hashmappen
        workContactHashMap.put(workContact.getFirstName(),workContact);

    }
    //adding psvm for testing purpose
    public static void main(String[] args) {
        addWorkContactToContactBook("Jannis", "Mueller","12345","jannis@test.de","Senab","monkey","1223");
        addWorkContactToContactBook("Albert","Andersson","43423","alber@test.se","VetInte","VD","244234");
        addWorkContactToContactBook("Joakim","liden","0876","joakim@test.com","DontKnow","teamleader","44234");
        addWorkContactToContactBook("Casper","ckokealot","93837","ckokealot@choke.se","Hell Production","stagehand","8765453");

        printContactBook();

    }

}

