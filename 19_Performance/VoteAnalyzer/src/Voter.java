public class Voter {

    private String name;
    private String birthDay;

    public Voter(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object obj) {
        Voter voter = (Voter) obj;
        return name.equals(voter.name) && birthDay.equals(voter.birthDay);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + birthDay.hashCode();
    }

    public String toString() {
        return name + " (" + birthDay + ")";
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }
}
