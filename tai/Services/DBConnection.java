package Services;

import java.io.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

public class DBConnection {
    protected String filePath;
    public DBConnection(String filePath) throws IOException {
        // Open the Excel file
        this.filePath = filePath;
        FileInputStream file = new FileInputStream(new File(filePath));

        // Create Workbook instance holding reference to .xlsx file
        Workbook workbook = WorkbookFactory.create(file);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Create a two-dimensional array to store the data
        String[][] data = new String[sheet.getLastRowNum() + 1][];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            data[i] = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
        }

        // Define the column names
        String[] columnNames = new String[sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            columnNames[i] = sheet.getRow(0).getCell(i).getStringCellValue();
        }
        workbook.close();
        file.close();
    }
    public void Add(List values) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(inputStream);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Create a new row and set the values
        Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);
        for(int i = 0; i < values.size(); i++)
        {
            Cell cell1 = newRow.createCell(i);
            cell1.setCellValue(values.get(i).toString());
        }
        Cell cell1 = newRow.createCell(values.size());
        cell1.setCellValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // Write the changes back to the Excel file
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    public void Remove(String value) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(inputStream);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Find the row and cell containing the value to be removed
        Row rowToRemove = null;
        Cell cellToRemove = null;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(value)) {
                    rowToRemove = row;
                    cellToRemove = cell;
                    break;
                }
            }
            if (rowToRemove != null)
            {
                break;
            }
        }
        int columnToRemove = cellToRemove.getColumnIndex();
        rowToRemove.removeCell(cellToRemove);
        for (Row row : sheet) {
            Cell cell = row.getCell(columnToRemove);
            if (cell != null) {
                row.removeCell(cell);
            }
        }
    }
}
