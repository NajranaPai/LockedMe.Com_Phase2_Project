import java.util.Scanner;
public class APP {
    static char c; static int choice;
    static Scanner s = new Scanner(System.in);
    static FileOperation fo=new FileOperation(); //object creation
    public static void main(String[] args) throws Exception {
       
        System.out.println((char)27+ "[35m" +"\n\tWELCOME TO LockedMe.Com APPLICATION : " + (char)27+ "[35m" +" Developed BY: PAI NAJRANABANU Y.");
        System.out.print((char)27+ "[30;0m");

        appstart();
    }

    private static void appstart() {
        do{
            System.out.println("\n\tLockedMe.Com Options:");
            System.out.print("\t-------------------------------------");
            System.out.println("\n\t  1: List Files");
            System.out.println("\n\t  2: File Operations");
            System.out.println("\n\t  3: Close");
            System.out.print("\n\tSelect Any one option:");
            choice=s.nextInt(); 
            switch(choice)
             {
                 case 1: fo.ListFiles(); break; //FileOperation class method called 
                 case 2: FileOperation();break; // this class method called
                 case 3: System.exit(0);
                 default : 
                         System.out.println((char)27+ "[31m" + "\n\t Please select Proper Numeber for operation." + (char)27+ "[30;0m");
                         appstart();
             }
            System.out.print("\tDo you want to continue ? Y/N ");
            c=s.next().charAt(0);
        }while(c=='Y' || c=='y');
    }

    private static void FileOperation() {
        do{
            System.out.println("\n\t File Operation:");
            System.out.print("\t---------------------------------"); 
            System.out.println("\n\t 1: Add File");
            System.out.println("\n\t 2: View File");
            System.out.println("\n\t 3: Delete File");
            System.out.println("\n\t 4: Search File");
            System.out.println("\n\t 5: Back");
            System.out.print("\n\tSelect Any one option:");
            choice=s.nextInt();  
            /*while (!Character.isDigit(choice)) {
                System.out.println((char)27+ "[31m" + "\n\t Please do not enter any character.");
                System.out.print((char)27+ "[37;1m");
                System.out.print("\n     Select Proper Choice:");
                choice=s.next().charAt(0);
            }
            choice=choice-48;*/
            
            switch(choice)
             {
                 case 1: fo.AddFile();break;
                 case 2: fo.ViewFile();break;
                 case 3: fo.DeleteFile(); break;
                 case 4: fo.SearchFile();break;
                 case 5: appstart();break;
                 default : 
                         System.out.println((char)27+ "[31m" + "\n\t Please select Proper Numeber for file operation." + (char)27+ "[30;0m");
                         appstart();
             }
            System.out.print("\n\tDo you want to continue for File Operation? Y/N ");
            c=s.next().charAt(0);
        }while(c=='Y'|| c=='y');
        if(c!='Y'|| c!='y')
         {
             appstart();
         }
    }   
}

