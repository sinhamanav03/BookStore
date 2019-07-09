	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://127.0.0.1:3306/school";
		String user="root";
		String password="mypass1234";
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
			else if(choice1==2){
				System.out.println("#MENU#");
				System.out.println("1.SHOW ALL STUDENT RECORDS");
				System.out.println("2.SEARCH BY CRITERIA");
				int choice2 = s1.nextInt();
				if(choice2==1) {
					Student03 student03 = new Student03();
					student03.readAllRecords();
				}
				else if(choice2==2){
					
					System.out.println("1. ROLL NO");
					System.out.println("2. NAME");
					System.out.println("3. STANDARD");
					System.out.println("4. MARKS OBTAINED IN PHYSICS");
					System.out.println("5. MARKS OBTAINED IN CHEMISTRY");
					System.out.println("6. MARKS OBTAINED IN MATHS");
					System.out.println("7. SEARCH BY TOTAL MARKS");
					System.out.println("8. SEARCH BY PERCENTAGE OBTAINED");
					System.out.println("9. GRADE OBTAINED");
					System.out.println("10.STUDENT WITH MOST MARKS");
					System.out.println("11.STUDENT WITH LEAST MARKS");
					boolean condition2 = true;
					while (condition2) {
						if(count_of_choices>0) {
							System.out.println();
							boolean condition3 =true;
							while (condition3) {
								System.out.print("ENTER POSSIBLE FILTER CHOICE:");
								options[count_of_choices]=s1.nextInt();
									for (int i = 0; i < count_of_choices; i++) {
										condition3 = (options[count_of_choices]==options[i])?true:false;
										if(condition3) {
											break;
									}
								}
							}
						}
						else
							options[count_of_choices]=s1.nextInt();
						
						if(options[count_of_choices]==1) {
							System.out.print("ENTER ROLL NO :");
							parameter1[count_of_choices]=s2.nextLine();
							parameter2[count_of_choices]="";
						}
						else if(options[count_of_choices]==2) {
							System.out.print("ENTER NAME :");
							parameter1[count_of_choices]=s2.nextLine();
							parameter2[count_of_choices]="";
						}
						else if(options[count_of_choices]==3) {
							System.out.print("ENTER STANDARD :");
							parameter1[count_of_choices]=s2.nextLine();
							parameter2[count_of_choices]="";
						}
						else if(options[count_of_choices]==4) {
							System.out.print("ENTER MINIMUM MARKS :");
							parameter1[count_of_choices]=s2.nextLine();
							System.out.print("ENTER MAXIMUM MARKS :");
							parameter2[count_of_choices]=s2.nextLine();
						}
						else if(options[count_of_choices]==5) {
							System.out.print("ENTER MINIMUM MARKS :");
							parameter1[count_of_choices]=s2.nextLine();
							System.out.print("ENTER MAXIMUM MARKS :");
							parameter2[count_of_choices]=s2.nextLine();
						}
						else if(options[count_of_choices]==6) {
							System.out.print("ENTER MINIMUM MARKS :");
							parameter1[count_of_choices]=s2.nextLine();
							System.out.print("ENTER MAXIMUM MARKS :");
							parameter2[count_of_choices]=s2.nextLine();
						}
						else if(options[count_of_choices]==7) {
							System.out.print("ENTER MINIMUM MARKS :");
							parameter1[count_of_choices]=s2.nextLine();
							System.out.print("ENTER MAXIMUM MARKS :");
							parameter2[count_of_choices]=s2.nextLine();
						}
						else if(options[count_of_choices]==8) {
							System.out.print("ENTER MINIMUM PERCENTAGE :");
							parameter1[count_of_choices]=s2.nextLine();
							System.out.print("ENTER MAXIMUM PERCENTAGE :");
							parameter2[count_of_choices]=s2.nextLine();
						}
						else if(options[count_of_choices]==9) {
							System.out.print("ENTER GRADE :");
							parameter1[count_of_choices]=s2.nextLine();
							parameter2[count_of_choices]="";
						}
						else if(options[count_of_choices]==10) {
					        System.out.println("YOU NEED TO ENTER PARMAETER FOR ENTERD OPERATTION::");
							System.out.println("1. MARKS OBTAINED IN PHYSICS");
							System.out.println("2. MARKS OBTAINED IN CHEMISTRY");
							System.out.println("3. MARKS OBTAINED IN MATHS");
							System.out.println("4. SEARCH BY TOTAL MARKS");
							System.out.println("5. SEARCH BY PERCENTAGE OBTAINED");
							int subf=0;
							boolean b3= true;
							int[] cf = {1,2,3,4,5};
							int flag10=0;
							while(b3) {
								System.out.print("ENTER PARAMETER FOR OPERATION : ");
								subf=s1.nextInt();
								for(int i=0;i<cf.length;i++) {
									if(subf ==cf[i]) {
										flag10=1;
										break;
									}
								}
								if(flag10==1) {
									b3= false;
								}
							}
							String ch2 = "Max";
							String ch1=(subf==1)?"Phys_marks":
								(subf==2)?"Chem_marks":(subf==3)?"Math_marks":(subf==4)?"Total_marks":"Percent";
							int val=Student03.getMaxMarks(ch1, ch2);
							
							parameter1[count_of_choices]=""+val;
							parameter2[count_of_choices]=ch1;
						}
						
						else if(options[count_of_choices]==11) {
					        System.out.println("YOU NEED TO ENTER PARMAETER FOR ENTERD OPERATTION::");
							System.out.println("1. MARKS OBTAINED IN PHYSICS");
							System.out.println("2. MARKS OBTAINED IN CHEMISTRY");
							System.out.println("3. MARKS OBTAINED IN MATHS");
							System.out.println("4. SEARCH BY TOTAL MARKS");
							System.out.println("5. SEARCH BY PERCENTAGE OBTAINED");
							int subf=0;
							boolean b3= true;
							int[] cf = {1,2,3,4,5};
							int flag10=0;
							while(b3) {
								System.out.print("ENTER PARAMETER FOR OPERATION : ");
								subf=s1.nextInt();
								for(int i=0;i<cf.length;i++) {
									if(subf ==cf[i]) {
										flag10=1;
										break;
									}
								}
								if(flag10==1) {
									b3= false;
								}
							}
							String ch2 = "Min";
							String ch1=(subf==1)?"Phys_marks":
								(subf==2)?"Chem_marks":(subf==3)?"Math_marks":(subf==4)?"Total_marks":"Percent";
							int val=Student03.getMaxMarks(ch1, ch2);
							
							parameter1[count_of_choices]=""+val;
							parameter2[count_of_choices]=ch1;
					        
						}
						count_of_choices++;
						if(count_of_choices<11) {
							System.out.println();
							System.out.println("DO YOU WANT TO CONTINUE ADING MORE FILTERS");
							String choice3 = s2.nextLine();
							condition2 =(choice3.compareToIgnoreCase("y")==0)?true:false;
						}
						else 
							condition2=false;
						
					}
					options = Arrays.copyOf(options, count_of_choices);
					String query ="";
					query = " where ";
					for (int i = 0; i < count_of_choices; i++) {
						if(true) {
							String op =(options[i]==1)?"Roll_no":(options[i]==2)?"Name":(options[i]==3)?"Standard":
								(options[i]==4)?"Phys_marks":(options[i]==5)?"Chem_marks":(options[i]==6)?"Math_marks":
									(options[i]==7)?"Total_marks":(options[i]==8)?"Percent":(options[i]==9)?"Grade":
										parameter2[i];
							
							if(options[i]>3 && options[i]<9) {
								query = query + op + " between "+ parameter1[i] +" and "+parameter2[i]; 
							}
							else if(options[i]==1||options[i]==2||options[i]==3||options[i]==9) {
								query = query + op + "=\'"+ parameter1[i]+ "\'";
							}
							else if(options[i]==10||options[i]==11) {
								query = query + op +"="+parameter1[i];
							}
							if(i<options.length-1) {
								query = query +" and ";
							}
						}
						
					}
										
					ResultSet rs = st.executeQuery("select * from student "+query);
					String[] p1=new String[3];
					int[] p2 = new int[5];
					Student03 student03 = new Student03();
					while(rs.next()) {
						p2[0] = rs.getInt("Roll_No");
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
				else {
					System.out.println("INVALID CHOICE");
				}
			}
			else {
				System.out.println("INVALID CHOICE");
			}
			
			
			System.out.println("DO YOU WANT TO CONTINUE");
			String choice = s2.nextLine();
			condition1=(choice.compareToIgnoreCase("y")==0)?true:false;
		}
		con.close();
	}
	

}
