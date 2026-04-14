import java.util.Scanner;
import service.BankService;
public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();
        int choice;
        int typechoice;
        do{
            System.out.println("=================================================");
            System.out.println("\t\t\t\t\tGG Bank");
            System.out.println("=================================================");
            System.out.println("Welcome!\nChoose one of the following options :");
            System.out.println("1. Create new Bank Account");
            System.out.println("2. Close Account");
            System.out.println("3. Active Closed Account");
            System.out.println("4. Withdraw funds");
            System.out.println("5. Deposit funds");
            System.out.println("6. Transfer funds to another Account");
            System.out.println("7. View transaction history");
            System.out.println("8. View Bank Account details");
            System.out.println("9. Update Account holder's details ");
            System.out.println("10. EXIT");
            System.out.println("=================================================");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            System.out.println("=================================================");
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.println("For creating a bank account, please provide the following details of bank account holder: ");
                    System.out.print("First name : ");
                    String fname = sc.nextLine();
                    System.out.print("Last name : ");
                    String lname = sc.nextLine();
                    System.out.print("email-id : ");
                    String email = sc.nextLine();
                    System.out.print("Phone number : ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Address : ");
                    String address = sc.nextLine();
                    System.out.print("Aadhar number : ");
                    long adharNumber = sc.nextLong();
                    System.out.println("Choose one of the following options : ");
                    System.out.println("  1.Current Account ");
                    System.out.println("  2.Savings Account");
                    typechoice = sc.nextInt();
                    sc.nextLine();
                    String accType = "";
                    switch(typechoice){
                        case 1:{
                            accType = "Current";
                            break;}
                        case 2:{
                            accType = "Savings";
                            break;}
                        default:{
                            System.out.println("Enter Valid Account Type");
                        }
                    }
                    System.out.print("PAN number : ");
                    String panNumber = sc.nextLine();
                    service.createAccount(fname, lname, email, phoneNumber, address, adharNumber, panNumber, accType);
                    break;
                case 2:
                    System.out.print("Enter your Account number : ");
                    long accNumber = sc.nextLong();
                    service.closeAccount(accNumber);
                    break;
                case 3:
                    System.out.print("Enter your Account number : ");
                    accNumber = sc.nextLong();
                    service.activeAccount(accNumber);
                    break;
                case 4:
                    System.out.print("Enter your account number : ");
                    accNumber = sc.nextLong();
                    System.out.print("Enter amount : ");
                    double amount = sc.nextDouble();
                    service.withdraw(accNumber, amount);
                    break;
                case 5:
                    System.out.print("Enter your account number : ");
                    accNumber = sc.nextLong();
                    System.out.print("Enter amount : ");
                    double depositAmount = sc.nextDouble();
                    service.deposit(accNumber, depositAmount);
                    break;
                case 6:
                    System.out.print("Enter your account number : ");
                    accNumber = sc.nextLong();
                    System.out.print("Enter receiver's account number : ");
                    long recAccountNumber = sc.nextLong();
                    System.out.print("Enter amount : ");
                    amount = sc.nextDouble();
                    service.transfer(accNumber, recAccountNumber, amount);
                    break;
                case 7:
                    System.out.print("Enter your account number : ");
                    accNumber = sc.nextLong();
                    service.getTransactionHistory(accNumber);
                    break;
                case 8:
                    System.out.print("Enter your account number : ");
                    accNumber = sc.nextLong();
                    service.getAccountDetails(accNumber);
                    break;
                case 9:
                    System.out.println("Please enter the updated account holder details : ");
                    System.out.print("First name : ");
                    fname = sc.nextLine();
                    System.out.print("Last name : ");
                    lname = sc.nextLine();
                    System.out.print("email-id : ");
                    email = sc.nextLine();
                    System.out.print("Phone number : ");
                    phoneNumber = sc.nextLine();
                    System.out.print("Address : ");
                    address = sc.nextLine();
                    System.out.print("Account number : ");
                    accNumber = sc.nextLong();
                    service.updateDetails(accNumber,fname, lname, email, phoneNumber, address);
                    break;
                case 10:
                    System.out.println("Thank you for visiting GG Bank!! \nHave a wonderful day ahead!");
                    System.out.println("=================================================");
                    break;
                default:
                    System.out.println("Invalid option selected.\nKindly choose a valid option.");
            }
        } while(choice != 10);
    }
}

