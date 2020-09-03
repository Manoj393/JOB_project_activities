package jobBoardCSV.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Pactivity_12 {
    //Write Excel
    public void writeExcel(String filePath) throws IOException {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
 
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");
 
        //This data needs to be written (Object[])
        List<String[]> data = new ArrayList<String[]>();
        String[] heading = {"ID", "ADMINUsername", "Password", "Username", "Email", "First Name", "Last Name", "Website", "Search"};
		String[] row1 = {"1", "root", "pa$$w0rd", "TFEA", "testfileA@exapmle.com", "filetest", "test", "www.filetest.com", "TFEA"};
        
        data.add(heading);
        data.add(row1);
        
        //Iterate over data and write to sheet
        int rownum = 0;
        for (String[] rowData : data) {
            //Creates a new row in the sheet
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for (String cellData : rowData) {
                //Creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(cellData);
            }
        }
        try {
            //this Writes to the workbook
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    //Read Excel
    public void readExcel(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);
 
            //Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                    case NUMERIC: 
                        System.out.print(cell.getNumericCellValue() + " \t ");
                        break;
                    case STRING: 
                        System.out.print(cell.getStringCellValue() + " \t ");
                        break;
                    default:
                        System.out.println("Invalid value");
                        break;
                    }
                }
                System.out.println("");
            }
            file.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String args[]) throws IOException {
        //Prepare the path of excel file
        String filePath = "src/test/resources/sample.xlsx";
 
        //Create an object of current class
        Pactivity_12 objExcelFile = new Pactivity_12();
 
        //Write the file using file name, sheet name and the data to be filled
        objExcelFile.writeExcel(filePath);
        
        //Call read file method of the class to read data
        objExcelFile.readExcel(filePath);
    }
}