package Calculator;
import java.util.Scanner;

public class first_part {
		public static String chance_PercentForm;
		static int chance_DecimalIntType;
		public static double chance_DoubleType;
		public static int chance_HowLongIsIt;
	
		public static void read_TheInput(Scanner in) {
			
			System.out.println("Kerem irja be a %-ot:");
			chance_PercentForm=in.nextLine();
			System.out.println("\n");
			calculate_InputLong(chance_PercentForm);
			convertInputStringToNumber();
		}
		
		public static void calculate_InputLong(String text){
			if(text.indexOf('.') >= 0 || text.indexOf(',') >= 0 ) {
				chance_HowLongIsIt=text.length() - 1;
				if(text.indexOf('.') != 3) {
					chance_HowLongIsIt++;
				}
			}else {
				chance_HowLongIsIt=text.length();
				if(text.length()<2) {
					chance_HowLongIsIt++;
				}
			}
		}
		
		public static int findTheIndexOf_inputString(String text) {
			int index=text.indexOf(".") + 1;
			return index;
		}
		
		public static void converStringToInt(String text, int i) {
			if(text.charAt(i)!=',' && text.charAt(i)!='.') {
				int oneNumber=Character.getNumericValue(text.charAt(i));
				chance_DecimalIntType=chance_DecimalIntType+oneNumber;
				if(i!=text.length()-1) {
					chance_DecimalIntType=chance_DecimalIntType*10;
				}
			}
		}
		
		public static double covertStringToDouble(String text) {
			double value=Double.parseDouble(text.replace(",","."));
			return value;
		}
		
		public static void convertInputStringToNumber() {
			String text=chance_PercentForm;
			
			chance_DecimalIntType=0;
			chance_DoubleType=0;
			
			for(int i=0;i<text.length();i++) {
				converStringToInt(text,i);
			}
			chance_DoubleType=covertStringToDouble(text);
			//System.out.println(chance_DecimalIntType + " " + chance_DoubleType +" "+chance_HowLongIsIt);
			//System.out.println(text.charAt(text.length()-1));
		}
		
		public static void writeOutAllInformation() {
			boolean ItHappened;
			ItHappened=chance_generator.letsGenerateAChance();
			if(ItHappened) {
				System.out.printf("Bejött!!!");
			}else {
				System.out.printf("Bekaphatod!");
			}
		}
		
	 	public static void main(String [] args) {
	 		Scanner in = new Scanner(System.in);
	 		read_TheInput(in);
	 		Summary_part.Attempt();
	 		//writeOutAllInformation();
	 		in.close();
		}

}
