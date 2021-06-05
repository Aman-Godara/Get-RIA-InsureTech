package insure.ria.acme_adaptive_testing.required;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Question {

    private String questionDescription;
    private final ArrayList<Option> options;

    public Question () {
        this.questionDescription = "";
        this.options = new ArrayList<>(Arrays.asList(new Option(), new Option()));
    }

    public String getQuestionDescription() {
        return this.questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        if (questionDescription != null) {
            this.questionDescription = questionDescription;
        }
    }

    public ArrayList<Option> getOptions() {
        return this.options;
    }

    public Option getOption(int index) {
        if (-1 < index && index < this.options.size()) {
            return this.options.get(index);
        }
        return null;
    }

    public void addOption() {
        this.options.add(new Option());
    }

    public void removeOption() {
        int index = this.options.size() - 1;
        if (-1 < index) {
            this.options.remove(index);
        }
    }

}
