package CodeArena.dto;
public class QuestionRequest {
    private String questionText, optionA, optionB, optionC, optionD, correctAnswer;
    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setQuestionText(String v) { this.questionText=v; }
    public void setOptionA(String v) { this.optionA=v; }
    public void setOptionB(String v) { this.optionB=v; }
    public void setOptionC(String v) { this.optionC=v; }
    public void setOptionD(String v) { this.optionD=v; }
    public void setCorrectAnswer(String v) { this.correctAnswer=v; }
}
