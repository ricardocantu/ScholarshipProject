public class Student extends SchoolUser{

		private String college;
		private boolean declaredMajor;
		private String major;
		private String classification;
		private double gpa;
		private int hoursTaken;
		private boolean hasAward;
                private String currentAward;
	
		public Student(){
			super();
			college = "";
			declaredMajor = false;
			major = "";
			classification = "";
			gpa = 0;
                        currentAward = "";
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
		
		public void setHasAward(boolean hasAwardData){
			hasAward = hasAwardData;
		}
                
                public void setCurrentAward(String currentAwardName){
                    currentAward = currentAwardName;
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
                
                public String getCurrentAward(){
                    return currentAward;
                }
	}