
public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        Reasoning reasoning = new Reasoning();
        reasoning.start();

        TeamTC1 team = new TeamTC1();
        team.run();
    }
}