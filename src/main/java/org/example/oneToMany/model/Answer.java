package org.example.oneToMany.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="answer")
public class Answer {
    public Answer() {
    }

    public Answer(String answer, boolean correctFlag) {
        this.answer = answer;
        this.correctFlag = correctFlag;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", correctFlag=" + correctFlag +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrectFlag() {
        return correctFlag;
    }

    public void setCorrectFlag(boolean correctFlag) {
        this.correctFlag = correctFlag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String answer;
    private boolean correctFlag;




}
