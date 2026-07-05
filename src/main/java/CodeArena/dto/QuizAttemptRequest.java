package CodeArena.dto;
import java.util.Map;
public class QuizAttemptRequest {
    private Long userId, quizId;
    private Map<Long, String> answers;
    public Long getUserId() { return userId; }
    public Long getQuizId() { return quizId; }
    public Map<Long, String> getAnswers() { return answers; }
    public void setUserId(Long v) { this.userId=v; }
    public void setQuizId(Long v) { this.quizId=v; }
    public void setAnswers(Map<Long, String> v) { this.answers=v; }
}
