package com.epam.javaExternalLab.korostelevk.lesson04.task02.DemoService;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.DemoService.intefaces.DemoService;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.GroupCalculationServiceImpl;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.StudentCalculationServiceImpl;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.interfaces.GroupCalculationService;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.interfaces.StudentCalculationService;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Group.Group;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.Student;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.StudentProgress;

public class DemoServiceImpl implements DemoService {

    @Override
    public void groupTests() {
        System.out.println("Testing group");
        Student[] students = new Student[5];
        students[0] = new Student("Ivan", "Ivanovich", "Ivanov"
                , new StudentProgress[]{new StudentProgress("Mathematics", 5)
                , new StudentProgress("Physic", 5)
                , new StudentProgress("Chemistry", 5)
        });
        students[1] = new Student("Petr", "Petrovich", "Petrov"
                , new StudentProgress[]{new StudentProgress("Mathematics", 5)
                , new StudentProgress("Physic", 4)
                , new StudentProgress("Chemistry", 3)
        });
        students[2] = new Student("Sidor", "Sidorovich", "Sidorov"
                , new StudentProgress[]{new StudentProgress("Mathematics", 2)
                , new StudentProgress("Physic", 3)
                , new StudentProgress("Chemistry", 4)
        });
        students[3] = new Student("Vasily", "Ivanovich", "Pupkin"
                , new StudentProgress[]{new StudentProgress("Mathematics", 3)
                , new StudentProgress("Physic", 2)
                , new StudentProgress("Chemistry", 4)
        });
        students[4] = new Student("Andrey", "Andreevich", "Andreev"
                , new StudentProgress[]{new StudentProgress("Mathematics", 4)
                , new StudentProgress("Physic", 5)
                , new StudentProgress("Chemistry", 5)
        });

        Group group = new Group("10-A");

        System.out.println("\naddStudents");
        group.addStudents(students);
        printGroupData(group);

        System.out.println("\nadd student:" + students[0]);
        group.addStudent(students[0]);
        printGroupData(group);

        System.out.println("\nremove student:" + students[0]);
        group.removeStudent(students[0]);
        printGroupData(group);

        System.out.println("\nlooking for  student:" + students[0].getFullName());
        System.out.println("find student: " + group.findStudentByFullName(
                students[0].getFirstName(), students[0].getMiddleName(), students[0].getLastName()));

        System.out.println("\naverage group score " + averageGroupScoreTests(group));
        System.out.println("excellent scores students " + countExcellentScoresStudentsTests(group));
        System.out.println("bad scores students " + countBadScoresStudentsTests(group));

    }

    @Override
    public void studentTests() {
        System.out.println("\nstudent tests");
        Student testStudent = new Student("Vasily", "Ivanovich", "Pupkin"
                , new StudentProgress[]{new StudentProgress("Mathematics", 3)
                , new StudentProgress("Physic", 2)
                , new StudentProgress("Chemistry", 4)});
        StringBuilder sb = new StringBuilder();

        sb.append("average  score for student: ").append(testStudent).append("   ")
                .append(averageStudentScoreTests(testStudent));
        System.out.println(sb.toString());
    }

    private static double averageStudentScoreTests(Student student) {
        StudentCalculationService studentCalculationService = new StudentCalculationServiceImpl();
        return studentCalculationService.averageStudentScore(student);
    }

    private static double averageGroupScoreTests(Group group) {
        GroupCalculationService groupCalculationService = new GroupCalculationServiceImpl();
        return groupCalculationService.averageGroupScore(group);
    }

    private static int countExcellentScoresStudentsTests(Group group) {
        GroupCalculationService groupCalculationService = new GroupCalculationServiceImpl();
        return groupCalculationService.countExcellentScoresStudents(group);
    }

    private static int countBadScoresStudentsTests(Group group) {
        GroupCalculationService groupCalculationService = new GroupCalculationServiceImpl();
        return groupCalculationService.countBadScoresStudents(group);
    }

    private void printGroupData(Group group) {
        for (Student student : group.getStudents()) {
            System.out.println(student);
        }
    }
}
