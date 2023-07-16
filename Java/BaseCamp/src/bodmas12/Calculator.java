package bodmas12;

import java.util.Scanner;

public class Calculator {
	public static Scanner input = new Scanner(System.in);
	public static Calculator test = new Calculator();

	public static void main(String[] args) {
		System.out.println(calculate("-1*5"));
	 }
	public static int calculate(String s) {
	    int len;
	    if(s==null || (len = s.length())==0) return 0;
	    MyStack stack = new MyStack();
	    int num = 0,temp;
	    char sign = '+';
	    for(int i=0;i<len;i++){
	    	//stack.displayStack();
	    	//System.out.println();
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	            	temp=stack.peek()*num;
	            	stack.pop();
	                stack.push(temp);
	            }
	            if(sign=='/'){
	            	temp=stack.peek()/num;
	            	stack.pop();
	                stack.push(temp);
	            }
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int result = 0;
	    for(int i=0; i<=stack.getTopOfStack();i++){
	        result += stack.getStack()[i];
	    }
	    return result;

	}
}
