
package addplace;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lng"
})
public class Location implements Serializable
{

    @JsonProperty("lat")
    private Float lat;
    @JsonProperty("lng")
    private Float lng;
    private final static long serialVersionUID = 7122136076957078781L;

    @JsonProperty("lat")
    public Float getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Float lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public Float getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(Float lng) {
        this.lng = lng;
    }

}
