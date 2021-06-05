package insure.ria.acme_adaptive_testing.required;

import org.springframework.stereotype.Service;

@Service
public class Option {
    static private final int INCORRECT_MARKS = 0;
    static private final int UNATTEMPTED_MARKS = 0;

    private String optionDescription;
    private boolean isCorrect;
    private int correctMarks;

    public Option() {
        this.optionDescription = "";
        this.isCorrect = false;
        this.correctMarks = 0;
    }

    public String getOptionDescription() {
        return this.optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        if (optionDescription != null) {
            this.optionDescription = optionDescription;
        }
    }

    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public int getCorrectMarks() {
        return this.correctMarks;
    }

    public void setCorrectMarks(int correctMarks) {
        this.correctMarks = correctMarks;
    }

}
