package maven_and_OOP;
import java.util.Scanner;
interface Received
{
	String[] giftsweets = {"Gulab jamun", "Jalebi", "Kheer", "Ghevar"};  
	void Sort(int n,int sweets[],int weights[],int price[]);
	void InputSweet(int sweets[],int weights[],int price[]);
}

class NewYearGift implements Received
{
	public static int min_value,max_value,nsweets,option,option2,temp;
	public void InputSweet(int sweets[],int weights[],int price[])
	{ 
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the serial no. of sweets received:\n1.Gulab jamun\n2.Jalebi\n3.Kheer\n4.Ghevar");
		System.out.println("enter sweet no.,weight,price of the sweet respectively separated by space:");
		for(int i=0;i<sweets.length;i++)
		{
			sweets[i]=scan.nextInt();
			weights[i]=scan.nextInt();
			price[i]=scan.nextInt();
		}
	}
	public void Sort(int n,int sweets[],int weights[],int price[])
	{
		if(n==1){
			for(int i=0;i<sweets.length;i++){
				for(int j=i+1;j<sweets.length;j++){
					if(weights[i]>weights[j])
						temp=weights[j];
						weights[j]=weights[i];
						weights[i]=temp;
						temp=price[j];
						price[j]=price[i];
						price[i]=temp;
						temp=sweets[j];
						sweets[j]=sweets[i];
						sweets[i]=temp;
				}
			}
		}
		else{
			for(int i=0;i<sweets.length;i++){
			for(int j=i+1;j<sweets.length;j++){
				if(price[i]>price[j])
					temp=price[j];
					price[j]=price[i];
					price[i]=temp;
					temp=weights[j];
					weights[j]=weights[i];
					weights[i]=temp;
					temp=sweets[j];
					sweets[j]=sweets[i];
					sweets[i]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter no.of sweets received in the gift:");
		nsweets=scan.nextInt();
		int sweets[]=new int[nsweets];
		int weights[]=new int[nsweets];
		int price[]=new int[nsweets];
		NewYearGift gift=new NewYearGift();
		gift.InputSweet(sweets,weights,price);
		System.out.println("enter the option to sort the received gifts according to:\n1.weight\n2.price");
		option=scan.nextInt();
		gift.Sort(option,sweets,weights,price);
		System.out.println("sorted order is:");
		for(int i=0;i<sweets.length;i++){
			System.out.println(giftsweets[sweets[i]-1]);
		}
		System.out.println("find candies of in the gift according to:\n1.weight\n2.price");
		option2=scan.nextInt();
		System.out.println("find candies of in the gift in the range with\nmin_value:");
		min_value=scan.nextInt();
		System.out.println("max_value:");
		max_value=scan.nextInt();
		if(option2==1){
			for(int i=0;i<sweets.length;i++){
				if(weights[i]>=min_value && weights[i]<=max_value){
					System.out.println("Sweet"+(i+1)+":"+giftsweets[sweets[i]-1]);
				}
			}
		}
		else{
			for(int i=0;i<sweets.length;i++){
				if(price[i]>=min_value && price[i]<=max_value){
					System.out.println("Sweet"+(i+1)+":"+giftsweets[sweets[i]-1]);
				}
			}
		}
	}
}