package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelMain {

	public static void work(String str) {
		try {
			Thread.sleep(2000);
			System.out.println(str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String [] ar = {"1", "2", "3", "4","5"};
		
		Stream <String> stream = Arrays.stream(ar);
		
		// 일반 스트림을 생성해서 ar에 work를 수행 - 10초 정도 걸림
		long start = System.currentTimeMillis();
		
		stream.forEach((data)->{work(data);});
		
		long end = System.currentTimeMillis();
		System.out.println("순차처리 :" + (end-start));
		
		//병렬 처리를 구현하기
		List <String> list = Arrays.asList(ar); //배열이 아니고 리스트여야 한다
		Stream <String> parallel = list.parallelStream(); //parallel이라는 스트림을 만들어서 리스트를 병렬스트림 구현
		
		start = System.currentTimeMillis();
		parallel.forEach((data)->{work(data);});
		end = System.currentTimeMillis();
		
		System.out.println("병렬처리 :" + (end-start));
		
		// 결론 : 데이터 모임을 가지고 작업할 때, 다른 데이터의 영향을 받지 않는다면 병렬처리가 시간면에선 이득이다.
		// 주의 : 단 순서대로 처리해야하면 병렬 처리를 하면 안된다.
		// ▶ 필터링 같은 경우 병렬처리에 최적화된 작업 : Map - Reduce 방식 
		// 각각의 데이터에서 작업을 처리하고 결과를 모아서 리턴
		
	}

}
