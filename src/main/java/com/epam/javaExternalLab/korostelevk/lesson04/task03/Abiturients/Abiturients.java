package com.epam.javaExternalLab.korostelevk.lesson04.task03.Abiturients;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.Group.Group;

// можно было использовать Group т.к функионал не добавляется
public class Abiturients extends Group {

    public Abiturients(String groupName, int capacity) {
        super(groupName, capacity);
    }

    public Abiturients(String groupName) {
        super(groupName);
    }
}
