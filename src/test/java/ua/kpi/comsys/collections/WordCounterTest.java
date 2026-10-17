package ua.kpi.comsys.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    private WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        wordCounter = new WordCounter();
    }

    @Test
    @DisplayName("countWords() counts alphanumeric Latin words in lowercase correctly")
    void countWordsSuccess() {
        List<String> lines = List.of(
                "Hello, World! Hello Java 21.",
                "java is great; WORLD_123 and 21!"
        );

        Map<String, Integer> result = wordCounter.countWords(lines);

        assertEquals(8, result.size());
        assertEquals(2, result.get("hello"));
        assertEquals(2, result.get("world"));
        assertEquals(2, result.get("java"));
        assertEquals(2, result.get("21"));
        assertEquals(1, result.get("is"));
        assertEquals(1, result.get("great"));
        assertEquals(1, result.get("123"));
        assertEquals(1, result.get("and"));
    }

    @Test
    @DisplayName("countWords() splits by non-Latin/non-alphanumeric characters including underscores and punctuation")
    void countWordsSeparatorsAndNonLatin() {
        List<String> lines = List.of(
                "user_name@domain.com, Привіт-test123...   ",
                "---!!!???"
        );

        Map<String, Integer> result = wordCounter.countWords(lines);

        Map<String, Integer> expected = Map.of(
                "user", 1,
                "name", 1,
                "domain", 1,
                "com", 1,
                "test123", 1
        );

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("countWords() returns empty Map for empty list or blank lines")
    void countWordsEmptyInput() {
        assertTrue(wordCounter.countWords(Collections.emptyList()).isEmpty());
        assertTrue(wordCounter.countWords(List.of("", "   ", " !@# $%^ ")).isEmpty());
    }

    @Test
    @DisplayName("countWords() safely ignores null elements inside the list")
    void countWordsWithNullLineElement() {
        List<String> lines = Arrays.asList("First line", null, "first");
        Map<String, Integer> result = wordCounter.countWords(lines);

        assertEquals(Map.of("first", 2, "line", 1), result);
    }

    @Test
    @DisplayName("countWords(null) throws IllegalArgumentException")
    void countWordsNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> wordCounter.countWords(null));
    }

    @Test
    @DisplayName("getUniqueWords() returns Set of unique lowercase words")
    void getUniqueWordsSuccess() {
        List<String> lines = List.of(
                "Apple banana APPLE",
                "Banana, cherry10! apple."
        );

        Set<String> result = wordCounter.getUniqueWords(lines);

        assertEquals(Set.of("apple", "banana", "cherry10"), result);
    }

    @Test
    @DisplayName("getUniqueWords() returns empty Set for empty list or lines without Latin alphanumeric characters")
    void getUniqueWordsEmptyInput() {
        assertTrue(wordCounter.getUniqueWords(Collections.emptyList()).isEmpty());
        assertTrue(wordCounter.getUniqueWords(List.of("   ", "---", "Кирилиця")).isEmpty());
    }

    @Test
    @DisplayName("getUniqueWords(null) throws IllegalArgumentException")
    void getUniqueWordsNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> wordCounter.getUniqueWords(null));
    }
}
