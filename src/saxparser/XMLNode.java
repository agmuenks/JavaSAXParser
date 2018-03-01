/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.Attributes;

/**
 *
 * @author Andrew
 */
public class XMLNode {
    private String name = "";
    public String content = "";
    public HashMap<String, ArrayList<XMLNode>> properties = new HashMap<String, ArrayList<XMLNode>>();
    //private Attributes attributes;
    public HashMap<String, String> attributes = new HashMap<String, String>();
    
    public XMLNode(){
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
//    public void setAttributes(HashMap attributes){
//        this.attributes = attributes;
//    }
    
    public String getName(){
        return name;
    }
    
    public String getContent(){
        return content;
    }
    
    public HashMap<String, String> getAttributes(){
        return attributes;
    }
}
