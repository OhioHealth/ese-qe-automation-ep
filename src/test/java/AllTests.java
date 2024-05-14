import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TxtfileValidate.class ,SFTPTest.class,DbTest.class })
public class AllTests {

}
