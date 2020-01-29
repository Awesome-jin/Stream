package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingMain {

	public static void main(String[] args) {
		
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
		
		//List를 Stream으로 변환
		Stream <Student> stream = list.stream();
		
		//Stream으로 그룹화 (리턴 타입이 맵)
		//Task1. 성별로 리스트를 만들어 보여주자
		Map<String, List<Student>> map = stream.collect(Collectors.groupingBy(Student::getGender));
		Set <String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + ":" + map.get(key));
		}
		
		System.out.println();
		
		//스트림은 한 번 하면 소모하면 소멸하니까 다시 비슷한 작업 할거면 스트림은 다시 만들자
		stream = list.stream();
		// 그룹화는 존재하는 메소드를 이용해도 되지만 람다로 직접 만들어도 상관 없음
		// 하나의 매개변수(스트림의 제너릭)를 받아서 데이터를 리턴하는 람다식
		
		// Task2. 성별로 그룹화 해서 Score의 평균을 구해보자
		Map<String, Double> map2 =stream.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getScore)));
		Set <String> keys2 = map2.keySet();
		for(String key : keys2) {
			System.out.println(key + ":" + map2.get(key));
		}
		System.out.println();
		
		// Task3. 성별 최소값을 출력해보자
		stream = list.stream();
		Map<String, Optional<Student>> result =stream.collect(Collectors.groupingBy(Student::getGender, Collectors.maxBy(Comparator.comparingInt(Student::getScore))));
		keys = result.keySet();
		for(String key : keys) {
			System.out.println(key + ":" + result.get(key).get()); //optional 없애고 싶으면 .get() 넣기
		}
	}

}
