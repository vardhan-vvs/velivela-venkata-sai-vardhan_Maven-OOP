package maven_and_OOP;
import java.util.Scanner;
interface Received
{
	String[] giftsweets = {"Gulab jamun", "Jalebi", "Kheer", "Ghevar"};  
	void Sort(int n);
	void InputSweet();
}
public class NewYearGift implements Received {
	public static int min_value,max_value,nsweets,option,temp;
	public static int sweets[]=new int[nsweets];
	public static int weights[]=new int[nsweets];
	public static int price[]=new int[nsweets];
	public void InputSweet()
	{ 
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the serial no. of sweets received:\n1.Gulab jamun\n2.Jalebi\n3.Kheer\n4.Ghevar");
		for(int i=0;i<nsweets;i++)
		{
			sweets[i]=scan.nextInt();
			System.out.println("enter weight of the sweet:");
			weights[i]=scan.nextInt();
			System.out.println("enter price of the sweet:");
			price[i]=scan.nextInt();
		}
	}
	public void Sort(int n)
	{
		if(n==1){
			for(int i=0;i<nsweets;i++){
				for(int j=i+1;j<nsweets;j++){
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
			for(int i=0;i<nsweets;i++){
			for(int j=i+1;j<nsweets;j++){
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
		NewYearGift gift=new NewYearGift();
		gift.InputSweet();
		System.out.println("enter the option to sort the received gifts according to:\n1.weight\n2.price");
		option=scan.nextInt();
		gift.Sort(option);
		System.out.println("sorted order is:");
		for(int i=0;i<sweets.length;i++){
			System.out.println(giftsweets[sweets[i]]);
		}
		System.out.println("find candies of in the gift according to:\n1.weight\n2.price");
		option=scan.nextInt();
		System.out.println("find candies of in the gift in the range with\nmin_value:");
		min_value=scan.nextInt();
		System.out.println("max_value:");
		max_value=scan.nextInt();
		if(option==1){
			for(int i=0;i<sweets.length;i++){
				if(weights[i]>=min_value && weights[i]<=max_value){
					System.out.println("Sweet"+i+":"+giftsweets[sweets[i]]);
				}
			}
		}
		else{
			for(int i=0;i<sweets.length;i++){
				if(price[i]>=min_value && price[i]<=max_value){
					System.out.println("Sweet"+i+":"+giftsweets[sweets[i]]);
				}
			}
		}	

	}

}
