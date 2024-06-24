package buoi5.mvc.command_processor;

public class CommandProcessor {
    //field
    private static CommandProcessor commandProcessorRemote = null;
    //method
    private CommandProcessor(){}

    //
    public static CommandProcessor makeCommandProcessor() {
        if(commandProcessorRemote == null){
            commandProcessorRemote = new CommandProcessor();
        }
        return commandProcessorRemote;
    }
    
    public void execute(Command commandRemote) {
        commandRemote.execute();
    }

}
