package com.epam.javaExternalLab.korostelevk.lesson04.task03.Demo;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.Student;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.StudentProgress;
import com.epam.javaExternalLab.korostelevk.lesson04.task03.Services.AbiturientCalcServiceImpl;
import com.epam.javaExternalLab.korostelevk.lesson04.task03.Abiturients.Abiturients;

public class DemoServiceImpl implements DemoService {

    public void abiturientsTests() {
        System.out.println("abiturients tests");
        Abiturients abiturients = new Abiturients("Test Group");

        abiturients.addStudent(new Student("Vasily", "Ivanovich", "Pupkin"
                , new StudentProgress[]{new StudentProgress("Mathematics", 3)
                , new StudentProgress("Physic", 2)
                , new StudentProgress("Chemistry", 4)
        }));

        abiturients.addStudent(new Student("Ivan", "Ivanovich", "Ivanov"
                , new StudentProgress[]{new StudentProgress("Mathematics", 5)
                , new StudentProgress("Physic", 5)
                , new StudentProgress("Chemistry", 5)
        }));

        abiturients.addStudent(new Student("Petr", "Petrovich", "Petrov"
                , new StudentProgress[]{new StudentProgress("Mathematics", 5)
                , new StudentProgress("Physic", 4)
                , new StudentProgress("Chemistry", 3)
        }));

        abiturients.addStudent(new Student("Sidor", "Sidorovich", "Sidorov"
                , new StudentProgress[]{new StudentProgress("Mathematics", 2)
                , new StudentProgress("Physic", 3)
                , new StudentProgress("Chemistry", 4)
        }));

        System.out.println("\nAll abiturients");
        printAbirurients(abiturients);

        int numberOfAbiturients = 2;
        System.out.println("\nRequired abiturients(number of abiturients " + numberOfAbiturients + ")");
        printAbirurients(acceptedAbiturientsTest(abiturients, numberOfAbiturients));
    }

    private Abiturients acceptedAbiturientsTest(Abiturients abiturients, int numberOfAbiturients) {
        AbiturientCalcServiceImpl abiturientCalcService = new AbiturientCalcServiceImpl();
        return abiturientCalcService.acceptedAbiturients(abiturients, numberOfAbiturients);
    }

    private void printAbirurients(Abiturients abiturients) {
        for (Student student : abiturients.getStudents()) {
            System.out.println(student);
        }
    }
}
