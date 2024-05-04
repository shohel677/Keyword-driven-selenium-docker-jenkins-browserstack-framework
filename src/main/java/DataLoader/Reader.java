package DataLoader;

import AbstractComponents.GenericWebPage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static DataLoader.FillFields.*;
import static DataLoader.TestData.fieldsFilePath;

public class Reader extends GenericWebPage {

    private static String genderXpath = "//label[contains(text(),'%1s')]/following-sibling::div/span[@class='%2s']/input";
    private static String inputXpath = "//label[contains(text(),'%s')]/following-sibling::input";
    private static String dobSelectXpath = "//label[contains(text(),'%1s')]/following-sibling::div/select[@name='%2s']";

    public static String testDataCurrentRow;

    public static void fieldsFiller(String fieldsCSVFileName) {

        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);

        int counter = 0;
        String csvFilepath = fieldsFilePath + fieldsCSVFileName;
        List<CSVFields> csvFields = readCSVFieldsFromCSVFile(csvFilepath);
        for (int i = 1; i < csvFields.size(); i++) {

            String getTypeValue = csvFields.get(i).getType();
            String label = csvFields.get(i).getLabel();
            //String currentTestDataValue = testDataCurrentRow.trim().split(",")[i - 1];

            String currentTestDataValue = testDataCurrentRow.trim()
                    .split(",")[TestData.getHeaderColumnIndex(csvFields.get(i).getLabel())];
            if (!currentTestDataValue.isEmpty()) {
                switch (getTypeValue) {

                    case "Text": {

                        if (csvFields.get(i).getAutoFill() == true) {
                            currentTestDataValue = currentTestDataValue+timestamp;
                            fillTextField(inputXpath,label, currentTestDataValue);
                        }
                        else{
                            fillTextField(inputXpath, label, currentTestDataValue);
                        }

                        break;
                    }
                    case "Radio": {
                        selectRadioButton(genderXpath, label, currentTestDataValue);
                        break;
                    }
                    case "DOB": {
                        selectDateOfBirth(dobSelectXpath, label, currentTestDataValue);
                        break;
                    }

                    default:
                        logger.info("In default case :");
                        break;
                }
            }

        }
    }
    public static List<CSVFields> readCSVFieldsFromCSVFile(String csvfilePath) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] value = null;
        List<CSVFields> csvValuesList = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvfilePath), StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {

                value = line.split(cvsSplitBy); // value.length = 4
                CSVFields csv = mannagecsvFields(value);
                csvValuesList.add(csv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return csvValuesList;
    }
    private static CSVFields mannagecsvFields(String[] metadata) {
        String label = metadata[0];
        String type = metadata[1];
        // String value = metadata[2];
        Boolean autofill = Boolean.parseBoolean(metadata[2]);

        // return new CSVFields(label, type, value, autofill);
        return new CSVFields(label, type, autofill);
    }

}
