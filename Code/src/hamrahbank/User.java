package hamrahbank;

/**
 * @author Mahsima Madaniopour
 * @author Nastaran Mahmoudifard
 * @author Sana Lashgari
 * @author Sara Fahimi
 */
public class User {

    String username;
    long password;

    public User(String u, long p) {
        username = u;
        password = p;

    }

    public boolean login(User[] ul, long c) {
        boolean ControlUser = false;
        for (int i = 0; i < c; i++) {
            if (ul[i].username.toLowerCase().equals(username) && ul[i].password == password) {
                ControlUser = true;
            }
        }
        return ControlUser;
    }
}
