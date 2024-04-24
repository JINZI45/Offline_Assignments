import java.util.Scanner;

public class Stack_main {
    public static int precedence(char c){
        switch (c){
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '(':
            case ')':
                return 0;
        }
        return-1;
    }
    public static float operation(float a, float b, char c){
        switch (c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if(b==0)
                    System.out.println("invalid");
                else
                    return a/b;

        }
        return -1;
    }
    public static boolean checkOperator(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/')
            return true;
        return false;
    }
    public static void main(String[] args) {
        LinkedList<Float> list1=new LinkedList<>();
        LinkedList<Character> list2=new LinkedList<>();
        Stack<Float> stack1=new Stack<Float>(list1);
        Stack<Character> stack2=new Stack<Character>(list2);
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int count=0;
        for (int i=0; i<input.length();i++){
            char in=input.charAt(i);
            if(Character.isDigit(in)){
                stack1.push((float) Character.getNumericValue(in));
            }
            else if(in=='('){
                count=count+1;
                if(input.charAt(i+1)==')'){
                    System.out.println("Not valid");
                    return;
                }
                else if (checkOperator(input.charAt(i+1))&& input.charAt(i+2)==')'){
                    System.out.println("Not valid");
                    return;
                }
                else if(input.charAt(i+1)=='-'|| input.charAt(i+1)=='+'){
                    if(Character.isDigit(input.charAt(i+2))&& input.charAt(i+3)==')'){
                        stack1.push(0.00F);
                        stack2.push(in);
                    }
                    else  if(Character.isDigit(input.charAt(i+2))&& checkOperator(input.charAt(i+3))){
                        System.out.println("Not valid");
                        return;
                    }
                }
                else if(input.charAt(i+1)=='*'||input.charAt(i+1)=='/'){
                    System.out.println("Not valid");
                    return;
                }
                else stack2.push(in);
            }
            else if(in==')'){
                    char t= stack2.peek();
                    while(t!='('){
                        float value1= stack1.pop();
                        float value2=stack1.pop();
                        stack1.push(operation(value2,value1,t));
                        stack2.pop();
                        t=stack2.peek();
                    }
                    stack2.pop();
                    count=count-1;
                }

                else {
                    while (!stack2.isEmpty() && !stack1.isEmpty()&& (precedence(in)<precedence(stack2.peek()))){
                        float value1 = stack1.pop();
                        float value2 = stack1.pop();
                        stack1.push(operation(value2, value1, stack2.pop()));
                    }
                    stack2.push(in);
                }
            }
        if (count>0){
            System.out.println("Not valid");
            return;
        }
        else {while (!stack2.isEmpty()){
            float value1 = stack1.pop();
            float value2 = stack1.pop();
            stack1.push(operation(value2, value1, stack2.pop()));
        }
            System.out.println("valid expression, computed value:     "+stack1.pop());}
    }
}
