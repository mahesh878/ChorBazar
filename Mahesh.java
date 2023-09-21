//import javax.jws.soap.SOAPBinding;
import java.util.*;


//class for colors 
class Colors
{
	static void sleep(int n)
	{
		try{
		Thread.sleep(n);
			}
		catch(InterruptedException e)
			{}
	}

	// colors
	static final String red = "\u001B[31m";
	static final String green  = "\u001B[32m";
	static final String  magent = "\u001B[95m";
	static final String blue = "\u001B[34m";
	static final String purple = "\u001B[35m";
	static final String cyan = "\u001B[36m";
	static final String black = "\u001B[30m";
	static final String yellow = "\u001B[93m";

	//color reset
	static final String reset = "\u001B[0m";
	

	//Background colors
	static final String bwhite = "\u001B[107m";
	static final String bgreen = "\u001B[42m";
	static final String bblack="\u001B[40m";
    static final String bred	="\u001B[41m";
	static final String byellow="\u001B[43m";
	static final String bblue=	"\u001B[44m";
	static final String bpurple="\u001B[45m";
	static final String bcyan="\u001B[46m";


	//background color reset
	static String breset = "\u001B[49m";

	//underline
	static final String ul = "\u001B[4m";

	//underline reset
	static final String rstul = "\u001B[24m";

	//blinking 
	static final String blink="\u001B[5m";

	//reset blinking
	static final String rstblink = "\u001B[0m";

	//italic
	static final String ital = "\u001B[3m";

}

// class for using setter and getter methods to reset username and password
class UserSignup
{
	private String username = "";
	private String password = "";
	private long MobileNumber;
	private String key = "";

	void setUsername(String username)
	{
		this.username = username;
	}

	void setPassword(String password)
	{
		this.password = password;
	}

	void setMobileNumber(long MobileNumber)
	{
		this.MobileNumber = MobileNumber;
	}

	void setKey(String key)
	{
		this.key = key;
	}

	String getUsername()
	{
		return username;
	}

	String getPassword()
	{
		return password;
	}

	long getMobileNumber()
	{
		return MobileNumber;
	}

	String getkey()
	{
		return key;
	}
}


//class for log in 
class UserLogin 
{
	static int status_login = 0;
	static int status_signup = 0;
	static int status_initial = 0;
	static Scanner sc = new Scanner(System.in);
	static UserSignup user_signup_obj = new UserSignup();

	void initial()
	{
		//initialize new  user name
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print(Colors.purple+"\t\t\t\t\t\t\t\tEnter a new username :: "+Colors.reset);
		String newUsername = sc.nextLine();
		System.out.println();
		//initialize new password
		System.out.print(Colors.purple+"\t\t\t\t\t\t\t\tEnter a new password :: "+Colors.reset);
		String newPassword = sc.nextLine();
		System.out.println();
		//setting username and password 
		user_signup_obj.setUsername(newUsername);
    	user_signup_obj.setPassword(newPassword);
		status_initial = 1;
	}

    void signUp()
	{
		long newMobile = 0;
		String new_Mobile;
		while(true)
		{
		//initialize phone number
			System.out.print(Colors.purple+"\t\t\t\t\t\t\t\tEnter your mobile number :: "+Colors.reset);
			new_Mobile = sc.nextLine();
			int length = new_Mobile.length();
			if(length == 10)
			{
				int i;
				for(i=0;i<length;i++)
				{
					char ch = new_Mobile.charAt(i);
					if(ch>='0' && ch<='9')
						continue;
					else
						break;
				}
				if(i>=length)
					break;
				else
					System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid Mobile Number Please Re Enter"+Colors.reset);
			}
			else
			{
				System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid Mobile Number Please Re Enter"+Colors.reset);
			}
			
		}
		newMobile = Long.parseLong(new_Mobile);
		System.out.println();
		//initialize private key
		System.out.println(Colors.blink+""+Colors.cyan+"\t\t\t\t\t\t\t\t*Private Key Set Only at the time of account creation\n\t\t\t\t\t\t\t\t*if you forgot this key u may loose your account\n\t\t\t\t\t\t\t\t*this key helps you at the time of you forgot your phone number"+Colors.reset+""+Colors.rstblink);
		System.out.println();
		System.out.print(Colors.purple+"\t\t\t\t\t\t\t\tPrivate Key :: "+Colors.reset);
		String key = sc.nextLine();
		//setting password, mobilenumber
        user_signup_obj.setMobileNumber(newMobile);
		user_signup_obj.setKey(key);
		System.out.println();
		System.out.println(Colors.blink+Colors.green+"\t\t\t\t\t\t\t\t\t\tSignUp Successful!\n\t\t\t\t\t\t\t\t"+Colors.reset+Colors.rstblink);
		status_signup = 1;
	}

	void logIn()
	{
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\tLOG IN");
		System.out.print("\t\t\t\t\t\t\t\tEnter Username :: ");
		String u_name = sc.nextLine();
		System.out.println();
		System.out.print("\t\t\t\t\t\t\t\tEnter Password :: ");
		String u_pwd = sc.nextLine();
		if(user_signup_obj.getUsername().equals(u_name) && user_signup_obj.getPassword().equals(u_pwd))
		{
			System.out.println("\t\t\t\t\t\t\t\tLogIn Successful!");
			status_login = 1;
		}
		else
		{
			System.out.println();
			System.out.print("\t\t\t\t\t\t\t\tInvalid Username or Password\n\t\t\t\t\t\t\t\t1.ReEnter\n\t\t\t\t\t\t\t\t2.Reset Credentials\n\t\t\t\t\t\t\t\t0.Back to SignUp Page :: ");
			String opt2 = sc.nextLine();
			int opt_2 = Integer.parseInt(opt2);
			if(opt_2 == 1)
				logIn();
			else if(opt_2 == 2)
			{
				System.out.println();
				System.out.print("\t\t\t\t\t\t\t\tEnter MobileNumber :: ");
				String m_no = sc.nextLine();
				long mno = Long.parseLong(m_no);
				if(mno == user_signup_obj.getMobileNumber())
				{
					UserLogin otp_obj = new UserLogin();
					while(true)
					{
						int otp = otp_obj.otp();
						System.out.println("\t\t\t\t\t\t\t\tOTP :: "+otp);
						System.out.print("\t\t\t\t\t\t\t\tEnter OTP ::");
						String dotp = sc.nextLine();
						int d_otp = Integer.parseInt(dotp);
						if(d_otp == otp)
						{
							initial();
							System.out.println("\t\t\t\t\t\t\t\tReset Credentials Successful!");
							System.out.println("\t\t\t\t\t\t\t\tBack to LogIn");
							logIn();
							break;
						}
						else
						{
							System.out.println();
							System.out.println("\t\t\t\t\t\t\t\tInvalid OTP Please ReEnter");
						}
					}
				}
				else if(user_signup_obj.getMobileNumber() != 0L)
				{
					System.out.println();
					System.out.println("\t\t\t\t\t\t\t\tInvalid MobileNumber");
					System.out.println();
					while(true)
					{
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Private Key to reset :: ");
						String pkey = sc.nextLine();
						if(pkey.equals(user_signup_obj.getkey()))
						{
							System.out.println("\t\t\t\t\t\t\t\tPrivat Key is Correct\n\t\t\t\t\t\t\t\tReset Your Credentials");
							initial();
							System.out.println("\t\t\t\t\t\t\t\tReset Credentials Successful!");
							System.out.println("\t\t\t\t\t\t\t\tBack to LogIn");
							break;
						}
						else
						{
							System.out.println();
							System.out.print("\t\t\t\t\t\t\t\tInvalid Key\n\t\t\t\t\t\t\t\t1.ReEnter\n\t\t\t\t\t\t\t\t2.Create New Account :: ");
							String opt3 = sc.nextLine();
							int opt_3 = Integer.parseInt(opt3);
							if(opt_3 == 2)
							{
								initial();
								signUp();
								break;
							}

						}
					}
				}
				else if(user_signup_obj.getMobileNumber() == 0L)
				{
					System.out.print("\t\t\t\t\t\t\t\tUser Not Found\n\t\t\t\t\t\t\t\t1.Create New User\n\t\t\t\t\t\t\t\t0.exit :: ");
					String opt4 = sc.nextLine();
					int opt_4 = Integer.parseInt(opt4);
					if(opt_4 == 1)
					{
						initial();
						signUp();
					}
					else
						UserLogin.status_login = 2;
				}
				
			}
			else
			{
				UserLogin.status_login=2;
				User.User_login();
			}
		}

	}

	int otp()
	{
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


//class for Electronics 
class Electronics
{
	static Scanner sc = new Scanner(System.in);
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
	static String cart1="";
	static String cart = "";
	void mobiles()
	{
		System.out.println();
		System.out.println(Colors.blue+"\t\t\t\t\t\t\t1.Samsung Galaxy W21 \t- \t24,000\r\n" + //
				"\t\t\t\t\t\t\t2.Huawei Mate X2 \t- \t20,000\r\n" + //
				"\t\t\t\t\t\t\t3.Huawei Mate X2 4G \t- \t21,000\r\n" + //
				"\t\t\t\t\t\t\t4.Xiami Mi Mix Alpha \t- \t19,000\r\n" + //
				"\t\t\t\t\t\t\t5.Huawei Mate  \t\t- \t18,000\r\n" + //
				"\t\t\t\t\t\t\t6.Samsung W2019 \t- \t18,000\r\n" + //
				"\t\t\t\t\t\t\t7.Samsung W22 5g \t- \t17,000\r\n" + //
				"\t\t\t\t\t\t\t8.Samsung Galzy Z  \t- \t17,999\r\n" + //
				"\t\t\t\t\t\t\t9.Apple iPhone 14  \t- \t45,000\r\n" + //
				"\t\t\t\t\t\t\t10.Apple iPhone 15 \t- \t55,000  "+Colors.reset);
		System.out.println(Colors.yellow+"\t\t\t\t\t\t\t0.Back To Electronics"+Colors.reset);
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
		String optformobiles = sc.nextLine();
		int opt_for_mobiles = Integer.parseInt(optformobiles);
		int total;
		switch(opt_for_mobiles)
		{
			case 1:
				System.out.println(Colors.cyan+"\n\t\t\t\t\t\t\t\tSamsung Galaxy W21\r\n" + //
						"\t\t\t\t\t\t\t\t-------------------\r\n" + //
						"\t\t\t\t\t\t\t\ttDisplay (Primary)   :  7.60-inch (1768x2208)\r\n" + //
						"\t\t\t\t\t\t\t\tProcessor           :  Qualcomm Snapdragon 865+\r\n" + //
						"\t\t\t\t\t\t\t\tFront Camera        :  10MP + 10MP\r\n" + //
						"\t\t\t\t\t\t\t\tRear Camera         :  12MP + 12MP + 12MP\r\n" + //
						"\t\t\t\t\t\t\t\tRAM                 :  12GB\r\n" + //
						"\t\t\t\t\t\t\t\tStorage             :  512GB\r\n" + //
						"\t\t\t\t\t\t\t\tBattery Capacity    :  4500mAh\r\n" + //
						"\t\t\t\t\t\t\t\tOS                  :  Android 10\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.println();
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);

				if(opt_for_addcart == 1 || opt_for_addcart ==  2)
				{
					System.out.print(Colors.blue+"\n\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*24000;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Samsung Galaxy W21!24,000#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total;
						cart += "Samsung Galaxy W21!24,000#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							b_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 2:
						total = 0 ;
						System.out.println(Colors.cyan+"Huawei Mate X2\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)   :  6.45-inch (1160x2700)\r\n" + //
						"Processor           :  HiSilicon Kirin 9000\r\n" + //
						"Front Camera        :  16MP\r\n" + //
						"Rear Camera         :  50MP + 16MP + 12MP + 8MP\r\n" + //
						"RAM                 :  8GB, 12GB\r\n" + //
						"Storage             :  256GB, 512GB\r\n" + //
						"Battery Capacity    :  4500mAh\r\n" + //
						"OS                  :  Android 10\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*20000;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Huawei Mate X2!20,000#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total;
						cart += "Huawei Mate X2!20,000#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							b_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"Huawei Mate X2 5G\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)   :  6.45-inch (1160x2700)\r\n" + //
						"Processor           :  HiSilicon Kirin 9000\r\n" + //
						"Front Camera        :  16MP\r\n" + //
						"Rear Camera         :  50MP + 16MP + 12MP + 8MP\r\n" + //
						"RAM                 :  8GB, 12GB\r\n" + //
						"Storage             :  256GB, 512GB\r\n" + //
						"Battery Capacity    :  4500mAh\r\n" + //
						"OS                  :  Android 10\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*21000;
					if(opt_for_addcart ==1)
					{
						cart1 = "";
						amount_electronics=total;
						cart1 += "Huawei Mate X2 4G!21,000#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics+=total;
						cart += "Huawei Mate X2 4G!21,000#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
					{
						b_obj.billDisplay(cart);
					}
					else if(opt_for_buynow == 2)
						mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"Xiaomi Mi Mix Alpha\r\n" + //
						"---------------------\r\n" + //
						"Display (Primary)    :  7.92-inch (2088x2250)\r\n" + //
						"Processor            :  Qualcomm Snapdragon 855+\r\n" + //
						"Front Camera         :  No\r\n" + //
						"Rear Camera          :  108MP + 12MP + 20MP\r\n" + //
						"RAM                  :  12GB\r\n" + //
						"Storage              :  512GB\r\n" + //
						"Battery Capacity     :  4050mAh\r\n" + //
						"OS                   :  Android\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*19000;
					if(opt_for_addcart ==1 )
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Xiami Mi Mix Alpha!19,000#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2){
						amount_electronics += total;
						cart += "Xiami Mi Mix Alpha!19,000#"+quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 5:
				total = 0;
				System.out.println(Colors.cyan+"Huawei Mate 40 RS Porsche Edition\r\n" + //
						"-----------------------------------\r\n" + //
						"Display (Primary)    :  6.76-inch (1344x2772)\r\n" + //
						"Processor            :  HiSilicon Kirin 9000\r\n" + //
						"Front Camera         :  13MP\r\n" + //
						"Rear Camera          :  50MP + 20MP + 12MP + 8MP\r\n" + //
						"RAM                  :  8GB, 12GB\r\n" + //
						"Storage              :  256GB, 512GB\r\n" + //
						"Battery Capacity     :  4400mAh\r\n" + //
						"OS                   :  Android 10\r\n" + //
						""+Colors.reset);	
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*18000;
					if(opt_for_addcart ==1 )
					{
						cart1 ="";
						amount_electronics=total;
						cart1 += "Huawei Mate 40 RS Porseche Edition!18,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total ;
						cart += "Huawei Mate 40 RS Porseche Edition!18,000#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							bill_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"Samsung W2019\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  4.20-inch (1080x1920)\r\n" + //
						"Processor            :  Qualcomm Snapdragon 845\r\n" + //
						"Front Camera         :  8MP\r\n" + //
						"Rear Camera          :  12MP + 12MP\r\n" + //
						"RAM                  :  6GB\r\n" + //
						"Storage              :  128GB\r\n" + //
						"Battery Capacity     :  3070mAh\r\n" + //
						"OS                   :  Android 8.1 Oreo\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*18000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Samsung W2019!18,000#"+ quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total ;
					cart += "Samsung W2019!18,000#"+ quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
					{
						bill_obj.billDisplay(cart);
					}
					else if(opt_for_buynow == 2)
						mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"Samsung W22 5G\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  7.60-inch (2208x1768)\r\n" + //
						"Processor            :  Octa-core\r\n" + //
						"Front Camera         :  10MP + 4MP\r\n" + //
						"Rear Camera          :  12MP + 12MP + 12MP\r\n" + //
						"RAM                  :  12GB, 16GB\r\n" + //
						"Storage              :  256GB, 512GB\r\n" + //
						"Battery Capacity     :  4400mAh\r\n" + //
						"OS                   :  Android\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*17000;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Samsung W2019 5g!17,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Samsung W2019 5g!17,000#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)

							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"Samsung Galaxy Z Fold 2\r\n" + //
						"------------------------\r\n" + //
						"Display (Primary)    :  7.60-inch (1768x2208)\r\n" + //
						"Processor            :  Qualcomm Snapdragon 865+\r\n" + //
						"Front Camera         :  10MP + 10MP\r\n" + //
						"Rear Camera          :  12MP + 12MP + 12MP\r\n" + //
						"RAM                  :  12GB\r\n" + //
						"Storage              :  256GB\r\n" + //
						"Battery Capacity     :  4500mAh\r\n" + //
						"OS                   :  Android 10\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*15000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics = total;
						cart1 += "Samsung W2019!15,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Samsung W2019!15,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"Apple iPhone 14\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  6.06-inch (1170x2532)\r\n" + //
						"Processor            :  Apple A15 Bionic\r\n" + //
						"Front Camera         :  12MP\r\n" + //
						"Rear Camera          :  12MP + 12MP\r\n" + //
						"Storage              :  128GB, 256GB, 512GB\r\n" + //
						"OS                   :  iOS 16\r\n" + //
						""+Colors.cyan);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*45000;
					if(opt_for_addcart == 1 )
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += " Apple iPhone 14 Pro Max GOLD!45000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += " Apple iPhone 14 Pro Max GOLD!45000#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"Apple iPhone 15\r\n" + //
						"----------------\r\n" + //
						"Display (Primary)    :  6.06-inch\r\n" + //
						"Rear Camera          :  Unspecified + 48MP\r\n" + //
						"RAM                  :  8GB\r\n" + //
						"OS                   :  iOS\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Mobiles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*55000;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += " Apple iPhone 14 Pro Max GOLD!55,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += " Apple iPhone 14 Pro Max GOLD!55,000#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Mobles"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							mobiles();
					}
				}
				else if(opt_for_addcart == 3)
					mobiles();
				break;

			case 0 :
				electronics();
				break;
			default :
				System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid Option"+Colors.reset);
				mobiles();
				
				
		}
	}

	void laptops()
	{

		System.out.println(Colors.blue+"1. Acer Aspire 5 Gaming Laptop \t- \t65,000\r\n" + //
				"2. HP Laptop 15s \t\t- \t70,000\r\n" + //
				"3. HP 255 G8 \t\t\t- \t72,000\r\n" + //
				"4. Jio Book 11 \t\t\t- \t68,000\r\n" + //
				"5. Jio Book 12 \t\t\t- \t78,000\r\n" + //
				"6. ASUS Vivobook 14 \t\t- \t58,000\r\n" + //
				"7. Lenovo IdeaPad 3\t \t- \t50,000\r\n" + //
				"8. HP Laptop 14s \t\t- \t57,000\r\n" + //
				"9. Asus VivoBook 14 mini \t- \t40,000\r\n" + //
				"10. DELL chrome edition \t- \t56,000\r\n" + //
				""+Colors.reset);
		System.out.println(Colors.yellow+"\n\t\t\t\t\t\t\t\t0.Back"+Colors.reset);
		System.out.println(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
		String optforlaptops = sc.nextLine();
		int opt_for_laptops = Integer.parseInt(optforlaptops);
		int total;
		switch(opt_for_laptops)
		{
			case 1:
				total = 0;
				System.out.println(Colors.cyan+"Acer Aspire 5 Gaming Laptop\r\n" + //
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
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*65000;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Acer Aspire 5 Gaming Laptop!65,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Acer Aspire 5 Gaming Laptop!65,000#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"HP Laptop 15s\r\n" + //
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
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*70000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "HP Laptop 15s!70,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "HP Laptop 15s!70,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 3:
			total = 0;
				System.out.println(Colors.cyan+"HP 255 G8\r\n" + //
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
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*72000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "HP 255 G8!72,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "HP 255 G8!72,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"Jio Book 11\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        Jio\r\n" + //
						"Model Name:                   JioBook\r\n" + //
						"Screen Size:                  11.6 Inches\r\n" + //
						"Colour:                       JioBlue\r\n" + //
						"Hard Disk Size:               64 GB\r\n" + //
						"CPU Model:                    Others\r\n" + //
						"RAM Memory Installed Size:    4 GB\r\n" + //
						"Operating System:             JioOS\r\n" + //
						"Special Feature:              Multi-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity KeyboardMulti-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity Keyboard, See more\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*68000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Jio Book 11!68,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
					amount_electronics += total;
					cart += "Jio Book 11!68,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 5:
				total  = 0;
				System.out.println(Colors.cyan+"Jio Book 12\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        Jio\r\n" + //
						"Model Name:                   JioBook\r\n" + //
						"Screen Size:                  11.6 Inches\r\n" + //
						"Colour:                       JioBlue\r\n" + //
						"Hard Disk Size:               64 GB\r\n" + //
						"CPU Model:                    Others\r\n" + //
						"RAM Memory Installed Size:    4 GB\r\n" + //
						"Operating System:             JioOS\r\n" + //
						"Special Feature:              Multi-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity KeyboardMulti-tasking with Multi-window Support, Universal compatibility, Ultra light and compact < 1kg, 4G-LTE enabled, Infinity Keyboard, See more\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_laptops==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*78000;
					if(opt_for_addcart ==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Jio Book 12!78,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else
					{
					amount_electronics += total;
					cart += "Jio Book 12!78,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 2)
					laptops();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"ASUS Vivobook 14\r\n" + //
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
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*58000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "ASUS Vivobook 14!58,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "ASUS Vivobook 14!58,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 7:
				total  = 0;
				System.out.println(Colors.cyan+"Lenovo IdeaPad 3\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        Lenovo\r\n" + //
						"Model Name:                   IdeaPad 3 15ITL6\r\n" + //
						"Screen Size:                  15.6 Inches\r\n" + //
						"Colour:                       Arctic Grey\r\n" + //
						"Hard Disk Size:               512 GB\r\n" + //
						"CPU Model:                    Core i5\r\n" + //
						"RAM Memory Installed Size:    16 GB\r\n" + //
						"Operating System:             Windows 11 Home\r\n" + //
						"Special Feature:              Anti Glare Screen, Backlit Keyboard, Thin, Built-in Microphone\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*50000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Lenovo IdeaPad 3!50,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Lenovo IdeaPad 3!50,000#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 8:
				System.out.println(Colors.cyan+"HP Laptop 14s\r\n" + //
						"----------------------------------------------\r\n" + //
						"Brand:                        HP\r\n" + //
						"Model Name:                   HP Laptop 14s-fq1083AU\r\n" + //
						"Screen Size:                  14 Inches\r\n" + //
						"Colour:                       Natural Silver\r\n" + //
						"CPU Model:                    Ryzen 7\r\n" + //
						"RAM Memory Installed Size:    8 GB\r\n" + //
						"Operating System:             Windows 10 Home\r\n" + //
						"Special Feature:              Fingerprint Reader, Backlit Keyboard, Anti Glare Coating, Memory Card Slot\r\n" + //
						"Graphics Card Description:    Integrated\r\n" + //
						"Graphics Coprocessor:         AMD Radeon Graphics\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*57000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "HP Laptop 14s!57,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "HP Laptop 14s!57,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"Asus VivoBook 14 mini\r\n" + //
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
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*40000;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Asus VivoBook 14 mini!40,000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Asus VivoBook 14 mini!40,000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"DELL chrome edition\r\n" + //
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
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*56000;
					if(opt_for_addcart == 2)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "DELL chrome edition!56000#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
					amount_electronics += total;
					cart += "DELL chrome edition!56000#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Laptops"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option :: "+Colors.reset);
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						laptops();
					}
				}
				else if(opt_for_addcart == 3)
					laptops();
				break;

			case 0 :
				electronics();
				break;
			default :
				System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid Option"+Colors.reset);
				mobiles();
		}
	}



	void earphones()
	{

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
		switch(opt_for_earphones)
		{
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*1199;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Boult Audio Z40 True Wireless!1,199#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Boult Audio Z40 True Wireless!1,199#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);

						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
		
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total += quantity_mobiles*total;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=1499;
						cart1 += "truke!1,499#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "truke!1,499#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*2796;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Sony WI-XB400 Wireless!2,796#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Sony WI-XB400 Wireless!2,796#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*799;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics = total;
						cart1 = "Boult Audio FXCharge!799#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Boult Audio FXCharge!799#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
					}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*1999;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "OnePlus Bullets Z2 Bluetooth Wireless!1,999#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
							amount_electronics += total;
							cart += "OnePlus Bullets Z2 Bluetooth Wireless!1,999#" + quantity+"@"+total+"&";
							System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
							System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
							optforbuynow = sc.nextLine();
							opt_for_buynow = Integer.parseInt(optforbuynow);
							if(opt_for_buynow == 1)
								bill_obj.billDisplay(cart);
							else if(opt_for_buynow == 2)
								earphones();
					}
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*1099;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "boAt Rockerz 255!1,099#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "boAt Rockerz 255!1,099#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*699;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "JBL Endurance Run!699#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "JBL Endurance Run!699#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*1699;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart += "Vibez by Lifelong Earphones!1,699#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);

					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Vibez by Lifelong Earphones!1,699#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
					
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*999;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Zebronics Yoga N2 RGB!999#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Zebronics Yoga N2 RGB!999#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Earphones\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*799;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1+="Wecool N1 High Bass Earphones!799#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Wecool N1 High Bass Earphones!799#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
					earphones();
				break;

			case 0 :
				electronics();
				break;
			default :
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				earphones();
		}
	}
	void televisions()
	{

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
		switch(opt_for_televisions)
		{
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
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*124990;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics = total;
						cart1 += "Sony Bravia 55-inch TV!1,24,990#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Sony Bravia 55-inch TV!1,24,990#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						televisions();
					}
				}
				else if(opt_for_addcart == 3)
					televisions();
				break;
			case 2:
				total = 0;
				System.out.println("Sony Bravia 65-inch 4K UHD Smart TV\r\n" + //
						"------------------------------------\r\n" + //
						"Screen Size                :  65 Inches\r\n" + //
						"Brand                      :  Sony\r\n" + //
						"Supported Internet Services:  Netflix, Amazon Prime Video, Disney+ Hotstar, Sony Liv, Zee5, Voot, Hoichoi & many More\r\n" + //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  8.7D x 146.3W x 85.2H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  60 Hz\r\n" + //
						"Special Feature            :  Google TV | Watchlist | Voice Search | Google Play | Chromecast | Netflix | Amazon Prime Video | Additional Features: Apple Airplay | Apple Homekit | AlexaGoogle TV | Watchlist | Voice Search | Google Play | Chromecast | Netflix | Amazon Prime Video | Additional Features: Apple Airplay | Apple Homekit | Alexa\r\n" + //
						"Model Name                 :  KD-65X74K\r\n" + //
						"Included Components        :  1 LED TV, 1 Warranty Card, 1 AC Power Cord, 1 Remote Control, 1 Table-Top Stand, 1 User Manual, 2 AAA Batteries1 LED TV, 1 Warranty Card, 1 AC Power Cord, 1 Remote Control, 1 Table-Top Stand, 1 User Manual, 2 AAA Batteries\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*77990;
					if(opt_for_addcart == 1)
					{
						cart1 ="";
						amount_electronics=total;
						cart1 += "Sony Bravia 65-inch 4K UHD Smart TV!77,990#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else
					{
					amount_electronics += total;
					cart += "Sony Bravia 65-inch 4K UHD Smart TV!77,990#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						televisions();
					}
				}
				else if(opt_for_addcart == 3)
					televisions();
				break;
			case 3:
				total = 0;
				System.out.println("Vu 65-inch The Masterpiece Glo Series 4K UHD Smart Android QLED TV\r\n" + //
						"-------------------------------------------------------------------\r\n" + //
						"Screen Size                :  65 Inches\r\n" + //
						"Brand                      :  VU\r\n" + //
						"Supported Internet Services:  Netflix, Prime Video, Zee5, SonyLiv, Youtube, Spotify, Hotstar, Google Play Movies & TV, Browser\r\n" + //
						"Display Technology         :  QLED\r\n" + //
						"Product Dimensions         :  30.6D x 144.7W x 90.6H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  120 Hz\r\n" + //
						"Model Name                 :  Vu Masterpiece\r\n" + //
						"Included Components        :  1-TV Unit, Remote Control, Power Cord, User Manual, Table Mount Stand, VESA Wall Mount Bracket, 2 AAA Batteries1-TV Unit, Remote Control, Power Cord, User Manual, Table Mount Stand, VESA Wall Mount Bracket, 2 AAA Batteries\r\n" + //
						"Connectivity Technology    :  Wi-Fi, USB, Ethernet, HDMI\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*81990;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Vu 65-inch The Masterpiece Glo Series 4K UHD Smart Android QLED TV!81,990#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Vu 65-inch The Masterpiece Glo Series 4K UHD Smart Android QLED TV!81,990#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						televisions();
					}
				}
				else if(opt_for_addcart == 3)
					televisions();
				break;
			case 4:
				total = 0;
				System.out.println("Acer 65-inch I Series 4K UHD Android Smart TV\r\n" + //
						"----------------------------------------------\r\n" + //
						"Screen Size                 :  65 Inches\r\n" + //
						"Brand                       :  Acer\r\n" + //
						"Supported Internet Services :  Netflix, Prime Video, Zee5, Eros Now, JioCinema, SonyLiv, Youtube, Hungama, Google Play Store, Hotstar\r\n" + //
						"                            :  Netflix, Prime Video, Zee5, Eros Now, JioCinema, SonyLiv, Youtube, Hungama, Google Play Store, Hotstar\r\n" + //
						"Display Technology          :  LED\r\n" + //
						"Product Dimensions          :  8.5D x 144.6W x 83.1H Centimeters\r\n" + //
						"Resolution                  :  4K\r\n" + //
						"Refresh Rate                :  60 Hz\r\n" + //
						"Special Feature             :  Certified Android 11, Dolby Vision-Atmos, Dual Band Wifi, Blue Light Reduction, MEMC, Dynamic Signal Calibration, Wide Colour Gamut+, 1.07 Billion Colours, HDR10+ with HLG, 4K Upscaling, Digital Noise Reduction, Micro Dimming | Apps: Netflix, Youtube, Prime Video, Hotstar, SonyLiv, Hungama, JioCinema, Zee5, Eros Now, Google Play Store\r\n" + //
						"                            :  Certified Android 11, Dolby Vision-Atmos, Dual Band Wifi, Blue Light Reduction, MEMC, Dynamic Signal Calibration, Wide Colour Gamut+, 1.07 Billion Colours, HDR10+ with HLG, 4K Upscaling, Digital Noise...\r\n" + //
						"Model Name                  :  AR65AR2851UDFL\r\n" + //
						"Included Components         :  1 LED TV, 1 Remote, 2 AAA Battery, 1 User Manual, 2 Table Top Stands, 4 Screws\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*45999;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Acer 65-inch I Series 4K UHD Android Smart TV !45,999#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Acer 65-inch I Series 4K UHD Android Smart TV !45,999#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							televisions();
					}
				}
				else if(opt_for_addcart == 3)
					televisions();
				break;
			case 5:
				total = 0;
				System.out.println("LG 43-inch 4k UHD Smart LED TV\r\n" + //
						"------------------------------\r\n" + //
						"Screen Size                 :  43 Inches\r\n" + //
						"Brand                       :  LG\r\n" + //
						"Supported Internet Services :  Netflix, Prime Video, Zee5, Many more, Voot, SonyLIV, Discovery+, Youtube, YuppTV, Apple TV, Disney+ Hotstar\r\n" + //
						"                            :  Netflix, Prime Video, Zee5, Many more, Voot, SonyLIV, Discovery+, Youtube, YuppTV, Apple TV, Disney+ Hotstar\r\n" + //
						"Display Technology          :  LED\r\n" + //
						"Product Dimensions          :  18.7D x 97.3W x 57.2H Centimeters\r\n" + //
						"Resolution                  :  4K\r\n" + //
						"Refresh Rate                :  60 Hz\r\n" + //
						"Special Feature             :  WebOS 22 with User Profiles | Filmmaker Mode, HDR 10 Pro & HLG | Game Optimizer, ALLM, HGIG Mode | Unlimited OTT Apps | AI Brightness Control, 4K Upscaling & AI Sound (Virtual Surround 5.1 up-mix)\r\n" + //
						"                            :  WebOS 22 with User Profiles | Filmmaker Mode, HDR 10 Pro & HLG | Game Optimizer, ALLM, HGIG Mode | Unlimited OTT Apps | AI Brightness Control, 4K Upscaling & AI Sound (Virtual Surround 5.1\u2026\r\n" + //
						"Model Name                  :  UHD TV\r\n" + //
						"Included Components         :  1 UHD 4K TV, 1 Table Top Stand, 1 User Manual, 1 Warranty Card, 1 Remote Control, 2 Batteries\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*19999;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "LG 43-inch 4k UHD Smart LED TV!30,490#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "LG 43-inch 4k UHD Smart LED TV!30,490#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						televisions();
					}
				}
				else if(opt_for_addcart == 3)
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
						"Special Feature            :  Smart TV Features: Supported apps: Netflix, Prime Video, YouTube, etc., Screen mirroring, Universal Guide, Media Home, Tap View, Mobile Camera Support, AI Speaker, Easy Setup, App Casting, Wireless DeX, SmartThings, Smart Hub, IoT Sensor, Web Browser\r\n" + //
						"                           :  Smart TV Features: Supported apps: Netflix, Prime Video, YouTube, etc., Screen mirroring, Universal Guide, Media Home, Tap View, Mobile Camera Support, AI Speaker, Easy Setup, App Casting, Wireless DeX\u2026\r\n" + //
						"Model Name                 :  UA50CUE60AKLXL\r\n" + //
						"Included Components        :  1N LED TV, 1N Power Cord, 1N Remote Control, 2N Stand-Top, 1N OC, 1 User Manual, 1 LED TV, 2 Battery (AAA Size), 1 REMOCON, 1 Stant-Left, 1 Stant-Right\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*45990;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Samsung 50-inch Crystal iSmart 4K UHD Smart LED TV!45,990#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
					amount_electronics += quantity_mobiles*45990;
					cart += "Samsung 50-inch Crystal iSmart 4K UHD Smart LED TV!45,990#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						televisions();
					}
				}
				else if(opt_for_addcart == 3)
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
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 1 AC Cord, 2 AAA Batteries\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*12999;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "OnePlus 32-inch Y Series HD Ready LED Smart TV!12,999#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "OnePlus 32-inch Y Series HD Ready LED Smart TV!12,999#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("Enter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						televisions();
					}
				}
				else if(opt_for_addcart == 3)
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
						"Special Feature            :  Android TV 11 | PatchWall | IMDb Integration | Universal Search | 300+ Free Live Channels | Kids Mode with Parental lock | Smart Recommendations | Language Universe \u2013 15+ Languages | User Centre | Okay Google | Chromecast supporting Apps: Netflix, Prime Video, Disney+ Hotstar | 5000+ apps from Play Store | Quad core Cortex A35 | Chromecast built-in | Ok Google | Auto Low Latency Mode | 1GB RAM + 8GB Storage\r\n" + //
						"Model Name                 :  Xiaomi TV 5A 40\r\n" + //
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 4 screws, 2 x AAA Batteries\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*20999;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Mi 40 inches 5A Series FHD Smart Android LED TV !20,999#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Mi 40 inches 5A Series FHD Smart Android LED TV !20,999#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Telivisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							televisions();
					}
				}
				else if(opt_for_addcart == 3)
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
						"Special Feature            :  Android TV 11 | PatchWall | IMDb Integration | Universal Search | 300+ Free Live Channels | Kids Mode with Parental lock | Smart Recommendations | Language Universe \u2013 15+ Languages | User Centre | Okay Google | Chromecast supporting Apps: Netflix, Prime Video, Disney+ Hotstar | 5000+ apps from Play Store | Quad core Cortex A35 | Chromecast built-in | Ok Google | Auto Low Latency Mode | 1GB RAM + 8GB Storage\r\n" + //
						"Model Name                 :  Xiaomi TV 5A 32\r\n" + //
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 4 screws, 2 x AAA Batteries\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*12999;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Xiaomi A Series L32M8-5AIN 32 inch !12,999#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Xiaomi A Series L32M8-5AIN 32 inch !12,999#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if(opt_for_buynow == 2)
							televisions();
					}
				}
				else if(opt_for_addcart == 3)
					televisions();
				break;
			case 10:
				total  = 0;
				System.out.println("Xiaomi Smart TV X Series 55 inch\r\n" + //
						"---------------------------------\r\n" + //
						"Screen Size                :  55 Inches\r\n" + //
						"Brand                      :  Redmi\r\n" + //
						"Supported Internet Services:  Netflix, Prime Video, SonyLiv, Youtube, Hotstar\r\n" + //
						"Display Technology         :  LED\r\n" + //
						"Product Dimensions         :  3.2D x 48.8W x 28.1H Centimeters\r\n" + //
						"Resolution                 :  4K\r\n" + //
						"Refresh Rate               :  60 Hz\r\n" + //
						"Special Feature            :  Android TV 10 | Quick Wake - Wake TV Under 5 secs | PatchWall | Supported Apps: Netflix | Prime Video | Disney+ Hotstar | YouTube | 5000+ apps from Google Play Store\r\n" + //
						"Model Name                 :  Redmi Smart TV X55 (138.8cm)\r\n" + //
						"Included Components        :  1 LED TV, 2 Table Stand Base, 1 User Manual, 1 Remote Control, 4 screws\r\n" + //
						"");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Televisions\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*36999;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Xiaomi Smart TV X Series 55!36,999#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Xiaomi Smart TV X Series 55!36,999#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Televisions\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("Enter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							televisions();
					}
				}
				else if(opt_for_addcart == 3)
					televisions();
				break;

			case 0 :
				electronics();
				break;
			default :
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				televisions();
		}
	}


	

	//object for bill class
	static Bill b_obj = new Bill();

	void electronics()
	{
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tELECTRONICS");
		System.out.println("\t\t\t\t\t\t\t\t1.Mobiles\n\t\t\t\t\t\t\t\t2.Laptops\n\t\t\t\t\t\t\t\t3.Earphones\n\t\t\t\t\t\t\t\t4.Televisions\n\n\t\t\t\t\t\t\t\t9.check out\n\t\t\t\t\t\t\t\t0.Home");
		System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
		String optforelehome = sc.nextLine();
		int opt_for_ele_home = Integer.parseInt(optforelehome);
		if(opt_for_ele_home == 1)
		{
			electronics_obj.mobiles();
		}
		else if(opt_for_ele_home == 2)
		{
			electronics_obj.laptops();
		}
		else if(opt_for_ele_home == 3)
		{
			electronics_obj.earphones();
		}
		else if(opt_for_ele_home == 4)
		{
			electronics_obj.televisions();
		}
		else if(opt_for_ele_home == 0)
		{
			User u_obj = new User();
			u_obj.selection();
		}
		else if(opt_for_ele_home == 9)
		{
			b_obj.billDisplay(cart);
		}
	}
}



/* ****************************   B E A U T Y **************************************************************** */


class Beauty extends Electronics
{
	static Beauty beauty_obj = new Beauty();
	void men()
	{
		System.out.println();
		 System.out.println(Colors.blue+"\t\t\t\t\t\t\t\t\t\t1.Aqualogica Glow+ Dewy Sunscreen    \t\t-  \t484\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t2.The Moms Co. Natural Green  Face Wash \t-\t174\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t3.Plum Green Tea Alcohol Free Toner\t\t-\t300\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t4.Glenmark Episoft AC Moisturizer\t\t-\t449\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t5.Bella Vita Organic EyeLift\t\t\t- \t224\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t6.Kimirica Bouquet Hand Lotion \t\t\t-\t416\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t7.Enchanteur Romantic Perfumed Shower Gel\t-\t159\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t8.Beardo Lip Lightener for Smokers\t\t-\t349\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t9.qualogica Radiance+ Oil Free Moisturizer\t-\t354\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t10.Aqualogica Glow+ Squishy Shower Gel\t\t-\t296\r\n" + //
                "\t\t\t\t\t\t\t\t\t\t\r\n" + //
                ""+Colors.reset);
		System.out.println();
		System.out.println("\n\t\t\t\t\t\t\t\t0.Back To Beauty Products");
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
		String optformobiles = sc.nextLine();
		int opt_for_mobiles = Integer.parseInt(optformobiles);
		int total;
		switch(opt_for_mobiles)
		{
			case 1:
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tAqualogica Glow+ Dewy Sunscreen\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                    Papaya\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tProduct Benefits         Hydrating\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSun Protection Factor    50 Sun Protection Factor (SPF)\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Weight              80 Grams\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items          1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNet Quantity             80.0 gram\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type                All\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tActive Ingredients       Hyaluronic acid, vitamin c\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Dimensions LxWxH    42 x 42 x 145 Millimeters\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                    Aqualogica\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);

				if(opt_for_addcart == 1 || opt_for_addcart ==  2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*484;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Aqualogica Glow+ Dewy Sunscreen!484#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total;
						cart += "Aqualogica Glow+ Dewy Sunscreen!484#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							b_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 2:
						total = 0 ;
						System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tThe Moms Co. Natural Green Face Wash\r\n" + //
								"\t\t\t\t\t\t\t\t\t\t------------------------------------\r\n" + //
								"\t\t\t\t\t\t\t\t\t\t\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tItem Form              Gel\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tSkin Type              All\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tBrand                  The Moms Co\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tScent                  Fresh\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tMaterial Feature       Natural\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tMaterial Type Free     Soap Free, Soap-free\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tAge Range (Description)  Adult\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tNumber of Items        80\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tNet Quantity           80.0 millilitre\r\n" + //
								"\t\t\t\t\t\t\t\t\t\tItem Package Quantity  1\r\n" + //
								""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
			System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*174;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "The Moms Co. Natural Green Face Wash!#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total;
						cart += "The Moms Co. Natural Green Face Wash!174#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							b_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tPlum Green Tea Alcohol Free Toner\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t------------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                         Plum\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Form                     Drop\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type                     Oily, Acne-prone, Combination\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Type Free            Alcohol Free, Alcohol-free\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tProduct Benefits              Pore Treatment\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tRecommended Uses For Product  Toning\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Feature              Natural\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                         Green Tea\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Volume                   200 Millilitres\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Weight                   0.22 Grams\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*300;
					if(opt_for_addcart ==1)
					{
						cart1 = "";
						amount_electronics=total;
						cart1 += "Plum Green Tea Alcohol Free Toner!300#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics+=total;
						cart += "Plum Green Tea Alcohol Free Toner!300#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
					{
						b_obj.billDisplay(cart);
					}
					else if(opt_for_buynow == 2)
						men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tGlenmark Episoft AC Moisturizer\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                    Fragrance free\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tProduct Benefits         Moisturizing\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSun Protection Factor    30 Sun Protection Factor (SPF)\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Weight              75 Grams\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items          1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNet Quantity             75 gram\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type                All\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tActive Ingredients       Disodium edta, glycerin, propanediol\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Dimensions LxWxH    44 x 43 x 142 Millimeters\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                    Episoft\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*449;
					if(opt_for_addcart ==1 )
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Glenmark Episoft AC Moisturizer!449#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2){
					amount_electronics += total;
					cart += "Glenmark Episoft AC Moisturizer!449#"+quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 5:
					total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tBella Vita Organic EyeLift\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                   Bella Vita Organic\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                   Cucumber\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Form               Gel\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tActive Ingredients      Retinol\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNet Quantity            20.0 gram\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items         1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tUse for                Eyes\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type               All\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSpecial Ingredients     Aloe Vera, Almond Oil\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Type Free      Sodium Lauryl Sulfate Free (SLS)\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*224;
					if(opt_for_addcart ==1)
					{
						cart1 ="";
						amount_electronics=total;
						cart1 += "Bella Vita Organic EyeLift!224#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total ;
						cart += "Bella Vita Organic EyeLift!224#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							bill_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tKimirica Bouquet Hand Lotion\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                   KIMIRICA\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                   Frangipanis & Rose\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Form               Lotion\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tActive Ingredients      Vitamin E\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNet Quantity            300.0 millilitre\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items         1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type               All\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSpecial Ingredients     Aloe Vera, Rose\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Type Free      Paraben Free\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tProduct Benefits        For Hair Uses Only\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*416;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Kimirica Bouquet Hand Lotion!416#"+ quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total ;
					cart += "Kimirica Bouquet Hand Lotion!416#"+ quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
					{
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_buynow == 2)
						men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tBeardo Lip Lightener for Smokers\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                   BEARDO\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Form               Balm\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tFinish Type             Glossy\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type               Normal\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tColour                  White\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tProduct Benefits        Brightening, Lightening, Lip, Lip Lightener, Lip Lightening, Smoothening, Softening\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Feature        Natural\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Type Free      No Parabens, Sulfates\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Weight             7 Grams\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items         1\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*349;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Beardo Lip Lightener for Smokers!349#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Beardo Lip Lightener for Smokers!349#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)

							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tEnchanteur Romantic Perfumed Shower Gel\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Form               Gel\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type               Normal\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                   Enchanteur\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                   Floral\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tAge Range (Description)  Adult\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items         1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNet Quantity            250.0 millilitre\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Package Quantity   1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tUse for                 Skin, Body\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tProduct Benefits        Hydrating\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*159;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics = total;
						cart1 += "Enchanteur Romantic Perfumed Shower Gel!159#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Enchanteur Romantic Perfumed Shower Gel!159#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tDr. Sheth's Radiance+ Oil Free Moisturizer\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                   Dr. Sheth's\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                   Unscented\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Form               Cream\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tActive Ingredients      1% Vitamin C\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNet Quantity            50.0 gram\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items         1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tUse for                 Face\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type               All\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSpecial Ingredients     Vitamin C, Ceramide\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Type Free      Oil Free, Sulfate Free, Paraben Free\r\n" + //
						""+Colors.reset);
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*354;
					if(opt_for_addcart == 1 )
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += " qualogica Radiance+ Oil Free Moisturizer!354#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += " qualogica Radiance+ Oil Free Moisturizer!354#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tAqualogica Glow+ Squishy Shower Gel\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------\r\n" + //
						"\t\t\t\t\t\t\t\t\t\t\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tItem Form               Liquid\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSkin Type               All\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tBrand                   Aqualogica\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tScent                   Watermelon\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Feature        Vegan\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial Type Free      Toxin-free\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tAge Range (Description) Adult\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNumber of Items         1\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tNet Quantity            250.0 millilitre\r\n" + //
						"\t\t\t\t\t\t\t\t\t\tSpecial Feature         Cruelty Free, Vegan\r\n" + //
						""+Colors.reset);
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
                    System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*296;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += " Aqualogica Glow+ Squishy Shower Gel!296#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += " Aqualogica Glow+ Squishy Shower Gel!296#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Men Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							men();
					}
				}
				else if(opt_for_addcart == 3)
					men();
				break;

			case 0 :
				beauty();
				break;
			default :
				System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid Option"+Colors.reset);
				men();
				
				
		}
	}

	void women()
	{

		System.out.println(Colors.blue+"\t\t\t\t\t\t\t\t\t\t1.Garnier Skin Naturals, Cleansing Water\t\t-\t164\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t2.Matrix Opti.Repair Professional Shampoo\t\t-\t634\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t3.Kaya Clinic Hair Nourishing Shampoo\t\t\t-\t203\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t4.Maybelline New York Waterproof Mascara\t\t-\t799\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t5.Maybelline New York Eyeshadow Palette\t\t\t-\t679\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t6.Dermafique Age Defying Nuit Regenerating Cream\t-\t407\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t7.The Moms Co. Natural Vita Rich Under Eye Cream\t-\t249\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t8.Aqualogica Radiance+ Oil Free Moisturizer \t\t-\t354\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t9.Noor Skincare Eyebrow Growth Serum\t\t\t-\t315\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t10.Enchanteur Charming Perfumed Soap for Women\t\t-\t185"+Colors.reset);
		System.out.println(Colors.yellow+"0.Back"+Colors.reset);
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

		String optforlaptops = sc.nextLine();
		int opt_for_laptops = Integer.parseInt(optforlaptops);
		int total;
		switch(opt_for_laptops)
		{
			case 1:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t\t\tGarnier Skin Naturals, Cleansing Water\r\n" + //
						"---------------------------------------\r\n" + //
						"\r\n" + //
						"Item Form               Liquid\r\n" + //
						"Skin Type               All\r\n" + //
						"Brand                   Garnier\r\n" + //
						"Scent                   Fresh\r\n" + //
						"Material Feature        Natural\r\n" + //
						"Material Type Free      Paraben Free; Alcohol Free; Sulfate Free\r\n" + //
						"Age Range (Description) Adult\r\n" + //
						"Number of Items         1\r\n" + //
						"Net Quantity            1 count\r\n" + //
						"Special Feature         Natural Ingredients\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*164;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Acer Aspire 5 Gaming Laptop!164#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Garnier Skin Naturals, Cleansing Water!164#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"Brand Bare Anatomy\r\n" + //
						"Item Form                Liquid\r\n" + //
						"Hair Type                Oily\r\n" + //
						"Scent                    Aloe Vera\r\n" + //
						"Age Range (Description)  Adult\r\n" + //
						"Material Type Free       Sulphate Free, Phthalate Free, Alcohol Free, Paraben Free, Formaldehyde Free\r\n" + //
						"Special Feature          Not Tested On Animals, Scented, Travel Size, Vegan\r\n" + //
						"Product Benefits         Anti-Dandruff\r\n" + //
						"Liquid Volume            250 Millilitres\r\n" + //
						"Recommended Uses For Product  Itchy Scalp\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*634;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Matrix Opti.Repair Professional Shampoo!634#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Matrix Opti.Repair Professional Shampoo!634#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 3:
			total = 0;
				System.out.println(Colors.cyan+"Kaya Clinic Hair Nourishing Shampoo\r\n" + //
						"------------------------------------\r\n" + //
						"\r\n" + //
						"Brand                    Kaya Clinic\r\n" + //
						"Item Form                Liquid\r\n" + //
						"Hair Type                All\r\n" + //
						"Scent                    Lemon\r\n" + //
						"Age Range (Description)  Adult\r\n" + //
						"Special Feature          Nourishing\r\n" + //
						"Product Benefits         Anti-Hair Loss, Breakage Control, PH Balancing\r\n" + //
						"Liquid Volume            225 Millilitres\r\n" + //
						"Recommended Uses For Product  Hair Breakage\r\n" + //
						"Number of Items          1\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*203;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Kavya Clinic Hair Nourishing Shampoo!203#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Kavya Clinic Hair Nourishing Shampoo!203#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"Maybelline New York Waterproof Mascara\r\n" + //
						"------------------------------------\r\n" + //
						"\r\n" + //
						"Colour                   Black\r\n" + //
						"Product Benefits         Curling, Lengthening, Nourishing, Volume, Volumizing\r\n" + //
						"Special Feature          Waterproof\r\n" + //
						"Brand                    Maybelline\r\n" + //
						"Item Form                Gel\r\n" + //
						"Speciality               Volumizing\r\n" + //
						"Number of Items          1\r\n" + //
						"Net Quantity             6.0 millilitre\r\n" + //
						"Item Volume              0.2 Fluid Ounces\r\n" + //
						"Package Information      Tube\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*799;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Maybelline New York Waterproof Mascara!799#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
					amount_electronics += total;
					cart += "Maybelline New York Waterproof Mascara!799#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 5:
				total  = 0;
				System.out.println(Colors.cyan+"Maybelline New York Eyeshadow Palette\r\n" + //
						"------------------------------------\r\n" + //
						"\r\n" + //
						"Colour                   Nude\r\n" + //
						"Brand                    Maybelline\r\n" + //
						"Item Form                Powder\r\n" + //
						"Finish Type              Shimmery\r\n" + //
						"Special Feature          Blendable\r\n" + //
						"Product Benefits         Blendable\r\n" + //
						"Number of Items          1\r\n" + //
						"Net Quantity             9.0 gram\r\n" + //
						"Coverage                 Full\r\n" + //
						"Skin Type                All\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_laptops==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*679;
					if(opt_for_addcart ==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Maybelline New York Eyeshadow Palette!679#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else
					{
					amount_electronics += total;
					cart += "Maybelline New York Eyeshadow Palette!679#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 2)
					women();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"Dermafique Age Defying Nuit Regenerating Cream\r\n" + //
						"------------------------------------\r\n" + //
						"\r\n" + //
						"Brand                    Dermafique\r\n" + //
						"Scent                    Apple\r\n" + //
						"Item Form                Cream\r\n" + //
						"Net Quantity             30.0 gram\r\n" + //
						"Number of Items          1\r\n" + //
						"Skin Type                All\r\n" + //
						"Item Volume              30 Millilitres\r\n" + //
						"Product Benefits         Fighting major signs of ageing\r\n" + //
						"Age Range (Description)  Adult\r\n" + //
						"Special Feature          Anti Aging\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*407;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Dermafique Age Defying Nuit Regenerating Cream!407#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Dermafique Age Defying Nuit Regenerating Cream!407#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 7:
				total  = 0;
				System.out.println(	Colors.cyan+"The Moms Co. Natural Vita Rich Under Eye Cream\r\n" + //
						"------------------------------------\r\n" + //
						"\r\n" + //
						"Skin Type                        All\r\n" + //
						"Product Benefits                 Soothing\r\n" + //
						"Use for                          Face\r\n" + //
						"Scent                            Shea Butter, Avocado, Chamomile, Green Tea\r\n" + //
						"Brand                            The Moms Co\r\n" + //
						"Item Form                        Drop\r\n" + //
						"Material Feature                 Antioxidant\r\n" + //
						"Active Ingredients               Vitamin C, Vitamin E\r\n" + //
						"Skin Tone                        All\r\n" + //
						"Recommended Uses For Product    Soothing, Dark Circle, Puffiness, Provides Vitamins, Wrinkles\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*249;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "The Moms Co. Natural Vita Rich Under Eye Cream!249#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "The Moms Co. Natural Vita Rich Under Eye Cream!249#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 8:
				System.out.println(Colors.cyan+"Aqualogica Radiance+ Oil Free Moisturizer\r\n" + //
						"------------------------------------\r\n" + //
						"\r\n" + //
						"Brand                            Aqualogica\r\n" + //
						"Recommended Uses For Product     Hydrating, Moisturizing\r\n" + //
						"Installation Type                Free Standing\r\n" + //
						"Special Feature                  Lightweight\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*354;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Aqualogica Radiance+ Oil Free Moisturizer!354#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Aqualogica Radiance+ Oil Free Moisturizer!354#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"Noor Skincare Eyebrow Growth Serum\r\n" + //
						"-----------------------------------\r\n" + //
						"\r\n" + //
						"Brand                    Bella Vita Organic\r\n" + //
						"Scent                    Vanilla\r\n" + //
						"Item Weight              12 Grams\r\n" + //
						"Item Form                Liquid\r\n" + //
						"Active Ingredients       Almond oil, avocado, castor oil, coconut oil, vitamin e\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*315;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Noor Skincare Eyebrow Growth Serum!315#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Noor Skincare Eyebrow Growth Serum!315#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"Enchanteur Charming Perfumed Soap for Women\r\n" + //
						"----------------------------------------\r\n" + //
						"\r\n" + //
						"Item Form               Soap\r\n" + //
						"Skin Type               All\r\n" + //
						"Brand                   Enchanteur\r\n" + //
						"Scent                   Floral\r\n" + //
						"Age Range (Description) Adult\r\n" + //
						"Number of Items         4\r\n" + //
						"Net Quantity            300.0 gram\r\n" + //
						"Item Package Quantity   1\r\n" + //
						"Use for                 Skin, Body\r\n" + //
						"Product Benefits        Moisturizing\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*185;
					if(opt_for_addcart == 2)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Enchanteur Charming Perfumed Soap for Women!185#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
					amount_electronics += total;
					cart += "Enchanteur Charming Perfumed Soap for Women!185#" + quantity+"@"+total+"&";
					System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Women Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

					System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						women();
					}
				}
				else if(opt_for_addcart == 3)
					women();
				break;

			case 0 :
				beauty();
				break;
			default :
				System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid Option"+Colors.reset);
				women();
		}
	}



	void kids()
	{

		System.out.println(Colors.blue+"1.Cetaphil Baby Daily Lotion, White\t\t-\t715\r\n" + //
				"2.Clensta Eggstreme Eyebrow Growth Serum Roll\t-\t299\r\n" + //
				"3.Organicos Eye Brow Growth Serum\t\t-\t399\r\n" + //
				"4.Noor Skincare Eyebrow Growth Serum\t\t-\t499\r\n" + //
				"5.Bella Vita Organic GrowBrow\t\t\t-\t261\r\n" + //
				"6.RENEE Eyebrow Growth Roll on Serum 8ml\t-\t257\r\n" + //
				"7.7 Days Eyelash Growth Serum Oil and Eyebrow\t-\t239\r\n" + //
				"8.HONEY \u2018N\u2019 BEAUTE Eyebrow Growth Serum\t\t-\t239\r\n" + //
				"9.Figaro Baby Lotion with oil\t\t\t-\t185\r\n" + //
				"10.Afflatus Ayurvedic AD Vitamin Baby  Oil\t-\t390"+Colors.reset);
		System.out.println(Colors.yellow+"0.Back"+Colors.reset);
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

		String optforearphones = sc.nextLine();
		int opt_for_earphones = Integer.parseInt(optforearphones);
		int total = 0;
		switch(opt_for_earphones)
		{
			case 1:
			total = 0;
			System.out.println(Colors.cyan+"Cetaphil Baby Daily Lotion, White\r\n" + //
					"-----------------------------------\r\n" + //
					"\r\n" + //
					"Brand                    Cetaphil\r\n" + //
					"Scent                    Shea Butter\r\n" + //
					"Item Form                Lotion\r\n" + //
					"Active Ingredients       Soybean oil, sunflower oil, glycerin, and shea butter\r\n" + //
					"Net Quantity             400 millilitre\r\n" + //
					"Number of Items          1\r\n" + //
					"Use for                  Whole Body\r\n" + //
					"Skin Type                All, Sensitive\r\n" + //
					"Special Ingredients      Shea Butter\r\n" + //
					"Material Type Free       Oil Free\r\n" + //
					""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*715;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Cetaphil Baby Daily Lotion, White!715#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Cetaphil Baby Daily Lotion, White!715#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);

						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
		
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"Clensta Eggstreme Eyebrow Growth Serum Roll\r\n" + //
						"--------------------------------------------\r\n" + //
						"\r\n" + //
						"Brand                    Clensta\r\n" + //
						"Item Form                Drop\r\n" + //
						"Active Ingredients       Egg Protein, Vitamin E, Almond Oil\r\n" + //
						"Material Type Free       Paraben Free\r\n" + //
						"Age Range (Description)  Adult\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total += quantity_mobiles*299;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Clensta Eggstreme Eyebrow Growth Serum Roll!299#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Clensta Eggstreme Eyebrow Growth Serum Roll!299#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"Organicos Eye Brow Growth Serum\r\n" + //
						"----------------------------------\r\n" + //
						"\r\n" + //
						"Skin Type                 All\r\n" + //
						"Product Benefits          Conditioning\r\n" + //
						"Scent                     Fragrance Free\r\n" + //
						"Brand                     ORGANICOS\r\n" + //
						"Item Form                 Drop\r\n" + //
						"Material Feature          Natural\r\n" + //
						"Skin Tone                 All\r\n" + //
						"Material Type Free        Paraben Free\r\n" + //
						"Number of Items           1\r\n" + //
						"Net Quantity              30.0 millilitre\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*399;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Organicos Eye Brow Growth Serum!399#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Organicos Eye Brow Growth Serum!399#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"Noor Skincare Eyebrow Growth Serum\r\n" + //
						"------------------------------------\r\n" + //
						"\r\n" + //
						"Product Benefits             Promotes new hair growth for thicker and voluminous eyebrow & eyelashes\r\n" + //
						"Scent                        Castor oil\r\n" + //
						"Brand                        Noor skincare\r\n" + //
						"Item Form                    Oil\r\n" + //
						"Material Feature              Natural\r\n" + //
						"Active Ingredients           Castor oil, Almond oil, Coconut oil, Rosemary essential oil & Vitamin E\r\n" + //
						"Skin Tone                    All\r\n" + //
						"Material Type Free           Chemical Free\r\n" + //
						"Recommended Uses For Product External use only\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*499;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Noor Skincare Eyebrow Growth Serum!499#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Noor Skincare Eyebrow Growth Serum!499#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
					}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 5:
				System.out.println(Colors.cyan+"Bella Vita Organic GrowBrow\r\n" + //
						"------------------------------\r\n" + //
						"\r\n" + //
						"Brand                   Bella Vita Organic\r\n" + //
						"Scent                   Vanilla\r\n" + //
						"Item Weight             12 Grams\r\n" + //
						"Item Form               Liquid\r\n" + //
						"Active Ingredients      Almond oil, avocado, castor oil, coconut oil, vitamin E\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*261;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Bella Vita Organic GrowBrow!261#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
							amount_electronics += total;
							cart += "Bella Vita Organic GrowBrow!261#" + quantity+"@"+total+"&";
							System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

							System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

							optforbuynow = sc.nextLine();
							opt_for_buynow = Integer.parseInt(optforbuynow);
							if(opt_for_buynow == 1)
								bill_obj.billDisplay(cart);
							else if(opt_for_buynow == 2)
								kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"RENEE Eyebrow Growth Roll-on Serum 8ml\r\n" + //
						"---------------------------------------\r\n" + //
						"\r\n" + //
						"Brand                    RENEE\r\n" + //
						"Item Form                Oil\r\n" + //
						"Colour                   Transparent\r\n" + //
						"Finish Type              Natural\r\n" + //
						"Special Feature          Not Tested On Animals, Travel Size, Natural Ingredients\r\n" + //
						"Material Feature         Natural\r\n" + //
						"Product Benefits         Brow Correction, Moisturizing, Nourishing\r\n" + //
						"Skin Type                All\r\n" + //
						"Speciality               Sulphate Free, Phthalate Free\r\n" + //
						"Coverage                 Full\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*257;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "RENEE Eyebrow Growth Roll-on Serum 8ml!257#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "RENEE Eyebrow Growth Roll-on Serum 8ml!257#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"7 Days Eyelash Growth Serum Oil and Eyebrow\r\n" + //
						"-------------------------------------------\r\n" + //
						"\r\n" + //
						"Brand                    Clensta\r\n" + //
						"Item Form                Drop\r\n" + //
						"Active Ingredients       Egg Protein, Vitamin E, Almond Oil\r\n" + //
						"Material Type Free       Paraben Free\r\n" + //
						"Age Range (Description)  Adult\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*239;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "7 Days Eyelash Growth Serum Oil and Eyebrow!239#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "7 Days Eyelash Growth Serum Oil and Eyebrow!239#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"HONEY N BEAUTE Eyebrow Growth Serum\r\n" + //
						"---------------------------------------\r\n" + //
						"\r\n" + //
						"Brand                    ATOGLA\r\n" + //
						"Scent                    Intense\r\n" + //
						"Item Form                Lotion\r\n" + //
						"Active Ingredients       Ceramide, Panthenol\r\n" + //
						"Net Quantity             200.0 millilitre\r\n" + //
						"Number of Items          1\r\n" + //
						"Use for                  Whole Body\r\n" + //
						"Skin Type                All\r\n" + //
						"Special Ingredients      Cocoa Butter\r\n" + //
						"Item Volume              200 Millilitres\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*239;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "HONEY N BEAUTE Eyebrow Growth Serum!239#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);

					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "HONEY N BEAUTE Eyebrow Growth Serum!239#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
					
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"Figaro Baby Lotion with oil\r\n" + //
						"-----------------------------\r\n" + //
						"\r\n" + //
						"Brand                    Figaro Baby\r\n" + //
						"Scent                    Musk\r\n" + //
						"Item Form                Lotion\r\n" + //
						"Active Ingredients       Musk\r\n" + //
						"Net Quantity             200.0 millilitre\r\n" + //
						"Number of Items          1\r\n" + //
						"Use for                  Whole Body\r\n" + //
						"Skin Type                All\r\n" + //
						"Special Ingredients      Olive Oil\r\n" + //
						"Material Type Free       Paraben Free\r\n" + //
						""+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*185;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Figaro Baby Lotion with oil!185#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Figaro Baby Lotion with oil!185#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"Afflatus Ayurvedic AD Vitamin Baby Massage Oil\r\n" + //
						"-------------------------------------------------\r\n" + //
						"\r\n" + //
						"Brand\tAfflatus\r\n" + //
						"Item Form\tOil\r\n" + //
						"Net Quantity\t300.0 millilitre\r\n" + //
						"Number of Items\t3\r\n" + //
						"Use for\tWhole Body\r\n" + //
						"Skin Type\tAll\r\n" + //
						"Special Ingredients\tOlive Oil\r\n" + //
						"Material Type Free\tChemical Free\r\n" + //
						"Item Volume\t100 Millilitres\r\n" + //
						"Product Benefits\tMoisturizing"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*390;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Afflatus Ayurvedic AD Vitamin Baby Massage Oil!390#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Afflatus Ayurvedic AD Vitamin Baby Massage Oil!390#" + quantity+"@"+total+"&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Kids Section"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;

			case 0 :
				beauty();
				break;
			default :
				System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid Option"+Colors.reset);
				kids();
		}
	}

	static Bill b_obj = new Bill();

	void beauty()
	{
		System.out.println(Colors.blue+"\t\t\t\t\t\t\t\t\t\t\t\tBEAUTY PRODUCTS"+Colors.reset);
		System.out.println(Colors.blue+"\t\t\t\t\t\t\t\t1.Men\n\t\t\t\t\t\t\t\t2.Women\n\t\t\t\t\t\t\t\t3.Kids\n\n\t\t\t\t\t\t\t\t9.check out\n\t\t\t\t\t\t\t\t0.Home"+Colors.reset);
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

		String optforelehome = sc.nextLine();
		int opt_for_ele_home = Integer.parseInt(optforelehome);
		if(opt_for_ele_home == 1)
		{
			beauty_obj.men();
		}
		else if(opt_for_ele_home == 2)
		{
			beauty_obj.women();
		}
		else if(opt_for_ele_home == 3)
		{
			beauty_obj.kids();
		}
		else if(opt_for_ele_home == 0)
		{
			User u_obj = new User();
			u_obj.selection();
		}
		else if(opt_for_ele_home == 9)
		{
			b_obj.billDisplay(cart);
		}
	}
}

/* ********************************** C L O T H I N G ********************************************/

//class for Clothing
class Clothing extends Electronics
{
	
	static  Clothing clothing_obj = new Clothing();
	
	void mens()
	{
		System.out.println();
		System.out.println(Colors.blue+"\t\t\t\t\t\t\t\t\t\t1.Luxury PV Lycra Stretchable Formal Pants for Men\t:\t1900\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t2.Symbol Men Regular Casual Pants\t\t\t:\t699\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t3.Ben Martin Men's Relaxed Fit Jeans\t\t\t:       628\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t4.U.S. Polo Assn. Mens Comfort Fit Solid I668 Shorts    :       499\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t5.hotfits Stylish Men Multicolored Cotton Shorts\t:\t685\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t6.Men's Cotton Printed Kurta with Pyjama \t\t:\t499\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t7.Urbano Fashion Men's Slim Fit Jogger Jeans Stretch\t:\t677\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t8.Dixcy Scott Men Vest\t\t\t\t\t:\t410\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t9.Levi's Men Brief\t\t\t\t\t:\t348\r\n" + //
				"\t\t\t\t\t\t\t\t\t\t10.Allen Solly Men Polo\t\t\t\t\t:\t689"+Colors.reset);
		System.out.println();
		System.out.println(Colors.yellow+"\n\t\t\t\t\t\t\t\t0.Back To Clothing"+Colors.reset);
		System.out.print(Colors.purple+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
		String optformobiles = sc.nextLine();
		int opt_for_mobiles = Integer.parseInt(optformobiles);
		int total;
		switch(opt_for_mobiles)
		{
			case 1:
				System.out.println(Colors.green+"\t\t\t\t\t\t\t\t\t\tLuxury PV Lycra Stretchable Formal Pants for Men \n" + //
						"\t\t\t\t\t\t\t\t\t\t--------------------------------------------------\n" +Colors.reset+ //
						Colors.cyan+"\t\t\t\t\t\t\t\t\t\tCare Instructions: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tSTRETCHABLE WAIST: Pant waist is the same as actual waist when measured with a measuring tape. \n" + //
						"\t\t\t\t\t\t\t\t\t\tIn doubt, order a size smaller as our REVOLUTIONARY FLEXTECH WAISTBAND stretches up to 2 INCHES extra while fitting perfectly");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Clothing\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);

				if(opt_for_addcart == 1 || opt_for_addcart ==  2)
				{
					System.out.print("\n\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*1900;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Luxury PV Lycra Stretchable Formal Pants for Men! 1900#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total;
						cart += "Luxury PV Lycra Stretchable Formal Pants for Men! 1900#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							b_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 2:
						total = 0 ;
						System.out.println("\t\t\t\t\t\t\t\t\t\tSymbol Men Regular Casual Pants\n" + //
								"\t\t\t\t\t\t\t\t\t\t-----------------------------------\n" + //
								"\t\t\t\t\t\t\t\t\t\tFit Type: Regular\n" + //
								"\t\t\t\t\t\t\t\t\t\tRegular Fit\n" + //
								"\t\t\t\t\t\t\t\t\t\tWashed out look is an inherent property of this product\n" + //
								"\t\t\t\t\t\t\t\t\t\tMachine wash cold, Wash dark colors separately, Do not bleach, Tumble dry low, Warm iron\n" + //
								"\t\t\t\t\t\t\t\t\t\t100% Cotton");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*699;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Symbol Men Regular Casual Pants! 699#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total;
						cart += "Symbol Men Regular Casual Pants! 699#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println("\t\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens\n\t\t\t\t\t\t\t\t0.Press any Key to Exit\n");
						System.out.print("\t\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							b_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 3:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tBen Martin Men's Relaxed Fit Jeans\n" + //
						"\t\t\t\t\t\t\t\t\t\t----------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial: Cotton\n" + //
						"\t\t\t\t\t\t\t\t\t\tColor: Dark Blue\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Relaxed; Occasion: Casual\n" + //
						"\t\t\t\t\t\t\t\t\t\tPackage Contents: 1 Jeans");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mens \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*628;
					if(opt_for_addcart ==1)
					{
						cart1 = "";
						amount_electronics=total;
						cart1 += "Ben Martin Men's Relaxed Fit Jeans! 628#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics+=total;
						cart += "Ben Martin Men's Relaxed Fit Jeans! 628#"+quantity+"@"+total+"&";
						System.out.println();
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
					{
						b_obj.billDisplay(cart);
					}
					else if(opt_for_buynow == 2)
						mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 4:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tU.S. Polo Assn. Mens Comfort Fit Solid I668 Shorts\n" + //
						"\t\t\t\t\t\t\t\t\t\t-----------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tMid-rise\n" + //
						"\t\t\t\t\t\t\t\t\t\tPremium combed cotton rich jersey fabric\n" + //
						"\t\t\t\t\t\t\t\t\t\tMoisture management for better breathability, anti-pilling, anti-static properties");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*499;
					if(opt_for_addcart ==1 )
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "U.S. Polo Assn. Mens Comfort Fit Solid I668 Shorts! 499#"+quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2){
					amount_electronics += total;
					cart += "U.S. Polo Assn. Mens Comfort Fit Solid I668 Shorts! 499#"+quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 5:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\thotfits Stylish Men Multicolored Cotton Shorts\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tare Instructions: Hand Wash Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tTwo side pockets\n" + //
						"\t\t\t\t\t\t\t\t\t\t100% cotton soft feel fabric\n" + //
						"\t\t\t\t\t\t\t\t\t\tSize rope for size adjustments\n" + //
						"\t\t\t\t\t\t\t\t\t\tSize Name: 2xl; Age Range Description: Adult");	
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*685;
					if(opt_for_addcart ==1 )
					{
						cart1 ="";
						amount_electronics=total;
						cart1 += "hotfits Stylish Men Multicolored Cotton Shorts! 685#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart ==2 )
					{
						amount_electronics += total ;
						cart += "hotfits Stylish Men Multicolored Cotton Shorts! 685#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
						{
							bill_obj.billDisplay(cart);
						}
						else if(opt_for_buynow == 2)
							mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 6:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tMen's Cotton Printed Kurta with Pyjama \n" + //
						"\t\t\t\t\t\t\t\t\t\t---------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tKURTA CHURIDAR SET\n" + //
						"\t\t\t\t\t\t\t\t\t\tSuitable for: Party, Weddings, Celebrations, Occasions, Festivals, Makar Sakranti, Holi, Raksha Bandhan, Dussehra, Diwali.");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*499;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Men's Cotton Printed Kurta with Pyjama! 499#"+ quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total ;
					cart += "Men's Cotton Printed Kurta with Pyjama! 499#"+ quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens \n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
					{
						bill_obj.billDisplay(cart);
					}
					else if(opt_for_buynow == 2)
						mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 7:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tUrbano Fashion Men's Slim Fit Jogger Jeans Stretch\n" + //
						"\t\t\t\t\t\t\t\t\t\t----------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions: Wash Dark Colors Separately\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Slim Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial: Cotton with Lycra for Stretchability\n" + //
						"\t\t\t\t\t\t\t\t\t\tColor: Black\n" + //
						"\t\t\t\t\t\t\t\t\t\tClosure: Drawstring; Fit Type: Slim Fit");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*677;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += "Urbano Fashion Men's Slim Fit Jogger Jeans Stretch! 677#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Urbano Fashion Men's Slim Fit Jogger Jeans Stretch! 677#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)

							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 8:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tDixcy Scott Men Vest\n" + //
						"\t\t\t\t\t\t\t\t\t\t-----------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tVest for men made Of Quality 100% Combed Cotton For All day Comfort. \n" + //
						"\t\t\t\t\t\t\t\t\t\tStrong, stretchable cotton fabric ensures durability and long life of this vest despite being comfortably lightweight.");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*410;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics = total;
						cart1 += "Dixcy Scott Men Vest! 410#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Dixcy Scott Men Vest! 410#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens \n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 9:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tLevi's Men Brief\n" + //
						"\t\t\t\t\t\t\t\t\t\t-----------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions: Wash cold and dark colors separately. Do not iron, dry clean or bleach\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tSingle Jersey Cotton: Made from pure cotton, this single jersey brief for men is lightweight and moisture-absorbent. \n" + //
						"\t\t\t\t\t\t\t\t\t\tThe soft, breathable fabric won't chafe, and sits gently against the skin.");
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mobiles\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*348;
					if(opt_for_addcart == 1 )
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += " Levi's Men Brief! 348#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += " Levi's Men Brief! 348#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;
			case 10:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tAllen Solly Men Polo\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions: Wash with mild detergent, do not bleach, dry in shade\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tOccasion : Casual\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit : Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial : 60% Cotton and 40% Polyester");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Mens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*689;
					if(opt_for_addcart == 1)
					{
						cart1 = "";
						amount_electronics = total;
						cart1 += " Allen Solly Men Polo! 689#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += " Allen Solly Men Polo! 689#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Mens \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if(opt_for_buynow == 2)
							mens();
					}
				}
				else if(opt_for_addcart == 3)
					mens();
				break;

			case 0 :
				clothing();
				break;
			default :
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				mens();
				
				
		}
	}

	void womens()
	{

		System.out.println("\t\t\t\t\t\t\t\t\t\t1.Rajnandini Women Cotton Printed Readymade Salwar Suit\t\t\t:\t599\n" + //
				"\t\t\t\t\t\t\t\t\t\t2.GoSriKi Women's Cotton Blend Embroidered Straight Kurta\t\t:\t499\n" + //
				"\t\t\t\t\t\t\t\t\t\t3.FUNDAY FASHION Full Sleeve Blue Solid Women's Denim Jacket\t\t:\t359\n" + //
				"\t\t\t\t\t\t\t\t\t\t4.Women's Embroidered Georgette Semi-Stiched Anarkali Gown with Dupatta :\t1294\n" + //
				"\t\t\t\t\t\t\t\t\t\t5.Selvia Women's Poly Viscose Solid Regular Fit Shirt\t\t\t:\t299\n" + //
				"\t\t\t\t\t\t\t\t\t\t6.Women's Pure Cotton Printed Night Suit Top and Pyjama Set\t\t:\t849\n" + //
				"\t\t\t\t\t\t\t\t\t\t7.Women's Kanjivaram Soft Silk Banarasi Saree With Blouse Piece\t\t:\t436\n" + //
				"\t\t\t\t\t\t\t\t\t\t8.Yashika Womens Art Silk Printed Saree With Blouse Piece\t\t:\t399\n" + //
				"\t\t\t\t\t\t\t\t\t\t9.Cotton Embroidery Nighty for Womens\t\t\t\t\t:\t399\n" + //
				"\t\t\t\t\t\t\t\t\t\t10.Eden & Ivy Women's Cotton All Over Print Pajama\t\t\t:\t675");
		System.out.println("\n\t\t\t\t\t\t\t\t0.Back");
		System.out.println("\t\t\t\t\t\t\t\tEnter Your Option : ");
		String optforlaptops = sc.nextLine();
		int opt_for_laptops = Integer.parseInt(optforlaptops);
		int total;
		switch(opt_for_laptops)
		{
			case 1:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tRajnandini Women Cotton Printed Readymade Salwar Suit\t\n" + //
						"\t\t\t\t\t\t\t\t\t\t------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Hand Wash Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tFabric \t\t\t: Top - Cotton , Bottom - Cotton , Dupatta -Cotton\n" + //
						"\t\t\t\t\t\t\t\t\t\tColor \t\t\t: Top -Blue , Bottom - Grey , Dupatta - Blue And Grey");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*599;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Rajnandini Women Cotton Printed Readymade Salwar Suit!599#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Rajnandini Women Cotton Printed Readymade Salwar Suit!599#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 2:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tGoSriKi Women's Cotton Blend Embroidered Straight Kurta\n" + //
						"\t\t\t\t\t\t\t\t\t\t--------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Dry Clean Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tKurta Fabric\t\t: Cotton Blend \n" + //
						"\t\t\t\t\t\t\t\t\t\tKurta Color \t\t: White\n" + //
						"\t\t\t\t\t\t\t\t\t\tStyle\t\t\t: Straight \n" + //
						"\t\t\t\t\t\t\t\t\t\tLength\t\t\t: Long Length\n" + //
						"\t\t\t\t\t\t\t\t\t\tSleeves\t\t\t: 3/4 \n" + //
						"\t\t\t\t\t\t\t\t\t\tNeck Style\t\t: Round v Neck");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart ==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*499;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "GoSriKi Women's Cotton Blend Embroidered Straight Kurta!499#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "GoSriKi Women's Cotton Blend Embroidered Straight Kurta!499#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 3:
			total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tFUNDAY FASHION Full Sleeve Blue Solid Women's Denim Jacket\t\n" + //
						"\t\t\t\t\t\t\t\t\t\t-----------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tSize Details \t\t: S - 36 Chest/33 Waist \n" + //
						"\t\t\t\t\t\t\t\t\t\t\t\t\t  M - 38 Chest/35 Waist\n" + //
						"\t\t\t\t\t\t\t\t\t\t\t\t\t  L - 40 Chest/37 Waist \n" + //
						"\t\t\t\t\t\t\t\t\t\t\t\t\t  XL - 42 Chest/39 Waist");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*359;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "FUNDAY FASHION Full Sleeve Blue Solid Women's Denim Jacket!359#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "FUNDAY FASHION Full Sleeve Blue Solid Women's Denim Jacket!359#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 4:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tWomen's Embroidered Georgette Semi-Stiched Anarkali Gown with Dupatta\n" + //
						"\t\t\t\t\t\t\t\t\t\t-----------------------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Dry Clean Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tGown Fabric \t\t: Pure Georgette ; Bottom : Santoon ; Inner : Santoon ; Duppta : Nazmeen\n" + //
						"\t\t\t\t\t\t\t\t\t\tFree Size \t\t: (Length : 52\" | Waist : 38\" | Chest/Bust : 42\")\n" + //
						"\t\t\t\t\t\t\t\t\t\tFlare \t\t\t: 2.5 Meters, Maximum Size Up To Xxl.");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*1294;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Women's Embroidered Georgette Semi-Stiched Anarkali Gown with Dupatta!1294#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
					amount_electronics += total;
					cart += "Women's Embroidered Georgette Semi-Stiched Anarkali Gown with Dupatta!1294#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart1);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 5:
				total  = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tSelvia Women's Poly Viscose Solid Regular Fit Shirt\t\n" + //
						"\"\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t-----------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tFabric \t\t\t: Poly Viscose\n" + //
						"\t\t\t\t\t\t\t\t\t\tStyle\t\t\t: Regular Fit 3/4th sleeve Shirt \n" + //
						"\t\t\t\t\t\t\t\t\t\tWork\t\t\t: Solid\n" + //
						"\t\t\t\t\t\t\t\t\t\tLength \t\t\t: 26Inch\n" + //
						"\t\t\t\t\t\t\t\t\t\tBust Size \t\t: 40Inch");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_laptops==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*299;
					if(opt_for_addcart ==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Selvia Women's Poly Viscose Solid Regular Fit Shirt!299#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else
					{
					amount_electronics += total;
					cart += "Selvia Women's Poly Viscose Solid Regular Fit Shirt!299#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 2)
					womens();
				break;
			case 6:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tWomen's Pure Cotton Printed Night Suit Top and Pyjama Set\n" + //
						"\t\t\t\t\t\t\t\t\t\t----------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t\t: Relaxed\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial\t\t\t: Cotton \n" + //
						"\t\t\t\t\t\t\t\t\t\tPrint\t\t\t\t: Floral Printed Night Suit For Women Cotton\n" + //
						"\t\t\t\t\t\t\t\t\t\tNeck Type\t\t\t: Notch Collar \n" + //
						"\t\t\t\t\t\t\t\t\t\tSleeve\t\t\t\t: 3/4th Sleeve");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*849;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Women's Pure Cotton Printed Night Suit Top and Pyjama Set!849#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Women's Pure Cotton Printed Night Suit Top and Pyjama Set!849#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 7:
				total  = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tWomen's Kanjivaram Soft Silk Banarasi Saree With Blouse Piece\t\n" + //
						"\t\t\t\t\t\t\t\t\t\t--------------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Hand Wash Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tSaree fabric\t\t: Latest Design Kanjeevaram Banarasi Soft Silk Saree With Golden Zari on the Border.\n" + //
						"\t\t\t\t\t\t\t\t\t\tSaree Length \t\t: 5.50 mtr \n" + //
						"\t\t\t\t\t\t\t\t\t\tBlouse Length  \t\t: 0.80 mtr");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*436;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Women's Kanjivaram Soft Silk Banarasi Saree With Blouse Piece!436#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
						amount_electronics += total;
						cart += "Women's Kanjivaram Soft Silk Banarasi Saree With Blouse Piece!436#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 8:
				System.out.println("\t\t\t\t\t\t\t\t\t\tYashika Womens Art Silk Printed Saree With Blouse Piece\t\n" + //
						"\t\t\t\t\t\t\t\t\t\t---------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash.\n" + //
						"\t\t\t\t\t\t\t\t\t\tFabric\t\t\t: Art silk\n" + //
						"\t\t\t\t\t\t\t\t\t\tSaree Length \t\t: 5.20 Mtr\n" + //
						"\t\t\t\t\t\t\t\t\t\tBlouse\t\t\t: 0.80 Mtr.");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*399;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Yashika Womens Art Silk Printed Saree With Blouse Piece!399#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Yashika Womens Art Silk Printed Saree With Blouse Piece!399#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 9:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tCotton Embroidery Nighty for Womens\t\n" + //
						"\t\t\t\t\t\t\t\t\t\t------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tPERFECT FIT\t\t: Fit Type is REGULAR.\n" + //
						"\t\t\t\t\t\t\t\t\t\tQuality \t\t: PURE COTTON & FABRIC EXCELLENT QUALITY");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart == 2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*399;
					if(opt_for_addcart == 1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Cotton Embroidery Nighty for Womens!399#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart == 2)
					{
					amount_electronics += total;
					cart += "Cotton Embroidery Nighty for Womens!399#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;
			case 10:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tEden & Ivy Women's Cotton All Over Print Pajama\n" + //
						"\t\t\t\t\t\t\t\t\t\t------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial\t\t: 100% Cotton");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To womens\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*675;
					if(opt_for_addcart == 2)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Eden & Ivy Women's Cotton All Over Print Pajama!675#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
					amount_electronics += total;
					cart += "Eden & Ivy Women's Cotton All Over Print Pajama!675#" + quantity+"@"+total+"&";
					System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To womens\n\t\t\t\t\t\t\t\t0.exit");
					System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
					optforbuynow = sc.nextLine();
					opt_for_buynow = Integer.parseInt(optforbuynow);
					if(opt_for_buynow == 1)
						bill_obj.billDisplay(cart);
					else if(opt_for_buynow == 2)
						womens();
					}
				}
				else if(opt_for_addcart == 3)
					womens();
				break;

			case 0 :
				clothing();
				break;
			default :
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				mens();
		}
	}



	void kids()
	{

		System.out.println("\t\t\t\t\t\t\t\t\t\t1.Full Sleeves Dress For Kids\t\t\t\t\t\t:\t449\n" + //
				"\t\t\t\t\t\t\t\t\t\t2.Boys Cotton Track Suit\t\t\t\t\t\t:\t889\n" + //
				"\t\t\t\t\t\t\t\t\t\t3.Baby Boys Cotton and Polyester Graphic Print T-shirt And Dungaree\t:\t649\n" + //
				"\t\t\t\t\t\t\t\t\t\t4.Baby girl Knee Length Frock Dress\t\t\t\t\t:       447\n" + //
				"\t\t\t\t\t\t\t\t\t\t5.Girls Poly Cotton Studded Sleeveless Party Dresses\t\t\t:\t2700\n" + //
				"\t\t\t\t\t\t\t\t\t\t6.A.T.U.N. (ALL THINGS UBER NICE) Girls Striped Double Bow Dress\t:\t456\n" + //
				"\t\t\t\t\t\t\t\t\t\t7.Kids Full Sleeves Night Suit Monster Eyes Print \t\t\t:\t399\n" + //
				"\t\t\t\t\t\t\t\t\t\t8.Girl's Cotton Tringle Printed Night Suit Set of Shirt & Pyjama\t:\t799\n" + //
				"\t\t\t\t\t\t\t\t\t\t9.Kid clothing set for boys\t\t\t\t\t\t:\t349\n" + //
				"\t\t\t\t\t\t\t\t\t\t10.Cute Cartoon Printed Full Sleeve Shirt\t\t\t\t:\t859");
		System.out.println("\n\t\t\t\t\t\t\t\t0.Back");
		System.out.println("\t\t\t\t\t\t\t\tEnter Your Option : ");
		String optforearphones = sc.nextLine();
		int opt_for_earphones = Integer.parseInt(optforearphones);
		int total = 0;
		switch(opt_for_earphones)
		{
			case 1:
			total = 0;
			System.out.println("\t\t\t\t\t\t\t\t\t\tFull Sleeves Dress For Kids\n" + //
					"\t\t\t\t\t\t\t\t\t\t----------------------------\n" + //
					"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
					"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
					"\t\t\t\t\t\t\t\t\t\tMaterial\t\t: Hosiery Cotton  \n" + //
					"\t\t\t\t\t\t\t\t\t\tColour\t\t\t: Peach \n" + //
					"\t\t\t\t\t\t\t\t\t\tSleeve Type\t\t: Full Sleeves\n" + //
					"\t\t\t\t\t\t\t\t\t\tNeck Style\t\t: Round \n" + //
					"\t\t\t\t\t\t\t\t\t\tAge\t\t\t: 3-4 Years");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*449;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Full Sleeves Dress For Kids!449#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Full Sleeves Dress For Kids!449#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To kids \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);

						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
		
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 2:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tBoys Cotton Track Suit\n" + //
						"\t\t\t\t\t\t\t\t\t\t------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Hand Wash Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial\t\t: 95% Cotton and 5% Spandex\n" + //
						"\t\t\t\t\t\t\t\t\t\tPackage Includes\t: 1 Sweatshirt, 1 Jogger");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total += quantity_mobiles*total;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=889;
						cart1 += "Boys Cotton Track Suit!889#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Boys Cotton Track Suit!889#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To kids \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 3:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tBaby Boys Cotton and Polyester Graphic Print T-shirt And Dungaree\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Hand Wash Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Overall\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial\t\t: 95% Cotton and 5% Polyester\n" + //
						"\t\t\t\t\t\t\t\t\t\t2Package Includes\t: 1 T-Shirt,1 Dungaree");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*649;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Baby Boys Cotton and Polyester Graphic Print T-shirt And Dungaree!649#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Baby Boys Cotton and Polyester Graphic Print T-shirt And Dungaree!649#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To kids \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 4:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tBaby girl Knee Length Frock Dress\n" + //
						"\t\t\t\t\t\t\t\t\t\t----------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Hand Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tFabric\t\t\t: Soft Lycra \n" + //
						"\t\t\t\t\t\t\t\t\t\tWash Care\t\t: Hand Wash In Cold Water With Mild Detergent\n" + //
						"\t\t\t\t\t\t\t\t\t\tGuide\t\t\t: Please Refer Size Chart For Better Fitting\n" + //
						"\t\t\t\t\t\t\t\t\t\tSleeve Type\t\t: Sleeveless\n" + //
						"\t\t\t\t\t\t\t\t\t\tClosure Type\t\t: Zipper");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*447;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Baby girl Knee Length Frock Dress!477#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Baby girl Knee Length Frock Dress!477#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Kids \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
					}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 5:
				System.out.println("\t\t\t\t\t\t\t\t\t\tGirls Poly Cotton Studded Sleeveless Party Dresses\n" + //
						"\t\t\t\t\t\t\t\t\t\t----------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Gentle Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial\t\t: 100% Polyester\n" + //
						"\t\t\t\t\t\t\t\t\t\tPackage Includes\t: 1 Party Dress\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instruction\t: Gentle Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tChest\t\t\t: 70 cm \n" + //
						"\t\t\t\t\t\t\t\t\t\tLength\t\t\t: 95 cm");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1|| opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*2700;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Girls Poly Cotton Studded Sleeveless Party Dresses!2700#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
							amount_electronics += total;
							cart += "Girls Poly Cotton Studded Sleeveless Party Dresses!2700#" + quantity+"@"+total+"&";
							System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Kids \n\t\t\t\t\t\t\t\t0.exit");
							System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
							optforbuynow = sc.nextLine();
							opt_for_buynow = Integer.parseInt(optforbuynow);
							if(opt_for_buynow == 1)
								bill_obj.billDisplay(cart);
							else if(opt_for_buynow == 2)
								kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 6:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tA.T.U.N. (ALL THINGS UBER NICE) Girls Striped Double Bow Dress\n" + //
						"\t\t\t\t\t\t\t\t\t\t--------------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tSleeve type\t\t\t: sleeveless");
				
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*456;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "A.T.U.N. (ALL THINGS UBER NICE) Girls Striped Double Bow Dress!456#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "A.T.U.N. (ALL THINGS UBER NICE) Girls Striped Double Bow Dress!456#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Kids \n\\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 7:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tKids Full Sleeves Night Suit Monster Eyes Print \n" + //
						"\t\t\t\t\t\t\t\t\t\t------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Hand Wash Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tOccasion \t\t: Night Wear\n" + //
						"\t\t\t\t\t\t\t\t\t\tNeck \t\t\t: Round Neck\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit \t\t\t: Regular Fit");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*399;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Kids Full Sleeves Night Suit Monster Eyes Print!399#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "\t\t\t\t\t\t\t\t\t\tKids Full Sleeves Night Suit Monster Eyes Print!399#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Kids \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 8:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tGirl's Cotton Tringle Printed Night Suit Set of Shirt & Pyjama\n" + //
						"\t\t\t\t\t\t\t\t\t\t-----------------------------------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tSleeve Type\t\t: Half Sleeve \n" + //
						"\t\t\t\t\t\t\t\t\t\tNeck Type\t\t: Notched Collar\n" + //
						"\t\t\t\t\t\t\t\t\t\tMaterial\t\t: Cotton \n" + //
						"\t\t\t\t\t\t\t\t\t\tprint\t\t\t: Triangle Night Suit for girl");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*799;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Girl's Cotton Tringle Printed Night Suit Set of Shirt & Pyjama!799#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);

					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Girl's Cotton Tringle Printed Night Suit Set of Shirt & Pyjama!799#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Earphones\n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
					
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 9:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tKid clothing set for boys\n" + //
						"\t\t\t\t\t\t\t\t\t\t-------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Hand Wash Only\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular\n" + //
						"\t\t\t\t\t\t\t\t\t\tOccasion \t\t: Daily Wear");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("Enter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("\t\t\t\t\t\t\t\tPlease Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*349;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Kid clothing set for boys!349#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Kid clothing set for boys!349#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Kids \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							kids();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;
			case 10:
				total = 0;
				System.out.println("\t\t\t\t\t\t\t\t\t\tCute Cartoon Printed Full Sleeve Shirt\n" + //
						"\t\t\t\t\t\t\t\t\t\t--------------------------------------\n" + //
						"\t\t\t\t\t\t\t\t\t\tCare Instructions\t: Machine Wash\n" + //
						"\t\t\t\t\t\t\t\t\t\tFit Type\t\t: Regular Fit\n" + //
						"\t\t\t\t\t\t\t\t\t\tSleeve type\t        : sleeveless\n" + //
						"\t\t\t\t\t\t\t\t\t\tOccasion \t\t: Daily Wear");
				System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Add to Cart\n\t\t\t\t\t\t\t\t3.Back To Kids \n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if(opt_for_addcart == 1 || opt_for_addcart==2)
				{
					System.out.print("Please Enter Quantity : ");
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles*859;
					if(opt_for_addcart==1)
					{
						cart1="";
						amount_electronics=total;
						cart1 += "Cute Cartoon Printed Full Sleeve Shirt!859#" + quantity+"@"+total+"&";
						bill_obj.billDisplay(cart1);	
					}
					else if(opt_for_addcart==2)
					{
						amount_electronics += total;
						cart += "Cute Cartoon Printed Full Sleeve Shirt!859#" + quantity+"@"+total+"&";
						System.out.println("\t\t\t\t\t\t\t\t1.Buy Now\n\t\t\t\t\t\t\t\t2.Back To Kids \n\t\t\t\t\t\t\t\t0.exit");
						System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if(opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if(opt_for_buynow == 2)
							earphones();
					}
				}
				else if(opt_for_addcart == 3)
					kids();
				break;

			case 0 :
				clothing();
				break;
			default :
				System.out.println("\t\t\t\t\t\t\t\tInvalid Option");
				kids();
		}
	}
	

	

	//object for bill class
	static Bill b_obj = new Bill();

	void clothing()
	{
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tCLOTHING");
		System.out.println("\t\t\t\t\t\t\t\t 1.Mens\n\t\t\t\t\t\t\t\t2.Womens\n\t\t\t\t\t\t\t\t3.Kids\n\t\t\t\t\t\t\t\t9.check out\n\t\t\t\t\t\t\t\t0.Home");
		System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
		String optforelehome = sc.nextLine();
		int opt_for_ele_home = Integer.parseInt(optforelehome);
		if(opt_for_ele_home == 1)
		{
			clothing_obj.mens();
		}
		else if(opt_for_ele_home == 2)
		{
			clothing_obj.womens();
		}
		else if(opt_for_ele_home == 3)
		{
			clothing_obj.kids();
		}
		else if(opt_for_ele_home == 0)
		{
			User u_obj = new User();
			u_obj.selection();
		}
		else if(opt_for_ele_home == 9)
		{
			System.out.println(cart);
			b_obj.billDisplay(cart);
		}
	}
}

/* ***********************************************G R O C E R Y ****************************************/


class Grocery extends Electronics {

	static Grocery grocery_obj = new Grocery();

	// static User u_obj = new User();
	public static void main(String args[]) {
		// grocery_obj.vegetables();
		grocery_obj.display();
	}

	void display() {
		System.out.println(
				Colors.blue+"\t\t\t\t\t\t\t1.vegetables\n\t\t\t\t\t\t\t\t2.Fruits\n\t\t\t\t\t\t\t\t\t3.Snacks\n\t\t\t\t\t\t\t\t4.Oils_and_Sauces\n\t\t\t\t\t\t\t\t5.Pulses\n\t\t\t\t\t\t\t\t6.exit" + Colors.reset);
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

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
				System.out.println(Colors.red+"\t\t\t\t\t\t\t\tInvalid option : "+Colors.reset);
				display();
		}
	}

	void vegetables() {

		System.out.println(Colors.blue+"\t\t\t\t\t\t\t\t1.tomato\t- \t240\r\n" + //
				"\t\t\t\t\t\t\t\t2.potato \t- \t130\r\n" + //
				"\t\t\t\t\t\t\t\t3.brinjal \t- \t100\r\n" + //
				"\t\t\t\t\t\t\t\t4.Lady's finger - \t50 \r\n" + //
				"\t\t\t\t\t\t\t\t5.cabbage \t- \t60\r\n" + //
				"\t\t\t\t\t\t\t\t6.Garlic \t- \t70\r\n" + //
				"\t\t\t\t\t\t\t\t7.Drumstick\t- \t150\r\n" + //
				"\t\t\t\t\t\t\t\t8.Mushroom \t- \t99\r\n" + //
				"\t\t\t\t\t\t\t\t9.califlower\t- \t60\r\n" + //
				"\t\t\t\t\t\t\t\t10.Beetroot \t- \t65 "+Colors.reset);
		System.out.println(Colors.yellow+"0.Back"+Colors.reset);
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

		String optformobiles = sc.nextLine();
		int opt_for_mobiles = Integer.parseInt(optformobiles);
		int total;
		switch (opt_for_mobiles) {
			case 1:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t tomato -240 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 240;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "tomato!240#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "tomato!240#" + quantity + "@" + total + "&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t potato - 130"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "potato!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "potato!130#" + quantity + "@" + total + "&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
                        System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t brinjal - 100"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "brinjal!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "brinjal!100#" + quantity + "@" + total + "&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tLady's finger - 50"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 50;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Lady's finger!50#" + quantity + "@";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Lady's finger!50#" + quantity + "@";
						// amount_Grocery += quantity_vegetables * 50;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
						System.out.print(Colors.green+"Enter Your Option :: "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 5:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\t cabbage - 60"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 60;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "cabbage!60#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "cabbage!60#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 60;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tGarlic - 70"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 70;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Garlic!70#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Garlic!70#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 70;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tDrumstick- 150"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Drumstick!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Drumstick!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tMushroom - 99"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 99;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Mushroom !99#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mushroom !99#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 99;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);


						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tBeetroot - 65 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 65;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += " Beetroot!65#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Beetroot!65#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 65;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							vegetables();
					}
				} else if (opt_for_addcart == 3)
					vegetables();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tcaliflower- 60"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 60;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "califlower!60#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "califlower!60#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_vegetables * 60;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Vegetables"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
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
				System.out.println(Colors.red+"Invalid Option"+Colors.reset);
				vegetables();

		}
	}

	void Fruits() {
		System.out.println(
				Colors.blue+"\t\t\t\t\t\t\t\t1.Apple- 240\n\t\t\t\t\t\t\t\t 2.Banana - 130\n\t\t\t\t\t\t\t\t3.Orange- 100\n\t\t\t\t\t\t\t\t4.Pine-apple - 150 \n\t\t\t\t\t\t\t\t5.papaya - 160\n\t\t\t\t\t\t\t\t\t6.Mango - 170\n\t\t\t\t\t\t\t\t7.Guava- 150\n\t\t\t\t\t\t\t\t8.Watermelon - 199\n\t\t\t\t\t\t\t\t9.Blackberry- 160\n\t\t\t\t\t\t\t\t10.Grapes - 165 \n\t\t\t\t\t\t\t\t0.Back"+Colors.reset);
		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

		String optforfruits = sc.nextLine();
		int opt_for_fruits = Integer.parseInt(optforfruits);
		int total = 0;
		switch (opt_for_fruits) {
			case 1:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tApple -240 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 240;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Apple!240#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Apple!240#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 240;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tBanana - 130"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Banana!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Banana!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 130;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tOrange -100"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Orange!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Orange!100#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 100;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tPine-apple - 150"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Pine-apple!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Pine-apple!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 5:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tpapaya - 160"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "papaya!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "papaya!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tMango - 170"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Mango!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mango!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 170;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tGuava- 150"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Guava!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart1 += "Guava!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tWatermelon - 199"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 199;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Watermelon !199#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Watermelon !199#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 199;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tBlackberry- 165 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 165;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += " Blackberry!165#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Blackberry!165#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 165;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Fruits();
					}
				} else if (opt_for_addcart == 3)
					Fruits();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tGrapes- 160"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Grapes!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Grapes!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Fruits"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
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
				System.out.println(Colors.red+"Invalid Option"+Colors.reset);
				Fruits();

		}
	}

	/**
	 * 
	 */
	void Snacks() {
		System.out.println(
        Colors.blue + "\t\t\t\t\t\t\t\t1.Crackers- 140\n" +
        "\t\t\t\t\t\t\t\t2.Nuts - 130\n" +
        "\t\t\t\t\t\t\t\t3.Quick oats- 100\n" +
        "\t\t\t\t\t\t\t\t4.Popcorn - 150\n" +
        "\t\t\t\t\t\t\t\t5.Tortilla Chips - 160\n" +
        "\t\t\t\t\t\t\t\t6.Candy - 170\n" +
        "\t\t\t\t\t\t\t\t7.Cashews- 150\n" +
        "\t\t\t\t\t\t\t\t8.Cookies - 230\n" +
        "\t\t\t\t\t\t\t\t9.Potato chips- 160\n" +
        "\t\t\t\t\t\t\t\t10.Dried fruits - 160\n" +
       "\t\t\t\t\t\t\t\tt0.Back" + Colors.reset
);

		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
		String optforsnacks = sc.nextLine();
		int opt_for_snacks = Integer.parseInt(optforsnacks);
		int total = 0;
		switch (opt_for_snacks) {
			case 1:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tCrackers -140 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 140;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Crackers!140#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Crackers!140#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 140;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tNuts - 130"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Nuts!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Nuts!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 130;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tQuick oats -100"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Quick oats!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Quick oats!100#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 100;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tPopcorn - 150"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Popcorn!150#" + quantity + "@" + total + '&';
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Popcorn!150#" + quantity + "@" + total + '&';
						// amount_Grocery += quantity_Snacks * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 5:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tTortilla Chips - 160"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Tortilla Chips!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Tortilla Chips!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tCandy - 170"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Candy!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);

					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Candy!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 170;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tCashews- 150"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Cashews!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Cashews!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tCookies- 230"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 230;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Cookies !230#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Cookies !230#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 230;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\totato chips- 160 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += " Potato chips!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Potato chips!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_Snacks * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Snacks();
					}
				} else if (opt_for_addcart == 3)
					Snacks();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tDried fruits- 160"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Dried fruits!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Dried fruits!160#" + quantity + "@" + total + "&";
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Snacks"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
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
				System.out.println(Colors.red+"Invalid Option"+Colors.reset);
				Snacks();
		}
	}

	void Oils_and_Sauces() {

			System.out.println(
        Colors.blue + "\t\t\t\t\t\t\t\t1.Olive oil- 180\n" +
        "\t\t\t\t\t\t\t\t2.Mustard oil - 130\n" +
        "\t\t\t\t\t\t\t\t3.Sunflower oil- 120\n" +
        "\t\t\t\t\t\t\t\t4.Soy sauce - 140\n" +
        "\t\t\t\t\t\t\t\t5.Fish Sauce - 110\n" +
        "\t\t\t\t\t\t\t\t6.Vinegar- 170\n" +
        "\t\t\t\t\t\t\t\t7.Tomato ketchup- 150\n" +
        "\t\t\t\t\t\t\t\t8.Sweet and sour sauce- 199\n" +
        "\t\t\t\t\t\t\t\t9.Rice bran oil- 160\n" +
        "\t\t\t\t\t\t\t\t10.Coconut oil - 165\n" +
        "\t\t\t\t\t\t\t\t0.Back" + Colors.reset);

		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
		String optforoils_and_Sauces = sc.nextLine();
		int opt_for_oils_and_Sauces = Integer.parseInt(optforoils_and_Sauces);
		int total = 0;
		switch (opt_for_oils_and_Sauces) {
			case 1:
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tOlive oil -180 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);
					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 180;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Olive oil!180#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Olive oil!180#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 140;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tMustard oil - 130"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Mustard oil!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);

					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mustard oil!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 130;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tSunflower oil -120"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 120;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Sunflower oil!120#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sunflower oil!120#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 120;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tSoy sauce - 140"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 140;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Soy sauce!140#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Soy sauce!140#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 140;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart1);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 5:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tFish Sauce - 110"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 110;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Fish Sauce!110#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Fish Sauce!110#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 110;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tVinegar - 170"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Vinegar!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Vinegar!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 170;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tTomato ketchup- 150"+Colors.reset);
			System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Tomato ketchup!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Tomato ketchup!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tSweet and sour sauce - 199"+Colors.reset);
			System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 199;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Sweet and sour sauce!199#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sweet and sour sauce!199#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 199;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tRice bran oil- 160 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += " Rice bran oil!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " Rice bran oil!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Oils_and_Sauces();
					}
				} else if (opt_for_addcart == 3)
					Oils_and_Sauces();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tCoconut oil- 165"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 165;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Coconut oil!165#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Coconut oil!165#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_oils_and_Sauces * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Oils_and_Sauces"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
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
				System.out.println(Colors.red+"Invalid Option"+Colors.reset);
				Oils_and_Sauces();

		}
	}

	/**
	 * 
	 */
	void Pulses() {

		System.out.println(
        Colors.blue + "\t\t\t\t\t\t\t\t1.Mung daal- 140\n" +
        "\t\t\t\t\t\t\t\t2.Hare mung daal - 130\n" +
        "\t\t\t\t\t\t\t\t3.Chawli daal- 100\n" +
        "\t\t\t\t\t\t\t\t4.Masoor daal - 150\n" +
        "\t\t\t\t\t\t\t\t5.Sabat masoor - 160\n" +
        "\t\t\t\t\t\t\t\t6.Toor daal- 170\n" +
        "\t\t\t\t\t\t\t\t7.Rajma- 150\n" +
        "\t\t\t\t\t\t\t\t8.Hari matar- 199\n" +
        "\t\t\t\t\t\t\t\t9.chickpeas- 160\n" +
        "\t\t\t\t\t\t\t\t10.Field beans - 165\n" +
        "\t\t\t\t\t\t\t\t0.Back" + Colors.reset);

		System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);
		String optforpulses = sc.nextLine();
		int opt_for_pulses = Integer.parseInt(optforpulses);
		int total = 0;
		switch (opt_for_pulses) {
			case 1:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tMung daal -140 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 140;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Mung daal!140#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Mung daal!140#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 140;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 2:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tHare mung daal - 130"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 130;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Hare mung daal!130#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Hare mung daal!130#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 130;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 3:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tChawli daal -100"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 100;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1+= "Chawli daal!100#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Chawli daal!100#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 100;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 4:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tMasoor daal - 150"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Masoor daal!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Masoor daal!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 5:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tSabat masoor - 160"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Sabat masoor!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Sabat masoor!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();

					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 6:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tToor daal - 170"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 170;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Toor daal!170#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Toor daal!170#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 170;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 7:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tRajma- 150"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 150;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Rajma!150#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} 
					 else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Rajma!150#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 150;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} 
				else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 8:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tHari matar - 199"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 199;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Hari matar !199#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Hari matar !199#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 199;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 9:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tchickpeas- 160 "+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += " chickpeas!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += " chickpeas!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_fruits * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);
                        System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
						else if (opt_for_buynow == 2)
							Pulses();
					}
				} else if (opt_for_addcart == 3)
					Pulses();
				break;
			case 10:
				total = 0;
				System.out.println(Colors.cyan+"\t\t\t\t\t\t\t\tField beans- 160"+Colors.reset);
				System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.purple+""+Colors.magent+"\n\t\t\t\t\t\t\t\t2.Add to Cart"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t3.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);

				System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

				optforaddcart = sc.nextLine();
				opt_for_addcart = Integer.parseInt(optforaddcart);
				if (opt_for_addcart == 1 || opt_for_addcart == 2) {
					System.out.print(Colors.blue+"\t\t\t\t\t\t\t\tPlease Enter Quantity : "+Colors.reset);

					quantity = sc.nextLine();
					quantity_mobiles = Integer.parseInt(quantity);
					total = quantity_mobiles * 160;
					if (opt_for_addcart == 1) {
						cart1 = "";
						amount_electronics = total;
						cart1 += "Field beans!160#" + quantity + "@" + total + "&";
						bill_obj.billDisplay(cart1);
					} else if (opt_for_addcart == 2) {
						amount_electronics += total;
						cart += "Field beans!160#" + quantity + "@" + total + "&";
						// amount_Grocery += quantity_pulses * 160;
						System.out.println(Colors.purple+"\t\t\t\t\t\t\t\t1.Buy Now"+Colors.reset+""+Colors.yellow+"\n\t\t\t\t\t\t\t\t2.Back To Pulses"+Colors.reset+""+Colors.red+"\n\t\t\t\t\t\t\t\t0.Press Any Key to Exit\n"+Colors.reset);


						System.out.print(Colors.green+"\t\t\t\t\t\t\t\tEnter Your Option : "+Colors.reset);

						optforbuynow = sc.nextLine();
						opt_for_buynow = Integer.parseInt(optforbuynow);
						if (opt_for_buynow == 1)
							bill_obj.billDisplay(cart);
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
				System.out.println(Colors.red+"Invalid Option"+Colors.reset);
				Pulses();

		}
	}
}



/***************************************************************************************************************** */
/*							B I L L I N G 					*/
class Bill
{
	static Scanner sc = new Scanner(System.in);
	static Electronics electronics_obj = new Electronics();
	static payment p_obj = new payment();
	static User u_obj = new User();
	static UserLogin u_login_obj = new UserLogin();

	static Date date()
	{
		Date currentDate = new Date();
		return currentDate;
	}

	void billDisplay(String cart)
	{
		if(cart.isEmpty())
		{
			System.out.println("\t\t\t\t\t\t\t\tCart is Empty\n\t\t\t\t\t\t\t\tPlease Add Some Items");
			System.out.println("\t\t\t\t\t\t\t\t1.Home\n\t\t\t\t\t\t\t\t0.Press Any Key To Exit");
			String optforhome = sc.nextLine();
			int opt_for_home = Integer.parseInt(optforhome);
			if(opt_for_home == 1)
			{
				u_obj.selection();
			}
		}
		else
		{
			
			//Entering address

			double amount_electronics = Electronics.amount_electronics;
			String[] products = cart.split("&");

			System.out.println("Product\t\t\t\t\t\t   Price\tQuantity\tTotal Price");
			System.out.println("-------------------------------------------------------------------------------------------");

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
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.printf("%80s %.2f","Amount : ", amount_electronics);
			double gst = 0.02*amount_electronics;
			System.out.println();
			System.out.printf("%80s %.2f","GST : ",gst);
			System.out.println();
			System.out.printf("%80s %.2f","TOTAL : ",(amount_electronics+gst));
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t\t1.Pay Online\n\t\t\t\t\t\t\t\t2. Cash On Delivery\n\t\t\t\t\t\t\t\t0.Press any Key to Home");
			System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
			String chpay = Electronics.sc.nextLine();
			int ch_pay = Integer.parseInt(chpay);
			if(ch_pay == 1)
			{
				p_obj.bank_select(amount_electronics+gst);
			}
			else if(ch_pay ==2)
			{
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
				"						"+name,
				"Gajala                                          "+house_address,
				"Form WashingTon DC                              "+pincode,
				"Sonic Solutions",
				"Hyderabad",
				"",
				"PAN No : CAMPS8381L                            Shipping Adress:",
				"GST Registration No : 07CAMPS83811L1ZQ         "+name,
				"                                               "+house_address,
				"Order Number : "+u_login_obj.otp()+"           		"+pincode,
				"Order Date : "+Bill.date(),
				""
				};
				for(String line : dynamicData)
					System.out.println(line);
				System.out.println("PAYMENT DETAILS\nStatus Of Payment : COD");
				System.out.println();
				System.out.println();
				
				products = cart.split("&");

				System.out.println("Product\t\t\t\t\t\t   Price\tQuantity\tTotal Price");
				System.out.println("-------------------------------------------------------------------------------------------");

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
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.printf("%80s %.2f","Amount : ", amount_electronics);
			gst = 0.02*amount_electronics;
			System.out.println();
			System.out.printf("%80s %.2f","GST : ",gst);
			System.out.println();
			System.out.printf("%80s %.2f","TOTAL : ",(amount_electronics+gst));

				Electronics.cart = "";
				Electronics.amount_electronics = 0;
				Electronics.address = "";
				
				System.out.println("\n\t\t\t\t\t\t\t\t1.Order More");
				System.out.println("\t\t\t\t\t\t\t\t0.Press Any Key To exit");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Choice ::");
				String optformore = sc.nextLine();
				int opt_for_more = Integer.parseInt(optformore);
				if(opt_for_more == 1)
					u_obj.selection();
				

				
			}
			else
			{
				u_obj.selection();
			}
		}
	}
}
/************************************************************************************************************** */


/*   *******************************************************************************************************
 * 						P A Y M E N T
 */


// P A Y M E N T 
interface pay{
    int getPin();
    boolean withdraw(double bal);
}


class sbi implements pay
{
    private int sbi_pin = 2580;
    
    private double sbi_bal=100000.0;

    // S B I
    public int getPin()
    {
        return sbi_pin;
    }
    
    public boolean withdraw(double sbi_bal)
    {
        if(this.sbi_bal<sbi_bal)
            return false;
        else
        {
            this.sbi_bal-=sbi_bal;
            return true;
        }
    }

}

    // K O T A K
class kotak  implements pay
{
    private int kotak_pin = 9834;

    private double kotak_bal=1000000.0;
    public int getPin()
    {
        return kotak_pin;
    }

    public boolean withdraw(double kotak_bal)
    {
        if(this.kotak_bal<kotak_bal)
            return false;
        else    
        {
            this.kotak_bal-=kotak_bal;
            return true;
        }
    }


}

    // I C I C I
class icici  implements pay
{
    private int icici_pin = 6478;

    private double icici_bal=10000000.0;
    public int getPin()
    {
        return icici_pin;
    }
    
    public boolean withdraw(double icici_bal)
    {
        if(this.icici_bal<icici_bal)
            return false;
        else   
        {
            this.icici_bal-=icici_bal;
            return true;
        }
    }
}



class payment 
{
    static Scanner sc = new Scanner(System.in);
	static User u_obj = new User();
    static payment payment_obj = new payment();
    static sbi sbi_obj  = new sbi();
    static kotak kotak_obj = new kotak();
    static icici icici_obj = new icici();
	static Bill bill_obj = new Bill();
	static UserLogin u_login_obj = new UserLogin();

    boolean validation(pay obj,double bill , String bank)
    {
        System.out.print("\n\t\t\t\t\t\tEnter "+bank+" account Pin : ");
        String pn = sc.nextLine();
        int pin = Integer.parseInt(pn);
        if(pin==obj.getPin())
        {
            if(obj.withdraw(bill))
            {
                System.out.println("\n\n\t\t\t\t************            Transaction Successful         ************\n");

				//Entering address
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
				"						"+name,
				"Gajala                                          "+house_address,
				"Form WashingTon DC                              "+pincode,
				"Sonic Solutions",
				"Hyderabad",
				"",
				"PAN No : CAMPS8381L                            Shipping Adress:",
				"GST Registration No : 07CAMPS83811L1ZQ         "+name,
				"                                               "+house_address,
				"Order Number : "+u_login_obj.otp()+"           		"+pincode,
				"Order Date : "+Bill.date(),
				""
				};

				for(String line : dynamicData)
				{
					System.out.println(line);
				}
				System.out.println("PAYMENT DETAILS\nPayment Status : Paid(Online)");


				System.out.println();
				System.out.println();
				
				String[] products = Electronics.cart.split("&");

				System.out.println("Product\t\t\t\t\t\t   Price\tQuantity\tTotal Price");
				System.out.println("-------------------------------------------------------------------------------------------");

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
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.printf("%80s %.2f","Amount : ", Electronics.amount_electronics);
			double gst = 0.02*Electronics.amount_electronics;
			System.out.println();
			System.out.printf("%80s %.2f","GST : ",gst);
			System.out.println();
			System.out.printf("%80s %.2f","TOTAL : ",(Electronics.amount_electronics+gst));

				Electronics.cart = "";
				Electronics.amount_electronics = 0;
				Electronics.address = "";
				
				System.out.println("\t\t\t\t\t1.Order More");
				System.out.println("\t\t\t\t\t\t\t\t0.Press Any Key To Exit");
				System.out.print("\t\t\t\t\t\t\t\tEnter Your Choice ::");
				String optformore = sc.nextLine();
				int opt_for_more = Integer.parseInt(optformore);
				if(opt_for_more == 1)
					u_obj.selection();
                return true;
            }
            else
            {
                System.out.println("\n\t\t\t\t************             Insuffiecient Funds in Your Account         ************\n");
                System.out.println("\t\t\tDo you want to switch to another bank");
                System.out.println("\t\t1 . Yes ");
                System.out.print("\t\t2 . No \n\t\t");
                String ys = sc.nextLine();
                if(Integer.parseInt(ys)==1)
                    return bank_select(bill);
                else    
                {
                    System.out.println("\t\t\t\t************            Transaction Failed          ************");
                    return false;
                }
            }
        }
        else
        {
            System.out.println("\t\t\t\t************            Incorrect Pin          ************");
            System.out.println("\t\t\tChoose Options : ");
            System.out.println("\t\t1 . Re-enter Pin");
            System.out.print("\t\tPress any number to Exit the Application\n\t\t");
            String opt = sc.nextLine();
            int ch = Integer.parseInt(opt);
            if(ch==1)
                return validation(obj,bill,bank);  
        }
        return false;
    }

    boolean bank_select(double bill)
    {
        System.out.println("\n\n\t\t\t\t\t************         W E L C O M E     T O       C V   P A Y       ************\n");
        System.out.println("\t\t\tChoose the Bank to Pay the Bill : \n");
        System.out.println("\t\t\t\t1 . S B I ");
        System.out.println("\t\t\t\t2 . K O T A K");
        System.out.print("\t\t\t\t3 . I C I C I \n\t\t\t\t");
        String opt = sc.nextLine();
        int bank = Integer.parseInt(opt);
        if(bank==1)
                return validation(sbi_obj,bill, " SBI ");
        else if(bank==2)
                return validation(kotak_obj,bill, " Kotak ");
        else if(bank==3)
                return validation(icici_obj, bill, " ICICI ");
        else 
        {
            System.out.println("\t\t\t\t************            Invalid Selection            ************");
            System.out.println("\t\t\tDo you want Re-select");
            System.out.println("\t\t1 . Yes ");
            System.out.print("\t\t2 . No \n\t\t");
            String ys = sc.nextLine();
            if(Integer.parseInt(ys)==1)
                return bank_select(bill);
            return false;
        }
    }

    
}




/* ********************************************************************************************************* */








//class for user interface
class User
{
	//creating object for colors class
	static Scanner sc = new Scanner(System.in);
	static UserLogin user_login_obj = new UserLogin();
	//static UserSignup user_signup_obj = new UserSignup();

	static 
	{
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
                System.out.print(Colors.yellow+line.charAt(i)+Colors.reset);
                try {
                    Thread.sleep(10); // Sleep for 100 milliseconds between characters
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(); // Move to the next line
        };
	}

	static void User_login()
	{
		//int c_login  = 0;
		System.out.println();
		System.out.print(Colors.blue+"\t\t\t\t\t\t\t\t1.Log In\n\t\t\t\t\t\t\t\t2.SignUp\n\t\t\t\t\t\t\t\t0.Press any other key to exit :: "+Colors.reset);
		String opt1 = sc.nextLine();
		int opt_1 = Integer.parseInt(opt1);
		if(opt_1 == 1)
		{
			while(true)
			{
				user_login_obj.logIn();
				if(UserLogin.status_login == 1)
					break;
				else if(UserLogin.status_login !=1)
				{
					if(UserLogin.status_login==2)
						break;
					User_login();
					break;
				}
				else if(UserLogin.status_login==2)
					break;
			}
		}
		else if(opt_1 == 2)
		{
			user_login_obj.initial();
			user_login_obj.signUp();
			System.out.println();
			System.out.print("\t\t\t\t\t\t\t\t1.Back to LogIn\n\t\t\t\t\t\t\t\t0.exit :: ");
			String opt5 = sc.nextLine();
			int opt_5 = Integer.parseInt(opt5);
			if(opt_5 == 1)
			{
				while(true)
				{
					user_login_obj.logIn();
					if(UserLogin.status_login == 1)
						break;
						
					else if(UserLogin.status_login != 1 && UserLogin.status_login==2)
					{
						if(UserLogin.status_login==2)
							break;
						User_login();
						break;
					}
					else if(UserLogin.status_login==2)
						break;
				}
			}
		}

	}

	void selection()
	{
		if(UserLogin.status_login == 1)
		{
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t\t\t\tHOME");
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t\t1.Electronics\n\t\t\t\t\t\t\t\t2.Grocery\n\t\t\t\t\t\t\t\t3.Beauty\n\t\t\t\t\t\t\t\t4.Fashion\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t5.Press Any Key to Exit\n");
			System.out.print("\t\t\t\t\t\t\t\tEnter Your Option :: ");
			String optforhome = sc.nextLine();
			int opt_for_home = Integer.parseInt(optforhome);
			if(opt_for_home==1)
				Electronics.electronics_obj.electronics();
			else if(opt_for_home == 2)
				Grocery.grocery_obj.display();
			else if(opt_for_home == 3)
				Beauty.beauty_obj.beauty();
			else if(opt_for_home == 4)
				Clothing.clothing_obj.clothing();
		}
			
	}
	
	public static void main(String args[])
    {
       User_login();
	   User u_obj = new User();
	   u_obj.selection();
	   
    }
}