import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        int boxesQuantity = Integer.parseInt(boxes);
        int containerQuantity = (int) Math.ceil((double) boxesQuantity / 27);
        int cargoQuantity = (int) Math.ceil((double) containerQuantity / 12);
        int emptyContainerQuantity = containerQuantity;
        int emptyBoxesQuantity = boxesQuantity;
        for (int i = 1; i <= cargoQuantity ; i ++){
            System.out.println("Грузовик: " + i);
            for (int j = 1; j <= 12; j++){
                emptyContainerQuantity--;
                System.out.println("\tКонтейнер: " + (containerQuantity - emptyContainerQuantity));
                for (int k = 1; k <= 27; k++){
                    if (emptyBoxesQuantity == 0){
                        break;
                    }
                    emptyBoxesQuantity--;
                    System.out.println("\t\tЯщик: " + (boxesQuantity - emptyBoxesQuantity));
                }
                if (emptyContainerQuantity == 0){
                    break;
                }
            }
        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + cargoQuantity + " шт.");
        System.out.println("контейнеров - " + containerQuantity + " шт.");
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
