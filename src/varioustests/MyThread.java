package varioustests;

public class MyThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t=new Thread(){
			public void run(){
				pong();
			}
		};
		t.run();
		System.out.println("ping");
		
	}
	
	static void pong(){
		System.out.println("pong");
	}
	

}
