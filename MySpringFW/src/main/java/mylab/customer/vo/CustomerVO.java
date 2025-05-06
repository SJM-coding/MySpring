package mylab.customer.vo;


public class CustomerVO {
    private int id;
    private String email;
    private String name;
    private int age;
    private String entryDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age + ", entryDate="
				+ entryDate + "]";
	} 
    
    

}