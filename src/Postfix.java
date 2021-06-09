import java.util.Scanner;

public class Postfix{

	public static void main(String[] args) {
		
		Postfix p = new Postfix();
		p.evaluate("35+");
		Scanner scanner = new Scanner( System.in );
		String s = scanner.nextLine();
		System.out.println(p.infixToPostfix(s));
		scanner.close();
	}
	
	
	public String infixToPostfix (String ifx) {
	  StackAsList<Character> stack = new StackAsList<Character>();
	  String result = "";
	  for(int i = 0; i < ifx.length(); i++) {
		  char t = ifx.charAt(i);
		  if (t == '0' || t == '1' || t == '2' || t == '3' || t == '4' || t == '5' || t == '6' || t == '7' || t == '8' || t == '9') {
			  result += t;
		  }
		  else if (t == '(') {
			  stack.push(t);
		  }
		  else if (t == ')') {
			  while(stack.top() != null && stack.top() != '(') {
				  result += stack.pop();
			  }
			  stack.pop();
		  }
		  else {
			  while(stack.top() != null && precedence(t) < precedence(stack.top())) {
				  result += stack.pop();
			  }
			  stack.push(t);
		  }
	  }
	  
	  while(stack.top() != null) {
		  if (stack.top() == '(') {
			  return "Invalid Expression";
		  }
		  result += stack.pop();
	  }
      return result;
	}
	
	public int precedence(char t) {
		
		if(t == '+' || t == '-') {
			return 1;
		}
		if(t == '*' || t == '/' || t == '%') {
			return 2;
		}
		return -1;
	}
	
	public void evaluate (String pfx) {
	    StackAsList<Character> stack = new StackAsList<Character>();

		String result = "";
		char t = ' ';
			
		for( int i = 0; i < pfx.length(); i++) {
			
			t = pfx.charAt(i);
			
			
			if(t == '1' || t == '2' || t == '3' || t == '4' || t == '5' || t == '6' || t == '7' || t == '8' || t == '9') {
				stack.push(t);
			}
			
			if(t == '*' || t == '+' || t == '-' || t=='/') {
			   int rhs = Character.getNumericValue(stack.top());
			   stack.pop();
			   
			   int lhs = Character.getNumericValue(stack.top());
			   stack.pop();
			   
			   int a = 0;
			   if(t == '*') {
				   a = lhs * rhs;
			   }
			   if(t == '+') {
				   a = lhs + rhs;
			   }
			   if(t == '-') {
				   a = lhs - rhs;
			   }
			   if(t == '/') {
				   a = lhs / rhs;
			   }
			   if(t == '%') {
				   a = lhs % rhs;
			   }
			   stack.push((char) (a + '0'));
			}
			
		}
		System.out.println("result is:" + Character.getNumericValue(stack.top()));
		
	//}
		
	}
}
