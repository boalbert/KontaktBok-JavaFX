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

    public WorkContact(String firstName, String lastName, String phoneNumber, String email, String company, String title, String jobPhoneNumber) {
        super(firstName, lastName, phoneNumber, email);
        this.company = company;
        this.title = title;
        this.jobPhoneNumber = jobPhoneNumber;


    }
}
