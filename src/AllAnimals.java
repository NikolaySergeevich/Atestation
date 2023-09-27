import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AllAnimals <HomeAnimal>{
    private List<HomeAnimal> animals = new ArrayList<>();

    /**
     * метод добавляет животное в список
     * @param animal
     */
    public void addAnimal(HomeAnimal animal) {
        animals.add(animal);
    }

    /**
     * метод удаляет животное из списка
     * @param animal
     * @return
     */
    public boolean removeAnimal(HomeAnimal animal){
        return animals.remove(animal);
    }

    /**
     * Получить список животных
     * @return
     */
    public List<HomeAnimal> getAnimals(){
        return animals;
    }

    /**
     * Получить только кошек
     * @return
     */
    public List<Cat> getCats(){
        List<Cat> cats = new ArrayList<>();
        for (HomeAnimal anim:animals) {
            if (anim instanceof Cat){
                cats.add((Cat)anim);
            }
        }
        return cats;
    }
    /**
     * Получить только собак
     * @return
     */
    public List<Dog> getDogs(){
        List<Dog> cats = new ArrayList<>();
        for (HomeAnimal anim:animals) {
            if (anim instanceof Dog){
                cats.add((Dog) anim);
            }
        }
        return cats;
    }

    /**
     * Получить только хомяков
     * @return
     */
    public List<Hamster> getHamsters(){
        List<Hamster> cats = new ArrayList<>();
        for (HomeAnimal anim:animals) {
            if (anim instanceof Hamster){
                cats.add((Hamster) anim);
            }
        }
        return cats;
    }

    public Cat findCat(String name){
        List<Cat> cats = this.getCats();
        Cat cat = null;

        try {
            cat = cats.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            cat = null;
        }
        return cat;
    }

    public Dog findDog(String name){
        List<Dog> dogs = this.getDogs();
        Dog dog = null;

        try {
            dog = dogs.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            dog = null;
        }
        return dog;
    }

    public Hamster findHamster(String name){
        List<Hamster> hamsters = this.getHamsters();
        Hamster hamster = null;

        try {
            hamster = hamsters.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            hamster = null;
        }
        return hamster;
    }
}