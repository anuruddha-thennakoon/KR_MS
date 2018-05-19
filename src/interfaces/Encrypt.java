/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.security.MessageDigest;

/**
 *
 * @author ANURUDDHA
 */
public class Encrypt {

    private static MessageDigest md;

    public static String NewEncrypt(String password) {
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = password.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
