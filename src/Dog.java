import java.util.List;

public class Dog extends HomeAnimal{
    public Dog(String name, String color, String dateBirth, List<String> commands) {
        super(name, color, dateBirth, commands);
    }

    @Override
    public String toString() {
        return String.format("Собака: %s", super.toString());
    }
}

