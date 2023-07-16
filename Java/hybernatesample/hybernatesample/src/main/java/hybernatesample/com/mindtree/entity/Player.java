package hybernatesample.com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
	@Id
    @Column(name = "jersynumber")
	private int jersyno;
	
	@Column(name = "firstName")
	private String firstName;
	
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "age")
	private int age;

	public Player(int jersyno, String firstName, String lastName, int age) {
		this.jersyno = jersyno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getJersyno() {
		return jersyno;
	}

	public void setJersyno(int jersyno) {
		this.jersyno = jersyno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
