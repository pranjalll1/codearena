package CodeArena.model;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int timeLimit;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title=t; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description=d; }
    public int getTimeLimit() { return timeLimit; }
    public void setTimeLimit(int t) { this.timeLimit=t; }
    public List<Question> getQuestions() { return questions; }
    public void setQuestions(List<Question> q) { this.questions=q; }
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private Quiz q = new Quiz();
        public Builder title(String v) { q.title=v; return this; }
        public Builder description(String v) { q.description=v; return this; }
        public Builder timeLimit(int v) { q.timeLimit=v; return this; }
        public Quiz build() { return q; }
    }
}
