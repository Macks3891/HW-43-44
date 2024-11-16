import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Класс для сравнения производительности добавления и выборки элементов в ArrayList и LinkedList.
 */
public class ListPerformanceComparison {

    private static final int NUM_ELEMENTS = 1000000;
    private static final int NUM_SELECTIONS = 100000;

    /**
     * Метод для добавления 1000000 элементов в ArrayList и LinkedList.
     */
    public static void addElements() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Добавление элементов в ArrayList
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время добавления " + NUM_ELEMENTS + " элементов в ArrayList: " + (endTime - startTime) + " мс");

        // Добавление элементов в LinkedList
        startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления " + NUM_ELEMENTS + " элементов в LinkedList: " + (endTime - startTime) + " мс");
    }

    /**
     * Метод для выборки 100000 элементов наугад из заполненного списка.
     *
     * @param list Список, из которого будут выбираться элементы.
     */
    public static void selectRandomElements(List<Integer> list) {
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_SELECTIONS; i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выборки " + NUM_SELECTIONS + " элементов из " + list.getClass().getSimpleName() + ": " + (endTime - startTime) + " мс");
    }

    /**
     * Основной метод для запуска тестов.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        addElements();


        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }


        selectRandomElements(arrayList);
        selectRandomElements(linkedList);


        System.out.println("\nСравнение результатов:");
        System.out.println("ArrayList быстрее при добавлении элементов в конец.");
        System.out.println("LinkedList медленнее при добавлении элементов в конец, но может быть быстрее при вставке элементов в середину.");
        System.out.println("ArrayList быстрее при выборке элементов по индексу.");
        System.out.println("LinkedList медленнее при выборке элементов по индексу, так как требуется перебор элементов.");
    }
}