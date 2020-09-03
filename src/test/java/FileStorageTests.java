import exception.FileNameAlreadyExistsException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileStorageTests {

    @Test
    public void testWriteInFileStorage() throws FileNameAlreadyExistsException {

        FileStorage files = new FileStorage();
        File file = new File("File", "test");
        files.write(file);

        Assert.assertTrue(files.isExists(file.getFilename()), "Error checking file write");
        Assert.assertEquals(files.getFile(file.getFilename()), file, "The recorded file not equal from the read");
    }

    @Test
    public void testWriteEmptyFile() throws FileNameAlreadyExistsException {
        FileStorage files = new FileStorage();
        File file = new File("File", "");
        files.write(file);
        Assert.assertTrue(files.isExists(file.getFilename()), "Error checking file write");
        Assert.assertEquals(files.getFile(file.getFilename()), file, "The recorded file not equal from the read");
    }

    @Test
    public void testFileStorageSizeCheck() throws FileNameAlreadyExistsException {

        FileStorage files = new FileStorage(5);
        File file1 = new File("File1", "1234567890");
        files.write(file1);
        File file2 = new File("File2", "1234567890");
        files.write(file2);

        Assert.assertTrue(files.getFiles().size() < 2, "File Storage size check error");
    }

    @Test
    public void testFileNameAlreadyExistsException() {

        FileStorage files = new FileStorage();
        File file = new File("File", "test1");
        try {
            files.write(file);
            files.write(file);

            Assert.fail("Check \"FileNameAlreadyExistsException\" does not work");

        } catch (FileNameAlreadyExistsException e) {

        }
    }

    @Test
    public void testIsExistsFile() throws FileNameAlreadyExistsException {

        FileStorage files = new FileStorage();
        File file1 = new File("File1", "test");
        File file2 = new File("File2", "test");
        files.write(file1);

        Assert.assertTrue(files.isExists(file1.getFilename()), "File existing in File Storage was not found");
        Assert.assertFalse(files.isExists(file2.getFilename()), "Found a file that does not exist in the File Storage");
    }

    @Test
    public void testDeleteFile() throws FileNameAlreadyExistsException {

        FileStorage files = new FileStorage();
        File file1 = new File("File1", "test");
        files.write(file1);
        files.delete(file1.getFilename());

        Assert.assertFalse(files.isExists(file1.getFilename()), "Found a file that does not exist in the File Storage");
    }

    @Test
    public void testGetFiles() throws FileNameAlreadyExistsException {

        FileStorage files = new FileStorage();
        File file1 = new File("File1", "test");
        File file2 = new File("File2", "test");
        File file3 = new File("File3", "test");
        files.write(file1);
        files.write(file2);
        files.write(file3);

        Assert.assertEquals(files.getFiles().size(), 3, "Error in getting file collection");
    }
}