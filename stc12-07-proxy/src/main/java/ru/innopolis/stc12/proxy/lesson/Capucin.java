package ru.innopolis.stc12.proxy.lesson;

public class Capucin extends Monkey {
    private int charming;
    private int harmfull;
    private int footSize;
    private final int tailLength = 40;

    public Capucin(int charming, int harmfull, int footSize) {
        this.charming = charming;
        this.harmfull = harmfull;
        this.footSize = footSize;
    }

    public Capucin(int charming) {
        this.charming = charming;
        this.footSize = 38;
        this.harmfull = 1;
    }

    public Capucin() {
    }

    protected void washFace(){
        System.out.println("Face clear");
    }

    private void washEars(){
        System.out.println("Ears clear");
    }

    public void eatBananas(){
        System.out.println("Ate  bananas");
    }
}
