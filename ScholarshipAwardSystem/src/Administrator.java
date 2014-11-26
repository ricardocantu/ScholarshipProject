
public class Administrator extends SchoolUser {

	private String password;
	
	private String schoolDepartment;
	
	private String adminTitle;
	
	public Administrator(){
		super();
		password = "";
		schoolDepartment = "";
		adminTitle = "";
	}
	
	public void setPassword(String passwordEntry){
		password = passwordEntry;
	}
	
	public void setSchoolDepartment(String schoolDept){
		schoolDepartment = schoolDept;
	}
	
	public void setAdminTitle(String titleOfAdmin){
		adminTitle = titleOfAdmin;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getSchoolDepartment(){
		return schoolDepartment;
	}
	
	public String getAdminTitle(){
		return adminTitle;
	}

}
