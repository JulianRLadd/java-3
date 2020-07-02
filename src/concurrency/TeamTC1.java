import java.util.ArrayList;
import java.util.List;

class TeamTC1 implements Runnable{

    List<String> team = new ArrayList<>();
    List<String> taGroup = new ArrayList<>(){
        {
            add("Emilios Papas");
            add("Abigail Swigert ");
            add("R Devon Brewster");
            add("Monica Howard");
            add("Michael Kinney");
            add("Phoenix Megan Shane");
            add("Marcelo Barbosa");
            add("Adam Rice ");
            add("Jose Moreno");
            add("Gabe Chavez");
            add("Christian");
        }
    };

    @Override
    public void run() {

        for(int i = 0;i<taGroup.size();i++){

        try {
            Thread.sleep(1000);
            System.out.println(taGroup.get(i));
            team.add(taGroup.get(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        for(int j = 1;j<taGroup.size();j++){
            System.out.println(taGroup.get(j));
        }


        }

    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.
    // In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).
    // There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to
    // the team List  After all the names have been pushed to this List, print out the entire list of all the students
    // in your TA group. Don't forget your TA as well!  All of these steps should be done whenever the thread is started.
    // (i.e. it can be done directly in the run()method of the thread itself).  Kick off the thread in the Main class of
    // the concurrency package.
}