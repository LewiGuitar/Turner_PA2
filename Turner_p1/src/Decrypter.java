
public class Decrypter {
	
	private int[] intUserInput = new int[4];
	
	private void stringToIntArray(String in) {
		//loop through the string at each character
		for(int i = 0; i<in.length(); i++) {
			//cast it to an int into an array
			this.intUserInput[i] = Character.getNumericValue(in.charAt(i));
		}
	}
	public String decrypt(String in) {
		
		//first turn the string into an array of ints		
		stringToIntArray(in);
		
		//unswap the first digit with the third, and unswap the second digit with the fourth
		int tmpStorage = 0;
		
		tmpStorage = intUserInput[0];		
		intUserInput[0] = intUserInput[2];		
		intUserInput[2] = tmpStorage;
		
		tmpStorage = intUserInput[1];		
		intUserInput[1] = intUserInput[3];		
		intUserInput[3] = tmpStorage;
		
		//undo modulus
		//since the numbers are limmited in scope, each mod done has one unique pairing
		//if the value is 7 or grater, it is the result of 7, 8, or 9 % 10, so leave it alone
		//otherwise add 10
				
		for(int i = 0; i < in.length(); i++) {
			if(intUserInput[i] < 7) {
				intUserInput[i] = intUserInput[i] + 10;
			}				
		}
				
				
		//subtract 7 from each value
		for(int i = 0; i < in.length(); i++) {
			intUserInput[i] = intUserInput[i] - 7;				
		}	
		
		//cast the array of ints back to a string and return it
		String decryptedNumber = "" + intUserInput[0] + intUserInput[1] + intUserInput[2] + intUserInput[3];
		return decryptedNumber;
	}
}
