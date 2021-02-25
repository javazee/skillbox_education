public class IndividualBusinessman extends Client {

    public static String getRules() {
        return "Комиссии за ввод с индивидуальных предпринимателей: до 1000 руб. 1 %, свыше или равно 1000 руб. 0.5 %.\n" +
                "Комиссии за вывод с индивидуальных предпрининимателей не снимаются";
    }

    public void put(double amountToPut) {
        if (amountToPut > 0){
            if (amountToPut >= 1000) {
                amount += amountToPut * 0.995;
            } else {
                amount += amountToPut * 0.99;
            }
        } else {
            System.out.println("Некорректный ввод. Сумма на счете не изменилась.");
        }
    }
}
