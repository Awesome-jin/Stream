package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectMain {

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
		
		Stream <Student> stream = list.stream();
		//gender의 값이 남인 데이터만 가지고 list를 만들어보기
		List <Student> manList=
				stream.filter((student)->{return student.getGender().equals("남");})
				.collect(Collectors.toList());
		for (Student temp : manList) {
			System.out.println(temp);
		}
		System.out.println();
		
		//gender의 값이 여인 데이터를 가지고 name을 키로 전체를 value로 하는 Map을 생성
		Stream <Student> stream2 = list.stream();
		//gender의 값이 남인 데이터만 가지고 list를 만들어보기
		Map <String, Student> womanMap=
				stream2.filter((student)->{return student.getGender().equals("여");})
				.collect(Collectors.toMap(Student::getName, (student)->{return student;}));
		
		//Map의 모든 데이터 출력
		Set <String> keys = womanMap.keySet();
		for(String key : keys) {
			System.out.println(key + ":" + womanMap.get(key));
		}
		System.out.println();
		
		
				
	}

}
