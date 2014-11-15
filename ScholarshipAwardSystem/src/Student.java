public class Student extends SchoolUser{

		private String college;
		private boolean declaredMajor;
		private String major;
		private String classification;
		private double gpa;
		private int hoursTaken;
		private boolean hasAward;
	
		//Mock erase later
		public Student(){
			super(false, "", "", 0, "");
			
			
			college = "";
			declaredMajor = false;
			major = "";
			classification = "";
			gpa = 0;
		}
		//erase top mock
		
		public Student(String frstName, String lstName, int schoolIDNumber,
			String usrName, String studentCollege, 
			boolean hasDeclaredMajor, String studentMajor,String studentClassification, 
			double studentGPA,int hoursTakenData, boolean hasScholarshipData) {
		
			super(false, frstName, lstName, schoolIDNumber, usrName);
		
			college = studentCollege;
			declaredMajor = hasDeclaredMajor;
			major = studentMajor;
			classification = studentClassification;
			gpa = studentGPA;
			hoursTaken = hoursTakenData;
			hasAward = hasScholarshipData;
		}
	
		
		public void setCollege(String studentCollege){
			college = studentCollege;
		}
	
		public void setDeclaredMajor(boolean declared){
			declaredMajor = declared;
		}
	
		public void setMajor(String studentMajor){
			major = studentMajor;
		}
	
		public void setClassification(String studentClassification){
			classification = studentClassification;
		}	
		
		public void setGPA(double studentGPA){
			gpa = studentGPA;
		}

		public void setHoursTaken(int hoursData){
			hoursTaken = hoursData;
		}
		
		public void setHasScholarship(boolean hasScholarshipData){
			hasAward = hasScholarshipData;
		}
	
		public String getCollege(){
			return college;
		}
	
		public boolean hasDeclaredMajor(){
			return declaredMajor;
		}
	
		public String getMajor(){
			return major;
		}
	
		public String getClassification(){
			return classification;
		}
	
		public double getGPA(){
			return gpa;
		}
		
		public int getHoursTaken(){
			return hoursTaken;
		}
		
		public boolean hasScholarship(){
			return hasAward;
		}
	}