package CodeArena.model;
import jakarta.persistence.*;
@Entity
@Table(name = "questions")
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private String optionA, optionB, optionC, optionD;
    private String correctAnswer;
    @ManyToOne @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    public Long getId() { return id; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String v) { this.questionText=v; }
    public String getOptionA() { return optionA; }
    public void setOptionA(String v) { this.optionA=v; }
    public String getOptionB() { return optionB; }
    public void setOptionB(String v) { this.optionB=v; }
    public String getOptionC() { return optionC; }
    public void setOptionC(String v) { this.optionC=v; }
    public String getOptionD() { return optionD; }
    public void setOptionD(String v) { this.optionD=v; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String v) { this.correctAnswer=v; }
    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz v) { this.quiz=v; }
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private Question q = new Question();
        public Builder questionText(String v) { q.questionText=v; return this; }
        public Builder optionA(String v) { q.optionA=v; return this; }
        public Builder optionB(String v) { q.optionB=v; return this; }
        public Builder optionC(String v) { q.optionC=v; return this; }
        public Builder optionD(String v) { q.optionD=v; return this; }
        public Builder correctAnswer(String v) { q.correctAnswer=v; return this; }
        public Builder quiz(Quiz v) { q.quiz=v; return this; }
        public Question build() { return q; }
    }
}
