/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain101;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

/**
 *
 * @author dimpledhawan
 */
public class Wallet {
    public PrivateKey privateKey;
    public PublicKey publicKey;
    
    public Wallet() {
        generateKeyPair();
    }
    
    public void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
