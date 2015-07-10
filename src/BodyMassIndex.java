/*
	this smal program takes as input the weight (in kg) and the height (in m) and gives
	as output the BMI (Body Mass Index), plus which category (obese, overweight, normal, underweight)
*/

import java.util.Scanner;
import java.text.DecimalFormat;

class BodyMassIndex 
{
	public static void main(String[] args) 
	{
		Scanner clavier = new Scanner(System.in);
		boolean retry = true;
		char yesOrNo = ' ';

		do 
		{

			System.out.print("Enter your weight (in kg) : ");
			double weight = clavier.nextDouble();
			System.out.print("Enter your height (in meter) : ");
			double height = clavier.nextDouble();
			
			DataBMI myData = new DataBMI(weight, height);
			
			myData.calculateBMI();
			
			DecimalFormat df = new DecimalFormat("####0.00");
			System.out.print("your Body Mass Index is : " + df.format(myData.BMI));
			System.out.println();
			System.out.println("your category is : " + myData.category());

			do
			{
				System.out.println();
				System.out.print("Try again? (y/n) : ");
				yesOrNo = clavier.next().charAt(0);
				if (yesOrNo == 'n')
				{
					System.out.println("Goodebye!");
					retry = false;
				}
			} while (yesOrNo != 'y' && yesOrNo != 'n');
		} while (retry == true);
	}
}

class DataBMI
{
	double m_weight;
	double m_height;
	double BMI;
	
	public DataBMI(double weight, double height)
	{
		m_weight = weight;
		m_height = height;
	}
	
	public double calculateBMI()
 	{
		BMI = m_weight/(m_height*m_height);
		return BMI;
	}
	
	public String category()
	{
		if (BMI < 15) return "very severely underweight";
		else if  (BMI>=15 && BMI<16) return "Severely underweight";
		else if  (BMI>=16 && BMI<18.5) return "Underweight";
		else if  (BMI>=18.5 && BMI<25) return "Normal";
		else if  (BMI>=25 && BMI<30) return "Overweight";
		else if  (BMI>=30 && BMI<35) return "Moderately obese";
		else if  (BMI>=35 && BMI<40) return "Severely obese";
		else return "Very severely obese";
	}	
}