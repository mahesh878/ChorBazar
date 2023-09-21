
//import javax.jws.soap.SOAPBinding;
import java.util.*;

//class for colors 
class Colors {
	static void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
		}
	}

	// colors
	static final String red = "\u001B[31m";
	static final String green = "\u001B[32m";
	static final String magent = "\u001B[95m";
	static final String blue = "\u001B[34m";
	static final String purple = "\u001B[35m";
	static final String cyan = "\u001B[36m";
	static final String black = "\u001B[30m";
	static final String yellow = "\u001B[93m";

	// color reset
	static final String reset = "\u001B[0m";

	// Background colors
	static final String bwhite = "\u001B[107m";
	static final String bgreen = "\u001B[42m";

	// background color reset
	static String breset = "\u001B[49m";

	// underline
	static final String ul = "\u001B[4m";

	// underline reset
	static final String rstul = "\u001B[24m";

	// blinking
	static final String blink = "\u001B[5m";

	// reset blinking
	static final String rstblink = "\u001B[0m";

	// italic
	static final String ital = "\u001B[3m";

}

// class for using setter and getter methods to reset username and password
class UserSignup {
	private String username = "";
	private String password = "";
	private long MobileNumber;
	private String key = "";

	void setUsername(String username) {
		this.username = username;
	}

	void setPassword(String password) {
		this.password = password;
	}

	void setMobileNumber(long MobileNumber) {
		this.MobileNumber = MobileNumber;
	}

	void setKey(String key) {
		this.key = key;
	}

	String getUsername() {
		return username;
	}

	String getPassword() {
		return password;
	}

	long getMobileNumber() {
		return MobileNumber;
	}

	String getkey() {
		return key;
	}
}

// class for log in
class UserLogin {
	static int status_login = 0;
	static int status_signup = 0;
	static int status_initial = 0;
	static Scanner sc = new Scanner(System.in);
	static UserSignup user_signup_obj = new UserSignup();

	void initial() {
		// initialize new user name
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print(Colors.purple + "\t\t\t\t\t\t\t\tEnter a new username :: " + Colors.reset);
		String newUsername = sc.nextLine();
		System.out.println();
		// initialize new password
		System.out.print(Colors.purple + "\t\t\t\t\t\t\t\tEnter a new password :: " + Colors.reset);
		String newPassword = sc.nextLine();
		System.out.println();
		// setting username and password
		user_signup_obj.setUsername(newUsername);
		user_signup_obj.setPassword(newPassword);
		status_initial = 1;
	}

	void signUp() {
		// initialize phone number
		System.out.print(Colors.purple + "\t\t\t\t\t\t\t\tEnter your mobile number :: " + Colors.reset);
		String new_Mobile = sc.nextLine();
		long newMobile = Long.parseLong(new_Mobile);
		System.out.println();
		// initialize private key
		System.out.println(Colors.blink + "" + Colors.cyan
				+ "\t\t\t\t\t\t\t\t*Private Key Set Only at the time of account creation\n\t\t\t\t\t\t\t\t*if you forgot this key u may loose your account\n\t\t\t\t\t\t\t\t*this key helps you at the time of miss match phone number"
				+ Colors.reset + "" + Colors.rstblink);
		System.out.println();
		System.out.print(Colors.purple + "\t\t\t\t\t\t\t\tPrivate Key :: " + Colors.reset);
		String key = sc.nextLine();
		// setting password, mobilenumber
		user_signup_obj.setMobileNumber(newMobile);
		user_signup_obj.setKey(key);
		System.out.println();
		System.out.println(Colors.blink + Colors.green + "\t\t\t\t\t\t\t\t\t\tSignUp Successful!\n\t\t\t\t\t\t\t\t"
				+ Colors.reset + Colors.rstblink);
		status_signup = 1;
	}

	void logIn() {
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\tLOG IN");
		System.out.print("\t\t\t\t\t\t\t\tEnter Username :: ");
		String u_name = sc.nextLine();
		System.out.println();
		System.out.print("\t\t\t\t\t\t\t\tEnter Password :: ");
		String u_pwd = sc.nextLine();
		if (user_signup_obj.getUsername().equals(u_name) && user_signup_obj.getPassword().equals(u_pwd)) {
			System.out.println("\t\t\t\t\t\t\t\tLogIn Successful!");
			status_login = 1;
		} else {
			System.out.println();
			System.out.print(
					"\t\t\t\t\t\t\t\tInvalid Username or Password\n\t\t\t\t\t\t\t\t1.ReEnter\n\t\t\t\t\t\t\t\t2.Reset Credentials\n\t\t\t\t\t\t\t\t0.Back to SignUp Page :: ");
			String opt2 = sc.nextLine();
			int opt_2 = Integer.parseInt(opt2);
			if (opt_2 == 1)
				logIn();
			else if (opt_2 == 2) {
				System.out.println();
				System.out.print("\t\t\t\t\t\t\t\tEnter MobileNumber :: ");
				String m_no = sc.nextLine();
				long mno = Long.parseLong(m_no);
				if (mno == user_signup_obj.getMobileNumber()) {
					UserLogin otp_obj = new UserLogin();
					while (true) {
						int otp = otp_obj.otp();
						System.out.println("\t\t\t\t\t\t\t\tOTP :: " + otp);
						System.out.print("\t\t\t\t\t\t\t\tEnter OTP ::");
						String dotp = sc.nextLine();
						int d_otp = Integer.parseInt(dotp);
						if (d_otp == otp) {
							initial();
							System.out.println("\t\t\t\t\t\t\t\tReset Credentials Successful!");
							System.out.println("\t\t\t\t\t\t\t\tBack to LogIn");
							logIn();
							break;
						} else {
							System.out.println();
							System.out.println("\t\t\t\t\t\t\t\tInvalid OTP Please ReEnter");
						}
					}
				} else if (user_signup_obj.getMobileNumber() != 0L) {
					System.out.println();
					System.out.println("\t\t\t\t\t\t\t\tInvalid MobileNumber");
					System.out.println();
					while (true) {
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Private Key to reset :: ");
						String pkey = sc.nextLine();
						if (pkey.equals(user_signup_obj.getkey())) {
							System.out.println(
									"\t\t\t\t\t\t\t\tPrivat Key is Correct\n\t\t\t\t\t\t\t\tReset Your Credentials");
							initial();
							System.out.println("\t\t\t\t\t\t\t\tReset Credentials Successful!");
							System.out.println("\t\t\t\t\t\t\t\tBack to LogIn");
							break;
						} else {
							System.out.println();
							System.out.print(
									"\t\t\t\t\t\t\t\tInvalid Key\n\t\t\t\t\t\t\t\t1.ReEnter\n\t\t\t\t\t\t\t\t2.Create New Account :: ");
							String opt3 = sc.nextLine();
							int opt_3 = Integer.parseInt(opt3);
							if (opt_3 == 2) {
								initial();
								signUp();
								break;
							}

						}
					}
				} else if (user_signup_obj.getMobileNumber() == 0L) {
					System.out.print(
							"\t\t\t\t\t\t\t\tUser Not Found\n\t\t\t\t\t\t\t\t1.Create New User\n\t\t\t\t\t\t\t\t0.exit :: ");
					String opt4 = sc.nextLine();
					int opt_4 = Integer.parseInt(opt4);
					if (opt_4 == 1) {
						initial();
						signUp();
					} else
						UserLogin.status_login = 2;
				}

			} else {
				UserLogin.status_login = 2;
				User.User_login();
			}
		}

	}

	int otp() {
		int randomNumber;
		// Create a Random object
		Random random = new Random();
		// Generate a random 6-digit number
		int min = 100_000; // Minimum value for a 6-digit number
		int max = 999_999; // Maximum value for a 6-digit number
		randomNumber = random.nextInt(max - min + 1) + min;
		return randomNumber;
	}

}

// class for Electronics
class Electronics {
	static Scanner sc = new Scanner(System.in);
	static String cart = "";
	static double amount_electronics;
	static Electronics electronics_obj = new Electronics();
	static String quantity;
	static String optforaddcart = "";
	static int opt_for_addcart = 0;
	static int quantity_mobiles;
	static String optforbuynow;
	static int opt_for_buynow;
	static User u_obj = new User();
	static Bill bill_obj = new Bill();
	static String address = "";

	void mobiles() {
		System.out.println();
		System.out.println("\t\t\t\t\t\t1.Samsung Galaxy W21 \t- \t24,000\r\n" + //
				"\t\t\t\t\t\t2.Huawei Mate X2 \t- \t20,000\r\n" + //
				"\t\t\t\t\t\t3.Huawei Mate X2 4G \t- \t21,000\r\n" + //
				"\t\t\t\t\t\t4.Xiami Mi Mix Alpha \t- \t19,000\r\n" + //
				"\t\t\t\t\t\t5.Huawei Mate  \t\t- \t18,000\r\n" + //
				"\t\t\t\t\t\t6.Samsung W2019 \t- \t18,000\r\n" + //
				"\t\t\t\t\t\t7.Samsung W22 5g \t- \t17,000\r\n" + //
				"\t\t\t\t\t\t8.Samsung Galzy Z  \t- \t17,999\r\n" + //
				"\t\t\t\t\t\t9.Apple iPhone 14  \t- \t45,000\r\n" + //
				"\t\t\t\t\t1\t10.Apple iPhone 15 \t- \t55,000  ");
		System.out.println();
		System.out.println("\n\t\t\t\t\t\t\t\t0.Back To Electronics");
		System.out.print("\t\t\t\t\t\t\t\tEnter Your Option : ");
		String optformobiles = sc.nextLine();
		int opt_for_mobiles = Integer.parseInt(optformobiles);
		int total;
		switch (opt_for_mobiles) {
			case 1:
				System.out.println("\n\t\t\t\t\t\t\t\tSamsung Galaxy W21\r\n" + //
						"\t\t\t\t\t\t\t\t-------------------\r\n" + //
						"\t\t\t\t\t\t\t\ttDisplay (Primary)   :  7.60-inch (1768x2208)\r\n" + //
						"\t\t\t\t\t\t\t\tProcessor           :  Qualcomm Snapdragon 865+\r\n" + //
						"\t\t\t\t\t\t\t\tFront Camera        :  10MP + 10MP\r\n" + //
						"\t\t\t\t\t\t\t\tRear Camera         :  12MP + 12MP + 12MP\r\n" + //
						"\t\t\t\t\t\t\t\tRAM                 :  12GB\r\n" + //
						"\t\t\t\t\t\t\t\tStorage             :  512GB\r\n" + //
						"\t\t\t\t\t\t\t\tBattery Capacity    :  4500mAh\r\n" + //
						"\t\t\t\t\t\t\t\tOS                  :  Android 10\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);

				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\n\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 24000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Samsung Galaxy W21!24,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Samsung Galaxy W21!24,000#" + quantity + "@" + total + "&";
						System.out.println();
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobles \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1) {
							b_obj.billDisplay();
						} else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 2:
				total = 0;
				System.out.println("Huawei Mate X2\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)   :  6.45-inch (1160x2700)\r\n" + //
						"Processor           :  HiSilicon Kirin 9000\r\n" + //
						"Front Camera        :  16MP\r\n" + //
						"Rear Camera         :  50MP + 16MP + 12MP + 8MP\r\n" + //
						"RAM                 :  8GB, 12GB\r\n" + //
						"Storage             :  256GB, 512GB\r\n" + //
						"Battery Capacity    :  4500mAh\r\n" + //
						"OS                  :  Android 10\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobles \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 20000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Huawei Mate X2!20,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();

					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Huawei Mate X2!20,000#" + quantity + "@" + total + "&";
						System.out.println();
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press any Key to Exit\n");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1) {
							b_obj.billDisplay();
						} else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 3:
				total = 0;
				System.out.println("Huawei Mate X2 5G\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)   :  6.45-inch (1160x2700)\r\n" + //
						"Processor           :  HiSilicon Kirin 9000\r\n" + //
						"Front Camera        :  16MP\r\n" + //
						"Rear Camera         :  50MP + 16MP + 12MP + 8MP\r\n" + //
						"RAM                 :  8GB, 12GB\r\n" + //
						"Storage             :  256GB, 512GB\r\n" + //
						"Battery Capacity    :  4500mAh\r\n" + //
						"OS                  :  Android 10\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 21000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Huawei Mate X2 4G!21,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Huawei Mate X2 4G!21,000#" + quantity + "@" + total + "&";
						System.out.println();
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobles \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1) {
							b_obj.billDisplay();
						} else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 4:
				total = 0;
				System.out.println("Xiaomi Mi Mix Alpha\r\n" + //
						"---------------------\r\n" + //
						"Display (Primary)    :  7.92-inch (2088x2250)\r\n" + //
						"Processor            :  Qualcomm Snapdragon 855+\r\n" + //
						"Front Camera         :  No\r\n" + //
						"Rear Camera          :  108MP + 12MP + 20MP\r\n" + //
						"RAM                  :  12GB\r\n" + //
						"Storage              :  512GB\r\n" + //
						"Battery Capacity     :  4050mAh\r\n" + //
						"OS                   :  Android\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 19000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Xiami Mi Mix Alpha!19,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Xiami Mi Mix Alpha!19,000#" + quantity + "@" + total + "&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 5:
				total = 0;
				System.out.println("Huawei Mate 40 RS Porsche Edition\r\n" + //
						"-----------------------------------\r\n" + //
						"Display (Primary)    :  6.76-inch (1344x2772)\r\n" + //
						"Processor            :  HiSilicon Kirin 9000\r\n" + //
						"Front Camera         :  13MP\r\n" + //
						"Rear Camera          :  50MP + 20MP + 12MP + 8MP\r\n" + //
						"RAM                  :  8GB, 12GB\r\n" + //
						"Storage              :  256GB, 512GB\r\n" + //
						"Battery Capacity     :  4400mAh\r\n" + //
						"OS                   :  Android 10\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 18000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Huawei Mate 40 RS Porseche Edition!18,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Huawei Mate 40 RS Porseche Edition!18,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobiles\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1) {
							bill_obj.billDisplay();
						} else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 6:
				total = 0;
				System.out.println("Samsung W2019\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  4.20-inch (1080x1920)\r\n" + //
						"Processor            :  Qualcomm Snapdragon 845\r\n" + //
						"Front Camera         :  8MP\r\n" + //
						"Rear Camera          :  12MP + 12MP\r\n" + //
						"RAM                  :  6GB\r\n" + //
						"Storage              :  128GB\r\n" + //
						"Battery Capacity     :  3070mAh\r\n" + //
						"OS                   :  Android 8.1 Oreo\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 18000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Samsung W2019!18,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Samsung W2019!18,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobiles \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1) {
							bill_obj.billDisplay();
						} else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 7:
				total = 0;
				System.out.println("Samsung W22 5G\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  7.60-inch (2208x1768)\r\n" + //
						"Processor            :  Octa-core\r\n" + //
						"Front Camera         :  10MP + 4MP\r\n" + //
						"Rear Camera          :  12MP + 12MP + 12MP\r\n" + //
						"RAM                  :  12GB, 16GB\r\n" + //
						"Storage              :  256GB, 512GB\r\n" + //
						"Battery Capacity     :  4400mAh\r\n" + //
						"OS                   :  Android\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 17000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Samsung W2019 5g!17,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Samsung W2019 5g!17,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobiles \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)

							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 8:
				total = 0;
				System.out.println("Samsung Galaxy Z Fold 2\r\n" + //
						"------------------------\r\n" + //
						"Display (Primary)    :  7.60-inch (1768x2208)\r\n" + //
						"Processor            :  Qualcomm Snapdragon 865+\r\n" + //
						"Front Camera         :  10MP + 10MP\r\n" + //
						"Rear Camera          :  12MP + 12MP + 12MP\r\n" + //
						"RAM                  :  12GB\r\n" + //
						"Storage              :  256GB\r\n" + //
						"Battery Capacity     :  4500mAh\r\n" + //
						"OS                   :  Android 10\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 15000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Samsung W2019!15,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Samsung W2019!15,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobiles \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 9:
				total = 0;
				System.out.println("Apple iPhone 14\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  6.06-inch (1170x2532)\r\n" + //
						"Processor            :  Apple A15 Bionic\r\n" + //
						"Front Camera         :  12MP\r\n" + //
						"Rear Camera          :  12MP + 12MP\r\n" + //
						"Storage              :  128GB, 256GB, 512GB\r\n" + //
						"OS                   :  iOS 16\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 45000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += " Apple iPhone 14 Pro Max GOLD!45000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Apple iPhone 14 Pro Max GOLD!45000#" + quantity + "@" + total + "&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;
			case 10:
				total = 0;
				System.out.println("Apple iPhone 15\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  6.06-inch\r\n" + //
						"Rear Camera          :  Unspecified + 48MP\r\n" + //
						"RAM                  :  8GB\r\n" + //
						"OS                   :  iOS\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 55000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += " Apple iPhone 14 Pro Max GOLD!55,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Apple iPhone 14 Pro Max GOLD!55,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobiles \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							mobiles();
					}
				} else if (opt_for_addcart == 3)
					mobiles();
				break;

			case 0:
				electronics();
				break;
			default:
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				mobiles();

		}
	}

	void laptops() {

		System.out.println("1. Acer Aspire 5 Gaming Laptop \t- \t65,000\r\n" + //
				"2. HP Laptop 15s \t\t- \t70,000\r\n" + //
				"3. HP 255 G8 \t\t\t- \t72,000\r\n" + //
				"4. Jio Book 11 \t\t\t- \t68,000\r\n" + //
				"5. Jio Book 12 \t\t\t- \t78,000\r\n" + //
				"6. ASUS Vivobook 14 \t\t- \t58,000\r\n" + //
				"7. Lenovo IdeaPad 3\t \t- \t50,000\r\n" + //
				"8. HP Laptop 14s \t\t- \t57,000\r\n" + //
				"9. Asus VivoBook 14 mini \t- \t40,000\r\n" + //
				"10. DELL chrome edition \t- \t56,000\r\n" + //
				"");
		System.out.println("\n\t\t\t\t\t\t\t\t0.Back");
		System.out.println("\t\t\t\t\t\t\t\tEnter Your Option : ");
		String optforlaptops = sc.nextLine();
		int opt_for_laptops = Integer.parseInt(optforlaptops);
		int total;
		switch (opt_for_laptops) {
			case 1:
				total = 0;
				System.out.println("Acer Aspire 5 Gaming Laptop\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        Acer\r\n" + //
						"Model Name:                   Aspire 5 Gaming\r\n" + //
						"Screen Size:                  15.6 Inches\r\n" + //
						"Colour:                       Gray\r\n" + //
						"Hard Disk Size:               512 GB\r\n" + //
						"CPU Model:                    Core i5\r\n" + //
						"RAM Memory Installed Size:    8 GB\r\n" + //
						"Operating System:             Windows 11 Home\r\n" + //
						"Special Feature:              Support CNVi interface\r\n" + //
						"Graphics Card Description:    Dedicated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 65000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Acer Aspire 5 Gaming Laptop!65,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Acer Aspire 5 Gaming Laptop!65,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 2:
				total = 0;
				System.out.println("HP Laptop 15s\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        HP\r\n" + //
						"Model Name:                   15s-du3612TU\r\n" + //
						"Screen Size:                  39.6 Centimetres\r\n" + //
						"Colour:                       Natural Silver\r\n" + //
						"Hard Disk Size:               1 TB\r\n" + //
						"CPU Model:                    Core i3\r\n" + //
						"RAM Memory Installed Size:    8 GB\r\n" + //
						"Operating System:             Windows 11 Home\r\n" + //
						"Special Feature:              FHD, Numeric Keypad\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 70000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "HP Laptop 15s!70,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "HP Laptop 15s!70,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 3:
				total = 0;
				System.out.println("HP 255 G8\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        HP\r\n" + //
						"Model Name:                   HP 255 G8\r\n" + //
						"Screen Size:                  15.6 Inches\r\n" + //
						"Hard Disk Size:               1 TB\r\n" + //
						"CPU Model:                    Ryzen 3 3250U\r\n" + //
						"RAM Memory Installed Size:    8 GB\r\n" + //
						"Operating System:             Windows\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						"Graphics Coprocessor:         AMD Radeon Vega 8\r\n" + //
						"CPU Speed:                    2.6 GHz\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 72000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "HP 255 G8!72,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "HP 255 G8!72,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 4:
				total = 0;
				System.out.println("Jio Book 11\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        Jio\r\n" + //
						"Model Name:                   JioBook\r\n" + //
						"Screen Size:                  11.6 Inches\r\n" + //
						"Colour:                       JioBlue\r\n" + //
						"Hard Disk Size:               64 GB\r\n" + //
						"CPU Model:                    Others\r\n" + //
						"RAM Memory Installed Size:    4 GB\r\n" + //
						"Operating System:             JioOS\r\n" + //
						"Special Feature:              Multi-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity KeyboardMulti-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity Keyboard, See more\r\n"
						+ //
						"Graphics Card Description:    Integrated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 68000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Jio Book 11!68,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Jio Book 11!68,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 5:
				total = 0;
				System.out.println("Jio Book 12\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        Jio\r\n" + //
						"Model Name:                   JioBook\r\n" + //
						"Screen Size:                  11.6 Inches\r\n" + //
						"Colour:                       JioBlue\r\n" + //
						"Hard Disk Size:               64 GB\r\n" + //
						"CPU Model:                    Others\r\n" + //
						"RAM Memory Installed Size:    4 GB\r\n" + //
						"Operating System:             JioOS\r\n" + //
						"Special Feature:              Multi-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity KeyboardMulti-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity Keyboard, See more\r\n"
						+ //
						"Graphics Card Description:    Integrated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_laptops == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 78000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Jio Book 12!78,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else {
						amount_electronics += total;
						cart += "Jio Book 12!78,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mobiles\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 2)
					laptops();
				break;
			case 6:
				total = 0;
				System.out.println("ASUS Vivobook 14\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        ASUS\r\n" + //
						"Model Name:                   Vivobook 14\r\n" + //
						"Screen Size:                  15.6 Inches\r\n" + //
						"Colour:                       Transparent Silver\r\n" + //
						"Hard Disk Size:               512 GB\r\n" + //
						"CPU Model:                    Celeron\r\n" + //
						"RAM Memory Installed Size:    8 GB\r\n" + //
						"Operating System:             Windows 11 Home\r\n" + //
						"Special Feature:              Fingerprint Reader\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 58000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "ASUS Vivobook 14!58,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "ASUS Vivobook 14!58,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							System.out.println("OK");
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 7:
				total = 0;
				System.out.println("Lenovo IdeaPad 3\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        Lenovo\r\n" + //
						"Model Name:                   IdeaPad 3 15ITL6\r\n" + //
						"Screen Size:                  15.6 Inches\r\n" + //
						"Colour:                       Arctic Grey\r\n" + //
						"Hard Disk Size:               512 GB\r\n" + //
						"CPU Model:                    Core i5\r\n" + //
						"RAM Memory Installed Size:    16 GB\r\n" + //
						"Operating System:             Windows 11 Home\r\n" + //
						"Special Feature:              Anti Glare Screen, Backlit Keyboard, Thin, Built-in Microphone\r\n"
						+ //
						"Graphics Card Description:    Integrated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 50000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Lenovo IdeaPad 3!50,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Lenovo IdeaPad 3!50,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 8:
				System.out.println("HP Laptop 14s\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        HP\r\n" + //
						"Model Name:                   HP Laptop 14s-fq1083AU\r\n" + //
						"Screen Size:                  14 Inches\r\n" + //
						"Colour:                       Natural Silver\r\n" + //
						"CPU Model:                    Ryzen 7\r\n" + //
						"RAM Memory Installed Size:    8 GB\r\n" + //
						"Operating System:             Windows 10 Home\r\n" + //
						"Special Feature:              Fingerprint Reader, Backlit Keyboard, Anti Glare Coating, Memory Card Slot\r\n"
						+ //
						"Graphics Card Description:    Integrated\r\n" + //
						"Graphics Coprocessor:         AMD Radeon Graphics\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 57000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "HP Laptop 14s!57,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "HP Laptop 14s!57,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 9:
				total = 0;
				System.out.println("Asus VivoBook 14 mini\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        ASUS\r\n" + //
						"Model Name:                   Vivobook Go 14 (2023)\r\n" + //
						"Screen Size:                  14 Inches\r\n" + //
						"Colour:                       Mixed Black\r\n" + //
						"Hard Disk Size:               512 GB\r\n" + //
						"CPU Model:                    Ryzen 3\r\n" + //
						"RAM Memory Installed Size:    8 GB\r\n" + //
						"Operating System:             Windows 11 Home\r\n" + //
						"Special Feature:              Anti Glare Coating\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 40000;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Asus VivoBook 14 mini!40,000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Asus VivoBook 14 mini!40,000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							System.out.println("OK");
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;
			case 10:
				total = 0;
				System.out.println("DELL chrome edition\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        HP\r\n" + //
						"Model Name:                   Chromebook\r\n" + //
						"Screen Size:                  14 Inches\r\n" + //
						"Colour:                       White\r\n" + //
						"Hard Disk Size:               64 GB\r\n" + //
						"CPU Model:                    Celeron N4020\r\n" + //
						"RAM Memory Installed Size:    4 GB\r\n" + //
						"Operating System:             Chrome OS\r\n" + //
						"Special Feature:              Touchscreen, Micro-Edge\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Laptops\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 56000;
					if (opt_for_addcart == 2) {
						cart = "";
						amount_electronics = total;
						cart += "DELL chrome edition!56000#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "DELL chrome edition!56000#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Laptops\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							laptops();
					}
				} else if (opt_for_addcart == 3)
					laptops();
				break;

			case 0:
				electronics();
				break;
			default:
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				mobiles();
		}
	}

	void earphones() {

		System.out.println("1. Boult Audio Z40 True Wireless \t\t- \t1,199\r\n" + //
				"2. truke \t\t\t\t\t- \t1,499\r\n" + //
				"3. Sony WI-XB400 Wireless \t\t\t- \t2,796\r\n" + //
				"4. Boult Audio FXCharge \t\t\t- \t799\r\n" + //
				"5. OnePlus Bullets Z2 Bluetooth Wireless \t- \t1,999\r\n" + //
				"6. boAt Rockerz 255 \t\t\t\t- \t1,099\r\n" + //
				"7. JBL Endurance Run \t\t\t\t- \t699\r\n" + //
				"8. Vibez by Lifelong 2-in-1 Wireless \t\t- \t1,699\r\n" + //
				"9. Zebronics Yoga N2 RGB \t\t\t- \t999\r\n" + //
				"10. Wecool N1 High Bass ENC Neckband Earphones\t- \t799\r\n" + //
				"");
		System.out.println("\n\t\t\t\t\t\t\t\t0.Back");
		System.out.println("\t\t\t\t\t\t\t\tEnter Your Option : ");
		String optforearphones = sc.nextLine();
		int opt_for_earphones = Integer.parseInt(optforearphones);
		int total = 0;
		switch (opt_for_earphones) {
			case 1:
				total = 0;
				System.out.println("Boult Audio Z40 True Wireless\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   Boult Audio\r\n" + //
						"Model Name:              Z40\r\n" + //
						"Colour:                  Z40 Blue\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Wireless\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 1199;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Boult Audio Z40 True Wireless!1,199#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Boult Audio Z40 True Wireless!1,199#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);

						if (opt_for_buynow == 1)
							bill_obj.billDisplay();

						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 2:
				total = 0;
				System.out.println("Truke Buds BTG 1 Bluetooth\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   Truke\r\n" + //
						"Model Name:              BTG 1\r\n" + //
						"Colour:                  Black\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Wireless\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total += quantity_mobiles * total;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = 1499;
						cart += "truke!1,499#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "truke!1,499#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 3:
				total = 0;
				System.out.println("Sony WI-XB400 Wireless\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   Sony\r\n" + //
						"Model Name:              Headphones\r\n" + //
						"Colour:                  Blue\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Bluetooth 5.0\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 2796;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Sony WI-XB400 Wireless!2,796#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sony WI-XB400 Wireless!2,796#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 4:
				total = 0;
				System.out.println("Boult Audio FXCharge\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   Boult Audio\r\n" + //
						"Model Name:              ProBass\r\n" + //
						"Colour:                  FXCharge Black\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Bluetooth 5.2\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 799;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Boult Audio FXCharge!799#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Boult Audio FXCharge!799#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 5:
				System.out.println("OnePlus Bullets Z2 Bluetooth Wireless\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   OnePlus\r\n" + //
						"Model Name:              OnePlus Bullets Wireless Z2\r\n" + //
						"Colour:                  Black\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Wireless, Bluetooth v5\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 1999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "OnePlus Bullets Z2 Bluetooth Wireless!1,999#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "OnePlus Bullets Z2 Bluetooth Wireless!1,999#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 6:
				total = 0;
				System.out.println("boAt Rockerz 255 Pro+");
				System.out.println("----------------------------------------------");
				System.out.println("Brand:\t\t\t BoAt");
				System.out.println("Model Name:\t\t Rockerz 255 Pro+");
				System.out.println("Colour:\t\t\t Active Black");
				System.out.println("Form Factor:\t\t In Ear");
				System.out.println("Connectivity Technology:\t Bluetooth 5.0");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 1099;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "boAt Rockerz 255!1,099#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "boAt Rockerz 255!1,099#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 7:
				total = 0;
				System.out.println("JBL Endurance Run\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   JBL\r\n" + //
						"Model Name:              Endurance RunBT\r\n" + //
						"Colour:                  Black\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Bluetooth\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 699;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "JBL Endurance Run!699#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "JBL Endurance Run!699#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 8:
				total = 0;
				System.out.println("Vibez by Lifelong 2-in-1 Wireless & Wired Earphones\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   Vibez\r\n" + //
						"Model Name:              Duos\r\n" + //
						"Colour:                  Black\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Wireless\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 1699;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Vibez by Lifelong Earphones!1,699#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();

					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Vibez by Lifelong Earphones!1,699#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}

				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 9:
				total = 0;
				System.out.println("Zebronics Yoga N2 RGB\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                   ZEBRONICS\r\n" + //
						"Model Name:              ZEB-YOGA N2 (Black)\r\n" + //
						"Colour:                  Black\r\n" + //
						"Form Factor:             In Ear\r\n" + //
						"Connectivity Technology: Bluetooth 5.2\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Zebronics Yoga N2 RGB!999#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Zebronics Yoga N2 RGB!999#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;
			case 10:
				total = 0;
				System.out.println("Wecool N1 High Bass ENC Neckband Earphones\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                         Wecool\r\n" + //
						"Colour:                        Black\r\n" + //
						"Form Factor:                   In Ear\r\n" + //
						"Connectivity Technology:       Wireless\r\n" + //
						"Wireless Communication Tech:   Bluetooth\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 799;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Wecool N1 High Bass Earphones!799#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Wecool N1 High Bass Earphones!799#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							earphones();
					}
				} else if (opt_for_addcart == 3)
					earphones();
				break;

			case 0:
				electronics();
				break;
			default:
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				earphones();
		}
	}

	void televisions() {

		System.out.println("1.Sony Bravia 55-inch XR Series 4K UHD Smart OLED Google TV \t\t- \t1,24,990\r\n" + //
				"2. Sony Bravia 65-inch 4K UHD Smart TV\t\t\t\t\t-\t77,990\r\n" + //
				"3. Vu 65-inch The Masterpiece Glo Series 4K UHD Smart Android QLED TV \t- \t81,990\r\n" + //
				"4. Acer 65-inch I Series 4K UHD Android Smart TV \t\t\t- \t45,999\r\n" + //
				"5. LG 43-inch 4k UHD Smart LED TV \t\t\t\t\t- \t30,490\r\n" + //
				"6. Samsung 50-inch Crystal iSmart 4K UHD Smart LED TV\t\t\t-\t45,990\r\n" + //
				"7. OnePlus 32-inch Y Series HD Ready LED Smart TV \t\t\t- \t12,999\r\n" + //
				"8. Mi 40 inches 5A Series FHD Smart Android LED TV\t\t\t- \t20,999\r\n" + //
				"9. Xiaomi A Series L32M8-5AIN 32 inch\t\t\t\t\t- \t12,999\r\n" + //
				"10. Xiaomi Smart TV X Series 55 inch\t\t\t\t\t- \t36,999\r\n" + //
				"");
		System.out.println("\n\t\t\t\t\t\t\t\t0.Back");
		System.out.println("\t\t\t\t\t\t\t\tEnter Your Option : ");
		String optfortelevisions = sc.nextLine();
		int opt_for_televisions = Integer.parseInt(optfortelevisions);
		int total;
		switch (opt_for_televisions) {
			case 1:
				total = 0;
				System.out.println("Sony Bravia 55-inch XR  TV\r\n" + //
						"---------------------------------------------------------\r\n" + //
						"Screen Size                :  55 Inches\r\n" + //
						"Brand                      :  Sony\r\n" + //
						"Supported Internet Services:  Netflix, Prime Video, Zee5, Eros Now, JioCinema\r\n" + //
						"Display Technology         :  OLED\r\n" + //
						"Product Dimensions         :  5.3D x 122.7W x 71.2H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  120 Hz\r\n" + //
						"Special Feature            :  Built-In Speaker, Smart TV, Voice Assistant, Browser\r\n" + //
						"Model Name                 :  55A80J\r\n" + //
						"Included Components        :  1 LED TV, 1 Warranty Card, 1 AC Power Cord\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 124990;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Sony Bravia 55-inch TV!1,24,990#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sony Bravia 55-inch TV!1,24,990#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 2:
				total = 0;
				System.out.println("Sony Bravia 65-inch 4K UHD Smart TV\r\n" + //
						"------------------------------------\r\n" + //
						"Screen Size                :  65 Inches\r\n" + //
						"Brand                      :  Sony\r\n" + //
						"Supported Internet Services:  Netflix, Amazon Prime Video, Disney+ Hotstar, Sony Liv, Zee5, Voot, Hoichoi & many More\r\n"
						+ //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  8.7D x 146.3W x 85.2H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  60 Hz\r\n" + //
						"Special Feature            :  Google TV | Watchlist | Voice Search | Google Play | Chromecast | Netflix | Amazon Prime Video | Additional Features: Apple Airplay | Apple Homekit | AlexaGoogle TV | Watchlist | Voice Search | Google Play | Chromecast | Netflix | Amazon Prime Video | Additional Features: Apple Airplay | Apple Homekit | Alexa\r\n"
						+ //
						"Model Name                 :  KD-65X74K\r\n" + //
						"Included Components        :  1 LED TV, 1 Warranty Card, 1 AC Power Cord, 1 Remote Control, 1 Table-Top Stand, 1 User Manual, 2 AAA Batteries1 LED TV, 1 Warranty Card, 1 AC Power Cord, 1 Remote Control, 1 Table-Top Stand, 1 User Manual, 2 AAA Batteries\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 77990;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Sony Bravia 65-inch 4K UHD Smart TV!77,990#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else {
						amount_electronics += total;
						cart += "Sony Bravia 65-inch 4K UHD Smart TV!77,990#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 3:
				total = 0;
				System.out.println("Vu 65-inch The Masterpiece Glo Series 4K UHD Smart Android QLED TV\r\n" + //
						"-------------------------------------------------------------------\r\n" + //
						"Screen Size                :  65 Inches\r\n" + //
						"Brand                      :  VU\r\n" + //
						"Supported Internet Services:  Netflix, Prime Video, Zee5, SonyLiv, Youtube, Spotify, Hotstar, Google Play Movies & TV, Browser\r\n"
						+ //
						"Display Technology         :  QLED\r\n" + //
						"Product Dimensions         :  30.6D x 144.7W x 90.6H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  120 Hz\r\n" + //
						"Model Name                 :  Vu Masterpiece\r\n" + //
						"Included Components        :  1-TV Unit, Remote Control, Power Cord, User Manual, Table Mount Stand, VESA Wall Mount Bracket, 2 AAA Batteries1-TV Unit, Remote Control, Power Cord, User Manual, Table Mount Stand, VESA Wall Mount Bracket, 2 AAA Batteries\r\n"
						+ //
						"Connectivity Technology    :  Wi-Fi, USB, Ethernet, HDMI\r\n" + //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 81990;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Vu 65-inch The Masterpiece Glo Series 4K UHD Smart Android QLED TV!81,990#" + quantity
								+ "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Vu 65-inch The Masterpiece Glo Series 4K UHD Smart Android QLED TV!81,990#" + quantity
								+ "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 4:
				total = 0;
				System.out.println("Acer 65-inch I Series 4K UHD Android Smart TV\r\n" + //
						"----------------------------------------------\r\n" + //
						"Screen Size                 :  65 Inches\r\n" + //
						"Brand                       :  Acer\r\n" + //
						"Supported Internet Services :  Netflix, Prime Video, Zee5, Eros Now, JioCinema, SonyLiv, Youtube, Hungama, Google Play Store, Hotstar\r\n"
						+ //
						"                            :  Netflix, Prime Video, Zee5, Eros Now, JioCinema, SonyLiv, Youtube, Hungama, Google Play Store, Hotstar\r\n"
						+ //
						"Display Technology          :  LED\r\n" + //
						"Product Dimensions          :  8.5D x 144.6W x 83.1H Centimeters\r\n" + //
						"Resolution                  :  4K\r\n" + //
						"Refresh Rate                :  60 Hz\r\n" + //
						"Special Feature             :  Certified Android 11, Dolby Vision-Atmos, Dual Band Wifi, Blue Light Reduction, MEMC, Dynamic Signal Calibration, Wide Colour Gamut+, 1.07 Billion Colours, HDR10+ with HLG, 4K Upscaling, Digital Noise Reduction, Micro Dimming | Apps: Netflix, Youtube, Prime Video, Hotstar, SonyLiv, Hungama, JioCinema, Zee5, Eros Now, Google Play Store\r\n"
						+ //
						"                            :  Certified Android 11, Dolby Vision-Atmos, Dual Band Wifi, Blue Light Reduction, MEMC, Dynamic Signal Calibration, Wide Colour Gamut+, 1.07 Billion Colours, HDR10+ with HLG, 4K Upscaling, Digital Noise...\r\n"
						+ //
						"Model Name                  :  AR65AR2851UDFL\r\n" + //
						"Included Components         :  1 LED TV, 1 Remote, 2 AAA Battery, 1 User Manual, 2 Table Top Stands, 4 Screws\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 45999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Acer 65-inch I Series 4K UHD Android Smart TV !45,999#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Acer 65-inch I Series 4K UHD Android Smart TV !45,999#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 5:
				total = 0;
				System.out.println("LG 43-inch 4k UHD Smart LED TV\r\n" + //
						"------------------------------\r\n" + //
						"Screen Size                 :  43 Inches\r\n" + //
						"Brand                       :  LG\r\n" + //
						"Supported Internet Services :  Netflix, Prime Video, Zee5, Many more, Voot, SonyLIV, Discovery+, Youtube, YuppTV, Apple TV, Disney+ Hotstar\r\n"
						+ //
						"                            :  Netflix, Prime Video, Zee5, Many more, Voot, SonyLIV, Discovery+, Youtube, YuppTV, Apple TV, Disney+ Hotstar\r\n"
						+ //
						"Display Technology          :  LED\r\n" + //
						"Product Dimensions          :  18.7D x 97.3W x 57.2H Centimeters\r\n" + //
						"Resolution                  :  4K\r\n" + //
						"Refresh Rate                :  60 Hz\r\n" + //
						"Special Feature             :  WebOS 22 with User Profiles | Filmmaker Mode, HDR 10 Pro & HLG | Game Optimizer, ALLM, HGIG Mode | Unlimited OTT Apps | AI Brightness Control, 4K Upscaling & AI Sound (Virtual Surround 5.1 up-mix)\r\n"
						+ //
						"                            :  WebOS 22 with User Profiles | Filmmaker Mode, HDR 10 Pro & HLG | Game Optimizer, ALLM, HGIG Mode | Unlimited OTT Apps | AI Brightness Control, 4K Upscaling & AI Sound (Virtual Surround 5.1\u2026\r\n"
						+ //
						"Model Name                  :  UHD TV\r\n" + //
						"Included Components         :  1 UHD 4K TV, 1 Table Top Stand, 1 User Manual, 1 Warranty Card, 1 Remote Control, 2 Batteries\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 19999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "LG 43-inch 4k UHD Smart LED TV!30,490#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "LG 43-inch 4k UHD Smart LED TV!30,490#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 6:
				total = 0;
				System.out.println("Samsung 50-inch Crystal iSmart 4K UHD Smart LED TV\r\n" + //
						"--------------------------------------------------\r\n" + //
						"Screen Size                :  50 Inches\r\n" + //
						"Brand                      :  Samsung\r\n" + //
						"Supported Internet Services:  Netflix, Prime Video, Zee5, SonyLiv, Youtube, Hotstar\r\n" + //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  6D x 111.7W x 64.4H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  50 Hz\r\n" + //
						"Special Feature            :  Smart TV Features: Supported apps: Netflix, Prime Video, YouTube, etc., Screen mirroring, Universal Guide, Media Home, Tap View, Mobile Camera Support, AI Speaker, Easy Setup, App Casting, Wireless DeX, SmartThings, Smart Hub, IoT Sensor, Web Browser\r\n"
						+ //
						"                           :  Smart TV Features: Supported apps: Netflix, Prime Video, YouTube, etc., Screen mirroring, Universal Guide, Media Home, Tap View, Mobile Camera Support, AI Speaker, Easy Setup, App Casting, Wireless DeX\u2026\r\n"
						+ //
						"Model Name                 :  UA50CUE60AKLXL\r\n" + //
						"Included Components        :  1N LED TV, 1N Power Cord, 1N Remote Control, 2N Stand-Top, 1N OC, 1 User Manual, 1 LED TV, 2 Battery (AAA Size), 1 REMOCON, 1 Stant-Left, 1 Stant-Right\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 45990;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Samsung 50-inch Crystal iSmart 4K UHD Smart LED TV!45,990#" + quantity + "@" + total
								+ "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += quantity_mobiles * 45990;
						cart += "Samsung 50-inch Crystal iSmart 4K UHD Smart LED TV!45,990#" + quantity + "@" + total
								+ "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 7:
				total = 0;
				System.out.println("OnePlus 32-inch Y Series HD Ready LED Smart TV\r\n" + //
						"---------------------------------------------\r\n" + //
						"Screen Size                :  32 Inches\r\n" + //
						"Brand                      :  OnePlus\r\n" + //
						"Supported Internet Services:  Netflix, Prime Video, YouTube\r\n" + //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  6.5D x 42W x 71.3H Centimeters\r\n" + //
						"Resolution                 :  8K\r\n" + //
						"Refresh Rate               :  60 Hz\r\n" + //
						"Special Feature            :  Flat\r\n" + //
						"Model Name                 :  32Y\r\n" + //
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 1 AC Cord, 2 AAA Batteries\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 12999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "OnePlus 32-inch Y Series HD Ready LED Smart TV!12,999#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "OnePlus 32-inch Y Series HD Ready LED Smart TV!12,999#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 8:
				total = 0;
				System.out.println("Mi 40 inches 5A Series FHD Smart Android LED TV\r\n" + //
						"----------------------------------------------\r\n" + //
						"Screen Size                :  40 Inches\r\n" + //
						"Brand                      :  MI\r\n" + //
						"Supported Internet Services:  Disney+ Hotstar\r\n" + //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  21D x 9.2W x 55.9H Centimeters\r\n" + //
						"Resolution                 :  1080p\r\n" + //
						"Refresh Rate               :  60 Hz\r\n" + //
						"Special Feature            :  Android TV 11 | PatchWall | IMDb Integration | Universal Search | 300+ Free Live Channels | Kids Mode with Parental lock | Smart Recommendations | Language Universe \u2013 15+ Languages | User Centre | Okay Google | Chromecast supporting Apps: Netflix, Prime Video, Disney+ Hotstar | 5000+ apps from Play Store | Quad core Cortex A35 | Chromecast built-in | Ok Google | Auto Low Latency Mode | 1GB RAM + 8GB Storage\r\n"
						+ //
						"Model Name                 :  Xiaomi TV 5A 40\r\n" + //
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 4 screws, 2 x AAA Batteries\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 20999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Mi 40 inches 5A Series FHD Smart Android LED TV !20,999#" + quantity + "@" + total
								+ "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mi 40 inches 5A Series FHD Smart Android LED TV !20,999#" + quantity + "@" + total
								+ "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Telivisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 9:
				total = 0;
				System.out.println("Xiaomi A Series L32M8-5AIN 32 inch\r\n" + //
						"------------------------------------\r\n" + //
						"Screen Size                :  32 Inches\r\n" + //
						"Brand                      :  MI\r\n" + //
						"Supported Internet Services:  Disney+ Hotstar\r\n" + //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  19D x 71.5W x 47H Centimeters\r\n" + //
						"Resolution                 :  720p\r\n" + //
						"Refresh Rate               :  60 Hz\r\n" + //
						"Special Feature            :  Android TV 11 | PatchWall | IMDb Integration | Universal Search | 300+ Free Live Channels | Kids Mode with Parental lock | Smart Recommendations | Language Universe \u2013 15+ Languages | User Centre | Okay Google | Chromecast supporting Apps: Netflix, Prime Video, Disney+ Hotstar | 5000+ apps from Play Store | Quad core Cortex A35 | Chromecast built-in | Ok Google | Auto Low Latency Mode | 1GB RAM + 8GB Storage\r\n"
						+ //
						"Model Name                 :  Xiaomi TV 5A 32\r\n" + //
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 4 screws, 2 x AAA Batteries\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 12999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Xiaomi A Series L32M8-5AIN 32 inch !12,999#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Xiaomi A Series L32M8-5AIN 32 inch !12,999#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;
			case 10:
				total = 0;
				System.out.println("Xiaomi Smart TV X Series 55 inch\r\n" + //
						"---------------------------------\r\n" + //
						"Screen Size                :  55 Inches\r\n" + //
						"Brand                      :  Redmi\r\n" + //
						"Supported Internet Services:  Netflix, Prime Video, SonyLiv, Youtube, Hotstar\r\n" + //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  3.2D x 48.8W x 28.1H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  60 Hz\r\n" + //
						"Special Feature            :  Android TV 10 | Quick Wake - Wake TV Under 5 secs | PatchWall | Supported Apps: Netflix | Prime Video | Disney+ Hotstar | YouTube | 5000+ apps from Google Play Store\r\n"
						+ //
						"Model Name                 :  Redmi Smart TV X55 (138.8cm)\r\n" + //
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 4 screws\r\n"
						+ //
						"");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 36999;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Xiaomi Smart TV X Series 55!36,999#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Xiaomi Smart TV X Series 55!36,999#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							televisions();
					}
				} else if (opt_for_addcart == 3)
					televisions();
				break;

			case 0:
				electronics();
				break;
			default:
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				televisions();
		}
	}

	// object for bill class
	static Bill b_obj = new Bill();

	void electronics() {
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tELECTRONICS");
		System.out.println(
				"\t\t\t\t\t\t\t\t1.Mobiles\n\t\t\t\t\t\t\t\t2.Laptops\n\t\t\t\t\t\t\t\t3.Earphones\n\t\t\t\t\t\t\t\t4.Televisions\n\n\t\t\t\t\t\t\t\t9.check out\n\t\t\t\t\t\t\t\t0.Home");
		System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
		String optforelehome = sc.nextLine();
		int opt_for_ele_home = Integer.parseInt(optforelehome);
		if (opt_for_ele_home == 1) {
			electronics_obj.mobiles();
		} else if (opt_for_ele_home == 2) {
			electronics_obj.laptops();
		} else if (opt_for_ele_home == 3) {
			electronics_obj.earphones();
		} else if (opt_for_ele_home == 4) {
			electronics_obj.televisions();
		} else if (opt_for_ele_home == 0) {
			User u_obj = new User();
			u_obj.selection();
		} else if (opt_for_ele_home == 9) {
			b_obj.billDisplay();
		}
	}
}

/***************************************************************************************************************** */
/* B I L L I N G */
class Bill {
	static Scanner sc = new Scanner(System.in);
	static Electronics electronics_obj = new Electronics();
	static payment p_obj = new payment();
	static User u_obj = new User();
	static UserLogin u_login_obj = new UserLogin();

	static Date date() {
		Date currentDate = new Date();
		return currentDate;
	}

	void billDisplay() {
		String cart = Electronics.cart;
		if (cart.isEmpty()) {
			System.out.println("\t\t\t\t\t\t\t\tCart is Empty\n\t\t\t\t\t\t\t\tPlease Add Some Items");
			System.out.println("\t\t\t\t\t\t\t\t1.Home\n\t\t\t\t\t\t\t\t0.Press Any Key To Exit");
			String optforhome = sc.nextLine();
			int opt_for_home = Integer.parseInt(optforhome);
			if (opt_for_home == 1) {
				u_obj.selection();
			}
		} else {

			// Entering address

			double amount_electronics = Electronics.amount_electronics;
			String[] products = cart.split("&");

			System.out.println("Product\t\t\t\t\t\t   Price\tQuantity\tTotal Price");
			System.out.println(
					"-------------------------------------------------------------------------------------------");

			for (String productInfo : products) {
				String[] parts = productInfo.split("!");
				String productDetails = parts[0];

				String[] priceQuantityTotal = parts[1].split("#");
				String price = priceQuantityTotal[0];

				String[] quantityTotal = priceQuantityTotal[1].split("@");
				String quantity = quantityTotal[0];
				String total = quantityTotal[1];

				System.out.printf("%-50s %-15s %-14s %-20s%n", productDetails, price, quantity, total);
			}
			System.out.println(
					"-------------------------------------------------------------------------------------------");
			System.out.printf("%80s %.2f", "Amount : ", amount_electronics);
			double gst = 0.02 * amount_electronics;
			System.out.println();
			System.out.printf("%80s %.2f", "GST : ", gst);
			System.out.println();
			System.out.printf("%80s %.2f", "TOTAL : ", (amount_electronics + gst));
			System.out.println();
			System.out.println(
					"\t\t\t\t\t\t\t\t1.Pay Online\n\t\t\t\t\t\t\t\t2. Cash On Delivery\n\t\t\t\t\t\t\t\t0.Press any Key to Home");
			System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
			String chpay = Electronics.sc.nextLine();
			int ch_pay = Integer.parseInt(chpay);
			if (ch_pay == 1) {
				p_obj.bank_select(amount_electronics + gst);
			} else if (ch_pay == 2) {
				System.out.print("Enter Your Name : ");
				String name = sc.nextLine();
				System.out.print("Enter Your House Adress : ");
				String house_address = sc.nextLine();
				System.out.print("Enter Your Pincode : ");
				String pincode = sc.nextLine();

				String[] dynamicData = {
						"CHOR.in               Tax Invoice/Bill of Suppluy/CashMemo",
						"                      (TripleCafe for Supplier)",
						"",
						"Sold By :                                   Billing Adress:",
						"						" + name,
						"Gajala                                          " + house_address,
						"Form WashingTon DC                              " + pincode,
						"Sonic Solutions",
						"Hyderabad",
						"",
						"PAN No : CAMPS8381L                            Shipping Adress:",
						"GST Registration No : 07CAMPS83811L1ZQ         " + name,
						"                                               " + house_address,
						"Order Number : " + u_login_obj.otp() + "           		" + pincode,
						"Order Date : " + Bill.date(),
						""
				};
				for (String line : dynamicData)
					System.out.println(line);
				System.out.println("PAYMENT DETAILS\nStatus Of Payment : COD");
				System.out.println();
				System.out.println();

				products = cart.split("&");

				System.out.println("Product\t\t\t\t\t\t   Price\tQuantity\tTotal Price");
				System.out.println(
						"-------------------------------------------------------------------------------------------");

				for (String productInfo : products) {
					String[] parts = productInfo.split("!");
					String productDetails = parts[0];

					String[] priceQuantityTotal = parts[1].split("#");
					String price = priceQuantityTotal[0];

					String[] quantityTotal = priceQuantityTotal[1].split("@");
					String quantity = quantityTotal[0];
					String total = quantityTotal[1];

					System.out.printf("%-50s %-15s %-14s %-20s%n", productDetails, price, quantity, total);
				}
				System.out.println(
						"-------------------------------------------------------------------------------------------");
				System.out.printf("%80s %.2f", "Amount : ", amount_electronics);
				gst = 0.02 * amount_electronics;
				System.out.println();
				System.out.printf("%80s %.2f", "GST : ", gst);
				System.out.println();
				System.out.printf("%80s %.2f", "TOTAL : ", (amount_electronics + gst));

				Electronics.cart = "";
				Electronics.amount_electronics = 0;
				Electronics.address = "";

				System.out.println("\n1.Order More");
				System.out.println("\t\t\t\t\t\t\t\t0.Press Any Key To exit");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Choice ::");
				String optformore = sc.nextLine();
				int opt_for_more = Integer.parseInt(optformore);
				if (opt_for_more == 1)
					u_obj.selection();

			} else {
				u_obj.selection();
			}
		}
	}
}

/************************************************************************************************************** */

/*
 * *****************************************************************************
 * **************************
 * P A Y M E N T
 */

// P A Y M E N T
interface pay {
	int getPin();

	boolean withdraw(double bal);
}

class sbi implements pay {
	private int sbi_pin = 2580;

	private double sbi_bal = 100000.0;

	// S B I
	public int getPin() {
		return sbi_pin;
	}

	public boolean withdraw(double sbi_bal) {
		if (this.sbi_bal < sbi_bal)
			return false;
		else {
			this.sbi_bal -= sbi_bal;
			return true;
		}
	}

}

// K O T A K
class kotak implements pay {
	private int kotak_pin = 9834;

	private double kotak_bal = 1000000.0;

	public int getPin() {
		return kotak_pin;
	}

	public boolean withdraw(double kotak_bal) {
		if (this.kotak_bal < kotak_bal)
			return false;
		else {
			this.kotak_bal -= kotak_bal;
			return true;
		}
	}

}

// I C I C I
class icici implements pay {
	private int icici_pin = 6478;

	private double icici_bal = 10000000.0;

	public int getPin() {
		return icici_pin;
	}

	public boolean withdraw(double icici_bal) {
		if (this.icici_bal < icici_bal)
			return false;
		else {
			this.icici_bal -= icici_bal;
			return true;
		}
	}
}

class payment {
	static Scanner sc = new Scanner(System.in);
	static User u_obj = new User();
	static payment payment_obj = new payment();
	static sbi sbi_obj = new sbi();
	static kotak kotak_obj = new kotak();
	static icici icici_obj = new icici();
	static Bill bill_obj = new Bill();
	static UserLogin u_login_obj = new UserLogin();

	boolean validation(pay obj, double bill, String bank) {
		System.out.print("\n\t\t\t\t\t\tEnter " + bank + " account Pin : ");
		String pn = sc.nextLine();
		int pin = Integer.parseInt(pn);
		if (pin == obj.getPin()) {
			if (obj.withdraw(bill)) {
				System.out.println("\n\n\t\t\t\t************            Transaction Successful         ************\n");

				// Entering address
				System.out.print("Enter Your Name : ");
				String name = sc.nextLine();
				System.out.print("Enter Your House Adress : ");
				String house_address = sc.nextLine();
				System.out.print("Enter Your Pincode : ");
				String pincode = sc.nextLine();

				String[] dynamicData = {
						"CHOR.in               Tax Invoice/Bill of Suppluy/CashMemo",
						"                      (TripleCafe for Supplier)",
						"",
						"Sold By :                                   Billing Adress:",
						"						" + name,
						"Gajala                                          " + house_address,
						"Form WashingTon DC                              " + pincode,
						"Sonic Solutions",
						"Hyderabad",
						"",
						"PAN No : CAMPS8381L                            Shipping Adress:",
						"GST Registration No : 07CAMPS83811L1ZQ         " + name,
						"                                               " + house_address,
						"Order Number : " + u_login_obj.otp() + "           		" + pincode,
						"Order Date : " + Bill.date(),
						""
				};

				for (String line : dynamicData) {
					System.out.println(line);
				}
				System.out.println("PAYMENT DETAILS\nPayment Status : Paid(Online)");

				System.out.println();
				System.out.println();

				String[] products = Electronics.cart.split("&");

				System.out.println("Product\t\t\t\t\t\t   Price\tQuantity\tTotal Price");
				System.out.println(
						"-------------------------------------------------------------------------------------------");

				for (String productInfo : products) {
					String[] parts = productInfo.split("!");
					String productDetails = parts[0];

					String[] priceQuantityTotal = parts[1].split("#");
					String price = priceQuantityTotal[0];

					String[] quantityTotal = priceQuantityTotal[1].split("@");
					String quantity = quantityTotal[0];
					String total = quantityTotal[1];

					System.out.printf("%-50s %-15s %-14s %-20s%n", productDetails, price, quantity, total);
				}
				System.out.println(
						"-------------------------------------------------------------------------------------------");
				System.out.printf("%80s %.2f", "Amount : ", Electronics.amount_electronics);
				double gst = 0.02 * Electronics.amount_electronics;
				System.out.println();
				System.out.printf("%80s %.2f", "GST : ", gst);
				System.out.println();
				System.out.printf("%80s %.2f", "TOTAL : ", (Electronics.amount_electronics + gst));

				Electronics.cart = "";
				Electronics.amount_electronics = 0;
				Electronics.address = "";

				System.out.println("\t\t\t\t\t1.Order More");
				System.out.println("\t\t\t\t\t\t\t\t0.Press Any Key To Exit");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Choice ::");
				String optformore = sc.nextLine();
				int opt_for_more = Integer.parseInt(optformore);
				if (opt_for_more == 1)
					u_obj.selection();
				return true;
			} else {
				System.out.println(
						"\n\t\t\t\t************             Insuffiecient Funds in Your Account         ************\n");
				System.out.println("\t\t\tDo you want to switch to another bank");
				System.out.println("\t\t1 . Yes ");
				System.out.print("\t\t2 . No \n\t\t");
				String ys = sc.nextLine();
				if (Integer.parseInt(ys) == 1)
					return bank_select(bill);
				else {
					System.out.println("\t\t\t\t************            Transaction Failed          ************");
					return false;
				}
			}
		} else {
			System.out.println("\t\t\t\t************            Incorrect Pin          ************");
			System.out.println("\t\t\tChoose Options : ");
			System.out.println("\t\t1 . Re-enter Pin");
			System.out.print("\t\tPress any number to Exit the Application\n\t\t");
			String opt = sc.nextLine();
			int ch = Integer.parseInt(opt);
			if (ch == 1)
				return validation(obj, bill, bank);
		}
		return false;
	}

	boolean bank_select(double bill) {
		System.out.println(
				"\n\n\t\t\t\t\t************         W E L C O M E     T O       C V   P A Y       ************\n");
		System.out.println("\t\t\tChoose the Bank to Pay the Bill : \n");
		System.out.println("\t\t\t\t1 . S B I ");
		System.out.println("\t\t\t\t2 . K O T A K");
		System.out.print("\t\t\t\t3 . I C I C I \n\t\t\t\t");
		String opt = sc.nextLine();
		int bank = Integer.parseInt(opt);
		if (bank == 1)
			return validation(sbi_obj, bill, " SBI ");
		else if (bank == 2)
			return validation(kotak_obj, bill, " Kotak ");
		else if (bank == 3)
			return validation(icici_obj, bill, " ICICI ");
		else {
			System.out.println("\t\t\t\t************            Invalid Selection            ************");
			System.out.println("\t\t\tDo you want Re-select");
			System.out.println("\t\t1 . Yes ");
			System.out.print("\t\t2 . No \n\t\t");
			String ys = sc.nextLine();
			if (Integer.parseInt(ys) == 1)
				return bank_select(bill);
			return false;
		}
	}

}

/*
 * *****************************************************************************
 * ****************************
 */

// class for user interface
class User {
	// creating object for colors class
	static Scanner sc = new Scanner(System.in);
	static UserLogin user_login_obj = new UserLogin();
	// static UserSignup user_signup_obj = new UserSignup();
	static {
		String pattern = "    #####  #     # ####### ######     ######     #    #######    #    ######  \n" +
				"   #     # #     # #     # #     #    #     #   # #        #    # #   #     # \n" +
				"   #       #     # #     # #     #    #     #  #   #      #    #   #  #     # \n" +
				"   #       ####### #     # ######     ######  #     #    #    #     # ######  \n" +
				"   #       #     # #     # #   #      #     # #######   #     ####### #   #   \n" +
				"   #     # #     # #     # #    #     #     # #     #  #      #     # #    #  \n" +
				"    #####  #     # ####### #     #    ######  #     # ####### #     # #     # \n";

		String[] lines = pattern.split("\n");

		for (String line : lines) {
			for (int i = 0; i < line.length(); i++) {
				System.out.print(Colors.yellow + line.charAt(i) + Colors.reset);
				try {
					Thread.sleep(20); // Sleep for 100 milliseconds between characters
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(); // Move to the next line
		}
		;
	}

	static void User_login() {
		// int c_login = 0;
		System.out.println();
		System.out.print(Colors.blue
				+ "\t\t\t\t\t\t\t\t1.Log In\n\t\t\t\t\t\t\t\t2.SignUp\n\t\t\t\t\t\t\t\t0.Press any other key to exit :: "
				+ Colors.reset);
		String opt1 = sc.nextLine();
		int opt_1 = Integer.parseInt(opt1);
		if (opt_1 == 1) {
			while (true) {
				user_login_obj.logIn();
				if (UserLogin.status_login == 1)
					break;
				else if (UserLogin.status_login != 1) {
					if (UserLogin.status_login == 2)
						break;
					User_login();
					break;
				} else if (UserLogin.status_login == 2)
					break;
			}
		} else if (opt_1 == 2) {
			user_login_obj.initial();
			user_login_obj.signUp();
			System.out.println();
			System.out.print("\t\t\t\t\t\t\t\t1.Back to LogIn\n\t\t\t\t\t\t\t\t0.exit :: ");
			String opt5 = sc.nextLine();
			int opt_5 = Integer.parseInt(opt5);
			if (opt_5 == 1) {
				while (true) {
					user_login_obj.logIn();
					if (UserLogin.status_login == 1)
						break;

					else if (UserLogin.status_login != 1 && UserLogin.status_login == 2) {
						if (UserLogin.status_login == 2)
							break;
						User_login();
						break;
					} else if (UserLogin.status_login == 2)
						break;
				}
			}
		}

	}

	void selection() {
		if (UserLogin.status_login == 1) {
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t\t\t\tHOME");
			System.out.println();
			System.out.println(
					"\t\t\t\t\t\t\t\t1.Electronics\n\t\t\t\t\t\t\t\t2.Grocery\n\t\t\t\t\t\t\t\t3.Beauty\n\t\t\t\t\t\t\t\t4.Fashion\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t5.Press Any Key to Exit\n");
			System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
			String optforhome = sc.nextLine();
			int opt_for_home = Integer.parseInt(optforhome);
			if (opt_for_home == 1)
				new Electronics().electronics();
			else if(opt_for_home == 2)
				Grocery.grocery_obj.display();
		}

	}

	public static void main(String args[]) {
		User_login();
		User u_obj = new User();
		u_obj.selection();

	}
}
class Grocery extends Electronics {

	static Grocery grocery_obj = new Grocery();

	// static User u_obj = new User();
	public static void main(String args[]) {
		// grocery_obj.vegetables();
		grocery_obj.display();
	}

	void display() {
		System.out.println(
				Colors.blue + "1.vegetables\n2.Fruits\n3.Snacks\n4.Oils_and_Sauces\n5.Pulses\n6.exit" + Colors.reset);
		System.out.println("Enter Your option : ");
		String optforgrocery = sc.nextLine();
		int opt_for_grocery = Integer.parseInt(optforgrocery);
		switch (opt_for_grocery) {
			case 1:
				grocery_obj.vegetables();
				break;
			case 2:
				grocery_obj.Fruits();
				break;
			case 3:
				grocery_obj.Snacks();
				break;
			case 4:
				grocery_obj.Oils_and_Sauces();
				break;
			case 5:
				grocery_obj.Pulses();
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid option : ");
				display();
		}
	}

	void vegetables() {

		System.out.println(
				"1.tomato- 240\n2.potato - 130\n3.brinjal - 100\n4.Lady's finger - 50 \n5.cabbage - 60\n6.Garlic - 70\n7.Drumstick- 150\n8.Mushroom - 99\n9.califlower- 60\n10.Beetroot - 65 \n0.Back");
		System.out.println("Enter Your Option : ");
		String optformobiles = sc.nextLine();
		int opt_for_mobiles = Integer.parseInt(optformobiles);
		int total;
		switch (opt_for_mobiles) {
			case 1:
				total = 0;
				System.out.println("tomato -240 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity  :  ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 240;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "tomato!240#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "tomato!240#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 2:
				total = 0;
				System.out.println("potato - 130");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "potato!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "potato!130#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 3:
				total = 0;
				System.out.println("brinjal - 100");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "brinjal!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "brinjal!100#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 100;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 4:
				total = 0;
				System.out.println("Lady's finger - 50");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 50;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Lady's finger!50#" + quantity + "@";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Lady's finger!50#" + quantity + "@";
						// amount_Grocery += quantity_vegetables * 50;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 5:
				total = 0;
				System.out.println("cabbage - 60");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 60;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "cabbage!60#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "cabbage!60#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 60;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 6:
				total = 0;
				System.out.println("Garlic - 70");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 70;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Garlic!70#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Garlic!70#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 70;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 7:
				total = 0;
				System.out.println("Drumstick- 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Drumstick!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Drumstick!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							System.out.println("OK");
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 8:
				total = 0;
				System.out.println("Mushroom - 99");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 99;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Mushroom !99#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mushroom !99#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 99;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 9:
				total = 0;
				System.out.println("Beetroot - 65 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 65;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += " Beetroot!65#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Beetroot!65#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 65;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 10:
				total = 0;
				System.out.println("califlower- 60");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Vegetables\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 60;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "califlower!60#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "califlower!60#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 60;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Vegetables \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;

			case 0:
				display();
				break;
			default:
				System.out.println("Invalid Option");
				vegetables();

		}
	}

	void Fruits() {
		System.out.println(
				"1.Apple- 240\n2.Banana - 130\n3.Orange- 100\n4.Pine-apple - 150 \n5.papaya - 160\n6.Mango - 170\n7.Guava- 150\n8.Watermelon - 199\n9.Blackberry- 160\n10.Grapes - 165 \n0.Back");
		System.out.println("Enter Your Option : ");
		String optforfruits = sc.nextLine();
		int opt_for_fruits = Integer.parseInt(optforfruits);
		int total = 0;
		switch (opt_for_fruits) {
			case 1:
				total = 0;
				System.out.println("Apple -240 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs :  ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 240;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Apple!240#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Apple!240#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 240;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 2:
				total = 0;
				System.out.println("Banana - 130");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Banana!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Banana!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 130;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 3:
				total = 0;
				System.out.println("Orange -100");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Orange!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Orange!100#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 100;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 4:
				total = 0;
				System.out.println("Pine-apple - 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Pine-apple!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Pine-apple!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 5:
				total = 0;
				System.out.println("papaya - 160");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs  : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "papaya!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "papaya!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 6:
				total = 0;
				System.out.println("Mango - 170");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Mango!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mango!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 170;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 7:
				total = 0;
				System.out.println("Guava- 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Guava!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Guava!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 8:
				total = 0;
				System.out.println("Watermelon - 199");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 199;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Watermelon !199#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Watermelon !199#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 199;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 9:
				total = 0;
				System.out.println("Blackberry- 165 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 165;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += " Blackberry!165#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Blackberry!165#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 165;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 10:
				total = 0;
				System.out.println("Grapes- 160");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Fruits\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Grapes!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Grapes!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Fruits \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;

			case 0:
				display();
				break;
			default:
				System.out.println("Invalid Option");
				Fruits();

		}
	}

	/**
	 * 
	 */
	void Snacks() {
		System.out.println(
				"1.Crackers- 140\n2.Nuts - 130\n3.Quick oats- 100\n4.Popcorn - 150 \n5.Tortilla Chips - 160\n6.Candy - 170\n7.Cashews- 150\n8.Cookies - 230\n9.Potato chips- 160\n10.Dried fruits - 160 \n0.Back");
		System.out.println("Enter Your Option : ");
		String optforsnacks = sc.nextLine();
		int opt_for_snacks = Integer.parseInt(optforsnacks);
		int total = 0;
		switch (opt_for_snacks) {
			case 1:
				total = 0;
				System.out.println("Crackers -140 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs :  ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 140;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Crackers!140#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Crackers!140#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 140;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 2:
				total = 0;
				System.out.println("Nuts - 130");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Nuts!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Nuts!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 130;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 3:
				total = 0;
				System.out.println("Quick oats -100");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Quick oats!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Quick oats!100#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 100;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 4:
				total = 0;
				System.out.println("Popcorn - 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Popcorn!150#" + quantity + "@" + total + '&';
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Popcorn!150#" + quantity + "@" + total + '&';
						// amount_Grocery += quantity_Snacks * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 5:
				total = 0;
				System.out.println("Tortilla Chips - 160");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs  : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Tortilla Chips!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Tortilla Chips!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 6:
				total = 0;
				System.out.println("Candy - 170");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Candy!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();

					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Candy!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 170;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 7:
				total = 0;
				System.out.println("Cashews- 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Cashews!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Cashews!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 8:
				total = 0;
				System.out.println("Cookies- 230");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 230;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Cookies !230#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Cookies !230#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 230;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 9:
				total = 0;
				System.out.println("Potato chips- 160 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += " Potato chips!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Potato chips!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 10:
				total = 0;
				System.out.println("Dried fruits- 160");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To Snacks\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Dried fruits!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Dried fruits!160#" + quantity + "@" + total + "&";
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Snacks \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;

			case 0:
				display();
				break;
			default:
				System.out.println("Invalid Option");
				Snacks();
		}
	}

	void Oils_and_Sauces() {

		System.out.println(
				"1.Olive oil- 180\n2.Mustard oil - 130\n3.Sunflower oil- 120\n4.Soy sauce - 140 \n5.Fish Sauce - 110\n6.Vinegar- 170\n7.Tomato ketchup- 150\n8.Sweet and sour sauce- 199\n9.Rice bran oil- 160\n10.Coconut oil - 165 \n0.Back");
		System.out.println("Enter Your Option : ");
		String optforoils_and_Sauces = sc.nextLine();
		int opt_for_oils_and_Sauces = Integer.parseInt(optforoils_and_Sauces);
		int total = 0;
		switch (opt_for_oils_and_Sauces) {
			case 1:
				System.out.println("Olive oil -180 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs :  ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 180;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Olive oil!180#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Olive oil!180#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 140;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 2:
				total = 0;
				System.out.println("Mustard oil - 130");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Mustard oil!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();

					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mustard oil!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 130;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 3:
				total = 0;
				System.out.println("Sunflower oil -120");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 120;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Sunflower oil!120#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sunflower oil!120#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 120;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 4:
				total = 0;
				System.out.println("Soy sauce - 140");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 140;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Soy sauce!140#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Soy sauce!140#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 140;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 5:
				total = 0;
				System.out.println("Fish Sauce - 110");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs  : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 110;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Fish Sauce!110#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Fish Sauce!110#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 110;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 6:
				total = 0;
				System.out.println("Vinegar - 170");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Vinegar!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Vinegar!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 170;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 7:
				total = 0;
				System.out.println("Tomato ketchup- 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Tomato ketchup!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Tomato ketchup!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 8:
				total = 0;
				System.out.println("	Sweet and sour sauce - 199");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 199;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Sweet and sour sauce!199#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sweet and sour sauce!199#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 199;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 9:
				total = 0;
				System.out.println("Rice bran oil- 160 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += " Rice bran oil!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Rice bran oil!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 10:
				total = 0;
				System.out.println("Coconut oil- 165");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Press Back To oils_and_Sauces\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 165;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Coconut oil!165#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Coconut oil!165#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To oils_and_Sauces \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;

			case 0:
				display();
				break;
			default:
				System.out.println("Invalid Option");
				Oils_and_Sauces();

		}
	}

	/**
	 * 
	 */
	void Pulses() {

		System.out.println(
				"1.Mung daal- 140\n2.Hare mung daal - 130\n3.Chawli daal- 100\n4.Masoor daal - 150 \n5.Sabat masoor - 160\n6.Toor daal- 170\n7.Rajma- 150\n8.Hari matar- 199\n9.chickpeas- 160\n10.Field beans - 165 \n0.Back");
		System.out.println("Enter Your Option : ");
		String optforpulses = sc.nextLine();
		int opt_for_pulses = Integer.parseInt(optforpulses);
		int total = 0;
		switch (opt_for_pulses) {
			case 1:
				total = 0;
				System.out.println("Mung daal -140 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs :  ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 140;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Mung daal!140#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mung daal!140#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 140;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 2:
				total = 0;
				System.out.println("Hare mung daal - 130");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Hare mung daal!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Hare mung daal!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 130;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 3:
				total = 0;
				System.out.println("Chawli daal -100");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Chawli daal!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Chawli daal!100#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 100;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 4:
				total = 0;
				System.out.println("Masoor daal - 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Masoor daal!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Masoor daal!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 5:
				total = 0;
				System.out.println("Sabat masoor - 160");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs  : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Sabat masoor!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sabat masoor!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();

					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 6:
				total = 0;
				System.out.println("Toor daal - 170");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Toor daal!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Toor daal!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 170;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 7:
				total = 0;
				System.out.println("Rajma- 150");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Rajma!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Rajma!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Rajma!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 150;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 8:
				total = 0;
				System.out.println("Hari matar - 199");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 199;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Hari matar !199#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Hari matar !199#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 199;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 9:
				total = 0;
				System.out.println("chickpeas- 160 ");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += " chickpeas!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " chickpeas!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 10:
				total = 0;
				System.out.println("Field beans- 160");
				System.out.println(
						"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3. Press Back To Pulses\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print("Please Enter Quantity in kgs : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart = "";
						amount_electronics = total;
						cart += "Field beans!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay();
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Field beans!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 160;
						System.out.println(
								"\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Press Back To Pulses \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");

						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay();
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;

			case 0:
				display();
				break;
			default:
				System.out.println("Invalid Option");
				Pulses();

		}
	}
}