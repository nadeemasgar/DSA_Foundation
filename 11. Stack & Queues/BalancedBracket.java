import java.io.*;
import java.util.*;

public class BalancedBracket {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack < Character > s = new Stack < > ();
        
        for(int i = 0; i < str.length(); i++){
            
            char ch = str.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            else if(ch == ')'){
                if(s.size() == 0 || s.peek() != '('){
                    System.out.println("false");
                    return;
                }
                else{
                    s.pop();
                }
            }
            else if(ch == '}'){
                if(s.size() == 0 || s.peek() != '{'){
                    System.out.println("false");
                    return;
                }
                else{
                    s.pop();
                }
            }
            else if(ch == ']'){
                if(s.size() == 0 || s.peek() != '['){
                    System.out.println("false");
                    return;
                }
                else{
                    s.pop();
                }
            }
        }
        
        if(s.size() == 0){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}

