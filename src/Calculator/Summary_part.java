package Calculator;

public class Summary_part {
	static int allAttempt_Number=5000;
	static int theLongestWorstPeriod;
	static int theShortestBestPeriod;
	static int succeededCounter=0;
	static int suchs=0;
	static int lucks=0;
	static int first_SuccesfullAppear;
	
	public static double chanceOfCase(int Attemp, double chance) {
		double worst = (100 - chance)/100;
		double result = 1 - Math.pow(worst,(double)Attemp);
		return result;
	}
	
	public static void Attempt() {
		int notSuccesed_PartCounter=0;
		theLongestWorstPeriod=0;
		first_SuccesfullAppear=-1;
		
		for(int i=1;i<=allAttempt_Number;i++) {
			if(chance_generator.letsGenerateAChance()) {
				succeededCounter++;
				if(notSuccesed_PartCounter==0) {
					notSuccesed_PartCounter++;
				}
				
				if(first_SuccesfullAppear == -1) {
					first_SuccesfullAppear=notSuccesed_PartCounter;
					theShortestBestPeriod=notSuccesed_PartCounter;
				}
				
				if(notSuccesed_PartCounter>theLongestWorstPeriod) {
					theLongestWorstPeriod=notSuccesed_PartCounter;
					suchs=succeededCounter;
					
				}
				
				if(notSuccesed_PartCounter<theShortestBestPeriod) {
					theShortestBestPeriod=notSuccesed_PartCounter;
					lucks=succeededCounter;
				}
				notSuccesed_PartCounter=0;
				
			}else {
				notSuccesed_PartCounter++;
			}
		}
		writeDownTheInput();
	}
	public static void writeDownTheInput() {
		double average=(double)allAttempt_Number/succeededCounter;
		double WorstPeriod_Chance=(double)theLongestWorstPeriod/allAttempt_Number*100;
		double bestPeriod_Chance=chanceOfCase(lucks, first_part.chance_DoubleType)*100;
		double fristwin=chanceOfCase(first_SuccesfullAppear, first_part.chance_DoubleType)*100;
		
		System.out.println("Az els� tal�lat "+first_SuccesfullAppear+" menet ut�n volt. Amire "+ fristwin +"% es�ly volt");
		System.out.println("�sszesen ennyi j�tt: "+succeededCounter+ " Az ennyi: "+allAttempt_Number+" prob�lkoz�sb�l.");
		System.out.printf("Atlag: %f Sz�val �tlagosan %d menetre van sz�ks�g.\n",average,(int)Math.ceil(average));
		System.out.println("A legrosszabb eset 'Negativ lotto': "+theLongestWorstPeriod+" menet - aminek: "+ WorstPeriod_Chance+" % es�llye volt, hogy bek�vetkezik �s "+suchs+" sikeres menet volt el�tte");
		System.out.println("A legjobb eset  'Pozitiv lotto'  : "+theShortestBestPeriod+" - aminek: "+ bestPeriod_Chance+" % es�llye volt, hogy bek�vetkezik �s "+lucks+" sikeres menet volt el�tte");
	}
}
