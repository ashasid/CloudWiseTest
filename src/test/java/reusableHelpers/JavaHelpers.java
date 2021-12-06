
package reusableHelpers;

        import itRunner.InitConstants;
        import org.apache.commons.io.FilenameUtils;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.Properties;

public class JavaHelpers extends InitConstants {

    public static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(FilenameUtils.normalize("src/test/application.properties")));
        return prop;
    }

    //get list of duplicate employee names from employee list
    public static void getListOfDuplicateEmployeesName(ArrayList employeeNameList) {
        ArrayList duplicateNameList = null;
        HashSet duplicateNames = null;
        duplicateNameList = new ArrayList<String>();
        for (int i = 0; i < employeeNameList.size(); i++) {
            for (int j = i + 1; j < employeeNameList.size(); j++) {
                if (employeeNameList.get(i).equals(employeeNameList.get(j))) {
                    duplicateNameList.add(employeeNameList.get(j).toString());
                }
            }
        }
        duplicateNames = new HashSet();
        for (Object l : duplicateNameList) {
            if (duplicateNames.add(l) == true)
                System.out.println("Duplicate employee names are " + l);
        }
    }
}