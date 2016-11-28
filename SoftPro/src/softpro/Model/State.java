package softpro.Model;

public enum State {
    ToDo("ToDo"), InProcess("InProcess"), ReadyForTest("ReadyForTest"), Done("ReadyForTest");
    private final String value;

    private State(String value) {
        this.value = value;
    }

    public static State parseState(String string) {
        for (State state : State.values()) {
            if (state.toString().equals(string)) return state;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
