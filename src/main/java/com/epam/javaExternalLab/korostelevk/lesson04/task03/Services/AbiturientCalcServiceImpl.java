package com.epam.javaExternalLab.korostelevk.lesson04.task03.Services;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.GroupCalculationServiceImpl;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.StudentCalculationServiceImpl;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.interfaces.StudentCalculationService;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.Student;
import com.epam.javaExternalLab.korostelevk.lesson04.task03.Abiturients.Abiturients;

import java.util.Arrays;

public class AbiturientCalcServiceImpl extends GroupCalculationServiceImpl implements AbiturientCalcService {

    private StudentCalculationService studentCalculationService;

    public AbiturientCalcServiceImpl() {
        studentCalculationService = new StudentCalculationServiceImpl();
    }

    @Override
    public Abiturients acceptedAbiturients(Abiturients abiturients, int numberOfRequiredAbiturients) {
        Student[] requiredAbiturients = abiturients.getStudents();

        Arrays.sort(requiredAbiturients, (o1, o2) -> {
            // reversed comparator
            if (o1 == null) {
                return 1;
            }

            if (o2 == null) {
                return -1;
            }
            double studentOneScores = studentCalculationService.averageStudentScore(o1);
            double studentTwoScores = studentCalculationService.averageStudentScore(o2);
            if (studentOneScores == studentTwoScores) {
                return 0;
            }

            return studentOneScores < studentTwoScores ? 1 : -1;
        });

        if (numberOfRequiredAbiturients > requiredAbiturients.length) {
            numberOfRequiredAbiturients = requiredAbiturients.length;
        }
        Abiturients newAbiturients = new Abiturients(abiturients.getGroupName());
        newAbiturients.addStudents(Arrays.copyOf(requiredAbiturients, numberOfRequiredAbiturients));
        return newAbiturients;
    }
}
