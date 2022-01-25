import org.testng.Assert;
import org.testng.annotations.Test;

public class Proba {

    @Test
    public void sampleTest(){
        String x = "test";

        Assert.assertTrue(x.equals("test"),"test is good");
    }
}
