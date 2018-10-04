package ru.innopolis.stc12.servlets.service.utils;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    private static Logger logger = Logger.getLogger(HashUtil.class);
    public static String stringToMD5(String password) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        BigInteger bigInteger = new BigInteger(1, digest);
        String result = bigInteger.toString(16);
        while (result.length() < 32) {
            result = "0" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        logger.info(stringToMD5("master"));
    }
}
