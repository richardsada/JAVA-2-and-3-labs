import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static Random random = new Random();
    Randomize randomize = new Randomize();

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000};//};
        // Эксперименты с ArrayList
        for (int size : sizes) {

            runExperiment(new ArrayList<>(), size, "ArrayListLog_" + size + ".txt");
        }

        // Эксперименты с LinkedList
        for (int size : sizes) {
            runExperiment(new LinkedList<>(), size, "LinkedListLog_" + size + ".txt");
        }
    }

    private static void runExperiment(List<Student> list, int size, String logFilename) {
        Randomize randomize = new Randomize();
        Logger logger = new Logger();
        logger.log("Start program: " + LocalDateTime.now());

        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(new Student(randomize.randname(), randomize.randage(), randomize.randsex()));
            logger.log("add, ID = " + i + ", " + (System.nanoTime() - startTime));
        }
        long addTotalTime = System.nanoTime() - startTime;
        logger.log("addTotalCount = " + size);
        logger.log("addTotalTime = " + addTotalTime);

        // Удаление 10% элементов
        int removeCount = size / 10;
        startTime = System.nanoTime();
        for (int i = 0; i < removeCount; i++) {
            int index = random.nextInt(list.size());
            list.remove(index);
            logger.log("remove, ID = " + index + ", " + (System.nanoTime() - startTime));
        }
        long removeTotalTime = System.nanoTime() - startTime;
        logger.log("removeTotalCount = " + removeCount);
        logger.log("removeTotalTime = " + removeTotalTime);

        logger.log("Finish program: " + LocalDateTime.now() + "\n\n");
        logger.saveLog(logFilename);
    }


}