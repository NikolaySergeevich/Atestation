import java.util.List;
import java.util.Objects;

public class HomeAnimal {
    private String name;
    private String color;
    private List<String> commands;
    private String dateBirth;

    public HomeAnimal(String name, String color, String dateBirth, List<String> commands) {
        this.name = name;
        this.color = color;
        this.commands = commands;
        this.dateBirth = dateBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    public void addCommand(String newCommand){
        if (commands.stream().filter(x -> x.equals(newCommand)).findFirst().isEmpty()) {
            return;
        }

        commands.add(newCommand);
    }

    public void removeCommand(String command) {
        commands.remove(command);
    }
    public List<String> getCommandList() {
        return commands;
    }

    @Override
    public String toString() {
        return String.format("%s", name);

    }@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeAnimal animal = (HomeAnimal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
