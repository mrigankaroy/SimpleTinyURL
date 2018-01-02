package com.simpleTinyURL.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mrro1015 on 1/2/2018.
 */
public class TinyURLGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TinyURLGenerator.class);
    private static final String CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private MD5Hashing md5Hashing;

    public String generateTinyURL(String url) {
        try {
            byte hashedURL[] = md5Hashing.generateMD5Bytes(url);
            StringBuffer tinyString = new StringBuffer();
            for (int i = 0; i < hashedURL.length; i++) {
                if (i > 6) {
                    break;
                }
                int value = (0xff & hashedURL[i]) % 62;
                tinyString.append(CODES.charAt(value));
            }
            return tinyString.toString();
        } catch (Exception e) {
            LOGGER.error("Error during generateTinyURL {}", e);
        }
        return null;
    }

    public void setMd5Hashing(MD5Hashing md5Hashing) {
        this.md5Hashing = md5Hashing;
    }
}
