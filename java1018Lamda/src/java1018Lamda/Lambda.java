package java1018Lamda;

public class Lambda {

	public static void main(String[] args) {
     //Runnable 인터페이스를 이용해서 
		//스레드를 생성해서 실행 
		Thread th1 = new Thread(
				new Runnable() {
					public void run() {
						try {
							for(int i=0; i<10; i+=1) {
								Thread.sleep(1000);
								System.out.printf("Anonymous\n");
							}
						}catch(Exception e) {}
					}
				});
		th1.start();
		
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
		
	}

}
