import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //hardcode the states with the necessary properties
        State start = new State("start", true,false);
        State home = new State("home", false,false);
        State success = new State("success", false,false);
        State seeUsers = new State("seeUsers", false,false);
        State error = new State("error", false,false);

        Logic l = new Logic();
        l.buildStates(start, home, success, seeUsers, error); //sets up the relational actions of the states

        l.getActionsFromFileAndExecute(start);

        //String[] inputs = {"login", "see users", "logout"};
        //l.doActions(inputs, start); //takes a string array of actions, and executes them into the states
    }
}
