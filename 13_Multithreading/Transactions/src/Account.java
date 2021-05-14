public class Account {

    private long money;
    private int id;
    private State state = State.Active;

    public Account(int id, long money){
        this.id = id;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
enum State{
    Active,
    Blocked
}
