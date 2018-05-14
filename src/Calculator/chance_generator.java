package Calculator;
import java.util.Random;

public class chance_generator {
	public static boolean letsGenerateAChance() {
		Random rand=new Random();
		
		int number = first_part.chance_DecimalIntType;
		int count = first_part.chance_HowLongIsIt;
			
		int sillparameter = (int)Math.pow(10,count);
		int randomNumber=rand.nextInt(sillparameter) + 1;
			
		if(randomNumber<=number) {
			return true;
		}
		return false;
	}
}
