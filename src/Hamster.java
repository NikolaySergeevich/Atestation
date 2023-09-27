import java.util.List;

public class Hamster extends HomeAnimal{
    public Hamster(String name, String color, String dateBirth, List<String> commands) {
        super(name, color, dateBirth, commands);
    }

    @Override
    public String toString() {
        return String.format("Хомяк: %s", super.toString());
    }
}