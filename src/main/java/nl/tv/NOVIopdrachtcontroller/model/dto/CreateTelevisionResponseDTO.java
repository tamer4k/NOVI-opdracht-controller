package nl.tv.NOVIopdrachtcontroller.model.dto;

import lombok.*;
import nl.tv.NOVIopdrachtcontroller.model.entity.Television;


@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreateTelevisionResponseDTO {

    private Long id;
    private String brand;
    private String name;
    private Double price;


    public static CreateTelevisionResponseDTO fromEntityToDTO(Television entity) {

            CreateTelevisionResponseDTO responseDTO = new CreateTelevisionResponseDTO();
            responseDTO.setId(entity.getId());
            responseDTO.setBrand(entity.getBrand());
            responseDTO.setName(entity.getName());
            responseDTO.setPrice(entity.getPrice());
            return responseDTO;

    }
}


