
//Given an income and tax information in a 2D array that defines the tax brackets 
//example: array[0][0] = minimum income for bracket
//		   array[0][1] = tax rate
//return the total amount taxed on the given income

public class TaxBrackets {

	public double taxCalc(double income, double[][] taxBrackets){
		double amountTaxed = 0;
		
		for(int i = 0; i < taxBrackets.length; i++){
			double min = taxBrackets[i][0]; //minimum income needed for this tax bracket
			double rate = taxBrackets[i][1];//current rate this bracket is taxed
			//maximum income for the current tax bracket is equal to the minimum of the next bracket
			double max = (i < taxBrackets.length - 1) ? taxBrackets[i+1][0] : Integer.MAX_VALUE;
			
			if(income > min){
				if(income > max){
					amountTaxed += (max - min) * rate;
				}else {
					amountTaxed += (income - min) * rate;
				}
			}
		}
		
		return amountTaxed;
	}
	
	
	public static void main(String [ ] args){
		double [][] taxBracketsTestArray = {{10000, 0.1},{20000, 0.15}, {40000, 0.2}, {75000, 0.25}};
		
		TaxBrackets taxes = new TaxBrackets();
		double tax1 = taxes.taxCalc(8000, taxBracketsTestArray); //expected amount taxed = 0
		double tax2 = taxes.taxCalc(15000, taxBracketsTestArray);; //expected amount taxed = 500
		double tax3 = taxes.taxCalc(25000, taxBracketsTestArray);; //expected amount taxed = 1750
		double tax4 = taxes.taxCalc(40000, taxBracketsTestArray);; //expected amount taxed = 4000
		double tax5 = taxes.taxCalc(80000, taxBracketsTestArray);; //expected amount taxed = 12250
		
		System.out.println(tax1);
		System.out.println(tax2);
		System.out.println(tax3);
		System.out.println(tax4);
		System.out.println(tax5);
		
	 
	}
}
