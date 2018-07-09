package com.epam.javaExternalLab.korostelevk.lesson04.task03.Services;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.EducationsUtils.interfaces.GroupCalculationService;
import com.epam.javaExternalLab.korostelevk.lesson04.task03.Abiturients.Abiturients;

public interface AbiturientCalcService extends GroupCalculationService {

    Abiturients acceptedAbiturients(Abiturients abiturients, int numberOfRequiredAbiturients);
}
