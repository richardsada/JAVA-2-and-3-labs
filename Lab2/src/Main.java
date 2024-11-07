import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем преподавателей
        Teacher teacher1 = new Teacher("Alice", "Math");
        Teacher teacher2 = new Teacher("Bob", "Physics");
        Teacher teacher3 = new Teacher("Carol", "Chemistry");

        // Создаем студентов
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20, 'M'));
        students.add(new Student("Anna", 19, 'F'));
        students.add(new Student("Mike", 21, 'M'));
        students.add(new Student("Emma", 18, 'F'));
        students.add(new Student("Alex", 22, 'M'));

        // Назначаем предметы студентам
        for (Student student : students) {
            student.addSubject(new Subject("Math"));
            student.addSubject(new Subject("Physics"));
            student.addSubject(new Subject("Chemistry"));
        }

        // Создаем родителей и добавляем детей
        List<Parent> parents = new ArrayList<>();
        parents.add(new Parent("Mr. Smith"));
        parents.add(new Parent("Mrs. Johnson"));
        parents.add(new Parent("Mrs. Weak"));
        parents.add(new Parent("Mrs. Stethem"));
        parents.add(new Parent("Mrs. Bolt"));

       for (int i = 0; i < 5; i++){
           parents.get(i).addChild(students.get(i));
       }

        for (Student student : students) {
            teacher1.giveGrades(student);
            teacher2.giveGrades(student);
            teacher3.giveGrades(student);
        }


        for (Student student : students) {
            student.calculateAverageGrade();
        }
        for (Parent parent : parents){
            parent.evaluateAndRewardChildren();}






        // Выводим результаты
        System.out.println("\n");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\n");
        for (Parent parent : parents){
            System.out.println(parent);
        }
        System.out.println("\n");
        System.out.println(teacher1);
        System.out.println(teacher2);
        System.out.println(teacher3);
    }
}
