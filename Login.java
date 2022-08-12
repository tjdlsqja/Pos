package Pos;

public class Login implements Admin{

	public static final Login login = new Login(); // login 싱글톤 객체
	
	private String password; //설정된 패스워드
	private String id;
	private String pw;
	private double sTime;
	private double eTime;
	private double pay;
	
	private Login() {
		this.password = "1234";
	}
	

	public static Login getInstance() {
		return login;
	}
	
	@Override
	public void changePassword() {
		// TODO Auto-generated method stub
		System.out.println("******************** Change Password ***********************");
		System.out.print("현재 PW를 입력하세요: ");
		this.pw = sc.nextLine();
		System.out.print("변경할 PW를 입력하세요: ");
		String tempPW = sc.nextLine();
		
		if(this.pw.equals(this.password)) {
			this.password = tempPW;
			System.out.println("패스워드가 변경되었습니다.");
		} else {
			System.out.println("현재 PW가 틀립니다. 다시 확인해주세요. ");
			changePassword();
		}
		
	}


	@Override
	public void login() {
		// TODO Auto-generated method stub
		boolean isLogin = false;
		while(!isLogin) {
			System.out.println("******************** Login ***********************");
			System.out.print("ID를 입력하세요: ");
			this.id = sc.nextLine();
			System.out.print("PW를 입력하세요: ");
			this.pw = sc.nextLine();
			if(id.equals(SSID) && pw.equals(password)) {
				System.out.println(USERNAME + "님 안녕하세요.");
				isLogin = true;
			} else {
				System.out.println("등록된 계정이 아닙니다. ID와 PW를 다시 확인해주세요.");
			}	
		}
	}
	
	
	
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		calculatePay();
		System.out.println(USERNAME + "님 오늘도 수고하셨습니다.");
		System.out.printf("예상 급여: %.2f원\n" ,getPay());
	}


	@Override
	public void setEndTime(long eTime) {
		// TODO Auto-generated method stub
		this.eTime = eTime;
	}

	@Override
	public void setStartTime(long sTime) {
		// TODO Auto-generated method stub
		this.sTime = sTime;
	}
	
	@Override
	public double getStartTime() {
		// TODO Auto-generated method stub
		return sTime;
	}

	@Override
	public double getEndTime() {
		// TODO Auto-generated method stub
		return eTime;
	}


	@Override
	public void calculatePay() {
		// TODO Auto-generated method stub
		double wTime = (eTime - sTime) / 3_600_000; // 근무한 시간
		this.pay = wTime * WAGE;
	}


	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return this.pay;
	}
}
