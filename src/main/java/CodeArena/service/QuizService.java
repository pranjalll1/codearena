package CodeArena.service;
import CodeArena.dto.QuizAttemptRequest;
import CodeArena.dto.QuizRequest;
import CodeArena.model.*;
import CodeArena.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final ResultRepository resultRepository;
    private final UserRepository userRepository;
    public QuizService(QuizRepository qr, QuestionRepository qnr, ResultRepository rr, UserRepository ur) {
        this.quizRepository=qr; this.questionRepository=qnr; this.resultRepository=rr; this.userRepository=ur;
    }
    public Quiz createQuiz(QuizRequest request) {
        Quiz quiz = Quiz.builder().title(request.getTitle()).description(request.getDescription()).timeLimit(request.getTimeLimit()).build();
        Quiz saved = quizRepository.save(quiz);
        if (request.getQuestions() != null) {
            request.getQuestions().forEach(q -> {
                Question question = Question.builder().questionText(q.getQuestionText()).optionA(q.getOptionA()).optionB(q.getOptionB()).optionC(q.getOptionC()).optionD(q.getOptionD()).correctAnswer(q.getCorrectAnswer()).quiz(saved).build();
                questionRepository.save(question);
            });
        }
        return saved;
    }
    public List<Quiz> getAllQuizzes() { return quizRepository.findAll(); }
    public Quiz getQuizById(Long id) { return quizRepository.findById(id).orElse(null); }
    public Result attemptQuiz(QuizAttemptRequest request) {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        Quiz quiz = quizRepository.findById(request.getQuizId()).orElse(null);
        if (user == null || quiz == null) return null;
        List<Question> questions = questionRepository.findByQuizId(request.getQuizId());
        Map<Long, String> answers = request.getAnswers();
        int score = 0;
        for (Question q : questions) {
            String submitted = answers.get(q.getId());
            if (submitted != null && submitted.equals(q.getCorrectAnswer())) score++;
        }
        Result result = Result.builder().user(user).quiz(quiz).score(score).totalQuestions(questions.size()).attemptedAt(LocalDateTime.now()).build();
        return resultRepository.save(result);
    }
    public List<Result> getLeaderboard(Long quizId) { return resultRepository.findByQuizId(quizId); }
}
