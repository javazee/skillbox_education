public abstract class Client {
    double amount = 0;
    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0){
            amount += amountToPut;
        } else {
            System.out.println("Некорректный ввод. Сумма на счете не изменилась.");
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= getAmount()){
            amount = getAmount() - amountToTake;
        } else {
            System.out.println("Недостаточно средств на счете");
        }
    }

}
