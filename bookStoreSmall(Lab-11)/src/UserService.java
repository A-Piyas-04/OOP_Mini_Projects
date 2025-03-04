
import javax.servlet.http.HttpSession;

public interface UserService {

    public User login(UserRole role, String email, String password, HttpSession session);

    public String register(UserRole role, User user);

    public boolean isLoggedIn(UserRole role, HttpSession session);

    public boolean logout(HttpSession session);

    public String addCart(User user, Cart cart);

}
