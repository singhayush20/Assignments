class Book extends Publication {
    int pageCount;

    public Book(String title, float price, int pageCount) {
        super(title, price);
        this.pageCount = pageCount;
    }
}
