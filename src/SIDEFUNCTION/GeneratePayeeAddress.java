package SIDEFUNCTION;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class GeneratePayeeAddress {
    private String fullName;

    public GeneratePayeeAddress(String fullName) {
        this.fullName = fullName;
    }

    public String createPayeeAddress(ArrayList<String> listName) {
        Random random = new Random();
        // Loại bỏ dấu tiếng việt
        String normalizeFullName = removeAccents(this.fullName);

        // Tách tên thành các từ
        String[] nameParts = normalizeFullName.split("\\s+");

        // Tạo username từ các chữ cái đầu tiên của từng phần trong tên
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < nameParts.length - 1; i++) {
            username.append(Character.toLowerCase(nameParts[i].charAt(0)));
        }

        // Thêm phần tên cuối cùng vào username
        username.append(nameParts[nameParts.length - 1].toLowerCase());

        // Tạo 3 số ngẫu nhiên và kiểm tra trùng lặp
        String newUsername = username.toString() + generateRandomNumber(random);
        while (isDuplicatePayeename(newUsername, listName)) {
            newUsername = username.toString() + generateRandomNumber(random);
        }

        return newUsername;
    }

    private boolean isDuplicatePayeename(String username, ArrayList<String> listName) {
        return listName.contains(username);
    }

    private String generateRandomNumber(Random random) {
        int randomNumber = random.nextInt(900) + 100; // Tạo số từ 100 đến 999
        return String.valueOf(randomNumber);
    }

    private String removeAccents(String fullName) {
        String normalized = Normalizer.normalize(fullName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
    }
}
