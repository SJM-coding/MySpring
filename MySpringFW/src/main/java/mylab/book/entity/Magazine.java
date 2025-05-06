package mylab.book.entity;

public class Magazine extends Publication {
    private String publishPeriod;

    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    @Override
    public String toString() {
        return String.format("%s [잡지] 발행주기:%s, %d쪽, %,d원, 출판일:%s",
                title, publishPeriod, page, price, publishDate);
    }
}
