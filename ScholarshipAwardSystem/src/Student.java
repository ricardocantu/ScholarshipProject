
public class Student extends SchoolUser{

	private String password;
	
	private String college;
	
	private boolean declaredMajor;
	
	private String major;
	
	private String classification;
	
	private double gpa;
	
	public Student(String frstName, String lstName, int schoolIDNumber,
			String usrName, boolean userIsAdmin, String passwordEntry,
			String studentCollege, boolean hasDeclaredMajor, String studentMajor,
			String studentClassification, double studentGPA) {
		
		super(frstName, lstName, schoolIDNumber, usrName, userIsAdmin);
		
		password = passwordEntry;
		college = studentCollege;
		declaredMajor = hasDeclaredMajor;
		major = studentMajor;
		classification = studentClassification;
		gpa = studentGPA;
	}
	
	public void setPassword(String studentPassword){
		password = studentPassword;
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
	
	public String getPassword(){
		return password;
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
	

}
