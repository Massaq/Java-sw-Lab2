package ua.kpi.comsys.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z0-9]+");

    public Map<String, Integer> countWords(List<String> textLines) {
        if (textLines == null) {
            throw new IllegalArgumentException("textLines cannot be null");
        }

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String line : textLines) {
            if (line == null || line.isEmpty()) {
                continue;
            }
            Matcher matcher = WORD_PATTERN.matcher(line);
            while (matcher.find()) {
                String word = matcher.group().toLowerCase(Locale.ROOT);
                if (!word.isEmpty()) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordCounts;
    }

    public Set<String> getUniqueWords(List<String> textLines) {
        if (textLines == null) {
            throw new IllegalArgumentException("textLines cannot be null");
        }

        return new HashSet<>(countWords(textLines).keySet());
    }
}
