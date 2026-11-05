package testClasses;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class main extends splittingCharacters{
    public static void main(String[] args){

        //list practice
        String[] testList = {};
        ArrayList<String> testArrayList = new ArrayList<String>();

        //user input
        Scanner console = new Scanner(System.in);
        
        //scanning and reading files and also throwing exceptions
        Collection<File> all = new ArrayList<File>(); //i stole this line of code from stackOverflow, but also it's just an array list so whatever

        scanningFiles fileScanner = new scanningFiles();
        System.out.println("Please enter a program you want to run, or type cd to see available programs");
        boolean exit = false;
        while(exit == false){
            String program = console.next();
            switch (program){
                case "printingFiles":
                    System.out.println("Please enter the file name");
                    String fileToScan = console.next();
                    fileScanner.scan(fileToScan);
                    try {
                        fileScanner.edit(fileToScan);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case "cd":
                    fileScanner.addTree(new File("."), all);
                    System.out.println(all);
                    all.clear();
                    continue;
                case "exit":
                    exit = true; 
                    //System.exit(0); this also works
            }
        }

        
    
        //constructors
        /*measuringDistance test = new measuringDistance(console.nextDouble(),console.nextDouble());

        //classes and inheritance, also using super
        splittingCharacters testTwo = new splittingCharacters();
        printingTwice testThree = new printingTwice();

        //for fun
        printer newPrinter = new printer();

        //testing

        
        testTwo.print("HEY");
        testThree.print("HEY");
        
        System.out.println(test.getTime());
        newPrinter.print(test.getTime(40.2)+" ");
        newPrinter.print("hey");
        *

        String temp = testTwo.split("four",2,'R');
        String tempTwo = testTwo.split("four",2,'L');
        

        System.out.println(tempTwo +" "+ temp);
        console.close();
        */
    }
}
