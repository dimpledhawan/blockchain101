/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain101;

import java.security.MessageDigest;

/**
 *
 * @author dimpledhawan
 */
public class stringUtil {
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
//            StringBuffer hexString = 
            return null;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
