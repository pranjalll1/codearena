package CodeArena.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "results")
public class Result {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "user_id") private User user;
    @ManyToOne @JoinColumn(name = "quiz_id") private Quiz quiz;
    private int score;
    private int totalQuestions;
    private LocalDateTime attemptedAt;
    public Long getId() { return id; }
    public User getUser() { return user; }
    public void setUser(User u) { this.user=u; }
    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz q) { this.quiz=q; }
    public int getScore() { return score; }
    public void setScore(int s) { this.score=s; }
    public int getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(int t) { this.totalQuestions=t; }
    public LocalDateTime getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(LocalDateTime t) { this.attemptedAt=t; }
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private Result r = new Result();
        public Builder user(User v) { r.user=v; return this; }
        public Builder quiz(Quiz v) { r.quiz=v; return this; }
        public Builder score(int v) { r.score=v; return this; }
        public Builder totalQuestions(int v) { r.totalQuestions=v; return this; }
        public Builder attemptedAt(LocalDateTime v) { r.attemptedAt=v; return this; }
        public Result build() { return r; }
    }
}
