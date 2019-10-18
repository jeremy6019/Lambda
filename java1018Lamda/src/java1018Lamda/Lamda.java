package java1018Lamda;

public class Lamda {
/*
 
**Lambda 
=>JDK1.7버전부터 지원 
=>이름없는 함수를 만들기 위해서 등장 
=>메소드가 1개인 인터페이스를 구현할 때 사용 
=>스트림 API에서 작업을 대입할 때 이용 
안드로이드의 이벤트 처리에 이용 

ex) Runnable인터페이스를 구현 
=>Runnable 인터페이스에는 public void run()메소드만 존재 
anonymous로  사용을 하고자 하면 
new Runnable(){
   public void run(){
       필요한 내용 작성 
   }
};

=>람다를 이용해서 작성
() ->{
     필요한 내용작성
} 

=>10초동안 1초마다 Hello Lambda를 출력하는 스레드를 생성해서 실행 
	Thread th2 = new Thread(
				()->{
					
					try {
						for(int i=0; i<10; i+=1) {
							Thread.sleep(1000);
							System.out.printf("Anonymous\n");
						}
					}catch(Exception e) {}
					
				}
				);
		th2.start();
		
       
** 함수적 스타일의 람다식 작성법 
 (자료형 매개변수,...)->{함수의 내용작성}
 =>매개변수의 자료형은 생략이 가능 - 함수가 실행될때 대입되는 매개변수를 가지고
 매개변수의 자료형을 유추해서 실행 
=>매개변수가 1개인 경우는 ()를 생략 가능 
없는 경우에는 생략을 못함 
=>실행하는 문장이 하나인 경우는 {}를 생략가능 
=>함수가 실행결과를 리턴해야하면 return문장을 만들면 됩니다. 

**자바에서 람다식으로 작성된 메소드 호출 
=>자바는 근본적으로 함수 단위로 호출이 안되기 때문에 람다식으로 작성한 문장을 
호출하려면 인터페이스 타입의 변수에 대입해서 사용 
=>아직까지는 일반 자바 프로그래밍에서는 람다를 잘 사용하지 않고 스트림 API와 
안드로이드에서 이벤트 핸들링하는 곳에만 주로 이용 

메소드가 1개인 인터페이스 변수 = 람다식;
변수.메소드()

로 람다식을 호출해야 합니다. 

**함수적 인터페이스 - JDK1.8부터 지원 
=>람다식을 사용할 수 있는 인터페이스 - 메소드가 1개인 인터페이스 
=>명시적으로 함수적인터페이스라는 것을 알려줄 때는 @FunctionalInterface라 
는 어노테이션을 인터페이스 선언문 위에 추가 
=>컴파일러가 컴파일을 할 때 메소드가 1개인지 확인을 해서 1개가 아니면 에러를 
발생시킵니다. 

=>매개변수가 없는 추상메소드를 가진 인터페이스
매개변수가 있는 추상메소드를 가진 인터페이스
리턴이 있는 추상메소드를 가진 인터페이스 
3개의 인터페이스를 만들고 람다를 이용해서 메소드를 구현하고 호출 
//메소드가 1개만 선언되어 있는지 확인해주는 어노테이션 
@FunctionalInterface
interface Lamda1{
	public void method();
}

@FunctionalInterface
interface Lamda2{
	public void method(int i);
}

@FunctionalInterface
interface Lamda3{
	public int method(int i, int j);
}

public class Lambda2 {

	public static void main(String[] args) {
		Lamda1 lam1 = () -> {
			System.out.printf(
					"매개변수 없는 람다\n");
		};
		lam1.method();

		Lamda2 lam2 = i ->{
			for(int x = 0; x < i; x+=1) {
				System.out.printf(
						"매개변수가 있는 람다\n");
			}
		};
		lam2.method(10);
	
		Lamda3 lam3 = (i,j) ->{
			return (i+j)/2;			
		};
		int result = lam3.method(5, 8);
		System.out.printf("result:%s\n", result);
		
	}

}

=>자바의 람다난 스위프트의 클로저의 단점은 가독성을 떨어뜨립니다. 

**JDK1.8부터 메소드의 이름을 매개변수로 넘길 수 있습니다. 
=>Collection에 이런 메소드가 존재 
=>List의 forEach메소드는 매개변수로 메소드를 받아서 모든 요소를 메소드의 
매개변수로 전달해서 실행합니다. 
반복문을 사용할 필요가 없기 때문에 코드가 간결해 집니다. 
public class Lambda3 {

	public static void main(String[] args) {
		//문자열을 저장하는 List를 생성하고 
		//데이터를 저장 
		List<String> list = 
				new ArrayList<String>();
		list.add("Swift");
		list.add("Android");
		list.add("Scalla");
		list.add("Java");
		list.add("Object C");
		
		//위의 데이터를 순서대로 하나씩 출력 
		//List의 함수를 매개변수로 대입해서 
		//List의 모든 데이터를 함수의 매개변수로 
		//대입해서 실행 
		//이 기능은 C언어를 제외한 거의 모든 프로그래밍
		//언어에 존재하는 기능인데 대부분은 map이라 
		//합니다. 
		list.forEach(System.out::println);
		
		
		
	}

} 

  **JDK1.8에서 제공하는 함수적 인터페이스 
  1.Consumer:매개변수가 있고 리턴값은 메소드를 소유 
  =>출력을 위해서 사용 
  
  2.Supplier:매개변수는 없고 리턴값만 있는 메소드를 소유 
  => 데이터 전체를 변환하기 위해서 사용 
  
  3.Function:매개변수가 있고 리턴값도 있는 메소드를 소유 
  =>데이터를 가공할 때 사용 
   
  4.Operator:매개변수가 있고 리턴값도 있는 메소드를 소유하고 있는데 
  매개변수를 연산해서 리턴값을 만들어 줍니다.
  =>데이터를 연산한 결과를 만들 때 사용 
   
  5.Predicate:매개변수가 있고 리턴이 boolean 
  =>조건에 맞는 데이터만 필터링할 때 사용 
  
  
 
 */

}