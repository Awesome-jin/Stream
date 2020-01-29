package stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Collection {

	public static void main(String[] args) {
		
		// List의 데이터를 사용
		
		// 배열을 이용해서 list 만들기
		List <String> list = Arrays.asList("C", "Python", "Java");

		//인덱스를 이용해서 하나씩 접근 - 배열이나 list의 데이터 개수를 알아야 함
		System.out.println("= 1.인덱스를 이용해 하나씩 접근하는 방법 =");
		int length = list.size();
		int i = 0;
		while(i<length) {
			String temp = list.get(i);
			System.out.println(temp);
			i = i+1;
		}
		System.out.println();
		
		System.out.println("= 2.반복자(Iterator-Enumeration)를 이용해 접근하는 방법 =");
		// 데이터 개수를 알 필요가 없다
		Iterator<String> iterator = list.iterator();
		
		// 다음 데이터 존재 여부를 확인하고 다음 데이터에 접근 > DB에서는 Cursor라고 부름
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		
		System.out.println("= 3.빠른열거(for-each)를 이용해 접근하는 방법 =");
		//반복자가 구현된 객체의 경우는 빠른 열거를 사용하는 것이 가능
		for(String imsi : list) {
			System.out.println(imsi);
		}
		System.out.println();
		
		System.out.println("= NEW 4.스트림을 이용해 접근하는 방법 =");
		Stream<String> stream = list.stream(); //스트림을 생성해주기
		
		// 람다식을 이용해 메소드의 내용을 매개변수로 대입 - 함수형 프로그래밍이라 불리는 이유
		stream.forEach((name)->{System.out.println(name);});
		// 설명1. 반복문을 사용하지 않아도 for each를 알아서 순서대로 실행함
		// 설명2. 스트림을 만들 때 사용한 Collection의 데이터를 name에 순서대로 대입해서 {   } 안의 내용을 수행
		System.out.println();
		
		System.out.println("= 배열을 이용해서 스트림 생성 =");
		//실제로는 리스트를 더 많이 쓴다 >> 외부에서 불러오는 경우 데이터 개수를 알 수 없는 경우가 많기 때문
		
		
		// =============실전같이 파일 읽어오는 연습 =============
		//1. 파일의 내용을 읽어올거면 try-catch 셋팅부터 한다.
		try {
			// 2. 파일을 읽어올 수 있는 스트림을 만든다 br > isr > fis
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./corona.csv")));
			
			// 3. 한 줄을 읽어온다
			String line = br.readLine();
			
			// 4. '  ,   ' 단위로 분할해서 문자열 배열로 만들어보자
			String [] ar = line.split(",");
			Stream <String> stream1 = Arrays.stream(ar);  // 스트림을 만들기
			stream1.forEach(System.out::println); // 출력하기 
			// 빠른 열거를 써도 되지만 >> 메모리를 많이 써도 나중에 병렬처리를 시키거나 자료형이 리스터여도 유지보수가 쉬워서 더 편하다.
			
			/*
			for(String imsi : ar) {
				System.out.print(imsi + "\t");
			}
			*/ 	
			
			br.close();
			
		}
		catch(Exception e){
			System.err.println("읽어오기 실패: " + e);
			e.printStackTrace();
		}
		
		
		
	}//end

}
