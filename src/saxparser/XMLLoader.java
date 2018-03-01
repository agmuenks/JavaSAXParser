/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Andrew
 */
public class XMLLoader {
        public static XMLRoot load(File xmlCourseFile) throws Exception {

        XMLRoot xmlRoot = new XMLRoot();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            
            
            
            DefaultHandler handler = new DefaultHandler() {
                XMLNode root;
                ArrayList<XMLNode> stack;
                XMLNode currentNode;
                
                
                @Override
                public void startDocument(){
                    //root = null;
                    xmlRoot.setRoot(null);
                    
                    stack = new ArrayList<>();
                }
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("start");
                    XMLNode node = new XMLNode();
                    node.setName(qName);
                    System.out.println(qName);
                    node.setAttributes(attributes);
                    stack.add(node);
                   
                    
                    if(currentNode != null){
                        if (currentNode.properties.get(localName) != null){
                            currentNode.properties.get(localName).add(node);
                        }
                        else{
                            ArrayList<XMLNode> nodeList = new ArrayList<>();
                            nodeList.add(node);
                            currentNode.properties.put(localName, nodeList);
                        }
                    }
                    currentNode = node;
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    
                    int stackSize = stack.size();
                    XMLNode poppedNode = stack.get(stackSize-1);
                    stack.remove(stackSize-1);
                    if (poppedNode != null){
                        if (stack.isEmpty()){
                            
                            xmlRoot.setRoot(poppedNode);
                            currentNode = null;
                        }
                        else{
                            currentNode = stack.get(stackSize-2);
                        }
                    }
                    
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    
                    if (currentNode != null){
                        currentNode.content += new String(ch, start, length);
                        
                    }
                }
            
            };
            
            saxParser.parse(xmlCourseFile.getAbsoluteFile(), handler);
            
        } catch (Exception e) {
            throw e;
        }
        
      return xmlRoot; 
    }
}
