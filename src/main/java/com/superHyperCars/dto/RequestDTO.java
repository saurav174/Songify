package com.superHyperCars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestDTO<T> {

    private MetaDTO metaDTO;
    private T payload;

    public MetaDTO getMetaDTO() {
        return metaDTO;
    }

    public void setMetaDTO(MetaDTO metaDTO) {
        this.metaDTO = metaDTO;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
