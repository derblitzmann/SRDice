package srdice;

public class SRDice {
	/**
	 * Determines the probability of success for total dice 
	 * with some threshold T in the 4th Ed. Shadowrun system. 
	 * @param T
	 * @param total
	 * @return result
	 */
	public double ProbSucceed(int T, int total){
		double top;
		double bottom;
		double result=0;
		
		for(int i=T;i<=total;i++){
			for(int j=0;j<=(total-i+1)/2;j++){
				top = fact(total) * Math.pow(2, i) * Math.pow(3, total-i-j);
				bottom = Math.pow(6, total) * fact(i) * fact(j) * fact(total-i-j);
				result += top/bottom;
			}
		}
		
		return result;
	}
	
	/**
	 * Determines the probability of "glitching" given some amount of dice.
	 * @param total
	 * @return result
	 */
	public double ProbGlitch(int total){
		double top;
		double bottom;
		double result=0;
		
		for(int i=(total+1)/2;i<=total;++i){
			for(int j=1;j<=total-i;++j){
				top = Math.pow(3, total-i-j) * Math.pow(2, j) * fact(total);
				bottom = Math.pow(6, total) * fact(i) * fact(j) * fact(total-i-j);
				result += top/bottom;
			}
		}
		return result;
	}
	
	/**
	 * Determines the probability of "critically glitching" given some amount of dice.
	 * @param total
	 * @return result
	 */
	public double ProbCriticalGlitch(int total){
		double top;
		double bottom;
		double result=0;
		
		for(int i=(total%2 == 1)?(total+1)/2:total/2;i<=total;++i){
			top = Math.pow(3, total-i) * fact(total);
			bottom = Math.pow(6, total) * fact(i) * fact(total-i);
			result += top/bottom;
		}
		return result;
	}
	
	/**
	 * Basic factorial calculation
	 * 
	 * @param i
	 * @return i!
	 */
	private double fact(double i){
		if(i <= 1){
			return 1;
		}else{
			return i * fact(i-1);
		}
	}
}
