package models.requests;

import java.util.List;

public class Text {
    private List<String> text;

    public Text() {
    }

    public Text(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
