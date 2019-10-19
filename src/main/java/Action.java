public class Action {
    private State state;
    private String action;

    public Action(State state, String action) {
        this.state = state;
        this.action = action;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Action{" +
                "state=" + state +
                ", action='" + action + '\'' +
                '}';
    }
}
