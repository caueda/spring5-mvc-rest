package guru
.springfamework.api.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt on 10/6/17.
 */
@Data
@NoArgsConstructor
public class VendorDTO {
    private String name;
    
    private List<ProductDTO> products = new ArrayList<>();
    
    @JsonProperty("vendor_url")
    private String vendorUrl;

	public VendorDTO(String name, String vendorUrl) {
		super();
		this.name = name;
		this.vendorUrl = vendorUrl;
	}

	public VendorDTO(String name, List<ProductDTO> products, String vendorUrl) {
		super();
		this.name = name;
		this.products = products;
		this.vendorUrl = vendorUrl;
	}
}
