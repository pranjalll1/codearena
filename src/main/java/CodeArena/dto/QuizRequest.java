package CodeArena.dto;
import java.util.List;
public class QuizRequest {
    private String title, description;
    private int timeLimit;
    private List<QuestionRequest> questions;
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getTimeLimit() { return timeLimit; }
    public List<QuestionRequest> getQuestions() { return questions; }
    public void setTitle(String v) { this.title=v; }
    public void setDescription(String v) { this.description=v; }
    public void setTimeLimit(int v) { this.timeLimit=v; }
    public void setQuestions(List<QuestionRequest> v) { this.questions=v; }
}
