package edu.phystech.hw2.analyzer;


import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final List<String> NEGATIVE_SMILES = List.of(":(", "=(", ":|");

    public NegativeTextAnalyzer() {
        super(NEGATIVE_SMILES, Label.NEGATIVE);
    }

    public Label processText(String text) {
        for (String word : this.getKeywords()) {
            if (text.indexOf(word) == text.length() - 2 && text.indexOf(' ' + word) != -1) {
                return Label.NEGATIVE;
            }
            if (text.indexOf(word) == 0 && text.indexOf(word + ' ') != -1) {
                return Label.NEGATIVE;
            }
            if (text.indexOf(' ' + word + ' ') != -1) {
                return Label.NEGATIVE;
            }
        }
        return Label.OK;
    }
}
