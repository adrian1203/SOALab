


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import java.util.Random;

@ManagedBean(name = "Poll")
@SessionScoped
public class Poll {

    private String name;
    private String email;
    private Integer age;
    private String education;
    private Integer height;
    private Gender gender;

    private Integer bustCircuit;
    private Integer cupSize;
    private Integer waistSize;
    private Integer hipSize;

    private Integer chestSize;
    private Integer menwaistSize;

    private String question1;
    private String question2;
    private String[] question3;
    private String[] question4;


    private Boolean aditionalQuestions;



    private HtmlSelectOneMenu htmlSelectOneMenu;

    private Boolean male, famale;

    public HtmlSelectOneMenu getHtmlSelectOneMenu() {
        return htmlSelectOneMenu;
    }

    public void setHtmlSelectOneMenu(HtmlSelectOneMenu htmlSelectOneMenu) {
        this.htmlSelectOneMenu = htmlSelectOneMenu;
    }


    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public Boolean getFamale() {
        return famale;
    }

    public void setFamale(Boolean famale) {
        this.famale = famale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getBustCircuit() {
        return bustCircuit;
    }

    public void setBustCircuit(Integer bustCircuit) {
        this.bustCircuit = bustCircuit;
    }

    public Integer getCupSize() {
        return cupSize;
    }

    public void setCupSize(Integer cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(Integer waistSize) {
        this.waistSize = waistSize;
    }

    public Integer getHipSize() {
        return hipSize;
    }

    public void setHipSize(Integer hipSize) {
        this.hipSize = hipSize;
    }

    public Integer getChestSize() {
        return chestSize;
    }

    public void setChestSize(Integer chestSize) {
        this.chestSize = chestSize;
    }

    public Integer getMenwaistSize() {
        return menwaistSize;
    }

    public void setMenwaistSize(Integer menwaistSize) {
        this.menwaistSize = menwaistSize;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String[] getQuestion3() {
        return question3;
    }

    public void setQuestion3(String[] question3) {
        this.question3 = question3;
    }

    public String[] getQuestion4() {
        return question4;
    }

    public void setQuestion4(String[] question4) {
        this.question4 = question4;
    }

    public Poll() {
    }

    public Boolean getAditionalQuestions() {
        return aditionalQuestions;
    }

    public void setAditionalQuestions(Boolean aditionalQuestions) {
        this.aditionalQuestions = aditionalQuestions;
    }

    public void selectGender() {
        if (getHtmlSelectOneMenu() == null) {
            male = null;
            famale = null;
        }
        if ("male".equals(getHtmlSelectOneMenu().getValue().toString())) {
            male = true;
            famale = false;
        } else {
            male = false;
            famale = true;
        }
    }
    public void renderAdidtionaQuestions(){
        this.aditionalQuestions=true;
        this.selectGender();
    }

//    public String renderAnswer(){
//        return "answer";
//    }

    public String getRandomBaner(){
        Random random = new Random();
        int wylosowana = random.nextInt(1);
        return "b" + wylosowana + ".jpg";
    }
}

