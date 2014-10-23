
public class Scholarship {

	private String name;//Award name
	
	private String major;//Student's major criteria
	
	private boolean declaredMajor;//Check if student has declared major
	
	private double minGPA;//Studuent's minimum GPA criteria
	
	private int minHrs;//Student's minimum hours criteria
	
	private String classification;//Student classification criteria
	
	private int amount;//award amount
	
	private int maxNumAwards;//Max number of awards available for student
	
	private int currentNumStudents;//added students 
	
	
	public Scholarship(String awardName, String awardMajor, boolean hasDeclaredMajor, double awardMinGPA,
			int awardMinHrs, String awardClassification, int awardAmount, int numOfAwardsAvail){
		
		name = awardName;
		major = awardMajor;
		declaredMajor = hasDeclaredMajor;
		minGPA = awardMinGPA;
		minHrs = awardMinHrs;
		classification = awardClassification;
		amount = awardAmount;
		maxNumAwards = numOfAwardsAvail;
	}
	
	public void setName(String awardName){
		name = awardName;
	}
	
	public void setMajor(String awardMajor){
		major = awardMajor;
	}
	
	public void setDeclaredMajor(boolean hasDeclaredMajor){
		declaredMajor = hasDeclaredMajor;
	}
	
	public void setMinGPA(double awardMinGPA){
		minGPA = awardMinGPA;
	}
	
	public void setMinHrs(int awardMinHrs){
		minHrs = awardMinHrs;
	}
	
	public void setClassification(String awardClassification){
		classification = awardClassification;
	}
	
	public void setAmount(int awardAmount){
		amount = awardAmount;
	}
	
	public void setMaxNumAwards(int numOfAwardsAvail){
		maxNumAwards = numOfAwardsAvail;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMajor(){
		return major;
	}
	
	public boolean hasDeclaredMajor(){
		return declaredMajor;
	}
	
	public double getMinGPA(){
		return minGPA;
	}
	
	public int getMinHrs(){
		return minHrs;
	}
	
	public String getClassification(){
		return classification;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public int getMaxNumAwards(){
		return maxNumAwards;
	}
	
	//Checks if there is more awards available for students
	public boolean noMoreAwards(){
		if(currentNumStudents>=maxNumAwards){
			return true;
		}
		else
			return false;
	}
	
	//Add to the number of current students of this award and return String stating if able to or not
	public String addCurrentNumStudents(){
		
		if(currentNumStudents<maxNumAwards){
			currentNumStudents++;
			return name+" added.";
		}
		else
			return "Award is full please try another one or check later for availability";
	}
	
	//If student or administrator removes award 
	//it reduces the current amount of students for scholarship availability
	public void removeStudent(){
		
		if(currentNumStudents>0)
			currentNumStudents--;
		else
			currentNumStudents = 0;	
	}
	
	
	
	
}
