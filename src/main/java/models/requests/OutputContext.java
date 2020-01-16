package models.requests;

public class OutputContext {
    private String name;
    private int lifespanCount;
    private Parameters parameters;

    public OutputContext() {
    }

    public OutputContext(String name, int lifespanCount, Parameters parameters) {
        this.name = name;
        this.lifespanCount = lifespanCount;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifespanCount() {
        return lifespanCount;
    }

    public void setLifespanCount(int lifespanCount) {
        this.lifespanCount = lifespanCount;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
