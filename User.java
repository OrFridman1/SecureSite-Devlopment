package model;

/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class that defines the user object.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class User {
	 
	private String id;
	private String password;
	private String age;
	private String mail;
	private String height;
	private String weight;
	private String lastName;
	private String firstName;

	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public User(String id, String password){
		this.id = id;
		this.password = password;
		age=null;
		mail=null;
		height=null;
		weight=null;
		lastName=null;
		firstName=null;
	}
	
	public User(String id){
		this.id = id;
		password = null;
		age=null;
		mail=null;
		height=null;
		weight=null;
		lastName=null;
		firstName=null;
	}
 
	public String getId() {
		return id;
	}
 
	public void setId(String id) {
		this.id = id;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
}
