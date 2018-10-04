package ru.innopolis.stc12.proxy.lesson;

import org.apache.log4j.Logger;

public class Capucin extends Monkey {
    private int charming;
    private int harmfull;
    private int footSize;
    private final int tailLength = 40;
    private static Logger logger = Logger.getLogger(Capucin.class);
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
        logger.info("Face clear");
    }

    private void washEars(){
        logger.info("Ears clear");
    }

    public void eatBananas(){
        logger.info("Ate  bananas");
    }
}
