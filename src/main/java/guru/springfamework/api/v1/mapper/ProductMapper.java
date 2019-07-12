package guru.springfamework.api.v1.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springfamework.api.v1.model.ProductDTO;
import guru.springfamework.domain.Product;

/**
 * Created by jt on 10/6/17.
 */
@Mapper(uses = {VendorMapper.class})
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    Product productDTOtoProduct(ProductDTO productDTO, @Context CycleAvoidingMappingContext context);
}
