import java.util.List;

public class Cat extends HomeAnimal{
    public Cat(String name, String color, String dateBirth, List<String> commands) {
        super(name, color, dateBirth, commands);
    }

    @Override
    public String toString() {
        return String.format("Кот: %s", super.toString());
    }
}