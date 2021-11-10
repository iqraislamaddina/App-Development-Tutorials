package apap.tutorial.pergipergi.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgensiDetail {
    private String status;

    @JsonProperty("agensi-license")
    private Integer agensiLicense;

    @JsonProperty("valid-until")
    private Date validUntil;

    public String getStatus() { return status; }
    public void  setStatus(String status){ this.status = status; }
    
    public Integer getAgensiLicense() { return agensiLicense; }
    
    public void setAgensiLicense(Integer agensiLicense) { this.agensiLicense = agensiLicense; }
    
    public Date getValidUntil() { return validUntil;}
    
    public void setValidUntil(Date validUntil) { this.validUntil = validUntil; }
}