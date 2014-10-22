
public class SchoolUser {
	
	private String firstName;
	
	private String lastName;
	
	private	int schoolID;
	
	private String userName;
	
	private boolean adminUser;
	
	public SchoolUser(String frstName, String lstName, int schoolIDNumber, 
			String usrName, boolean userIsAdmin){
		firstName = frstName;
		lastName = lstName;
		schoolID = schoolIDNumber;
		userName = usrName;
		adminUser = userIsAdmin;
	}
	
	public void setName(String first, String last){
		firstName = first;
		lastName = last;
	}
	
	public void setAdminUser(boolean userIsAdmin){
		adminUser = userIsAdmin;
	}
	
	public void setSchoolID(int idNumber){
		schoolID = idNumber;
	}

	public void setUserName(String usrName){
		userName = usrName;
	}

	public String getName(){
		return firstName+" "+lastName;
	}
	
	public int getSchoolID(){
		return schoolID;
	}
	
	public String getUserName(){
		return userName;
	}

	public boolean isAdminUser(){
		return adminUser;
	}
}