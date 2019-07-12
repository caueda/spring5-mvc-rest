package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt on 10/6/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
    private String name;
    private VendorDTO vendor;
}
