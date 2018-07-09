package com.epam.javaExternalLab.korostelevk.lesson04.task02.Student;

// не учитываем вариант с полными тезками в целях упрощения
public class Student {

    private String firstName;

    private String middleName;

    private String lastName;

    private StudentProgress[] progress;

    public Student(String firstName, String middleName, String lastName, StudentProgress[] progress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.progress = progress;
    }

    public Student(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentProgress[] getStudentProgress() {
        int progressLength = progress.length;
        StudentProgress[] progressCopy = new StudentProgress[progressLength];
        System.arraycopy(progress, 0, progressCopy, 0, progressLength);
        return progressCopy;
    }

    public void setStudentProgress(StudentProgress[] studentProgress) {
        this.progress = studentProgress;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder(firstName);
        sb.append(" ").append(middleName).append(" ").append(lastName);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return firstName.equals(student.firstName)
                    && middleName.equals(student.middleName)
                    && lastName.equals(student.lastName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder student = new StringBuilder(firstName + " " + middleName + " " + lastName);
        student.append("(");
        for (StudentProgress studentProgress : progress) {
            student.append(studentProgress).append(",");
        }
        student.replace(student.length() - 1, student.length(), ")");
        return student.toString();
    }
}
