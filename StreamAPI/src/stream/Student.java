package stream;

public class Student {
	
	// summary : private > constructor > getters and setters > toString
	
	// 1. DTO 클래스 만들기 : private으로 있는 속성 다 만들기
	private int num;
	private String name;
	private String gender;
	private int age;
	private int score;
	
	// ★★ 2. superclass로부터 생성자 만들기 & 필드값 사용해서 생성자 만들기
	// superclass는 왜? 데이터가 없는 경우에 사용할 생성자
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 이건 데이터가 제공되는 경우 - 테스트 할 때, 빠르게 입력 해보기 위해 사용
	public Student(int num, String name, String gender, int age, int score) {
		super();
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.score = score;
	}
	
	//★★3. Getters and setters : 접근자 메소드 만들기
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	//★★4. toString() : 데이터를 빠르게 확인하기 위한 메소드
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", gender=" + gender + ", age=" + age + ", score=" + score
				+ "]";
	}
	
	

	
}
