import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Work {
    private final AllAnimals<HomeAnimal> animalList = new AllAnimals();
    private final Contact contact = new Contact();

    private final String mainMenu = "1 - Добавить животное\n2 - Добавить команду\n3 - Отобразить список\n4 - Показать команды"+
            "\n5 - Показать кол-во животных\n6 - Выход";
    private final String animalMenu = "1 - Кот\n2 - Собака\n3 - Хомяк\n0 - Отмена";
    private final String menuYesNo = "1 - Да\n2 - Нет";


    private enum ANIMALS {CAT, DOG, HAMSTER};

    public void Run() throws Exception {
        String menu;
        do {
            menu = getOperation();

            switch (menu) {
                case "11" -> addAnimal(ANIMALS.CAT);
                case "12" -> addAnimal(ANIMALS.DOG);
                case "13" -> addAnimal(ANIMALS.HAMSTER);
                case "21" -> addCommand(ANIMALS.CAT);
                case "22" -> addCommand(ANIMALS.DOG);
                case "23" -> addCommand(ANIMALS.HAMSTER);
                case "31" -> showAnimals(ANIMALS.CAT);
                case "32" -> showAnimals(ANIMALS.DOG);
                case "33" -> showAnimals(ANIMALS.HAMSTER);
                case "41" -> showCommands(ANIMALS.CAT);
                case "42" -> showCommands(ANIMALS.DOG);
                case "43" -> showCommands(ANIMALS.HAMSTER);
                case "5" -> showCountAnimals();
            }
        } while (!(menu.isEmpty() || menu.equals("0")));
    }

    private void showCountAnimals() throws Exception{
        try(Counter counter = new Counter()){
            Logger.getAnonymousLogger().info(counter.getCount().toString());
        }
    }

    /**
     * Отобразить список команд животного
     * @param animal
     */
    private void showCommands(ANIMALS animal){
        String name = contact.getString("Имя животного: ");

        Object o = null;

        switch (animal){
            case CAT -> o = animalList.findCat(name);
            case DOG -> o = animalList.findDog(name);
            case HAMSTER -> o = animalList.findHamster(name);
        }

        if(o == null){
            Logger.getAnonymousLogger().info("Животное не найдено");
            return;
        }

        List<String> commands = null;

        switch (animal){
            case CAT -> commands = ((Cat)o).getCommandList();
            case DOG -> commands = ((Dog)o).getCommandList();
            case HAMSTER -> commands = ((Hamster)o).getCommandList();
        }

        StringBuilder strCommands = new StringBuilder();
        for (String c :commands) {
            strCommands.append(c).append(", ");
        }

        Logger.getAnonymousLogger().info(strCommands.toString());
    }

    /**
     * Отображение списка животных
     * @param animal
     */
    private void showAnimals(ANIMALS animal){
        List<Cat> animalsCat = null;
        List<Dog> animalsDog = null;
        List<Hamster> animalsHamster = null;
        if (animal.equals(ANIMALS.CAT)){
            animalsCat = animalList.getCats();
            Logger logger = Logger.getAnonymousLogger();
            for (Object o : animalsCat) {
                logger.info(o.toString());
            }
        } else if (animal.equals(ANIMALS.DOG)) {
            animalsDog = animalList.getDogs();
            Logger logger = Logger.getAnonymousLogger();
            for (Object o : animalsDog) {
                logger.info(o.toString());
            }
        } else if (animal.equals(ANIMALS.HAMSTER)) {
            animalsHamster = animalList.getHamsters();
            Logger logger = Logger.getAnonymousLogger();
            for (Object o : animalsHamster) {
                logger.info(o.toString());
            }
        }

//        switch (animal){
//            case CAT -> animalsCat = animalList.getCats();
//
//            case DOG -> animalsDog = animalList.getDogs();
//            case HAMSTER -> animalsHamster = animalList.getHamsters();
//        }
//        switch (animal){
//            case CAT -> helpShowAnimals(animalsCat);
//            case DOG -> animalsDog = animalList.getDogs();
//            case HAMSTER -> animalsHamster = animalList.getHamsters();
//        }

    }
    public void helpShowAnimals( List<HomeAnimal> animal){

        Logger logger = Logger.getAnonymousLogger();
        for (Object o : animal) {
            logger.info(o.toString());
        }
    }

    /**
     * Добавление команды
     * @param animal
     */
    private void addCommand(ANIMALS animal){
        String name = contact.getString("Имя животного: ");
        Object objAnimal = null;
        switch (animal){
            case CAT -> objAnimal = animalList.findCat(name);
            case DOG -> objAnimal = animalList.findDog(name);
            case HAMSTER -> objAnimal = animalList.findHamster(name);
        }

        if(objAnimal == null){
            Logger.getAnonymousLogger().info("Такое животное не найдено");
        }
        else{
            String command = contact.getString("Новая команда: ");

            switch (animal){
                case CAT -> ((Cat)objAnimal).addCommand(command);
                case DOG -> ((Dog)objAnimal).addCommand(command);
                case HAMSTER -> ((Hamster)objAnimal).addCommand(command);
            }
        }

    }

    /**
     * Добавленеи нового животного
     * @param animal - вид добавляемого животного
     */
    private void addAnimal(ANIMALS animal) throws Exception {
        // Счетчик
        try(Counter counter = new Counter()){
            counter.add();
        }


        String name = contact.getString("Имя животного: ");
        String color = contact.getString("Окрас: ");
        String date = contact.getString("Дата рождения: ");

        List<String> commands = new ArrayList<>();
        System.out.println("Добавить команды?");
        String menu = contact.ShowYesNoMenu(menuYesNo);
        while (menu.equals("1")){
            String command = contact.getString("Команда: ");
            commands.add(command);
            System.out.println("Продолжить?");
            menu = contact.ShowYesNoMenu(menuYesNo);
        }

        switch (animal){
            case CAT -> animalList.addAnimal(new Cat(name, color, date, commands));
            case DOG -> animalList.addAnimal(new Dog(name, color, date, commands));
            case HAMSTER -> animalList.addAnimal(new Hamster(name, color, date, commands));
        }
    }

    /**
     * Выбор операции в меню программы
     *
     * @return
     */
    private String getOperation() {
        String menu = contact.ShowMainMenu(mainMenu);
        if (!menu.isEmpty() && !menu.equals("0") && !menu.equals("5")) {
            menu += contact.ShowAnimalMenu(animalMenu);
        }

        return menu;
    }
}
