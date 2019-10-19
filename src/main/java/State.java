public class State {
    private String name;
    private boolean isFinal;
    private boolean isError;
    private Action[] actions;

    public State() {
    }

    public State(String name, boolean isFinal, boolean isError) {
        this.name = name;
        this.isFinal = isFinal;
        this.isError = isError;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public Action[] getActions() {
        return actions;
    }

    public void setActions(Action[] actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        String actionsToString = "{";
        for (int i = 0; i < actions.length; i++){
            if(i == actions.length-1){
                actionsToString += actions[i].getAction() + "}";
                break;
            } else {
                actionsToString += actions[i].getAction() + ",";
            }

        }
        return "State{" +
                "name='" + name + '\'' +
                ", isFinal=" + isFinal +
                ", isError=" + isError +
                ", actions=" + actionsToString +
                '}';
    }
}
