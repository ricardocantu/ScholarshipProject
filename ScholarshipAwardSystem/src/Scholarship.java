
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
        
        private String fileName;//File name wher scholarship is stored
        
        private String studInAward;
        
        private boolean empty;
	
        public Scholarship(){
            
            name = "";
            major = "";
            declaredMajor = false;
            minGPA = 0.00;
            minHrs = 0;
            classification = "";
            amount = 0;
            maxNumAwards = 0;
            currentNumStudents = 0;
            fileName = "";
            studInAward = "";
            empty = true;
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
        
        public void setCurrentNumStudents(int currentNumData){
            currentNumStudents = currentNumData;
            
        }
	
        public void setFileName(String fileNameData){
            fileName = fileNameData;
            
        }
        
        public void setStudInAward(String studentsInData){
            studInAward = studentsInData;
            
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
        
        public int getCurrentNumStudents(){
            return currentNumStudents;
        }
        
        public String getFileName(){
            return fileName;
        }
        
        public String getStudInAward(){
            return studInAward;
        }
        
        public boolean isEmpty(){
           
            if(!name.matches(""))
                if(!major.matches(""))
                    if(minGPA != 0.00)
                        if(minHrs != 0)
                            if(!classification.matches(""))
                                if(amount != 0)
                                    if(maxNumAwards != 0)
                                        empty = false;
            
            return empty;
            
        }
}
        