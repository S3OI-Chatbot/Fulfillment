package models.requests;

public class Request {
    private String responseId;
    private QueryResult queryResult;
    private IntentRequest originalDetectIntentRequest;
    private String session;

    public Request() {
    }

    public Request(String responseId, QueryResult queryResult, IntentRequest originalDetectIntentRequest, String session) {
        this.responseId = responseId;
        this.queryResult = queryResult;
        this.originalDetectIntentRequest = originalDetectIntentRequest;
        this.session = session;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    public IntentRequest getOriginalDetectIntentRequest() {
        return originalDetectIntentRequest;
    }

    public void setOriginalDetectIntentRequest(IntentRequest originalDetectIntentRequest) {
        this.originalDetectIntentRequest = originalDetectIntentRequest;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
