import java.io.*;
import java.util.*;

public class infixEvaluation {

    public static int priority(char c) {

        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else
            return 0;
    }


    public static int evaluate(int val1, int val2, char op) {

        if (op == '*') {
            return val1 * val2;
        } else if (op == '/') {
            return val1 / val2;
        } else if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else
            return 0;
    }

    public static void infixEvaluation(String str) {

        Stack<Integer> vstack = new Stack<>();
        Stack<Character> ostack = new Stack<>();



        for (int i = 0; i < str.length(); i++) {

            System.out.println(vstack + " " + ostack);

            char ch = str.charAt(i);

            if (ch == ' ')
                continue;

            if (ch >= '0' && ch <= '9') {
                vstack.push(ch - '0');
            } else if (ch == '(') {
                ostack.push(ch);
            } else if (ch == ')') {

                while (ostack.peek() != '(') {

                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();

                    int value = evaluate(val1, val2, op);

                    vstack.push(value);
                }

                ostack.pop();

            } else {
                while (ostack.size() > 0 && priority(ostack.peek()) >= priority(ch)) {

                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();

                    int value = evaluate(val1, val2, op);

                    vstack.push(value);
                }
                ostack.push(ch);
            }
        }

        System.out.println(vstack + " " + ostack);

        while (ostack.size() > 0) {

            int val2 = vstack.pop();
            int val1 = vstack.pop();
            char op = ostack.pop();

            int value = evaluate(val1, val2, op);

            vstack.push(value);

            System.out.println(vstack + " " + ostack);
        }

        System.out.println(vstack.peek());
        System.out.println(vstack + " " + ostack);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        infixEvaluation(exp);
    }

}