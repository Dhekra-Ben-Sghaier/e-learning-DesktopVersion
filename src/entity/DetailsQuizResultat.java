package entity;

public class DetailsQuizResultat {
    
    private Integer id;
    private ResultatQuiz quizResultat;
    private Question question;
    private String userReponse;

    public DetailsQuizResultat() {
    }

    public DetailsQuizResultat(Integer id, ResultatQuiz quizResultat, Question question, String userReponse) {
        this.id = id;
        this.quizResultat = quizResultat;
        this.question = question;
        this.userReponse = userReponse;
    }

    public DetailsQuizResultat(ResultatQuiz quizResultat, Question question, String userReponse) {
        this.quizResultat = quizResultat;
        this.question = question;
        this.userReponse = userReponse;
    }   

    public Integer getId() {
        return id;
    }

    public ResultatQuiz getQuizResultat() {
        return quizResultat;
    }

    public Question getQuestion() {
        return question;
    }

    public String getUserReponse() {
        return userReponse;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuizResultat(ResultatQuiz quizResultat) {
        this.quizResultat = quizResultat;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setUserReponse(String userReponse) {
        this.userReponse = userReponse;
    }
    
//    public void saveDetailsQuizResultat(){
//    
//    
//    }
    
}
