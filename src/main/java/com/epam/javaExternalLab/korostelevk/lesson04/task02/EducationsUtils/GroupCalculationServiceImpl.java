package com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.interfaces.GroupCalculationService;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Group.Group;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.Student;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.StudentProgress;

public class GroupCalculationServiceImpl implements GroupCalculationService {
    @Override
    public double averageGroupScore(Group group) {
        double scoresSum = 0;
        int scoresCount = 0;

        for (Student student : group.getStudents()) {
            for (StudentProgress progress : student.getStudentProgress()) {
                scoresSum += progress.getScore();
                scoresCount++;
            }
        }
        return scoresCount == 0 ? 0 : scoresSum / scoresCount;
    }

    @Override
    public int countExcellentScoresStudents(Group group) {
        boolean isExcellent = true;
        int countStudents = 0;

        for (Student student : group.getStudents()) {
            for (StudentProgress progress : student.getStudentProgress()) {
                if (progress.getScore() < 5) {
                    isExcellent = false;
                    break;
                }
            }

            if (isExcellent) {
                countStudents++;
            }
        }
        return countStudents;
    }

    @Override
    public int countBadScoresStudents(Group group) {
        int countStudents = 0;

        for (Student student : group.getStudents()) {
            for (StudentProgress progress : student.getStudentProgress()) {
                if (progress.getScore() <= 2) {
                    countStudents++;
                    break;
                }
            }
        }
        return countStudents;
    }
}
