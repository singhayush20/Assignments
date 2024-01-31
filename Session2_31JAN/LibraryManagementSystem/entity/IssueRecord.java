public class IssueRecord {
    private LibraryBook book;
    private String issuerId;
    private String issueDate;
    private String lastReturnDate;
    private double fine;

    public IssueRecord(LibraryBook book, String issuerId, String issueDate, String lastReturnDate, double fine) {
        this.book = book;
        this.issuerId = issuerId;
        this.issueDate = issueDate;
        this.lastReturnDate = lastReturnDate;
        this.fine = fine;
    }

    public LibraryBook getBook() {
        return book;
    }

    public void setBook(LibraryBook book) {
        this.book = book;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getLastReturnDate() {
        return lastReturnDate;
    }

    public void setLastReturnDate(String lastReturnDate) {
        this.lastReturnDate = lastReturnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "IssueRecord [book=" + book + ", issuerId=" + issuerId + ", issueDate=" + issueDate + ", lastReturnDate="
                + lastReturnDate + ", fine=" + fine + "]";
    }


    
}