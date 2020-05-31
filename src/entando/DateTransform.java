package entando;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DateTransform {

    public static List<String> changeDateFormat(List<String> dates) {
        List<String> listDates = new ArrayList<>();

        for(String date : dates) {
            LocalDate LocalDate = null;
            try{
                LocalDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            }catch(DateTimeParseException ex){
                try{
                    LocalDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                }catch(DateTimeParseException ex2) {
                    try{
                        LocalDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                    }catch(DateTimeParseException ex3){}
                }
            }

            if(Objects.nonNull(LocalDate))
                listDates.add(LocalDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        }

        return listDates;
    }


    public static void main(String[] args) {
        List<String> dates = changeDateFormat(Arrays.asList("2010/03/30", "15/12/2016", "11-15-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }
}