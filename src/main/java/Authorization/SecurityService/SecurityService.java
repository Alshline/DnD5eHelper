package Authorization.SecurityService;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
