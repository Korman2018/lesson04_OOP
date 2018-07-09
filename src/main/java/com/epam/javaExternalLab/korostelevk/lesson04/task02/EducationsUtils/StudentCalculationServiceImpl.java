package com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.interfaces.StudentCalculationService;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.Student;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.StudentProgress;

public class StudentCalculationServiceImpl implements StudentCalculationService {
    @Override
    public double averageStudentScore(Student student) {
        double scoresSum = 0;
        int scoresCount = 0;

        for (StudentProgress progress : student.getStudentProgress()) {
            scoresSum += progress.getScore();
            scoresCount++;
        }
        return scoresCount == 0 ? 0 : scoresSum / scoresCount;
    }
}
