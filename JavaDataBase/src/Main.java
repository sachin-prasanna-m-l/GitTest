import java.util.Scanner;
import com.login.entity.LoginEntity;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        LoginEntity longinEntity = new LoginEntity(sc.next(),sc.next());
        sc.close();
	}

}
