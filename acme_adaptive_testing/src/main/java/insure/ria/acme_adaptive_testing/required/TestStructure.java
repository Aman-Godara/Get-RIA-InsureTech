package insure.ria.acme_adaptive_testing.required;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static java.lang.Math.min;

@Service
public class TestStructure {
    private final ArrayList<GroupStructure> groupStructureList;

    public TestStructure() {
        this.groupStructureList = new ArrayList<>();
    }

    public ArrayList<GroupStructure> getTestStructure() {
        return this.groupStructureList;
    }

    public ArrayList<String> getTestStructureStatus() {
        ArrayList<String> testStructureStatus = new ArrayList<>();
        for (GroupStructure groupStructure : this.groupStructureList) {
            groupStructure.getGroupStructureStatus(testStructureStatus);
        }
        return testStructureStatus;
    }

    public String createGroupStructure() {
        String groupStructureTag = Integer.toString(this.groupStructureList.size() + 1);
        GroupStructure groupStructure = new GroupStructure();
        groupStructure.setTag(groupStructureTag);
        this.groupStructureList.add(groupStructure);
        return "Question Group Created Successfully! groupTag: " + groupStructureTag;
    }

    public String deleteGroupStructure() {
        int lastIndex = this.groupStructureList.size() - 1;
        if (-1 < lastIndex) {
            this.groupStructureList.remove(lastIndex);
            return "Question Group Removed Successfully! groupTag: " + (lastIndex + 1);
        }
        return "No Question Group Present To Remove!";
    }

    public GroupStructure getGroupStructure(String path) {
        if (path != null && path.length() != 0) {
            int i = 0;
            while (i < path.length()) {
                if (path.charAt(i) == '.') {
                    break;
                }
                i = i + 1;
            }
            try {
                int index = Integer.parseInt(path.substring(0, i));
                return this.groupStructureList.get(index - 1).getGroupStructure(path.substring(i + 1));
            }
            catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public ArrayList<String> getGroupStructureStatus(String path) {
        GroupStructure groupStructure = this.getGroupStructure(path);
        ArrayList<String> groupStructureStatus = new ArrayList<>();
        if (groupStructure != null) {
            groupStructure.getGroupStructureStatus(groupStructureStatus);
        }
        return groupStructureStatus;
    }

    public String createCorrectGroupStructure(String path) {
        if (path != null && path.length() != 0) {
            int i = 0;
            while (i < path.length()) {
                if (path.charAt(i) == '.') {
                    break;
                }
                i = i + 1;
            }
            int index;
            try {
                index = Integer.parseInt(path.substring(0, i));
            } catch (NumberFormatException e) {
                return "Non Integer groupTag Given! groupTag: " + path.substring(0, i);
            }
            if (1 <= index && index <= this.groupStructureList.size()) {
                return this.groupStructureList.get(index - 1).createCorrectGroupStructure(path.substring(min(i + 1, this.groupStructureList.size())));
            }
            return "groupTag Doesn't Exists! [Create This Group First] groupTag: " + index;
        }
        return "Please Provide Non-null Path! And A Non Empty Path!";
    }

    public String createIncorrectGroupStructure(String path) {
        if (path != null && path.length() != 0) {
            int i = 0;
            while (i < path.length()) {
                if (path.charAt(i) == '.') {
                    break;
                }
                i = i + 1;
            }
            int index;
            try {
                index = Integer.parseInt(path.substring(0, i));
            }
            catch (NumberFormatException e) {
                return "Non Integer groupTag Given! groupTag: " + path.substring(0, i);
            }
            if (1 <= index && index <= this.groupStructureList.size()) {
                return this.groupStructureList.get(index - 1).createIncorrectGroupStructure(path.substring(min(i + 1, this.groupStructureList.size())));
            }
            return "groupTag Doesn't Exists! [Create This Group First] groupTag: " + index;
        }
        return "Please Provide Non-null Path! And A Non Empty Path!";
    }

    public String getQuestionID(String path) {
        if (path != null && path.length() != 0) {
            int i = 0;
            while (i < path.length()) {
                if (path.charAt(i) == '.') {
                    break;
                }
                i = i + 1;
            }
            int index;
            try {
                index = Integer.parseInt(path.substring(0, i));
            }
            catch (NumberFormatException e) {
                return "Non Integer groupTag Given! groupTag: " + path.substring(0, i);
            }
            if (1 <= index && index <= this.groupStructureList.size()) {
                return this.groupStructureList.get(index - 1).getQuestionID(path.substring(min(i + 1, this.groupStructureList.size())));
            }
            return "groupTag Doesn't Exists! [Create This Group First] groupTag: " + index;
        }
        return "Please Provide Non-null Path! And A Non Empty Path!";
    }

    public String setQuestionID(String path, int questionID) {
        if (path != null && path.length() != 0) {
            int i = 0;
            while (i < path.length()) {
                if (path.charAt(i) == '.') {
                    break;
                }
                i = i + 1;
            }
            int index;
            try {
                index = Integer.parseInt(path.substring(0, i));
            }
            catch (NumberFormatException e) {
                return "Non Integer groupTag Given! groupTag: " + path.substring(0, i);
            }
            if (1 <= index && index <= this.groupStructureList.size()) {
                return this.groupStructureList.get(index - 1).setQuestionID(path.substring(min(i + 1, this.groupStructureList.size())), questionID);
            }
            return "groupTag Doesn't Exists! [Create This Group First] groupTag: " + index;
        }
        return "Please Provide Non-null Path! And A Non Empty Path!";
    }

    public String deleteCorrectGroupStructure(String path) {
        if (path != null && path.length() != 0) {
            int i = 0;
            while (i < path.length()) {
                if (path.charAt(i) == '.') {
                    break;
                }
                i = i + 1;
            }
            int index;
            try {
                index = Integer.parseInt(path.substring(0, i));
            }
            catch (NumberFormatException e) {
                return "Non Integer groupTag Given! groupTag: " + path.substring(0, i);
            }
            if (1 <= index && index <= this.groupStructureList.size()) {
                return this.groupStructureList.get(index - 1).deleteCorrectGroupStructure(path.substring(min(i + 1, this.groupStructureList.size())));
            }
            return "groupTag Doesn't Exists! [Create This Group First] groupTag: " + index;
        }
        return "Please Provide Non-null Path! And A Non Empty Path!";
    }

    public String deleteIncorrectGroupStructure(String path) {
        if (path != null && path.length() != 0) {
            int i = 0;
            while (i < path.length()) {
                if (path.charAt(i) == '.') {
                    break;
                }
                i = i + 1;
            }
            int index;
            try {
                index = Integer.parseInt(path.substring(0, i));
            }
            catch (NumberFormatException e) {
                return "Non Integer groupTag Given! groupTag: " + path.substring(0, i);
            }
            if (1 <= index && index <= this.groupStructureList.size()) {
                return this.groupStructureList.get(index - 1).deleteIncorrectGroupStructure(path.substring(min(i + 1, this.groupStructureList.size())));
            }
            return "groupTag Doesn't Exists! [Create This Group First] groupTag: " + index;
        }
        return "Please Provide Non-null Path! And A Non Empty Path!";
    }
}
