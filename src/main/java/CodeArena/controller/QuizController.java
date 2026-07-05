package CodeArena.controller;
import CodeArena.dto.QuizAttemptRequest;
import CodeArena.dto.QuizRequest;
import CodeArena.model.Quiz;
import CodeArena.model.Result;
import CodeArena.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;
    public QuizController(QuizService quizService) { this.quizService = quizService; }
    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizRequest request) {
        return ResponseEntity.ok(quizService.createQuiz(request));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }
    @PostMapping("/attempt")
    public ResponseEntity<Result> attemptQuiz(@RequestBody QuizAttemptRequest request) {
        return ResponseEntity.ok(quizService.attemptQuiz(request));
    }
    @GetMapping("/leaderboard/{quizId}")
    public ResponseEntity<List<Result>> getLeaderboard(@PathVariable Long quizId) {
        return ResponseEntity.ok(quizService.getLeaderboard(quizId));
    }
}
