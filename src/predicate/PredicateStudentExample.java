package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    public static Predicate<Student> studentPredicate = s -> s.getMarks() > 70;
    private static Predicate<Student> gradePredicate = s -> s.getGrade() >= 2;

    public static void filterMarks(List<Student> students){
        students
                .forEach(student -> {
                    if( studentPredicate.and(gradePredicate).test(student))
                        System.out.println("Passed Student: " + student.getName());
                });
    }

    public static void main(String[] args) {
        List<Student> students = getStudentList();
        PredicateStudentExample.filterMarks(students);
    }

    public static List<Student> getStudentList() {
        Student student1 = new Student(90, "Bishal",3);
        Student student2 = new Student(80, "Jaiwal",1);
        Student student3 = new Student(70, "Sagar",3);
        Student student4 = new Student(60, "Akash",2);
        Student student5 = new Student(90, "Mom",1);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        return students;
    }

}
