package Lesson_4.Homework_4.TicketService;

public class Document {

    private String firstName;
    private String lastName;
    private long docId;

    public Document(String fname, String lname, long cardNumber) {
        this.firstName = fname;
        this.lastName = lname;
        this.docId = cardNumber;
    }

    @Override
    public String toString() {
        return String.format(">>PassportRF<<\n%d\n%s %s",
            this.docId,
            this.firstName,
            this.lastName);
    }
}
