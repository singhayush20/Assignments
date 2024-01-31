public class LibraryBook {
    private String name;
    private int pageCount;
    private double price;
    private int quantity;
    private Publisher publication; 
    private String edition;
    private Department department;

    public LibraryBook(String name, int pageCount, double price, int quantity, Publisher publication, String edition, Department department) {
        this.name = name;
        this.pageCount = pageCount;
        this.price = price;
        this.quantity = quantity;
        this.publication = publication;
        this.edition = edition;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Publisher getPublication() {
        return publication;
    }

    public void setPublication(Publisher publication) {
        this.publication = publication;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "LibraryBook [name=" + name + ", pageCount=" + pageCount + ", price=" + price + ", quantity=" + quantity
                + ", publication=" + publication + ", edition=" + edition + ", department=" + department + "]";
    }

    
}
