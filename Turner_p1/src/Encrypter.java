
public class Encrypter {
	
	private int[] intUserInput = new int[4];
	
	private void stringToIntArray(String in) {
		//loop through the string at each character
		for(int i = 0; i<in.length(); i++) {
			//cast it to an int into an array
			this.intUserInput[i] = Character.getNumericValue(in.charAt(i));
		}
	}
	
	public String encrypt(String in) {
		//first turn the string into an array of ints		
		stringToIntArray(in);
		
		//add 7 to each digit, then get remander after dividing by 10
		
		for(int i = 0; i < in.length(); i++) {
			intUserInput[i] = intUserInput[i] + 7;
			intUserInput[i] = intUserInput[i] % 10;
		}
		
		//swap the first digit with the third, and swap the second digit with the fourth
		int tmpStorage = 0;
		
		tmpStorage = intUserInput[0];		
		intUserInput[0] = intUserInput[2];		
		intUserInput[2] = tmpStorage;
		
		tmpStorage = intUserInput[1];		
		intUserInput[1] = intUserInput[3];		
		intUserInput[3] = tmpStorage;
		
		
		//cast the array of ints back to a string and return it
		String encryptedNumber = "" + intUserInput[0] + intUserInput[1] + intUserInput[2] + intUserInput[3];
		return encryptedNumber;
	}
}
