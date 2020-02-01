import java.util.Scanner;

public class BMICalculator {
	private static Scanner input = new Scanner(System.in);
	
	private int dataType;	
	private double weight;	
	private double height;	
	private double Bmi;	
	private String BmiCatagory;
	
	//first read in user data
	public void readUserData() {		
		//find the data type, and then the measurments
		this.dataType = readUnitType();
		readMeasurementData(this.dataType);
		
	}
	
	
	//returns a 1 for Imperial units and a 2 for Metric Units
	private int readUnitType() {		
		//loop the question until a reasonable answer is given
		int userInput = 0;
		do {
			System.out.print("Enter 1 for Metric units, and 2 of Imperial units: ");
			userInput = input.nextInt();			
		} while (userInput != 1 && userInput != 2);
		
		return userInput;
	}
	
	private void readMeasurementData(int dataType) {
		//check datatype
		if(dataType == 1) {
			readMetricData();
		} else if (dataType == 2) {
			readImperialData();
		}
	}	
	
	private void readMetricData() {
		//scan in weight
		System.out.print("Please enter your weight in kilograms: ");
		setWeight();
		//exit if less than zero
		if(this.getWeight() < 0) {
			System.exit(0);
		}
		
		//scan in height
		System.out.print("Please enter your height in meters: ");
		setHeight();
		//exit if less than zero
		if(this.getHeight() < 0) {
			System.exit(0);
		}
	}
	
	private void readImperialData() {
		//scan in weight
		System.out.print("Please enter your weight in pounds: ");
		setWeight();
		//exit if less than zero
		if(this.getWeight() < 0) {
			System.exit(0);
		}
		
		//scan in height
		System.out.print("Please enter your height in inches: ");
		setHeight();
		//exit if less than zero
		if(this.getHeight() < 0) {
			System.exit(0);
		}
	}
	
	public void calculateBmi() {
		//calculate the BMI
		
		//check the dataType
		
		//if Metric
		if(this.dataType == 1) {
			//divide the weight by the height squared
			this.Bmi = this.getWeight() / (this.getHeight() * this.getHeight());
		} else if (this.dataType == 2) {
			
		//if Imperial
			//multiple the weight by 703, then divide by height squared
			this.Bmi = (703 * this.getWeight()) / (this.getHeight() * this.getHeight());
		}
		
		//find the BMI catagory
		calculateBmiCategory();
	}
	
	private void calculateBmiCategory() {
		//if below 18.5 BMI catagory is underweight
		//if between 18.5 and 24.9, Normal weight
		//if between 24.9 and 29.9 Overweight
		//if above 29.9 Obese
		if(this.Bmi < 18.5) {
			this.BmiCatagory = "Underweight";
		} else if (this.Bmi < 24.9) {
			this.BmiCatagory = "Normal weight";
		} else if(this.Bmi < 29.9) {
			this.BmiCatagory = "Overweight";
		} else {
			this.BmiCatagory = "Obesity";
		}
	}
	
	public void displayBmi() {
		//print out BMI
		System.out.printf("Your BMI is: %.2f%n", this.Bmi);
		//print out BMI Catagory
		System.out.println("Your BMI catagory is: " + this.BmiCatagory);
	}
	
	private void setWeight() {
		this.weight = input.nextDouble();
	}
	
	private void setHeight() {
		this.height = input.nextDouble();
	}	
	
	public double getWeight() {
		
		return this.weight;
	}
	
	public double getHeight() {
		
		return this.height;
	}
	
	public double getBmi() {
		return this.Bmi;
	}
	
	public String getBmiCategory() {
		return this.BmiCatagory;
	}
}
