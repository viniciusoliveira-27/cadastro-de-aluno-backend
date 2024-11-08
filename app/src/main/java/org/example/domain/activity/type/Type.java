package org.example.domain.activity.type;

public enum Type {
    MANHA("manha"),
    TARDE("tarde");
    
    private String value;

    Type(final String aValue) {
        this.value = aValue;
    }

    public String getValue() {
        return this.value;
    }

}
