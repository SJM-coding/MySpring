package mylab.music.entity;

public class Vinyl extends MusicMedia {
    private int rpm;

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    @Override
    public void play() {
        System.out.println("바이닐 레코드 '" + title + "'이(가) " + rpm + "rpm으로 재생됩니다.");
    }

    public void clean() {
        System.out.println("바이닐 레코드를 청소합니다.");
    }
}