package shop.servies.user.test;

import shop.servies.user.Client;

public class ClientTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = new Client("홍길동", "한양", 1111, false);
		System.out.println(client.getName());
		
		// client 안의 모든 정보를 확인해주고 싶은데 모든걸 다 get메서드로 받아오면 너무 귀찮음.
		// SOP 안에 레퍼런스를 찍으면 toString이 오버라이딩 되어있는 구조 생각!
		// 그러므로 Client 클래스에서 toString을 오버라이딩 해주면 모든 상태값을 다 확인할 수 있음
		// Object 안의 toString 메소드를 다른 클래스에서 오버라이딩 하면 : 상태값을 리턴해주는 메소드
		
		System.out.println("모든정보확인 : " + client);
	}
}