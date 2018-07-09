package com.epam.javaExternalLab.korostelevk.lesson04.task02.Group;

import com.epam.javaExternalLab.korostelevk.lesson04.task02.Student.Student;

public class Group {

    private String groupName;

    private Student[] students;

    private int size;

    public Group(String groupName, int capacity) {
        this.groupName = groupName;
        students = new Student[capacity];
    }

    public Group(String groupName) {
        this(groupName, 30);
    }

    public boolean addStudent(Student student) {
        if (size < students.length) {
            students[size] = student;
            size++;
            return true;
        }
        return false;
    }

    public boolean addStudents(Student[] students) {
        int studentsLength = students.length;
        if (studentsLength < this.students.length - size) {
            System.arraycopy(students, 0, this.students, size, studentsLength);
            size += studentsLength;
            return true;
        }
        return false;
    }

    /**
     * remove first find of student
     *
     * @param student student for remove
     * @return removed student
     */
    public Student removeStudent(Student student) {
        for (int i = 0; i < size; i++) {
            if (students[i].equals(student)) {
                Student tempStudent = students[i];
                size--;
                students[i] = students[size];
                return tempStudent;
            }
        }
        return null;
    }


    /**
     * find first
     * @param firstName
     * @param middleName
     * @param lastName
     * @return
     */
    public Student findStudentByFullName(String firstName, String middleName, String lastName) {
        Student tempStudent = new Student(firstName, middleName, lastName);
        for (int i = 0; i < size; i++) {

            if (students[i].equals(tempStudent)) {
                return students[i];
            }
        }
        return null;
    }

    public Student[] getStudents() {
        Student[] studentsCopy = new Student[size];
        System.arraycopy(students, 0, studentsCopy, 0, size);
        return studentsCopy;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getSize() {
        return size;
    }
}
