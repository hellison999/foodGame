package dev.pereira.wellison;

public class Question {
    private String name;
    private QuestionType type;
    private Question lastQuestion;
    private Question nextYesQuestion;
    private Question nextNoQuestion;

    public Question(String name, QuestionType type) {
        this.name = name;
        this.type = type;
        this.lastQuestion = null;
        this.nextYesQuestion = null;
        this.nextNoQuestion = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Question getLastQuestion() {
        return lastQuestion;
    }

    public void setLastQuestion(Question lastQuestion) {
        this.lastQuestion = lastQuestion;
    }

    public Question getNextYesQuestion() {
        return nextYesQuestion;
    }

    public void setNextYesQuestion(Question nextYesQuestion) {
        this.nextYesQuestion = nextYesQuestion;
    }

    public Question getNextNoQuestion() {
        return nextNoQuestion;
    }

    public void setNextNoQuestion(Question nextNoQuestion) {
        this.nextNoQuestion = nextNoQuestion;
    }

    public String getQuestionString() {
        switch (getType()){
            case CHARACTERISTIC:

            case FOOD:
                return "O prato que você pensou é "+getName()+"?";
            default:
                return null;
        }
    }
}
