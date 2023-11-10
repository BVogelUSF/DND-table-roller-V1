import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Input {

    public static void main(String[] args) throws IOException {

        /* Data finding logic
        Program locates teh FindMe.txt file stored inside it's relative path.
        This file exists outside the source folder and shouldn't be altered.

        Program takes the absolute path of the file, pathString, and then attempts to split it in two ways.
        Method 1: the file is split on the word Kobold, this is the projects name and is the host folder if you are
        running tests on the source code.
        Method 2: the file is split on the word FindMe, the name of the dummy txt file. This is where the split occurs
        in the packaged jar or exe.
        The split text, found[0], is then stored to dataDirectory and has Data/ added to it to finalize the
        data directory path.
        The Try Catch is used to search for the existence of an empty test file, Test.txt, in the Data directory.
        If it exists then no exception is thrown and method 1 is used, else method 2 is used.
         */
        File location = new File("FindMe.txt");
        String pathString = location.getAbsolutePath();
        String dataDirectory = "";
        try{
            String[] found = pathString.split("Kobold");
            dataDirectory = found[0].concat("Data/");
            File test = new File(dataDirectory+"Test.txt");
            if (!test.exists()){
                throw new Exception();
            }
        }
        catch (Exception e){
            String[] found = pathString.split("FindMe");
            dataDirectory = found[0].concat("Data/");
            File test = new File(dataDirectory+"Test.txt");
        }



        /*Data loading call
        The user is prompted for the data folder they wish to utilize, stored in dynamic.
        A new DataLoad call is made, stored as data, taking the previously created data directory and adding
        the users chosen folder.
         */
        Scanner input = new Scanner(System.in);
        Roller roll = new Roller();
        System.out.println("Enter name of folder: ");
        String dynamic = input.next();
        DataLoad data = new DataLoad(dataDirectory.concat(dynamic));


        /*Usage loop
        The program contently calls roll.Generate, the previously created Roller instance with the read data
        until the user kills the program, either by entering a different character than y or by closing the
        window.
         */

        System.out.println("Data loaded, press y to run");
        String command = input.next();
        while (command.contentEquals("y")){
            System.out.println();
            System.out.println("*********************");
            System.out.println();
            roll.Generate(data);
            System.out.println();
            System.out.println("Press y to run again, press anything else to quit");
            command = input.next();
        }


    }


}

