package mylab.book.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + " 이(가) 장바구니에 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        Iterator<Publication> it = items.iterator();
        while (it.hasNext()) {
            Publication pub = it.next();
            if (pub.getTitle().equals(title)) {
                it.remove();
                System.out.println(title + " 이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println(title + " 을(를) 찾을 수 없습니다.");
        return false;
    }

    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###원");
        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();

        System.out.println("=== 장바구니 목록 ===");
        for (Publication p : items) {
            System.out.println(p);
        }
        System.out.println("총 가격: " + df.format(total));
        System.out.println("할인 적용 가격: " + df.format(discounted));
    }

    public int calculateTotalPrice() {
        int sum = 0;
        for (Publication p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public int calculateDiscountedPrice() {
        int sum = 0;
        for (Publication p : items) {
            double rate = 1.0;
            if (p instanceof Magazine) rate = 0.9;
            else if (p instanceof Novel) rate = 0.85;
            else if (p instanceof ReferenceBook) rate = 0.8;
            sum += (int)(p.getPrice() * rate);
        }
        return sum;
    }

    public void printStatistics() {
        int novelCount = 0, magazineCount = 0, refCount = 0, etcCount = 0;
        for (Publication p : items) {
            if (p instanceof Novel) novelCount++;
            else if (p instanceof Magazine) magazineCount++;
            else if (p instanceof ReferenceBook) refCount++;
            else etcCount++;
        }
        System.out.println("===== 장바구니 통계 =====");
        System.out.println("소설: " + novelCount);
        System.out.println("잡지: " + magazineCount);
        System.out.println("참고서: " + refCount);
        System.out.println("기타: " + etcCount);
    }
}
