package java1018Lamda;

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
		
	    Lamda3 lam4 = new Lamda3() {
	    	public int method(int i, int j) {
	    	    return (i+j)/2;
	        }
	   };
	
	int result = lam3.method(5, 8);
	System.out.printf("result:%s\n", result);
	
		
	}

}
