package testClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class scanningFiles {
    Scanner console = new Scanner(System.in);

    public scanningFiles(){
        

    }
    void scan(String fileName){
        File tempFile = new File(fileName);

        try (Scanner fileReader = new Scanner(tempFile)){
            
            while(fileReader.hasNextLine()){
                String readLine = fileReader.nextLine();
                System.out.println(readLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("NoFileFound");
        }
    }
    
    void edit(String fileName) throws IOException{
    
        File tempFile = new File(fileName);
        boolean exit = false;

        try { 
            FileWriter fileEditor = new FileWriter(tempFile);
            
                while(exit == false){
                    String nextLine = console.nextLine();
                    if(nextLine.equals("exit")){
                        exit = true;
                        console.close();
                        fileEditor.close();
                    }
                    else{
                        fileEditor.write("\n");
                        fileEditor.write(nextLine);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("NoFileFound");
            
        }
    }
    //Also stole this function from the same stack overflow https://stackoverflow.com/questions/189094/how-to-scan-a-folder-in-java. 
    //Its basically making a new list of all the files in a directory then if the folder isn't empty, it adds all of the files from the directory to the list
    //specified in the functions argument. Then it runs the file through the same function to see if it is a directory, and if it is, it runs the function on that directory as well.
    //This is in order to get all the file names in the tree as opposed to only the file names in the directory you are in right now.
    //I am going to edit it to only print out the runnable .java files
    //hopefully it works now?
    //it does work now kindof, i need to split the string at the end of the directory that has java attached to it though, which should not be hard as I
    //can simply look backwards to find the first "\" and work forward
    
    ArrayList<String> addTree(File file, Collection<File> all,ArrayList<String> fileNames) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                if(child.isDirectory() == true){
                    addTree(child, all, fileNames);
                } else if(child.getName().contains("java") && child.isHidden() != true && child.canExecute()){
                //} else if(child.getName().substring(child.getName().length()-4,child.getName().length()).equals("java")){ this was an earlier attempt at the code i finished below
                    
                    fileNames.add(child.getName());
                    //all.add(child); unused after i realized i only truly need to print a list of the runnable file names and not the entire file tree
                }

            }
        }
        return fileNames;
    }
}
