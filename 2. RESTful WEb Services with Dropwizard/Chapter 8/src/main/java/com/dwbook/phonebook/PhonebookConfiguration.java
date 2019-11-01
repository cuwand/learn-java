package com.dwbook.phonebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.constraints.Max;
import io.dropwizard.db.DataSourceFactory;

public class PhonebookConfiguration extends Configuration {
    @JsonProperty
    private String message;

    @JsonProperty
    @Max(10)
    private int messageRepetitions;

    public String getMessage() {
        return message;
    }

    public int getMessageRepetitions() {
        return messageRepetitions;
    }

    @JsonProperty
    private String additionalMessage = "This is will give default messages";
    public String getAdditionalMessage() {
        return additionalMessage;
    }

    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
