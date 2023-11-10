import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataLoad {
    public ArrayList<Basic> overview = new ArrayList<>();
    public ArrayList<Basic> npc = new ArrayList<>();
    public ArrayList<Basic> event = new ArrayList<>();
    public ArrayList<Basic> resource = new ArrayList<>();

    public ArrayList<Enemy> npcTable = new ArrayList<>();
    public ArrayList<Resource> eventTable = new ArrayList<>();
    public ArrayList<Resource> resourceTable = new ArrayList<>();

    public DataLoad(String file){
        String[] loadArray;
        try {
            File myObj = new File(file + "/" + "overview.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                loadArray = data.split(";");
                int low = Integer.parseInt(loadArray[1]);
                int high = Integer.parseInt(loadArray[2]);
                overview.add(new Basic(loadArray[0],low,high));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ArrayList<String> overviewList = new ArrayList<>();
        boolean resourceExists = false;
        for (Basic build : overview) {
            overviewList.add(build.getName());
        }
        for (String list : overviewList) {
            try {
                File myObj = new File(file + "/" + list + ".txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    loadArray = data.split(";");
                    int low = Integer.parseInt(loadArray[1]);
                    int high = Integer.parseInt(loadArray[2]);
                    switch (list) {
                        case "npc":
                            npc.add(new Basic(loadArray[0],low,high));
                            break;
                        case "event":
                            event.add(new Basic(loadArray[0], low, high));
                            break;
                    }
                    if (loadArray[0].contentEquals("resource")||
                            loadArray[0].contentEquals("Resource")){
                        resourceExists=true;
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        ArrayList<String> npcList = new ArrayList<>();
        ArrayList<Integer> difficulty = new ArrayList<>();
        for (Basic resource : npc) {
            npcList.add(resource.getName());
        }
        for (String list : npcList) {
            try {
                File myObj = new File(file + "/" + list + ".txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    loadArray = data.split(";");
                    int low = Integer.parseInt(loadArray[1]);
                    int high = Integer.parseInt(loadArray[2]);
                    for (int i = 3, y = 0; i<loadArray.length; i++, y++){
                        try{
                            difficulty.add(Integer.parseInt(loadArray[i]));
                        }
                        catch (Exception e){
                            difficulty.add(-1);
                        }
                    }
                    npcTable.add(new Enemy(loadArray[0],low,high,difficulty.get(0),
                            difficulty.get(1),difficulty.get(2),difficulty.get(3),list));
                    difficulty.clear();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        ArrayList<String> eventList = new ArrayList<>();
        for (Basic resource : event) {
            if (resource.getName().contentEquals("Nothing") ||
                    resource.getName().contentEquals("nothing")||
                    resource.getName().contentEquals("Resource") ||
                    resource.getName().contentEquals("resource")
            ){
                continue;
            }
            eventList.add(resource.getName());
        }
        for (String list : eventList) {
            try {
                File myObj = new File(file + "/" + list + ".txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    loadArray = data.split(";");
                    int low = Integer.parseInt(loadArray[1]);
                    int high = Integer.parseInt(loadArray[2]);
                    eventTable.add(new Resource(loadArray[0],low,high,-1,list));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        if (resourceExists){
            try {
                File myObj = new File(file + "/" + "resource.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    loadArray = data.split(";");
                    int low = Integer.parseInt(loadArray[1]);
                    int high = Integer.parseInt(loadArray[2]);
                    resource.add((new Basic(loadArray[0],low,high)));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        ArrayList<String> resourceList = new ArrayList<>();
        for (Basic resource : resource) {
            resourceList.add(resource.getName());
        }
        for (String list : resourceList) {
            try {
                File myObj = new File(file + "/" + list + ".txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    loadArray = data.split(";");
                    int low = Integer.parseInt(loadArray[1]);
                    int high = Integer.parseInt(loadArray[2]);
                    int quan = Integer.parseInt(loadArray[3]);
                    //Test master array for Resources
                    resourceTable.add(new Resource(loadArray[0],low,high,quan,list));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}


