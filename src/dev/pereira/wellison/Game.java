package dev.pereira.wellison;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    /**
     *
     */
    private Question startQuestion;

    /**
     * Gets the game running
     */
    public void startGame(){
        List<Integer> list = new ArrayList<Integer>();
        Question question = getStartQuestion();
        boolean i = true;
        while (i){
            int answer = JOptionPane.showConfirmDialog(null,question.getQuestionString(),"Confirm",JOptionPane.YES_NO_OPTION);
            if (answer==0){
                if (question.getType()==QuestionType.FOOD){
                    //If the answer is correct, exit the game
                    showCorrectAnswer();
                    i=false;
                }else{
                    question = question.getNextYesQuestion();
                }
            }
            else if (answer==1 && question.getNextNoQuestion()!=null){
                question = question.getNextNoQuestion();
            }
            else{
                //If there's a need to create a new food and a new characteristic, creates it and exists the game
                String plate = JOptionPane.showInputDialog("Qual prato você pensou?");
                Question plateQuestion = new Question(plate,QuestionType.FOOD);
                String characteristic = JOptionPane.showInputDialog(plate+" é ____________ que "+question.getName()+" não é");
                Question characteristicQuestion = new Question(characteristic,QuestionType.CHARACTERISTIC);
                shiftQuestionNodes(question, plateQuestion, characteristicQuestion);
                i = false;
            }
        }


    }


    /**
     * @param question - The original question that was answered no
     * @param plateQuestion -  The new food that was created
     * @param characteristicQuestion - the new characteristic that was created
     */
    private void shiftQuestionNodes(Question question, Question plateQuestion, Question characteristicQuestion) {
        Question lastQuestion = question.getLastQuestion();
        lastQuestion.setNextYesQuestion(characteristicQuestion);
        characteristicQuestion.setLastQuestion(lastQuestion);

        question.setLastQuestion(characteristicQuestion);

        characteristicQuestion.setNextNoQuestion(question);
        characteristicQuestion.setNextYesQuestion(plateQuestion);
        plateQuestion.setLastQuestion(characteristicQuestion);
    }

    private void showCorrectAnswer() {
        JOptionPane.showMessageDialog(null, "Acertei de Novo!");
    }

    /**
     * It starts de game nodes with the default values
     */
    public void setupGame() {
        startQuestion = new Question("Massa", QuestionType.CHARACTERISTIC);
        startQuestion.setLastQuestion(null);
        Question chocolate = new Question("Bolo de Chocolate",QuestionType.FOOD);
        chocolate.setLastQuestion(startQuestion);
        Question lazagna = new Question("Lasanha",QuestionType.FOOD);
        lazagna.setLastQuestion(startQuestion);
        startQuestion.setNextNoQuestion(chocolate);
        startQuestion.setNextYesQuestion(lazagna);

    }

    public Question getStartQuestion() {
        return startQuestion;
    }

    public void setStartQuestion(Question startQuestion) {
        this.startQuestion = startQuestion;
    }
}
