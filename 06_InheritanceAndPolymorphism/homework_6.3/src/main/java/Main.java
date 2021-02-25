public class Main {
    public static void main(String[] args) {
        Client kolya = new PhysicalPerson();
        System.out.println(PhysicalPerson.getRules());
        kolya.amount = 7000;
        System.out.println("У Коли " + kolya.getAmount() + " руб.");
        kolya.take(2000);
        System.out.println("У Коли " + kolya.getAmount() + " руб.");
        kolya.take(5500);
        System.out.println("У Коли " + kolya.getAmount() + " руб.");
        kolya.put(65);
        System.out.println("У Коли " + kolya.getAmount() + " руб.");
        Client ipKolya = new IndividualBusinessman();
        System.out.println(IndividualBusinessman.getRules());
        ipKolya.amount = 70000;
        System.out.println("У ИП Коли " + ipKolya.getAmount() + " руб.");
        ipKolya.take(20000);
        System.out.println("У ИП Коли " + ipKolya.getAmount() + " руб.");
        ipKolya.take(55000);
        System.out.println("У ИП Коли " + ipKolya.getAmount() + " руб.");
        ipKolya.put(500);
        System.out.println("У ИП Коли " + ipKolya.getAmount() + " руб.");
        ipKolya.put(5000);
        System.out.println("У ИП Коли " + ipKolya.getAmount() + " руб.");
        Client kolyaEnterprise = new LegalPerson();
        System.out.println(LegalPerson.getRules());
        kolyaEnterprise.amount = 700000;
        System.out.println("У Коля-Энтерпрайс " + kolyaEnterprise.getAmount() + " руб.");
        kolyaEnterprise.take(200000);
        System.out.println("У Коля-Энтерпрайс " + kolyaEnterprise.getAmount() + " руб.");
        kolyaEnterprise.take(600000);
        System.out.println("У Коля-Энтерпрайс " + kolyaEnterprise.getAmount() + " руб.");
        kolyaEnterprise.take(496000);
        System.out.println("У Коля-Энтерпрайс " + kolyaEnterprise.getAmount() + " руб.");
        kolyaEnterprise.put(100000);
        System.out.println("У Коля-Энтерпрайс " + kolyaEnterprise.getAmount() + " руб.");
    }
}
