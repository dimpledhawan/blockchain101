/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain101;

import java.util.Date;

/**
 *
 * @author dimpledhawan
 */
public class Block {
    public String hash;
    public String prevHash;
    private String data;
    private long timeStamp;
    private int nonce;
    
    public Block(String data, String prevHash) {
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }
    
    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                prevHash +
                Long.toString(timeStamp) +
                data
        );
        return calculatedHash;
    }
    
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined! : " + hash);
    }
    
}
