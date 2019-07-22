package com.anisha.git;

import java.util.Arrays;
import java.util.Scanner;

public class Anisha {public static void main(String args[]) {
	int temp,n,i;
	String choice;
	Scanner sc = new  Scanner(System.in);
	//System.out.println("Enter the choice ascending or descending");
	//choice = sc.nextLine();
	System.out.println("Enter no of elements in array");
	n=sc.nextInt();
	System.out.println("Enter the nos");
	Integer arr[] = new Integer[n];
	for(i= 0;i<n;i++) {
		arr[i]=sc.nextInt();
	}
	/*if(choice.equalsIgnoreCase("a")) {
		for(i =0;i<n-1;i++) {
			for(int j = i+1; j<n;j++) {
				if (arr[i]> arr[j]) {
					temp =arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}		
			}
		}	
	}
	else if(choice.equalsIgnoreCase("d")){
		for(i =0;i<n-1;i++) {
			for(int j = i+1; j<n;j++) {
				if (arr[i] < arr[j]) {
					temp =arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}		
			}
		}	
	}
	else 
		{System.out.println("wrong choice");}
	*/
	Arrays.sort(arr);
	System.out.println(Arrays.toString(arr));
	/*
	 * Arrays.sort(arr,Collections.reverseOrder());
//	 * System.out.println(Arrays.toString(arr));
	 */
	for(int j = n-1;j>=0;j--)
	{
		i=0;
		arr[j]= arr[i];
		i++;}
	System.out.println(Arrays.toString(arr));		
}


}
