
package pojopractice.pojos;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "place_id",
    "scope",
    "reference",
    "id"
})
public class AddPlaceResponse implements Serializable {

  @JsonProperty("status")
  private String status;
  @JsonProperty("place_id")
  private String placeId;
  @JsonProperty("scope")
  private String scope;
  @JsonProperty("reference")
  private String reference;
  @JsonProperty("id")
  private String id;
  private final static long serialVersionUID = -1384409893050331728L;

  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  @JsonProperty("place_id")
  public String getPlaceId() {
    return placeId;
  }

  @JsonProperty("place_id")
  public void setPlaceId(String placeId) {
    this.placeId = placeId;
  }

  @JsonProperty("scope")
  public String getScope() {
    return scope;
  }

  @JsonProperty("scope")
  public void setScope(String scope) {
    this.scope = scope;
  }

  @JsonProperty("reference")
  public String getReference() {
    return reference;
  }

  @JsonProperty("reference")
  public void setReference(String reference) {
    this.reference = reference;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

}