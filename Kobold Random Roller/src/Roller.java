import java.util.ArrayList;
import java.util.Random;
public class Roller {
    private Random rand = new Random();
    private int roll;

    public void Generate(DataLoad data){

        roll = rand.nextInt(100)+1;

        String eventResult = "";
        for (int i = 0; i < data.overview.size(); i++) {
            if (data.overview.get(i).getMinimum() <= roll &&
                    roll <= data.overview.get(i).getMaximum()) {
                eventResult = data.overview.get(i).getName();
            }
        }
        switch (eventResult){
            case "npc":
                System.out.println("Hostile");
                Hostile(data);
                break;
            case "event":
                System.out.println("Event");
                Event(data);
                break;
        }

    }

    private void Hostile(DataLoad data){
        int area = 1;
        ArrayList<Integer> enemy = new ArrayList<>();
        String result = "";
        roll = rand.nextInt(100)+1;



        for (int i = 0; i<data.npc.size();i++){
            if (data.npc.get(i).getMinimum() <= roll &&
                    roll <= data.npc.get(i).getMaximum()) {
                result = data.npc.get(i).getName();
                System.out.println(result);
            }
        }
        roll = rand.nextInt(100)+1;
        for (int i = 0; i<data.npcTable.size(); i++){
            if(data.npcTable.get(i).getTag().contentEquals(result)){
                if(data.npcTable.get(i).getMinimum() <= roll &&
                        roll <= data.npcTable.get(i).getMaximum()){
                    enemy.add(i);
                }
            }
        }
        if (enemy.size()<2){
            System.out.println(data.npcTable.get(enemy.get(0)).getName());
            roll = rand.nextInt(4);
            switch (roll) {
                case 0:
                    System.out.println("Easy: " + data.npcTable.get(enemy.get(0)).getEasy());
                    break;
                case 1:
                    System.out.println("Medium: " + data.npcTable.get(enemy.get(0)).getMedium());
                    break;
                case 2:
                    System.out.println("Hard: " + data.npcTable.get(enemy.get(0)).getHard());
                    break;
                case 3:
                    System.out.println("Deadly: " + data.npcTable.get(enemy.get(0)).getDeadly());
                    break;
            }
        }
        else{
            for(Integer count : enemy){
                System.out.println("Area: " + area);
                area++;
                System.out.println(data.npcTable.get(count).getName());
                roll = rand.nextInt(4);
                switch (roll) {
                    case 0:
                        System.out.println("Easy: " + data.npcTable.get(count).getEasy());
                        break;
                    case 1:
                        System.out.println("Medium: " + data.npcTable.get(count).getMedium());
                        break;
                    case 2:
                        System.out.println("Hard: " + data.npcTable.get(count).getHard());
                        break;
                    case 3:
                        System.out.println("Deadly: " + data.npcTable.get(count).getDeadly());
                        break;
                }
                System.out.println();
            }
        }
    }

    private void Event(DataLoad data){
        roll = rand.nextInt(100)+1;
        String eventResult = "";
        for (int i = 0; i < data.event.size(); i++) {
            if (data.event.get(i).getMinimum() <= roll &&
                    roll <= data.event.get(i).getMaximum()) {
                eventResult = data.event.get(i).getName();
                System.out.println(eventResult);
            }
        }
        if (eventResult.contentEquals("Resource") ||
                eventResult.contentEquals("resource")){
            roll = rand.nextInt(100)+1;
            for (int i = 0; i < data.resource.size(); i++) {
                if (data.resource.get(i).getMinimum() <= roll &&
                        roll <= data.resource.get(i).getMaximum()) {
                    eventResult = data.resource.get(i).getName();
                    System.out.println(eventResult);
                }
            }
            roll = rand.nextInt(100)+1;
            for (int i = 0; i<data.resourceTable.size(); i++){
                if(data.resourceTable.get(i).getTag().contentEquals(eventResult)){
                    if(data.resourceTable.get(i).getMinimum() <= roll &&
                    roll <= data.resourceTable.get(i).getMaximum()){
                        roll = rand.nextInt(data.resourceTable.get(i).getQuantity())+1;
                        System.out.println(data.resourceTable.get(i).getName()+": "+roll);
                    }
                }
            }
        }
        else if (eventResult.contentEquals("Nothing") ||
                eventResult.contentEquals("nothing")){
            System.out.println("Enjoy your rest");
        }
        else {
            roll = rand.nextInt(100)+1;
            for (int i = 0; i<data.eventTable.size(); i++){
                if(data.eventTable.get(i).getTag().contentEquals(eventResult)){
                    if(data.eventTable.get(i).getMinimum() <= roll &&
                            roll <= data.eventTable.get(i).getMaximum()){
                        System.out.println(data.eventTable.get(i).getName());
                    }
                }
            }
        }
    }


}
