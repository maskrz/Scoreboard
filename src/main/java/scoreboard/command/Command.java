package scoreboard.command;

public abstract class Command {

    public String execute(){
        validate();
        executeCommand();
        return getOutput();
    }

    protected void validate() {
        // nothing, just do not throw exception
    }

    protected abstract void executeCommand();

    protected abstract String getOutput();


}
