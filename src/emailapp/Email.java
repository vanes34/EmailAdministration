package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Email {
    public Scanner scr=new Scanner ( System.in );
    private String fname;
    private String lname;
    private String debt;
    private String email;
    private String password;
    private int mailCapacity=500;
    private String alter_email;

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println ("New Employee:"+this.fname+""+this.lname);
        this.debt=this.setDept ();
        this.password=this.generate_password ( 6 );
        this.email=this.generate_email ();//email generation

    }
    private String generate_email(){
        return this.fname.toLowerCase ()+"."+this.lname.toLowerCase ()+
                "@"+this.debt.toLowerCase ()+"company.com";
    }
    private String setDept(){
        System.out.println ("Department codes :\n1 for Sales \n2 "+
                "for Development \n3 for Accounting \n4 for none");
        boolean flag=false;
        do{
            System.out.println ("Enter Department code");
            int choice=scr.nextInt ();
            switch (choice){
                case 1:
                    return "Salary";

                case 2:
                    return "Development";

                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println ("None");


            }
        } while (!flag);
            return null;
    }
    private String generate_password(int length){
        Random r =new Random();
        String Capital_char="ABSDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_char="abcdefghijklmnopqrstuvwxyz";
        String numbers="0123456789";
        String symbols="!@#$%^&*?";
        String values=Capital_char+Small_char+numbers+symbols;
        String password="";
        for (int i=0;i<length;i++){
            password=password+values.charAt (r.nextInt (values.length ()));
        }
        return password;
    }
    public void set_password() {
        boolean flag = false;
        do {
            System.out.println ( "Do you want to change your password(Y/N)" );
            char choice = scr.next ().charAt ( 0 );
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println ( "Enter current password" );
                String temp = scr.next ();
                if (temp.equals ( this.password )) {
                    System.out.println ( "Enter new password" );
                    this.password = scr.next ();
                    System.out.println ( "Password changed successfuly" );
                } else {
                    System.out.println ( "Incorrect password" );
                }
            }
                else if (choice == 'N' || choice == 'n') {
                    flag = true;
                    System.out.println ( "Password changed option cancelled" );

                }
                else {
                System.out.println ("Enter valid choice");
            }

        } while (!flag);

    }
    public void set_mailCapacity(){
        System.out.println("Current capacity= "+this.mailCapacity+"mb");
        System.out.println ("Enter new mailbox capacity");
        this.mailCapacity= scr.nextInt ();
        System.out.println("Mailbox capacity is successfully changed");

    }
    public void alternate_email(){
        System.out.println ("Enter new alternate email:");
        this.alter_email= scr.next ();
        System.out.println ("Alternate email is set");
    }
    public void getInfo(){
        System.out.println("New: +"+this.fname+""+this.lname);
        System.out.println ("Department"+this.debt);
        System.out.println ("Email"+this.email);
        System.out.println ("Password:"+this.password); // vetem per testim
        System.out.println ("Mailbox capacity"+this.mailCapacity+"mb");
        System.out.println ("Alternate mail"+this.alter_email);
    }

    public void storefile(){
        try{
            FileWriter in=new FileWriter ( "C:\\Users\\User\\IdeaProjects\\EmailAdministration\\info.txt" );
            in.write("First name: "+this.fname);
            in.append ( "\nLast name: "+this.lname );
                    in.append ("\nEmail: "+this.email);
                    in.append ("\nPassword: "+this.password );
                    in.append ("\nCapacity: "+this.mailCapacity );
                    in.append ("\nAlternate mail: "+this.alter_email  );
                    in.close ();
            System.out.println ("Data stored");

        }catch (Exception e){
            System.out.println (e);
        }

    }
    public void read_file(){
try {
    FileReader f1=new FileReader ( "C:\\Users\\User\\IdeaProjects\\EmailAdministration\\info.txt" );
    int i;
    while((i=f1.read ())!=-1){
        System.out.print ((char)i);
    }

f1.close ();
}catch (Exception e){
    System.out.println (e);
}
    }
}