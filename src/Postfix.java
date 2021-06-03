
public class Postfix {

	public void evaluate (String pfx) {
	 

		String r = "";
		char t = ' ';
		
		while(pfx != "") {
			
		for( int i = 0; i < pfx.length(); i++) {
			
			t = pfx.charAt(i);
			if(t == 1 || t == 2 || t == 3 || t == 4 || t == 5 || t == 6 || t == 7 || t == 8 || t == 9) {
				push(t);
			}
			
			if(t == '*' || t == '+' || t == '-' || t=='/') {
			   int rhs = Character.getNumericValue(top());
			   pop();
			   int lhs = Character.getNumericValue(top());
			   pop();
			   
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
			   push((char) a);
			   
			}
			System.out.println("result is:" + top());
			
			
			
		}
		
	}
		
	}
}
