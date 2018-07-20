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
}
