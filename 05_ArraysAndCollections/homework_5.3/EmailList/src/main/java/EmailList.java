import java.util.*;
import java.util.regex.Pattern;

public class EmailList {
    TreeSet<String> emailList = new TreeSet<>();
    public void add(String email) {
        // TODO: валидный формат email добавляется
        if (Pattern.matches("[A-Za-z-_0-9]+@[A-Za-z0-9-]+\\.[A-Za-z]+", email)) {
            if (!emailList.contains(email.toLowerCase())) {
                emailList.add(email);
            }
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList<>(emailList);
    }

}
