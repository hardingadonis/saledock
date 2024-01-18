package io.hardingadonis.saledock.utils;

import org.apache.commons.codec.digest.*;

public class Hash {

    public static String MD5(String message) {
        return DigestUtils.md5Hex(message);
    }
}
