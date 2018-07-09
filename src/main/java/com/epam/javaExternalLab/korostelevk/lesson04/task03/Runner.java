package com.epam.javaExternalLab.korostelevk.lesson04.task03;


import com.epam.javaExternalLab.korostelevk.lesson04.task03.Demo.DemoService;
import com.epam.javaExternalLab.korostelevk.lesson04.task03.Demo.DemoServiceImpl;

public class Runner {
    public static void main(String[] args) {
        DemoService demoService = new DemoServiceImpl();
        demoService.abiturientsTests();
    }
}
