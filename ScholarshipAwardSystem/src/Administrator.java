
public class Administrator extends SchoolUser {

	private String password;
	
	private String schoolDepartment;

	public Administrator(String frstName, String lstName, int schoolIDNumber, 
			String usrName, boolean userIsAdmin, String passwordEntry, String schoolDept){
		super(frstName,lstName,schoolIDNumber,usrName,userIsAdmin);
		password = passwordEntry;
		schoolDepartment = schoolDept;
	}
	
	public void setPassword(String passwordEntry){
		password = passwordEntry;
	}
	
	public void setSchoolDepartment(String schoolDept){
		schoolDepartment = schoolDept;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getSchoolDepartment(){
		return schoolDepartment;
	}

}
