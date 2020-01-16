package models.requests;

import java.util.List;

public class QueryResult {
    private String queryText;
    private Parameters parameters;
    private boolean allRequiredParamsPresent;
    private String fulfillmentText;
    private List<FulfillmentMessages> fulfillmentMessages;
    private OutputContext outputContext;
    private Intent intent;
    private double intentDetectionConfidence;
    private String languageCode;

    public QueryResult() {
    }

    public QueryResult(String queryText, Parameters parameters, boolean allRequiredParamsPresent, String fulfillmentText, List<FulfillmentMessages> fulfillmentMessages, OutputContext outputContext, Intent intent, double intentDetectionConfidence, String languageCode) {
        this.queryText = queryText;
        this.parameters = parameters;
        this.allRequiredParamsPresent = allRequiredParamsPresent;
        this.fulfillmentText = fulfillmentText;
        this.fulfillmentMessages = fulfillmentMessages;
        this.outputContext = outputContext;
        this.intent = intent;
        this.intentDetectionConfidence = intentDetectionConfidence;
        this.languageCode = languageCode;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public boolean isAllRequiredParamsPresent() {
        return allRequiredParamsPresent;
    }

    public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
        this.allRequiredParamsPresent = allRequiredParamsPresent;
    }

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public void setFulfillmentText(String fulfillmentText) {
        this.fulfillmentText = fulfillmentText;
    }

    public List<FulfillmentMessages> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(List<FulfillmentMessages> fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    public OutputContext getOutputContext() {
        return outputContext;
    }

    public void setOutputContext(OutputContext outputContext) {
        this.outputContext = outputContext;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public double getIntentDetectionConfidence() {
        return intentDetectionConfidence;
    }

    public void setIntentDetectionConfidence(double intentDetectionConfidence) {
        this.intentDetectionConfidence = intentDetectionConfidence;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}
