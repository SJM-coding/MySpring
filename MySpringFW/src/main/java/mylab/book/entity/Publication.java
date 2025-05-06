package mylab.book.entity;

public abstract class Publication {
    protected String title;
    protected String publishDate;
    protected int page;
    protected int price;

    public Publication() {}

    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    public String getTitle() { return title; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String getPublishDate() { return publishDate; }

    @Override
    public String toString() {
        return title;
    }
}