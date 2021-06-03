
public class Postfix{

	public static void main(String[] args) {
		
		Postfix p = new Postfix();
		p.evaluate("35+");
	}
	
	public void evaluate (String pfx) {
	    StackAsList<Character> stack = new StackAsList<Character>();

		String r = "";
		char t = ' ';
		
		//while(pfx != "") {
			
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
			   stack.push((char) (a + '0'));
			   
			}
			
		}
		System.out.println("result is:" + Character.getNumericValue(stack.top()));
		
	//}
		
	}
}
