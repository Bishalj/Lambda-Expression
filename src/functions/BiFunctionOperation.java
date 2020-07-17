package functions;

import predicate.PredicateStudentExample;
import predicate.Student;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BiFunctionOperation {

    final static BiFunction<List<Student>, Predicate<Student>, Map<String, Integer>> biFunction = (students, studentPredicate) ->
        students
                .parallelStream()
                .filter(student -> studentPredicate.test(student))
                .collect(Collectors.toMap(Student::getName, Student::getGrade));

    public static void main(String[] args) {
        List<Student> students = PredicateStudentExample.getStudentList();
        Predicate<Student> studentPredicate = PredicateStudentExample.studentPredicate;
        System.out.println(biFunction.apply(students, studentPredicate));
    }
}
