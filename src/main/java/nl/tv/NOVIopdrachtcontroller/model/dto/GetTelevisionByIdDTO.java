package nl.tv.NOVIopdrachtcontroller.model.dto;


import lombok.*;
import nl.tv.NOVIopdrachtcontroller.model.entity.Television;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class GetTelevisionByIdDTO {
    private Long id;
    private String brand;
    private String name;

    public static GetTelevisionByIdDTO fromEntityTelevisionBrandAndNameDTO(Television entity) {
        GetTelevisionByIdDTO dto = new GetTelevisionByIdDTO();
        dto.setId(entity.getId());
        dto.setBrand(entity.getBrand());
        dto.setName(entity.getName());
        return dto;
    }

}
