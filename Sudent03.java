package S1;

import java.sql.*;
import java.util.Arrays;

public class Student03 {
	static int[] markslist;

void display(String[] p1,int[] p2,float p3) {
	System.out.println("*******************************************************************************************");
	System.out.println("ROLL NO         : "+p2[0]);
	System.out.println("NAME            : "+p1[0]);
	System.out.println("STANDARD        : "+p1[1]);
	System.out.println("PHYSICS MARKS   : "+p2[1]);
	System.out.println("CHEMISTRY MARKS : "+p2[2]);
	System.out.println("MATHS MARKS     : "+p2[3]);
	System.out.println("TOTAL MARKS     : "+p2[4]);
	System.out.println("PERCENTAGE      : "+ p3);
	System.out.println("GRADE           : "+p1[2]);
	System.out.println("*******************************************************************************************");
}

void readAllRecords() throws Exception{
	String url="jdbc:mysql://127.0.0.1:3306/school";
	String user="root";
	String password="mypass1234";
	//Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, user, password);
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("Select * from student");
	String[] p1=new String[3];
	int[] p2 = new int[5];
	Student03 student03 = new Student03();
	while(rs.next()) {
		p2[0] = rs.getInt("Roll_no");
		p1[0] = rs.getString("Name");
		p1[1] = rs.getString("Standard");
		p2[1] = rs.getInt("Phys_marks");
		p2[2] = rs.getInt("Chem_marks");
		p2[3] = rs.getInt("Math_marks");
		p2[4] = rs.getInt("Total_marks");
		float pr = rs.getFloat("Percent");
		p1[2] = rs.getString("Grade");
		student03.display(p1, p2, pr);
	}
}

static int getMaxMarks(String ch1,String ch2) throws Exception {
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","mypass1234");
	Statement St = con.createStatement();
	String query = ch2+"("+ch1+")";
	int val=0;
	ResultSet rs = St.executeQuery("select "+query+" as max from student");
	while(rs.next()) {
		val = rs.getInt("max"); 
	}
	return val;
}


}
