package models.requests;

public class IntentRequest {
    private Payload payload;

    public IntentRequest() {
    }

    public IntentRequest(Payload payload) {
        this.payload = payload;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
