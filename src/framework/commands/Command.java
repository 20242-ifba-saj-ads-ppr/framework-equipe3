package framework.commands;

public abstract class Command {

    private String name;
    private String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    String getName(){return this.name;}

    String getDescription(){return this.description;}

    public abstract void execute();

}
