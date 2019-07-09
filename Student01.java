package S1;
import java.sql.*;
import java.util.Scanner;
public class Student01 {
	void addRecord() throws Exception {
		String url="jdbc:mysql://127.0.0.1:3306/school";
		String user="root";
		String password="mypass1234";
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		Scanner s1 =  new Scanner(System.in);
		Scanner s2 =  new Scanner(System.in);
		
		System.out.print("Enter Roll No:");
		int rn = s1.nextInt();
		
		System.out.print("Enter Name:");
		String nm = s2.nextLine();
		System.out.print("Enter Standard:");
		String std = s2.nextLine();
		System.out.print("Enter Marks Obtained in Physics:");
		int pn = s1.nextInt();
		System.out.print("Enter Marks Obtained in Chemistry:");
		int cn = s1.nextInt();
		System.out.print("Enter Marks Obtained in Maths:");
		int mn = s1.nextInt();
		
		int tm = pn +cn +mn;
		float p = (float) tm /3;
		String g = (p>=90)?"A":(p>=80)?"B":(p>=70)?"C":(p>=55)?"D":"E";
		
		st.executeUpdate("insert into student "
				+ "values('"+rn+"','"+nm+"','"+std+"','"+pn+"','"+cn+"','"+mn+"',"
						+ "'"+tm+"','"+p+"','"+g+"')");
		System.out.println("Record Added");
	}
	
	public static void main(String[] args) throws Exception {
		Student01 student01 = new  Student01();
		student01.addRecord();
	}

}
