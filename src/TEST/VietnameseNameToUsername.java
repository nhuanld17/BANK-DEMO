package TEST;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;

public class VietnameseNameToUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            // Nhập tên tiếng Việt từ người dùng
            System.out.print("Nhập tên tiếng Việt: ");
            String fullName = scanner.nextLine().trim();

            // Loại bỏ dấu tiếng Việt
            String normalizedFullName = removeVietnameseAccents(fullName);
            
            System.out.println("Tên loại bỏ dấu tiếng việt: "+normalizedFullName);

            // Tách tên thành các từ
            String[] nameParts = normalizedFullName.split("\\s+");

            // Tạo username từ các chữ cái đầu tiên của từng phần trong tên
            StringBuilder username = new StringBuilder();
            for (int i = 0; i < nameParts.length - 1; i++) {
                username.append(Character.toLowerCase(nameParts[i].charAt(0)));
            }

            // Thêm phần tên cuối cùng vào username
            username.append(nameParts[nameParts.length - 1].toLowerCase());

            // Tạo 3 số ngẫu nhiên
            int randomNumber = random.nextInt(900) + 100; // Tạo số từ 100 đến 999

            // Thêm số ngẫu nhiên vào cuối username
            username.append(randomNumber);

            // In kết quả
            System.out.println("Tên đăng nhập: " + username.toString());
		}
    }

    // Phương thức để loại bỏ dấu tiếng Việt
    private static String removeVietnameseAccents(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
    }
}

