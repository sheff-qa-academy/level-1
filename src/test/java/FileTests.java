import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FileTests {

    @Parameters({"fileName", "content"})
    @Test
    public void testGetParamsForFile(String fileName, String content) {

        File file = new File(fileName, content);
        System.out.println(file.getSize());
        Assert.assertEquals(file.getSize(), 2.0, "File size parameter error");
        Assert.assertEquals(file.getFilename(), fileName, "File name parameter error");
    }
}


