package com.epam.javaExternalLab.korostelevk.lesson04.task02;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.DemoService.intefaces.DemoService;
import com.epam.javaExternalLab.korostelevk.lesson04.task02.DemoService.DemoServiceImpl;

public class Runner {
    public static void main(String[] args) {
        DemoService demoService = new DemoServiceImpl();
        demoService.groupTests();
        demoService.studentTests();
    }
}
