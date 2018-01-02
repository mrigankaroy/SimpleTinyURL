package com.simpleTinyURL.app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mrro1015 on 1/2/2018.
 */
public class MD5Hashing {

    public byte[] generateMD5Bytes(String url) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(url.getBytes());
        return md.digest();
    }
}
