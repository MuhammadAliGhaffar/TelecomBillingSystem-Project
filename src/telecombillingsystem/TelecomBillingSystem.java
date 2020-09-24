/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telecombillingsystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Muhammad Ali Ghaffar
 */
public class TelecomBillingSystem {

    class Node {  
        String name;
        String number;
        double payment;
        Node next; 
        Node previous;  
        public Node(String number,String name, double payment) {  
            this.name = name;
            this.number=number;
            this.payment=payment;
        }
}
    
    Node head, tail = null;
    Node newNode;
    Scanner s1=new Scanner(System.in);
    
    public void addRecord() throws IOException{
        System.out.println("Add an entry");
                                        
        System.out.print("Enter a Phone Number: ");
        String phoneNumber = s1.next();
					
        System.out.print("Enter a Name: ");
        String name = s1.next();

        System.out.print("Enter an Amount: ");
        double amount = s1.nextDouble();

        newNode = new Node(phoneNumber,name,amount);
        //Adding Filing
        FileWriter fw = new FileWriter(new File("file.txt"), true);
	BufferedWriter out = new BufferedWriter(fw);
	out.write(phoneNumber + " " + name + " " + amount);
	out.newLine();
	out.close();
        
        if(head == null) 
        {  
           head = tail = newNode;  
           head.previous = null;  
           tail.next = null;  
        }  
        else 
        {  
           tail.next = newNode;   
           newNode.previous = tail;  
           tail = newNode;  
           tail.next = null;   
        }
        System.out.print("Record successfully added\n\n");
        
    }
    public void viewList(){
        Node current = head;  
        System.out.print("\t\t\t****LIST RECORD****\n\n");
        System.out.print("User Name\t\tPhone Number\t\t\tAmount\n");
        int j;
        System.out.println();
        for(j=0;j<79;j++)
        System.out.print("-");
        if(head == null) {  
            System.out.print("\nList is empty\n");  
            return;  
        }    
        while(current != null) {  
            System.out.print("\n"+current.name + "\t\t\t" +current.number + "\t\t\t" + current.payment+"/-");  
            current = current.next;  
        }
        System.out.println();
        for(j=0;j<79;j++)
        System.out.print("-");
        
        System.out.println();
    }
    public void search(){
        System.out.print("\t\t\t****SEARCH RECORD****\n\n");
        System.out.print("Enter a number you want to search :");
        String num=s1.next();
        Node current = head;  
        int i=0;
        boolean flag = false;  
        
        //Checks whether list is empty  
        if(head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else {  
            while(current != null) 
            {  
                 //Compares node to be found with each node present in the list  
                if(current.number.equals(num)) 
                {  
                    flag = true;
                    System.out.println("Number given by user is founded");
                    break;  
                }  
                i++;  
                current = current.next;  
            }  
        }  
        if(flag == false)
        {
            System.out.println("Number given by user is not founded");  
        }
    }
    public void modify(){
        System.out.print("\t\t\t****MODIFY RECORD****\n\n");
        System.out.print("Enter phone number of the subscriber to modify :");
        String num=s1.next();
        Node current = head;  
        int i=0;
        boolean flag = false;  
        
        //Checks whether list is empty  
        if(head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else {  
            while(current != null) 
            {  
                 //Compares node to be found with each node present in the list  
                if(current.number.equals(num)) 
                {  
                    flag = true;
                                        
                    System.out.print("Enter a Phone Number: ");
                    String phoneNumber = s1.next();
                    current.number = phoneNumber;
                    
                    System.out.print("Enter a Name: ");
                    String name = s1.next();
                    current.name=name;
                    
                    System.out.print("Enter an Amount: ");
                    double amount = s1.nextDouble();
                    current.payment=amount;
        
                    break;  
                }  
                i++;  
                current = current.next;  
            }  
        }  
        if(flag == false)
        {
            System.out.println("Number given by user is not founded");  
        }
    }
    public void addpayment(){
        System.out.print("\t\t\t****PAYMENT RECORD****\n\n");
        System.out.print("Enter phone number of the subscriber for payment :");
        String num=s1.next();
        Node current = head;  
        int i=0;
        boolean flag = false;  
        
        //Checks whether list is empty  
        if(head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else {  
            while(current != null) 
            {  
                 //Compares node to be found with each node present in the list  
                if(current.number.equals(num)) 
                {  
                    flag = true;
                    System.out.println("Phone Number :"+current.number);
                    System.out.println("Customer Name :"+current.name);
                    System.out.println("Current Amount :"+current.payment);
                    System.out.print("\nEnter amount of payment :");
                    double amount = s1.nextDouble();
                    current.payment=current.payment-amount;
                    System.out.println("Current Amount :"+current.payment);
                    break;  
                }  
                i++;  
                current = current.next;  
            }  
        }  
        if(flag == false)
        {
            System.out.println("Number given by user is not founded");  
        }
    }
    public void delete(){
        System.out.print("\t\t\t****DELETE RECORD****\n\n");
        System.out.print("Enter phone number of the subscriber to delete :");
        String num=s1.next();
        Node current = head;  
        int i=0;
        boolean flag = false;  
        
        //Checks whether list is empty  
        if(head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else {  
            while(current != null) 
            {  
                if(current.number.equals(num)) 
                {  
                    flag = true;
                    System.out.println("Selected User data is deleted !!!!");
                    current.name = "";
                    current.number = "";
                    current.payment = current.payment-current.payment;//in java int is premitive type only objects can be
                    while(tail.next != null)
                    {
                        tail = current.next;
                    }
                    break;                      
                }  
                i++;  
                current = current.next;  
            }  
        }  
        if(flag == false)
        {
            System.out.println("Number given by user is not founded");  
        }
    }
    public void selectionSort(){
        Node current = null, index = null;  
        String temp;  
        if(head == null) {  
            return;  
        }  
        else {  
            for(current = head; current.next != null; current = current.next) {  
                for(index = current.next; index != null; index = index.next) {  
                    if(current.name.compareTo(index.name) > 0 ) {  
                        temp = current.name;  
                        current.name = index.name;  
                        index.name = temp;  
                    }  
                }  
            }  
        }
       System.out.println("Successfully Selection Sorting Applied\n\n");
       viewList(); 
    }
    public static void clearData() throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("file.txt");
        writer.print("");
        writer.close();
    }
    public void menu(){
        System.out.printf("\n 1 : for adding new records.\n 2 : for list of records");
        System.out.printf("\n 3 : for Sorting List.");
        System.out.printf("\n 4 : for modifying records.");
        System.out.printf("\n 5 : for searching records.");
        System.out.printf("\n 6 : for deleting records.\n 7 : for Add Payments");
        System.out.printf("\n 8 : for Menu");
        System.out.printf("\n 9 : for Exit.\n");
    }
    
    

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        clearData();
        TelecomBillingSystem b1=new TelecomBillingSystem();
        
        System.out.printf("**************************************************************");
	System.out.printf("\n\t\t------TELECOM BILLING SYSTEM---");
	System.out.printf("\n\t\t****************************************************************\n\n");
        
        System.out.printf("\n 1 : for adding new records.\n 2 : for list of records");
        System.out.printf("\n 3 : for Sorting List.");
        System.out.printf("\n 4 : for modifying records.");
        System.out.printf("\n 5 : for searching records.");
        System.out.printf("\n 6 : for deleting records.\n 7 : for Add Payments");
        System.out.printf("\n 8 : for Menu");
        System.out.printf("\n 9 : for Exit.\n");
        
        String choice;
        Scanner in=new Scanner(System.in);
        while(true){
            
            choice = in.nextLine();

            switch (choice) {
		case "1": 
                    b1.addRecord();
                    break;
                case "2": 
                    b1.viewList();
                    break;
                case "3":
                    b1.selectionSort();
                    break;
                case "4":
                    b1.modify();
                    break;
		case "5": 
                    b1.search();
                    break;
		case "6": 
                    b1.delete();
                    break;
                case "7":
                    b1.addpayment();
                    break;
                case "8":
                    b1.menu();
                    break;
		case "9": 
                    System.out.println("Exiting!");
                    System.out.print("\n\t\t\t\tTHANK YOU\n\n");
                    return;
				
            }
        }
    }
    
}
