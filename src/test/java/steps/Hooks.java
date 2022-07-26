package steps;
import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {
    @Before
    public void setUp(){
    initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            testFailed();
        }
        closeDriver();
    }
}
