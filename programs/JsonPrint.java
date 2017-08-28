* 
 */
package my.practice;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

/**
* @author Piyush
*
*/
public class JsonPrint {

                /**
                * @param args
                */
                public static void main(String[] args) {
                                String s= "{ \"name\": \"John\", \"age\": 31, \"city\": \"London\", \"interests\":[\"Swimming\", \"Music\"]}"; 
                                printJsonValues(s);

                }
                private static boolean valueIsTypeArray=false;

                private static void printJsonValues(String s) {
                                ArrayList<String>  elements= new ArrayList<>();
                                s=s.replace("{", "");
                                s=s.replace("}", "");
                                for (String element :s.split(",")) {
                                                
                                                if(element.contains(":")) {
                                                                
                                                                //is a key value pair split by ","
                                                                elements.add(handleArray(element.split(":")[1]));
                                                }else if (valueIsTypeArray){
                                                                if(element.contains("]")) {
                                                                                valueIsTypeArray=false;
                                                                                element=element.replace("]", "");
                                                                }
                                                                elements.add(element.trim());
                                                }
                                }
                                System.out.println(elements);
                                
                                
                }

                private static String handleArray(String element) {
                                if (element.contains("[")) {
                                                valueIsTypeArray=true;
                                                element=element.replace("[", "");
                                }
                                return element;
                }

}
