package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReductionMain {

	public static void main(String[] args) {
		
		// 샘플 데이터 작성
		Student student1 = new Student(1, "바다", "여", 40, 100);
		Student student2 = new Student(2,"옥주현","여", 32, 90);
		Student student3 = new Student(3,"김종국","남", 37, 95);
		Student student4 = new Student(4,"조성모","남", 25, 92);
		Student student5 = new Student(5,"소찬휘", null , 45, 93);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);
		
		// distinct() : 중복을 제거해주는 메소드
		String [ ] ar = {"수서", "대전", "동대구", "부산", "동대구", "대전", "천안아산", "동탄", "지제", "수서"};
		Stream <String> stream = Arrays.stream(ar);
		stream.distinct().forEach(System.out::print); // distinct를 중간에 넣어버리면 중복을 없애준다 - 중간연산!
		System.out.println();
		
		// filter : 조건에 맞는 데이터만 추출하는 중간 연산
		// filter에는 매개변수 1개를 갖고 boolean을 리턴하는 람다식을 대입 (파이썬에서는 람다식 대신 함수식을 넣으면 됨)
		Stream <Student> studentstream = list.stream();
		//studentstream.filter((student) -> {return student.getScore()>=95;}).forEach(System.out::println); //predicate가 람다식 자리
		// student는 위에서 1,2,3,4,5 만든 인스턴스를 의미함
		studentstream.filter((student) -> {return student.getGender()=="남";}).forEach(System.out::println);
		System.out.println();
		
		// map() : 데이터를 변환할 때 사용하는 메소드
		// 숫자 > 문자열, 문자열 > 숫자, 날짜 > 문자열, 인스턴스 > 기본형 이럴때 사용한다!
		// student를 score로 바꿔보자
		Stream <Student> studentstream2 = list.stream();
		//studentstream2.mapToInt((student)->{return student.getScore();}).forEach(System.out::println);
		studentstream2.mapToInt(Student::getScore).forEach(System.out::println); // 특정 메소드만 수행할거면 클래스이름::메소드이름만 써도 된다!
		System.out.println();
		
		
		// sorted() : 데이터 정렬을 위한 메소드
		// 각 요소가 크기 비교가 가능하다면 바로 오름차순 정렬
		// 크기 비교가 불가능하다면 크기 비교가 가능한 메소드를 넣어야 함
		// 크기 비교가 가능하다? 자료형이 하나로 통일되어 있다.
		// 기본 자료형, 문자열, 날짜
		
		Stream<String> arStream = Arrays.stream(ar);
		try {
		arStream.sorted().forEach(System.out::println);
		}
		catch(Exception e)
		{
			System.err.println("에러 발생 : " +e.getMessage());
			e.printStackTrace();
		}
		
		
		System.out.println();
		
		// 크기 비교하는 메소드를 만들어서 정렬
		// 크기 비교를 할 때는 2개의 매개변수를 가지고 정수를 리턴하는 메소드를 만들면 됨
		// 앞의 데이터가 크면 양수!, 같으면 0, 앞이 작으면 음수!
		
		Stream <Student> studentstream3 = list.stream();
		studentstream3.sorted((a,b)->{return a.getScore() - b.getScore();}).forEach(System.out::println);
		System.out.println();
		
		// 문자열인 경우는 compareTo를 이용하자. (앞 뒤 순서를 바꾸면 내림차순 가능)
		Stream <Student> studentstream4 = list.stream();
		studentstream4.sorted((a,b)->{return a.getName().compareTo(b.getName());}).forEach(System.out::println);
		
	}//end

}
