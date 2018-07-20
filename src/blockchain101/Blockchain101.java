/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain101;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;
/**
 *
 * @author dimpledhawan
 */
public class Blockchain101 {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 3;
            
    public static void main(String[] args) {
        blockchain.add(new Block("Hi I'm the first block", "0"));
        System.out.println("Trying to Mine block 1... ");
	blockchain.get(0).mineBlock(difficulty);
                
        blockchain.add(new Block("Hi I'm the second block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
	blockchain.get(1).mineBlock(difficulty);
        
        blockchain.add(new Block("Hi I'm the third block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
	blockchain.get(2).mineBlock(difficulty);
        
        System.out.println("\nBlockchain is Valid: " + isValid());
		
	String blockchain_json = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
	System.out.println("\nThe block chain: ");
        System.out.println(blockchain_json);     
    }
    
        
    public static Boolean isValid() {
        Block currentBlock, prevBlock;
        
        for(int i = 0; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            prevBlock = blockchain.get(i-1);
            
            if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current hashes not equal");
                return false;
            }
            
            if(!prevBlock.hash.equals(prevBlock.calculateHash())) {
                System.out.println("Previous hashes not equal");
                return false;
            }
            
        }
        
        return true;
    }
    
}
