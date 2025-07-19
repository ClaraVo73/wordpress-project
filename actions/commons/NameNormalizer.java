package commons;

import java.util.HashMap;
import java.util.Map;

public class NameNormalizer {

    private static final Map<String, String> COMMON_NAME_MAP = new HashMap<>();
    static {
        COMMON_NAME_MAP.put("van", "Văn");
        COMMON_NAME_MAP.put("thi", "Thị");
        COMMON_NAME_MAP.put("huu", "Hữu");
    }

    public static String normalize(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        String cleaned = input.replaceAll("[^\\p{L}\\p{M}]", " ");
        cleaned = cleaned.trim().replaceAll("\\s{2,}", " ");

        StringBuilder result = new StringBuilder();
        for (String word : cleaned.split(" ")) {
            if (word.isEmpty()) continue;
            String lowerWord = word.toLowerCase();

            if (COMMON_NAME_MAP.containsKey(lowerWord)) {
                result.append(COMMON_NAME_MAP.get(lowerWord)).append(" ");
            } else {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}