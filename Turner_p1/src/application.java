import java.util.Scanner;
public class application {
	
	public static String readInString() {
		Scanner input = new Scanner(System.in);
		
		String userInput;
		
		userInput = input.nextLine();
		
		input.close();
		
		return userInput;
	}
	
	public static int readInInt() {
		Scanner input = new Scanner(System.in);
		
		//read in the int, then return it
		int userInput = input.nextInt();		
		
		return userInput;
		//the input is not closed as it needs to remain open 
	}
	
	public static int getEncryptOrDecrypt() {
		
		int userInput = 0;
		
		//Ask if encrypting or decrypting, loop until valid input is given
		do {
		System.out.print("To Encrypt a number, enter 1, to decrypt a number, enter 2: ");
		userInput = readInInt();
		} while (userInput != 1 && userInput != 2);
		
		return userInput;
	}
	
	public static String readInUserNumber(int userInput){
		
		if(userInput ==1) {
			System.out.print("Enter the number you would like to encrypt: ");
		} else if (userInput == 2) {
			System.out.print("Enter the number you would like to decrypt: ");
		}
				
		String num = readInString();
		return num;
	}
	
	public static void main(String[] args) {
		
		//find out if user wants to Encrypt or Decrypt
		int userInput = getEncryptOrDecrypt();		
		
		//read in the number the user enters as a string
		String numInput = readInUserNumber(userInput);
		
		//depending on input, call the encrypt or decrypt function, and print out it's output
		if(userInput == 1) {
			Encrypter Encrypter = new Encrypter();
			System.out.println("Your encrypted number is: " + Encrypter.encrypt(numInput));
		}
		if(userInput == 2) {
			Decrypter Decrypter = new Decrypter();
			System.out.println("Your decrypted number is: " + Decrypter.decrypt(numInput));
		}
	}
}
