import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by artem on 02.03.17.
 * Modified by artem on 05.03.17
 */
@RunWith(value = Parameterized.class)
public class SimpleTest {

      private String value1;
      private String value2;
      private String value3;

    public SimpleTest(String value1, String value2, String value3){

      this.value1=value1;
      this.value2=value2;
      this.value3=value3;

    }
    @Test
    public void firstSimpleTest(){
        int number1= Integer.parseInt(value1);
        int number2= Integer.parseInt(value2);
        int number3= Integer.parseInt(value3);
        assertTrue("Result not equals to 4", number1 * number2 == number3);
    }



    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return getTestData("data.csv");
    }


    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        file.close();
        return records;
    }


}
