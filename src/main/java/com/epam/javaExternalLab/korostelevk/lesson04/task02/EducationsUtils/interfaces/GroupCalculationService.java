package com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.interfaces;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.Group.Group;

public interface GroupCalculationService {
    double averageGroupScore(Group group);

    int countExcellentScoresStudents(Group group);

    int countBadScoresStudents(Group group);
}
