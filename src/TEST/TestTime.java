package TEST;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestTime {
	public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println("Ngày hiện tại (định dạng): " + formattedDate);
	}
}
