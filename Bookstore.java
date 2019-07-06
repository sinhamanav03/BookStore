

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BookShop {
	String[] var;
	//method to display all books
	//parameters are string which includes book details and a integer book no
	void display(String[] sp, int no) {
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("BOOK NO :" +no);
		System.out.println("ISBN NO :" +sp[0]);
		System.out.println("TOPIC :" +sp[1]);
		System.out.println("AUTHOR :" +sp[2]);
		System.out.println("PRICE :" +sp[3]);
		System.out.println("PUBLISHER HOUSE :" +sp[4]);
		System.out.println("-------------------------------------------------------------------------------------------------");
	}
	
	//this method will read all book details
	void readFile(File file) 
	throws Exception{
		BookShop b = new BookShop();
		FileInputStream fb = new FileInputStream(file);
		Scanner sc = new Scanner(fb);
		int no=1;
		String com=",";
		while(sc.hasNextLine()) {
			String text = sc.nextLine();
			String[] sp = text.split(com); //splits the book details in an array of string 
			b.display(sp, no);//calling the function display to show book details
			no++;
		}
		
	}
	
	//this method returns an array of isbn no which match the desired criteria
	//parameters are string (may be author name/topic/publisher house) 
	//file the location at which all data is saved
	//integer value for determination of parameter which is decided as
	//1 for topic ,2 for author,4 for publisher house 
	int[] findBook(String paramater,File file,int ch) 
	throws Exception{
		FileInputStream fb = new FileInputStream(file);
		Scanner sc = new Scanner(fb);
		int q=0;
		int[] isbnlist = new int[6];
		String com=",";
		while(sc.hasNextLine()) {
			String text = sc.nextLine();
			var = text.split(com);
			int is = Integer.parseInt(var[0]);
			if(var[ch].compareToIgnoreCase(paramater)==0) {
				isbnlist[q]=is;
				q++;
			}			
	    }
		return isbnlist;
	}
	
	//this method returns an array of isbn no which match the desired price range
	//parameter are integer max price and min price ,file containing location where data is stored 
	int[] findBookByPrice(int paramater1,int parameter2,File file)
	throws Exception{
		FileInputStream fb = new FileInputStream(file);
		Scanner sc = new Scanner(fb);
		int[] isbnlist = new int[6];
		int q=0;
		String com=",";
		while(sc.hasNextLine()) {
			String text = sc.nextLine();
			var = text.split(com);
			int is = Integer.parseInt(var[0]);
			int mprice =Integer.parseInt(var[3]);
			if(mprice<=paramater1 && mprice>=parameter2) {
				isbnlist[q]=is;
				q++;
			}			
	    }
		return isbnlist;
	}
	
	////this method returns an array of isbn no which match the desired isbn no
	//parameters are isbn no of book and file at which location of data is saved
	int[] findBookByIsbn(int paramater,File file)
	throws Exception{
		FileInputStream fb = new FileInputStream(file);
		Scanner sc = new Scanner(fb);
		int q=0;
		int[] isbnlist = new int[6];
		String com=",";
		while(sc.hasNextLine()) {
			String text = sc.nextLine();
			var = text.split(com);
			int is = Integer.parseInt(var[0]);
			if(is==paramater) {
				isbnlist[q]=is;
				q++;
			}			
	    }
		return isbnlist;
	}
	
	
	
	public static void main(String[] args)
	throws Exception{
		File bookList = new File("E:\\BookList.txt");
		BookShop b = new BookShop(); 
		int noOfBooksInRecord = 6; //this variable stores maximum books in record
		//the six following arrays will store array of isbn no returned by function 
		int[] a= new int[noOfBooksInRecord];//for author name
		int[] t= new int[noOfBooksInRecord];//for topic
		int[] p= new int[noOfBooksInRecord];//for price
		int[] ph= new int[noOfBooksInRecord];// for publisher house
		int[] is= new int[noOfBooksInRecord];//for isbn no
		Scanner sk = new Scanner(System.in);
		Scanner sk1 = new Scanner(System.in);
		System.out.println("#MENU#");
		System.out.println("1.SHOW ALL BOOKS");
		System.out.println("2.SEARCH PARTICULAR BOOKS ");
		int ch = sk.nextInt();//input choice 
		if(ch==1) {
			//this will read all books present in record
			b.readFile(bookList);
				
		}
		else if(ch==2) {
			//y=this is menu 2 if you choose to search by particular book
			System.out.println("1.SEARCH BY AUTHOR");
			System.out.println("2.SEARCH BY TOPIC");
			System.out.println("3.SEARCH BY PRICE");
			System.out.println("4.SEARCH BY PUBLISHER HOUSE");
			System.out.println("5.SEARCH BY ISBN NO.");
			System.out.print("Choose option :");
			
			boolean b2 = true;
			int[] options = new int[5];//this array will store options chosen from menu 2 in order
			int cop=0;//this variable will keep count of no of choices
			//the upcoming loop will control selection of choices
			while(b2 && cop<5) {
				int ch1 = 0;//this variable is used to enter choice from menu 2
				//this if condition will work after first choice is made and you want to add more filters
				if(cop>0) {
					boolean b1=true;
					while(b1) {
					    System.out.print("Enter Option other than previous:");
						ch1 = sk.nextInt();
						for (int i = 0; i < cop; i++) {
							b1=(options[i]==ch1) ? true:false;
							if(b1==true)
								break;
						}
					}
				}
				//this will work when first entry is going to be made
				else
					ch1=sk.nextInt();
				
				//now according to choice following code will work
				if(ch1 == 1) {
					System.out.print("Enter Author Name:");
					String author = sk1.nextLine();
					a=b.findBook(author, bookList, 2);//a will store array of isbn no of books of given author
					
				}
				else if(ch1==2) {
					System.out.print("Enter Topic:");
					String topic = sk1.nextLine();
					t=b.findBook(topic, bookList, 1);//a will store array of isbn no of books of given topic
				}
				else if(ch1==3) {
					System.out.print("Enter Max price:");
					int maxPrice = sk.nextInt();
					System.out.print("Enter Min price:");
					int minPrice = sk.nextInt();
					p=b.findBookByPrice(maxPrice, minPrice, bookList);//a will store array of isbn no of books of given price range
				}
				else if(ch1==4) {
					System.out.print("Enter Publisher House:");
					String pubHouse = sk1.nextLine();
					ph=b.findBook(pubHouse, bookList, 4);//a will store array of isbn no of books of given publisher house
				}
				else if(ch1==5) {
					System.out.print("Enter ISBN No.:");
					int isbn = sk.nextInt();
					is=b.findBookByIsbn(isbn, bookList);//a will store array of isbn no of books of given isbn no
				}
				else {
					System.out.println("Invalid option");//if invalid choice is entered
				}
				
				options[cop] = ch1;//here the current choice of filter is stored
				cop++;//keeping count of no of choices made
				//now this if is to ask user whether they want to add more filters or not
				if(cop<5) {
					System.out.print("Do You Want to Continue by adding more filters :");
					String c = sk1.nextLine();
					b2= (c.compareToIgnoreCase("y")==0)?true:false;
				}
			}
			
			//if more than one filter is used we will get more than one array 
			//so we need to pick out common element(s) from each array
			//we declare to arrays here 
			//reference array ref and temporary array temp
			//we take array obtained by first filter as reference array
			//all other subsequent array will be one by one stored in temp array in order to compare it with reference array
			//note temp array will be only used when more than 1 filter is used
			//assigning reference array ref since options array stores choice of filter in order
			//the element at 0 index of options array is used to assign it
			//only if more than 1 filter is used this comparision of ref and temp array will be done
			int[] ref = new int[noOfBooksInRecord];
			int[] temp = new int[noOfBooksInRecord];
			ref=(options[0]==1)?a:(options[0]==2)?t:(options[0]==3)?p:(options[0]==4)?ph:is;
			if(cop>1) {
				//this loop controls no of time comparision of array is done which is 
				//equals to no of choices made - 1.
				for (int i = 1; i < cop; i++) {
					int flag=0,f2=0;//both are flag values
					temp=(options[i]==1)?a:(options[i]==2)?t:(options[i]==3)?p:(options[i]==4)?ph:is; //assigning value to temporary array temp 
					for (int j = 0; j < ref.length; j++) // now the below nested for loop will check whether elements of ref array is present in temp array or not
					{
						flag=0;
						if(ref[j]!=0)//since if element is zero it is not isbn no so we dont check at zero 
						{
							for (int j2 = 0; j2 < temp.length; j2++) {
								if(ref[j]==temp[j2]) {
									flag++;
									f2++;
								}
							}
	
							if(flag==0)//if element is not present in temp array it will be assigned as zero as now it is not needed 
							{
								ref[j]=0;
							}
						}
						
						
					}
					if(f2==0) //if no element of ref array is present this means that no requires books will match books in record so no further need of comparing with other array
					{
						break;
					}
				}
			}
			Arrays.sort(ref);//sort array in assending order
			//it will reverse array and actually sort array in descending order
			for(int i=0;i<ref.length/2;i++) {
				int tem = ref[i];
				ref[i]=ref[ref.length-i-1];
				ref[ref.length-1-i]=tem;
			}
			FileInputStream fb = new FileInputStream(bookList);
			Scanner sc = new Scanner(fb);
			String com=",";
			int q=0;
			if(ref[q]!=0) {
				while(sc.hasNextLine()) //reading data of all books
				{
					String text = sc.nextLine();//reads individual book data
					String[] var1 = text.split(com);//splits a book data into array of string
					String s = String.valueOf(ref[q]);//it converts value of qth element of reference into string basically required isbn no to string
					if(var1[0].compareTo(s)==0) //if the current book elements matches with required book 
						{
						q++;//increment to check for next required book
						b.display(var1,q);//call of display function to show book details
					}
			    }
			}
			if(q==0) {
				System.out.println("NO BOOKS MATCHED WITH ENTERED DATA");
			}
			sc.close();
		}
		else
			System.out.println("Invalid option");
	}

}
