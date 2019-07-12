package guru.springfamework.api.v1.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springfamework.api.v1.model.ProductDTO;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Product;
import guru.springfamework.domain.Vendor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorMapperTest {

    public static final String NAME = "someName";
    
    @Autowired
    ProductMapper productMapper;
    @Autowired
    VendorMapper vendorMapper;

    @Test
    public void vendorToVendorDTO() throws Exception {
        //given
        Vendor vendor = new Vendor();
        vendor.setName(NAME);

        //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor, new CycleAvoidingMappingContext());

        //then
        assertEquals(vendor.getName(), vendorDTO.getName());
    }

    @Test
    public void vendorDTOtoVendor() throws Exception {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        //when
        Vendor vendor = vendorMapper.vendorDTOtoVendor(vendorDTO, new CycleAvoidingMappingContext());

        //then
        assertEquals(vendorDTO.getName(), vendor.getName());
    }
    
    @Test
    public void productDTOtoProduct() throws Exception {
        //given
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(NAME);

        //when
        Product product = productMapper.productDTOtoProduct(productDTO, new CycleAvoidingMappingContext());

        //then
        assertEquals(productDTO.getName(), product.getName());
    }
    
    @Test
    public void testVendorMapper() {
		Vendor vendor = new Vendor();
		vendor.setId(1L);
		vendor.setName("Wolverine");
		Product product = new Product();
		product.setName("Omo");
		product.setVendor(vendor);
		vendor.getProducts().add(product);
		
		VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor, new CycleAvoidingMappingContext());
		
		assertNotNull(vendorDTO.getName());
		
	}
}