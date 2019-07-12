package guru.springfamework.api.v1.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;

/**
 * Created by jt on 10/6/17.
 */
@Mapper(uses = {ProductMapper.class})
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor, @Context CycleAvoidingMappingContext context);
    
    @InheritInverseConfiguration
    Vendor vendorDTOtoVendor(VendorDTO vendorDTO, @Context CycleAvoidingMappingContext context);
}
