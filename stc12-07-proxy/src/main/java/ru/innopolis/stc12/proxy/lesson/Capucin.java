package ru.innopolis.stc12.proxy.lesson;

import org.apache.log4j.Logger;

public class Capucin extends Monkey {
    private int footSize;
    private final int tailLength = 40;
    private static Logger logger = Logger.getLogger(Capucin.class);

    public Capucin(int charming) {
        this.footSize = 38;
    }

    public Capucin() {
        this.footSize = 38;
    }

    protected void washFace() {
        logger.info("Face clear");
    }


    public void eatBananas() {
        logger.info("Ate  bananas");
    }
}
