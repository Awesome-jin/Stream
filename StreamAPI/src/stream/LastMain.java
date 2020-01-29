package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class LastMain {

	public static void main(String[] args) {
		
		//문자열 배열을 이용해서 스트림 생성
		String [] ar = {"Boston","NewYork","Seattle","LA","Vegas","Chicago","Sanfrancisco"};
		Stream <String> arstream = Arrays.stream(ar);
		
		//배열의 모든 데이터가 3글자 이상인지 확인 - LA 때문에 false
		boolean r = arstream.allMatch((language)->{return language.length()>3;});
		System.out.println(r);
		System.out.println();
		// anyMatch였다면? 1개라도 만족하면 true
		// noneMatch는 모두 만족을 안해야 true
		
		//집계함수를 사용해보자
		// 글자가 5개 이상인 데이터의 개수를 파악해보자
		Student student1 = new Student(1, "바다", "여", 40, 100);
		Student student2 = new Student(2,"옥주현","여", 32, 90);
		Student student3 = new Student(3,"김종국","남", 37, 95);
		Student student4 = new Student(4,"조성모","남", 25, 92);
		Student student5 = new Student(5,"소찬휘", "여", 45, 93);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);
		
		Stream <Student> stream2 = list.stream();
		// 점수의 합계 구하기
		int tot = stream2.mapToInt(Student::getScore).sum();
		System.out.println("합계: " + tot);
		System.out.println();
		
		// ★★★남자 나이의 평균만 구해보기
		Stream <Student> stream3 = list.stream();
		OptionalDouble tot2 = stream3.filter((student)->{return student.getGender().equals("남");}).mapToInt(Student::getAge).average();
		System.out.println("남자 나이의 평균: " + tot2.getAsDouble());
		// getAsDouble이면 결과가 null일때, 예외가 발생한다.
		// >> 이게 싫으면 orElse로 기본값을 설정해주면 된다.
		System.out.println();
		
		//데이터 개수 구하기
		Stream <Student> stream4 = list.stream();
		long cnt = stream4.filter((student)->{return student.getGender().equals("여");}).count();
		System.out.println("Student에서 여자 데이터의 개수: "+cnt);
		System.out.println();
		
		//max나 min은 Comparator.comparing 자료형(비교할 데이터의 메소드)를 대입하면 Optional<제너릭>으로 리턴함
		//Score의 최대값 구해보기
		Stream <Student> stream5 = list.stream();
		Optional <Student> result = stream5.filter((student)->{return student.getGender().equals("남");}).max(Comparator.comparingInt(Student::getScore));
		System.out.println("남자 최고 점수: " + result.get());
		}

}
