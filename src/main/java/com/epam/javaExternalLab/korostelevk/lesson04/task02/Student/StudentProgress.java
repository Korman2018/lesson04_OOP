package com.epam.javaExternalLab.korostelevk.lesson04.task02.Student;


public class StudentProgress {
    private double score;

    private String subject;

    public StudentProgress(String subject, double scores) {
        this.score = scores;
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(subject);
        sb.append("-").append(score);
        return sb.toString();
    }
}
