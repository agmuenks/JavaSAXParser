/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

/**
 *
 * @author Andrew
 */
public class XMLRoot {
    
    private XMLNode root;
    
    public XMLRoot (){
        
    }
    
    public void setRoot(XMLNode root){
        this.root = root;
    }
    
    public XMLNode getRoot(){
        return root;
    }
}
