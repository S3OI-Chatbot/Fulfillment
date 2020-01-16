package models.requests;

public class FulfillmentMessages {
    private Text text;

    public FulfillmentMessages() {
    }

    public FulfillmentMessages(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
