package projektarbete.Model;

public class WorkContact extends Contact {

    private String company;
    private String title;
    private String jobPhoneNumber;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobPhoneNumber() {
        return jobPhoneNumber;
    }

    public void setJobPhoneNumber(String jobPhoneNumber) {
        this.jobPhoneNumber = jobPhoneNumber;
    }

    /**
     * Constructor with following parameters:
     *
     * @param firstName     First name of the contact
     * @param lastName      Last name of the contact
     * @param phoneNumber   Phone number of the contact
     * @param email         Email of the contact
     * @param company       company name of company the contact is at
     * @param title         work tile  of the contact
     * @param jobPhoneNumber work related phone number of the contact
     **/
    public WorkContact(String firstName, String lastName, String phoneNumber, String email, String company, String title, String jobPhoneNumber) {
        super(firstName, lastName, phoneNumber, email);
        this.company = company;
        this.title = title;
        this.jobPhoneNumber = jobPhoneNumber;


    }
}
