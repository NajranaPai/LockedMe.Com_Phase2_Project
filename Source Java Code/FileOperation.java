import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class FileOperation {
    String fname,fnam,fco;File f,dp;
    FileWriter fw;int n;FileReader fr;
    Scanner s1=new Scanner(System.in);
    List<String> listfile;
    public void ListFiles() {
        directoryfiles();
        Iterator itr=listfile.iterator();
        if(listfile.size()>0)
        {
         System.out.println("\t------------------------------------------------------------");
         System.out.println("\tAvailable Files in direcory  " + dp + " are:");
         while(itr.hasNext())
           System.out.println("\t\t\t\t\t\t "+ itr.next());
         System.out.println("\t------------------------------------------------------------"); 
        }
       else 
        {
            System.out.println((char)27 + "[31m" + "\n\t Directories does not contain any file..");
            System.out.println((char)27 + "[30;0m");
        }
    }
    private void directoryfiles() {
        dp=new File("D:\\JAVA\\Phase-1\\Practise\\LockedMeCom\\File");
        listfile=Arrays.asList(dp.list());
        Collections.sort(listfile);
    }
    public void AddFile()
    {
        System.out.print("\n\tEnter File Name With Extension:");
        fname=s1.nextLine();
        fnam="File/" +fname;
        f=new File(fnam);
        try {
            if(f.createNewFile())
             {
               System.out.print("\n\tEnter File Content :");  
               fco=s1.nextLine();
               fw=new FileWriter(fnam,Charset.forName("UTF8"));
               fw.write(fco);
               fw.close();
               System.out.println((char)27 + "[31m" + "\n\t   " + fname +" File Added Successfully:"+ (char)27 + "[30;0m");

             }
            else
             {
                System.out.println((char)27 + "[31m" + "\n\t   " + fname +" File Already exist..:"+ (char)27 + "[30;0m");
             }             
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ViewFile()
    {
       System.out.print("\n\tEnter File Name with extension:");
       fname=s1.nextLine();
       fnam="File/" +fname;
       f=new File(fnam);
       directoryfiles();
       n=0;
       for (String fn : listfile)
        {
          if(fn.equals(fname))
            {
              System.out.print((char)27 + "[31m" + "\n\t   " + fname +" File exist With content:"+ (char)27 + "[30;0m"); 
              n++;

              try {
                fr=new FileReader(fnam);
                int i=0;
                while((i=fr.read())!=-1)
                 {
                  System.out.print((char)i);
                 }
              } catch (Exception e) {
                //TODO: handle exception
              }
              System.out.println();
            }  
        }
       if(n==0)
          System.out.println((char)27 + "[31m" + "\n\t   " + fname +" File does not exist:"+ (char)27 + "[30;0m"); 
  
    }
    public void DeleteFile()
    {
        System.out.print("\n\tEnter File Name with extension:");
        fname=s1.nextLine();
        f=new File("File/" + fname);
        directoryfiles();
        int n=0;
        for (String fn : listfile)
         {
           if(fn.equals(fname))
             {
               if(f.delete())
                 System.out.println((char)27 + "[31m" + "\n\t   " + fname + " File Successfully deleted:"+ (char)27 + "[30;0m");
                 n++;
             } 
         }
         if(n==0)
            System.out.println((char)27 + "[31m" + "\n\t   " + fname +" File does not exist:"+ (char)27 + "[30;0m"); 
    }
  public void SearchFile()
  {
    System.out.print("\n\tEnter File Name with extension:");
    fname=s1.nextLine();
    fnam="File/" +fname;
    f=new File(fnam);
    directoryfiles();
    n=0;
    for (String fn : listfile)
     {
       if(fn.equals(fname))
        n=1;
     }
     if(n==1)
      {
        System.out.println((char)27 + "[31m" + "\n\t   " + fname +" File Found"+ (char)27 + "[30;0m");
        Desktop desk=Desktop.getDesktop();
        try {
          desk.open(f);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }    
        
      }
     else
        System.out.println((char)27 + "[31m" + "\n\t   " + fname +" File Not Found"+ (char)27 + "[30;0m");
  }
}
