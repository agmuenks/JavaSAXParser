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
    private String content = "";
    private HashMap<String, ArrayList<XMLNode>> properties = new HashMap<String, ArrayList<XMLNode>>();
    private HashMap<String, String> attributes = new HashMap<String, String>();
    
    public XMLNode(){
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void concatContent (String content){
        this.content += content;
    }
    
    public void setProperties (HashMap<String, ArrayList<XMLNode>> properties){
        this.properties = properties;
    }
    
    public void setAttributes(HashMap<String, String> attributes){
        this.attributes = attributes;
    }
    
    public String getName(){
        return name;
    }
    
    public String getContent(){
        return content;
    }
    
    public HashMap<String, ArrayList<XMLNode>> getProperties(){
        return properties;
    }
    
    public HashMap<String, String> getAttributes(){
        return attributes;
    }
}
