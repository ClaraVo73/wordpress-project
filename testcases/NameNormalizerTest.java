import commons.NameNormalizer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NameNormalizerTest {

    @DataProvider(name = "nameDataProvider")
    public Object[][] nameDataProvider() {
        return new Object[][]{
                {"Nguyễn  vAn Thanh", "Nguyễn Văn Thanh"},
                {"trần  thị Nhung", "Trần Thị Nhung"},
                {"Huỳnh  Thúc Điền.", "Huỳnh Thúc Điền"},
                {"“Lê van NaM”", "Lê Văn Nam"},
                {"  Phạm     Văn     Tý   ", "Phạm Văn Tý"},
                {"", ""},
                {null, ""},
                {"tuấn", "Tuấn"},
                {" Đỗ  ", "Đỗ"},
                {"Trần123Van456An", "Trần Văn An"},
                {"Bùi@#&*Thị*!$%Mai","Bùi Thị Mai"},
                {"lÊ vĂn nGỌC ", "Lê Văn Ngọc"},
                {"hoàng-anh", "Hoàng Anh"},
                {"(Trần huu Tâm)", "Trần Hữu Tâm"}
        };
    }

    @Test(dataProvider = "nameDataProvider")
    public void testNormalizeName(String input, String expectedOutput) {
        String actual = NameNormalizer.normalize(input);
        Assert.assertEquals(actual, expectedOutput,
                "Expected: '" + expectedOutput + "' but got: '" + actual + "' for input: '" + input + "'");
    }
}
