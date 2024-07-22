package org.nwolfhub;

import org.apache.commons.text.StringEscapeUtils;
import org.nwolfhub.utils.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
        String inp = encoder.encodeToString(Utils.generateString(43).getBytes()).replace("+", "-").replace("=", "").replace("/", "_");
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String res = encoder.encodeToString(digest.digest(inp.getBytes())).replace("+", "-").replace("=", "").replace("/", "_");;
        System.out.println("Challenge: " + StringEscapeUtils.escapeHtml3(res) + "\nVerifier: " + inp);
    }
}