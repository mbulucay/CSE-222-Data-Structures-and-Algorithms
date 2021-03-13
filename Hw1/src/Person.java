
public abstract class Person {

	private String name;
	private String surname;
	private String email;
	private String password;

	Person(String _name,String _surname, String _email, String _password){
		setName(_name);
		setSurname(_surname);
		setEmail(_email);
		setPassword(_password);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String _surname) {
		surname = _surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String _email) {
		email = _email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String _password) {
		password = _password;
	}
}
