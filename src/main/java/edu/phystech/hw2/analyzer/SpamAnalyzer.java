package edu.phystech.hw2.analyzer;

import java.util.List;

public class SpamAnalyzer extends KeywordAnalyzer {
    public SpamAnalyzer(List<String> keywords) {
        super(keywords, Label.SPAM);
    }

    @Override
    public Label processText(String txt) {
        for (String word : this.getKeywords()) {
            if (txt.indexOf(word) != -1) {
                return Label.SPAM;
            }
        }
        return Label.OK;
    }
}
