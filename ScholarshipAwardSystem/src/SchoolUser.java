
public class SchoolUser {
	
	private boolean adminUser;//to check if it is an administrator
	
	private String firstName;
	
	private String lastName;
	
	private	int schoolID;
	
	private String userName;
	
	
	public SchoolUser(){
		firstName = "";
		lastName = "";
		schoolID = 0;
		userName = "";
		adminUser = false;
	}
	
	public void setFirstName(String first){
		firstName = first;
	}
	
	public void setLastName(String last){
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

	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
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