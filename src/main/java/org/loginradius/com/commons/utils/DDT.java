package org.loginradius.com.commons.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.opencsv.CSVReader;

/**
 * @date 29/12/208
 * @author vidya bhushan
 */
public class DDT {
    private static CSVReader csvReader;
    private static final String COMMENT_PREFIX = "--";

    private static Logger logger = Logger.getRootLogger();

    /**
     * Reads a specific CSV file and return just the lines that meets with the filter
     * @param csvPath Path of the CSV file that you need to read
     * @return 
     */
    public static Object[][] DDTReader(String csvPath) {
        try {
            FileReader fr = new FileReader(csvPath);
            csvReader = new CSVReader(fr);
            List<String[]> complete = csvReader.readAll();
            complete.remove(0);

            // Ignore commented out rows from csv
            Iterator<String[]> iter = complete.iterator();
            while (iter.hasNext()) {
                String[] row = iter.next();
                if (row[0].startsWith(COMMENT_PREFIX)) {
                    iter.remove();
                }
            }

            Object[][] arrayResp = new Object[complete.size()][];
            for(int i = 0; i < complete.size(); i++){
                arrayResp[i] = complete.get(i);
            }
            return arrayResp;
        } catch (FileNotFoundException ex) {
            logger.error(ex);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return new Object[][]{};
    }
    
    
    public static Object[][] DDTReaders(String csvPath) {
        try {
            FileReader fr = new FileReader(csvPath);
            csvReader = new CSVReader(fr);
            List<String[]> complete = csvReader.readAll();
            complete.remove(0);

            // Ignore commented out rows from csv
            Iterator<String[]> iter = complete.iterator();
            while (iter.hasNext()) {
                String[] row = iter.next();
                if (row[0].startsWith(COMMENT_PREFIX)) {
                    iter.remove();
                }
            }

            Object[][] arrayResp = new Object[complete.size()][];
            for(int i = 0; i < complete.size(); i++){
                arrayResp[i] = complete.get(i);
                if(arrayResp[i]==arrayResp[0]){  
                	
	            }
            }
            return arrayResp;
        } catch (FileNotFoundException ex) {
            logger.error(ex);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return new Object[][]{};
    }


}
