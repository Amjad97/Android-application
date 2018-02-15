package com.amjadaboabdou.questions;

/**
 * Created by Amjad on 03/09/17.
 */

public class info {
    String Type;
    String Type_question;
    String level;
    int score;

    public info(String Type, String Type_question, String level, int score){
        this.Type=Type;
        this.Type_question=Type_question;
        this.level=level;
        this.score=score;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getType_question() {
        return Type_question;
    }

    public void setType_question(String type_question) {
        Type_question = type_question;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }
}
