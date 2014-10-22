
public class Scholarship {

	private String name;
	
	private String major;
	
	private double minGPA;
	
	private int minHrs;
	
	private String classification;
	
	private int amount;
	
	private int maxNumAwards;
	
	private int currentNumStudents;
	
	private boolean noMoreAwards;
	
	
	public Scholarship(String awardName, String awardMajor, double awardMinGPA,
			int awardMinHrs, String awardClassification, int awardAmount, int numOfAwardsAvail){
		
		name = awardName;
		major = awardMajor;
		minGPA = awardMinGPA;
		minHrs = awardMinHrs;
		classification = awardClassification;
		amount = awardAmount;
		maxNumAwards = numOfAwardsAvail;
		
		if(currentNumStudents>0){
			currentNumStudents++;
		}
		else{
			currentNumStudents = 1;
		}
	}
	
	public void setName(String awardName){
		name = awardName;
	}
	
	public void setMajor(String awardMajor){
		major = awardMajor;
	}
	
	public void setMinGPA(double awardMinGPA){
		minGPA = awardMinGPA;
	}
	
	public void setMinHrs(int awardMinHrs){
		minHrs = awardMinHrs;
	}
	
	
	
	//Checks if there is more awards available for students
	public boolean noMoreAwards(){
		if(currentNumStudents>=maxNumAwards){
			return true;
		}
		else
			return false;
	}
	
	//If remove a student reduce the current amount of students for scholarship availability
	public void removeStudent(){
		
		if(currentNumStudents>0)
			currentNumStudents--;
		else
			currentNumStudents = 0;	
	}
	
	
	
	
}
