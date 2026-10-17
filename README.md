# Лабораторна робота №2: Збірка проєкту за допомогою Gradle та робота з Java Collections Framework

## Виконавець
* **Студент:** Гнітій Максим Олександрович
* **Група:** ІА-42
* **Номер у списку групи:** 2

## Розрахунок варіанта
Варіант визначається за формулою:
$$V = N \bmod 3$$
де $N = 2$ — порядковий номер студента у списку групи.

$$V = 2 \bmod 3 = 2$$

**Варіант 2:** Частотний аналізатор тексту (`WordCounter`).

## Опис проєкту
Проєкт реалізує частотний аналізатор тексту `WordCounter` у пакеті `ua.kpi.comsys.collections` з використанням стандартних колекцій `java.util.*` (`Map`, `HashMap`, `Set`, `HashSet`, `List`) та системи збірки **Gradle** із застосуванням **Version Catalogs** (`gradle/libs.versions.toml`).

### Основна функціональність `WordCounter`:
* Розбиває вхідні рядки на слова (послідовності буквено-цифрових символів латиниці `[a-zA-Z0-9]+`).
* Приводить усі слова до нижнього регістру та ігнорує порожні рядки/слова.
* `countWords(List<String> textLines)` — повертає `Map<String, Integer>` із підрахунком частоти кожного слова (кидає `IllegalArgumentException`, якщо `textLines == null`).
* `getUniqueWords(List<String> textLines)` — повертає `Set<String>` усіх унікальних слів (кидає `IllegalArgumentException`, якщо `textLines == null`).

## Інструкція із запуску та тестування

### Вимоги
* **JDK:** 21 або новіша версія
* **Gradle:** 8.5+ (або використання Gradle Wrapper `./gradlew`)

### Збірка проєкту
```bash
./gradlew build
```

### Запуск юніт-тестів (JUnit 5)
```bash
./gradlew test
```
