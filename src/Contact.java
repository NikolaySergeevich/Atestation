import java.util.Scanner;

public class Contact {

    public String ShowMainMenu(String menu){
        Scanner scanner = new Scanner(System.in);
        String answear;
        System.out.println(menu);
        answear = scanner.next();
        if (answear.equals("1") || answear.equals("2") || answear.equals("3") || answear.equals("4") || answear.equals("5") || answear.equals("0") ){
            return answear;
        }else return "";
    }
    public String ShowAnimalMenu(String menu) {
        Scanner scanner = new Scanner(System.in);
        String answear;
        System.out.println(menu);
        answear = scanner.next();
        if (answear.equals("1") || answear.equals("2") || answear.equals("3") || answear.equals("0")) {
            return answear;
        } else return "";
    }
    public String ShowYesNoMenu(String menu) {
        Scanner scanner = new Scanner(System.in);
        String answear;
        System.out.println(menu);
        answear = scanner.next();
        if (answear.equals("1") || answear.equals("2")) {
            return answear;
        } else return "";
    }

    /**
     * Ввод пользователем числового значения
     * @param message - сообщение пользователю
     * @return
     */
    public int getInteger(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        return scanner.nextInt();
    }

    /**
     * ввод пользователеи строкового сообщения
     * @param message - сообщение пользователю
     * @return
     */
    public String getString(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        return scanner.next();
    }
}
