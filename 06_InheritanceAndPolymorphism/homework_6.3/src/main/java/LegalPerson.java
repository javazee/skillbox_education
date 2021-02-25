public class LegalPerson extends Client {

    public static String getRules() {
        return "Комиссии за ввод c юридических лиц не снимаются.\n" +
                "Комиссии за вывод с юридических лиц 1%";
    }

    public void take(double amountToTake) {
        if (amountToTake * 1.01 <= getAmount()){
            amount = getAmount() - amountToTake * 1.01;
        } else {
            System.out.println("Недостаточно средств на счете");
        }
    }
}
