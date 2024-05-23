import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ validateTxtfile.class ,sftpTest.class,dbTest.class })
public class AllTests {

}
