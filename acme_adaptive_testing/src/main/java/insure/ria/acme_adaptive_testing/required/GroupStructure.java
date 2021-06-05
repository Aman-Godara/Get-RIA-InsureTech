package insure.ria.acme_adaptive_testing.required;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import static java.lang.Math.abs;

@Service
public class GroupStructure {

    private int questionID;
    private String tag;
    private GroupStructure correctGroupStructure;
    private GroupStructure incorrectGroupStructure;

    public GroupStructure() {
        this.questionID = 0;
        this.tag = "";
        this.correctGroupStructure = null;
        this.incorrectGroupStructure = null;
    }

    public void setTag(String tag) {
        if (tag != null) {
            this.tag = tag;
        }
    }

    public GroupStructure getCorrectGroupStructure() {
        return this.correctGroupStructure;
    }

    public GroupStructure getIncorrectGroupStructure() {
        return this.incorrectGroupStructure;
    }

    public String getTag() {
        return this.tag;
    }

    public int getQuestionID() {
        return this.questionID;
    }

    public void getGroupStructureStatus(ArrayList<String> tagsData) {
        String status = ": EMPTY";
        if (this.questionID != 0) {
            status = ": OCCUPIED: " + this.questionID;
        }
        tagsData.add(this.tag + status);

        if (this.correctGroupStructure != null) {
            this.correctGroupStructure.getGroupStructureStatus(tagsData);
        }
        if (this.incorrectGroupStructure != null) {
            this.incorrectGroupStructure.getGroupStructureStatus(tagsData);
        }
    }

    public GroupStructure getGroupStructure(String path) {
        if (path != null) {
            GroupStructure current = this;
            for (int i = 0; i < path.length(); i = i + 2) {
                if (path.charAt(i) == '1' && this.correctGroupStructure != null) {
                    current = this.correctGroupStructure;
                }
                else if (path.charAt(i) == '2' && this.incorrectGroupStructure != null) {
                    current = this.incorrectGroupStructure;
                }
                else {
                    return null;
                }
            }
            return current;
        }
        return null;
    }

    public String createCorrectGroupStructure(String path) {
        if (path != null) {
            GroupStructure groupStructure = this.getGroupStructure(path);
            if (groupStructure != null) {
                String tag = groupStructure.tag + ".1";
                if (groupStructure.correctGroupStructure == null) {
                    groupStructure.correctGroupStructure = new GroupStructure();
                    groupStructure.correctGroupStructure.setTag(tag);
                    return "Node Created Successfully! tag: " + tag;
                }
                return "Node Already Exists! tag: " + tag;
            }
            return "Bad Path Given! path: " + path;
        }
        return "Please Provide Non-null Path! path: null";
    }

    public String createIncorrectGroupStructure(String path) {
        if (path != null) {
            GroupStructure groupStructure = this.getGroupStructure(path);
            if (groupStructure != null) {
                String tag = groupStructure.tag + ".2";
                if (groupStructure.incorrectGroupStructure == null) {
                    groupStructure.incorrectGroupStructure = new GroupStructure();
                    groupStructure.incorrectGroupStructure.setTag(tag);
                    return "Node Created Successfully! tag: " + tag;
                }
                return "Node Already Exists! tag: " + tag;
            }
            return "Bad Path Given! path: " + path;
        }
        return "Please Provide Non-null Path! path: null";
    }

    public String setQuestionID(String path, int questionID) {
        if (path != null) {
            GroupStructure groupStructure = this.getGroupStructure(path);
            if (groupStructure != null) {
                groupStructure.questionID = abs(questionID);
                return "Question ID Set Successfully! questionID: " + groupStructure.questionID;
            }
            return "Bad Path Given! path: " + path;
        }
        return "Please Provide Non-null Path! path: null";
    }

    public String getQuestionID(String path) {
        if (path != null) {
            GroupStructure groupStructure = this.getGroupStructure(path);
            if (groupStructure != null) {
                if (groupStructure.questionID != 0) {
                    return "questionID: " + groupStructure.questionID;
                }
                return "questionID Not Set! tag: " + groupStructure.tag;
            }
            return "Bad Path Given! path: " + path;
        }
        return "Please Provide Non-null Path! path: null";
    }

    public String deleteCorrectGroupStructure(String path) {
        if (path != null) {
            GroupStructure groupStructure = this.getGroupStructure(path);
            if (groupStructure != null) {
                if (groupStructure.correctGroupStructure != null) {
                    String tag = groupStructure.correctGroupStructure.tag;
                    groupStructure.correctGroupStructure = null;
                    return "Correct Node Deleted Successfully! tag: " + tag;
                }
                return "Correct Node Doesn't Exist Already! tag: " + groupStructure.tag;
            }
            return "Bad Path Given! path: " + path;
        }
        return "Please Provide Non-null Path! path: null";
    }

    public String deleteIncorrectGroupStructure(String path) {
        if (path != null) {
            GroupStructure groupStructure = this.getGroupStructure(path);
            if (groupStructure != null) {
                if (groupStructure.incorrectGroupStructure != null) {
                    String tag = groupStructure.incorrectGroupStructure.tag;
                    groupStructure.incorrectGroupStructure = null;
                    return "InCorrect Node Deleted Successfully! tag: " + tag;
                }
                return "InCorrect Node Doesn't Exist Already! tag: " + groupStructure.tag;
            }
            return "Bad Path Given! path: " + path;
        }
        return "Please Provide Non-null Path! path: null";
    }

}
