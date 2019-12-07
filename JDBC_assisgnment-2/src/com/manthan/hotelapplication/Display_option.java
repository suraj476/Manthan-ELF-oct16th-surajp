package com.manthan.hotelapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class Display_option {

	public static void main(String[] args) {
		
		List<Double> bill_of_eachcustomer = new ArrayList<Double>();
		 double Total_bill_of_day = 0;
		 Scanner scanner= new Scanner(System.in);
		 int choice =0;
		 while(choice!=5) {
		System.out.println(" press ");
		System.out.println(" 1. Show all food Items");
		System.out.println(" 2. Take orders from customers ");
		System.out.println(" 3. Operate on food items ");
		System.out.println(" 4. Total bill of the day");
		System.out.println(" 5. Exit");
		 choice =scanner.nextInt();
					if(choice==1)
					{
						new Showallfooditems();
					}							
					if(choice==2)
					{
					Takeordersfromcustomer takeorder = new Takeordersfromcustomer();
					double billofcustomer = takeorder.takeorders();
					System.out.println("Bill of a customer ====="+billofcustomer);
					bill_of_eachcustomer.add(billofcustomer);
					}
					if(choice==3)
					{
							System.out.println(" press ");
							System.out.println(" A. To add food Items");
							System.out.println(" B. To Delete food Items");
							System.out.println(" C. To Modify food Items");
							String choiceof3 =scanner.next();
							switch (choiceof3) 
							{
							case "A":{
								new Addfooditem();
								break;
							}
							case "B":{
								new DeletefoodItem();
								break;
							
							}
							case "C":{
								new Modifyfooditem();
								break;
							}
							
							
							default:
								{
								System.out.println("invalid choice");
								break;
								}
							}
					}
					if(choice==4)
						{
						for(int i = 0; i < bill_of_eachcustomer.size(); i++)
							Total_bill_of_day += bill_of_eachcustomer.get(i);
							System.out.println("Total bill of day ===== "+Total_bill_of_day);
						}
					}			
		 }
				
	}


