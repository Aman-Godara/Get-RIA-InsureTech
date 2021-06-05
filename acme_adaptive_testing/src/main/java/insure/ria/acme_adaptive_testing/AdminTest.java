package insure.ria.acme_adaptive_testing;

import insure.ria.acme_adaptive_testing.required.Question;
import insure.ria.acme_adaptive_testing.required.GroupStructure;
import insure.ria.acme_adaptive_testing.required.TestStructure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Service
public class AdminTest {

    private String testName;
    private final HashMap<Integer, Question> testQuestions;
    private int id;
    private final TestStructure testStructure;

    public AdminTest() {
        this.testQuestions = new HashMap<> ();
        this.id = 1;
        this.testName = "New Test";
        this.testStructure = new TestStructure();
    }

    public String setTestName(String testName) {
        if (testName != null) {
            this.testName = testName;
            return "Test Name Updated! testName: " + testName;
        }
        return "Failed to Update Test Name! [Please provide a non-null value]";
    }

    public String getTestName() {
        return "testName: " + this.testName;
    }

    public HashMap<Integer, Question> getBuildQuestions() {
        return testQuestions;
    }

    public String createBuildQuestion() {
        Question question = new Question();
        this.testQuestions.put(this.id, question);
        this.id += 1;
        return "Question Created Successfully! id: " + (this.id - 1);
    }

    public Set<Integer> getBuildQuestionIDs() {
        return this.testQuestions.keySet();
    }

    public String deleteBuildQuestion(int id) {
        Question removed = this.testQuestions.remove(id);
        if (removed == null) {
            return "Question Not Found! id: " + id;
        }
        return "Question Removed Successfully! id: " + id;
    }

    public Question getBuildQuestion(int id) {
        return this.testQuestions.get(id);
    }

    public ArrayList<GroupStructure> getTestStructure() {
        return this.testStructure.getTestStructure();
    }

    public ArrayList<String> getTestStructureStatus() {
        return this.testStructure.getTestStructureStatus();
    }

    public ArrayList<String> getGroupStructureStatus(String path) {
        return this.testStructure.getGroupStructureStatus(path);
    }

    public String createGroupStructure() {
        return this.testStructure.createGroupStructure();
    }

    public String deleteGroupStructure() {
        return this.testStructure.deleteGroupStructure();
    }

    public GroupStructure getGroupStructure(String path) {
        return this.testStructure.getGroupStructure(path);
    }

    public String createCorrectGroupStructure(String path) {
        return this.testStructure.createCorrectGroupStructure(path);
    }

    public String createIncorrectGroupStructure(String path) {
        return this.testStructure.createIncorrectGroupStructure(path);
    }

    public String getQuestionID(String path) {
        return this.testStructure.getQuestionID(path);
    }

    public String setQuestionID(String path, int questionID) {
        if (this.testQuestions.containsKey(questionID)) {
            return this.testStructure.setQuestionID(path, questionID);
        }
        return "questionID Doesn't Exist! [Please Create This Question First] questionID: " + questionID;
    }

    public String deleteCorrectGroupStructure(String path) {
        return this.testStructure.deleteCorrectGroupStructure(path);
    }

    public String deleteIncorrectGroupStructure(String path) {
        return this.testStructure.deleteIncorrectGroupStructure(path);
    }
}
