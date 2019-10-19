import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Logic {
    public void buildStates(State start, State home, State success, State seeUsers, State error){
        start.setActions(new Action[]{new Action(home, "login")});
        home.setActions(new Action[]{
                new Action(seeUsers, "see users"),
                new Action(success, "add user"),
                new Action(success, "delete user"),
                new Action(success, "change password"),
                new Action(error, "timeout"),
                new Action(start, "logout"),
                new Action(home, "login")
        });
        success.setActions(new Action[]{
                new Action(home, "back to homepage"),
                new Action(error, "timeout")
        });
        seeUsers.setActions(new Action[]{
                new Action(home, "back to homepage"),
                new Action(start, "logout"),
                new Action(error, "timeout")
        });
        error.setActions(new Action[]{});
    }

    public void doActions(ArrayList<String> actions, State start){

        if(!start.getName().equals("start")){
            System.out.println("you have to begin in the 'start' state!");
            return;
        }
        System.out.println("testing out... " + actions.toString());
        State currentState = start;
        for (int i = 0; i < actions.size(); i++){
            if(actions.get(i).equals("end")){
                System.out.println("error! since you were timed out the application has ended");
                break;
            }
            for (Action action: currentState.getActions()){

                if(action.getAction().equals(actions.get(i))){
                    currentState = action.getState();
                    if(i == actions.size()-1){
                        if(currentState.isFinal()){
                            System.out.println("exited in a final state (" + currentState.getName() + "). Actions were correct");
                        } else if(!currentState.isFinal()){
                            System.out.println("exited in a non-final state (" + currentState.getName() + "). Actions were wrong and developers need to fix this!");
                        }
                    }
                }
            }
        }
    }

    public void getActionsFromFileAndExecute(State startState) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("LogEntry.txt").getFile());

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int instanceId = 1;
        ArrayList<String> instanceInputs = new ArrayList<String>();
        while ((st = br.readLine()) != null){
            int lineInstanceId = Integer.parseInt(st.split(",")[2].split(":")[1]);
            String action = st.split(",")[3].split(":")[1];
            if(instanceId == lineInstanceId){
                instanceInputs.add(action);
                continue;
            } else {
                instanceId = lineInstanceId;
                doActions(instanceInputs, startState);
                instanceInputs.clear();
                instanceInputs.add(action);
            }
        }
        doActions(instanceInputs, startState);
    }
}

