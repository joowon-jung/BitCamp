package shop.servies.user;

public class Client {

	///Field
	private String name;
	protected String add; 
	int age;
	public boolean gender;
	public static final String nationality = "대한민국";
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String name, String add, int age, boolean gender) {
		super();
		this.name = name;
		this.add = add;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	// 오버라이딩 => source 통해 생성
	@Override
	public String toString() {
		return "Client [name=" + name + ", add=" + add + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
