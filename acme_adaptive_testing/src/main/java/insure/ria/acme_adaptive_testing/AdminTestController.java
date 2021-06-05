package insure.ria.acme_adaptive_testing;

import insure.ria.acme_adaptive_testing.required.Question;
import insure.ria.acme_adaptive_testing.required.GroupStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


@RestController
public class AdminTestController {

    @Autowired
    private final AdminTest adminTest;

    public AdminTestController(AdminTest adminTest) {
        this.adminTest = adminTest;
    }

    @PostMapping("admin/test/name")
    public String setTestName(@RequestBody String newName) {
        return this.adminTest.setTestName(newName);
    }

    @GetMapping("admin/test/name")
    public String getTestName() {
        return this.adminTest.getTestName();
    }

    @GetMapping("admin/test/build")
    public HashMap<Integer, Question> getBuildQuestions() {
        return this.adminTest.getBuildQuestions();
    }

    @PutMapping("admin/test/build")
    public String createBuildQuestion() {
        return this.adminTest.createBuildQuestion();
    }

    @GetMapping("admin/test/build/questionIDs")
    public Set<Integer> getBuildQuestionIDs() {
        return this.adminTest.getBuildQuestionIDs();
    }

    @DeleteMapping("admin/test/build/{id}")
    public String deleteBuildQuestion(@PathVariable int id) {
        return this.adminTest.deleteBuildQuestion(id);
    }

    @GetMapping("admin/test/build/{id}")
    public Question getBuildQuestion(@PathVariable int id) {
        return this.adminTest.getBuildQuestion(id);
    }

    @GetMapping("admin/test/structure")
    public ArrayList<GroupStructure> getTestStructure() {
        return this.adminTest.getTestStructure();
    }

    @GetMapping("admin/test/structure/status")
    public ArrayList<String> getTestStructureStatus() {
        return this.adminTest.getTestStructureStatus();
    }

    @PutMapping("admin/test/structure")
    public String createGroupStructure() {
     return this.adminTest.createGroupStructure();
    }

    @DeleteMapping("admin/test/structure")
    public String deleteGroupStructure() {
        return this.adminTest.deleteGroupStructure();
    }

    @GetMapping("admin/test/structure/{path}")
    public GroupStructure getGroupStructure(@PathVariable String path) {
        return this.adminTest.getGroupStructure(path);
    }

    @GetMapping("admin/test/structure/{path}/status")
    public ArrayList<String> getGroupStructureStatus(@PathVariable String strGroupTag) {
        return this.adminTest.getGroupStructureStatus(strGroupTag);
    }

    @GetMapping("admin/test/structure/{path}/questionID")
    public String getQuestionID(@PathVariable String path) {
        return this.adminTest.getQuestionID(path);
    }

    @PostMapping("admin/test/structure/{path}questionID")
    public String setQuestionID(@PathVariable String path, @RequestBody int questionID) {
        return this.adminTest.setQuestionID(path, questionID);
    }

    @PutMapping("admin/test/structure/{path}")
    public String createCorrectNode(@PathVariable String path, @RequestBody String correctIncorrect) {
        if (correctIncorrect != null) {
            if (correctIncorrect.equals("correctNode")) {
                return this.adminTest.createCorrectGroupStructure(path);
            }
            else if (correctIncorrect.equals("incorrectNode")) {
                return this.adminTest.createIncorrectGroupStructure(path);
            }
            return "Bad Input Given In Request Body! RequestBody: " + correctIncorrect;
        }
        return "Provide Non-null value! correctIncorrect: null";
    }

    @DeleteMapping("admin/test/structure/{path}")
    public String deleteCorrectNode(@PathVariable String path, @RequestBody String correctIncorrect) {
        if (correctIncorrect != null) {
            if (correctIncorrect.equals("correctNode")) {
                return this.adminTest.deleteCorrectGroupStructure(path);
            }
            else if (correctIncorrect.equals("incorrectNode")) {
                return this.adminTest.deleteIncorrectGroupStructure(path);
            }
            return "Bad Input Given In Request Body! RequestBody: " + correctIncorrect;
        }
        return "Provide Non-null value! correctIncorrect: null";
    }
}
