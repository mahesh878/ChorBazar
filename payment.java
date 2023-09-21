// P A Y M E N T 
import java.util.*;
interface pay{
    int getPin();
    void setPin(int pin);
    double get_bal();
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
    public void setPin(int sbi_pin)
    {
        this.sbi_pin=sbi_pin;
    }

    public double get_bal()
    {
        return sbi_bal;
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
    public void setPin(int kotak_pin)
    {
        this.kotak_pin=kotak_pin;
    }

    public double get_bal()
    {
        return kotak_bal;
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
    public void setPin(int icici_pin)
    {
        this.icici_pin=icici_pin;
    }

    public double get_bal()
    {
        return icici_bal;
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

class User{
    private String mobilenumber="9959258025";
    String get_mobilenum()
    {
        return mobilenumber;
    }
}

class payment 
{
    static Scanner sc = new Scanner(System.in);
    static payment payment_obj = new payment();
    static User u_obj = new User();
    static sbi sbi_obj  = new sbi();
    static kotak kotak_obj = new kotak();
    static icici icici_obj = new icici();
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
            System.out.println("\t\t2 . Reset Pin");
            System.out.print("\t\tPress any number to Exit the Application\n\t\t");
            String opt = sc.nextLine();
            int ch = Integer.parseInt(opt);
            if(ch==1)
                return validation(obj,bill,bank);
            else if(ch==2)
            {
                while(true)
                {
                    System.out.print("\t\t\t\tEnter Your Mobile Number : ");
                    String phno = sc.nextLine();
                    if(u_obj.get_mobilenum().equals(phno))
                    {
                        System.out.println("For Resetting the Pin of "+bank+" Bank");
                        System.out.print("\t\t\t\tEnter the OTP : ");
                        int sent = payment_obj.otp();
                        System.out.println("otp:"+sent);
                        String enterotp = sc.nextLine();
                        int enter_otp = Integer.parseInt(enterotp);
                        if(sent==enter_otp)
                        {
                            System.out.print("\t\t\t\tEnter Your New Pin : ");
                            String npin = sc.nextLine();
                            int new_pin = Integer.parseInt(npin);
                            obj.setPin(new_pin);
                            System.out.println("\n\t\t\t\t************         Pin changed Successfully         ************\n");
                            System.out.print("\t\t\tPlease wait you're  directing to the Billing");
                            System.out.println();
                            return validation(obj, bill, bank);
                        }
                        System.out.println("\t\t\t\t************             Incorrect OTP             ************\n\n");
                        System.out.println("\t\t\tDo you want to Re-send : ");
                        System.out.println("\t\t1 . Yes");
                        System.out.print("\t\tPress any number to exit");
                        String ys = sc.nextLine();
                        if(Integer.parseInt(ys)==1)
                            continue;
                        return false;
                    }
                    else
                    {
                        System.out.println("\t\t\t\t************             Invalid Mobile Number             ************\n\n");
                        System.out.println("\t\t\tDo you want to Re-enter : ");
                        System.out.println("\t\t1 . Yes");
                        System.out.println("\t\tPress any number to exit");
                        String ys = sc.nextLine();
                        if(Integer.parseInt(ys)==1)
                            continue;
                        return false;
                    }
                }
            }
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

class Bill extends payment
{
    static double amount =  19990;
    public static void main(String[] args) {
        payment_obj.bank_select(amount);
    }
}