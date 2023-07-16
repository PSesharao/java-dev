package functionalInterface.impl;


import functionalInterface.Calculator;

public class CalculatorImpl{
	public static void main(String[] args) {
		Calculator calc = (operand1,operand2,operator) ->{
			switch(operator)
			{
			case 'x':
				System.out.println("Multiplication:");
				return operand1*operand2;
			case '+':
				System.out.println("Addition:");
				return operand1+operand2;
			case '/':
				System.out.println("Division:");
				
				try {
					return operand1/operand2;
				} catch ( ArithmeticException e) {
					
					e.printStackTrace();
					System.out.println("Can't divide by zero");
				}
				
			case '-':
				System.out.println("Subtraction:");
				return operand1-operand2;
			default :
				System.out.println("Invalid input returning -1");
			}
			return -1;
		};
		
		System.out.println(calc.calculate(12, 3, '+'));
		
		System.out.println(calc.calculate(12, 3, '-'));
		
		System.out.println(calc.calculate(12, 3, 'x'));
		
		System.out.println(calc.calculate(12, 3, '/'));
	}
	
}
