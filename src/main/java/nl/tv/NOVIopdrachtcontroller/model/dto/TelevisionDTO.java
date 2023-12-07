package nl.tv.NOVIopdrachtcontroller.model.dto;

import lombok.*;
import nl.tv.NOVIopdrachtcontroller.model.entity.AvailableSize;
import nl.tv.NOVIopdrachtcontroller.model.entity.ScreenType;
import nl.tv.NOVIopdrachtcontroller.model.entity.Television;

import javax.validation.constraints.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TelevisionDTO {
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private AvailableSize availableSize;
    private Double refreshRate;
    private ScreenType screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Integer originalStock;
    private Integer sold;

    public static TelevisionDTO fromEntityToDto(Television entity){
        TelevisionDTO dto = new TelevisionDTO();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setBrand(entity.getBrand());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setAvailableSize(entity.getAvailableSize());
        dto.setRefreshRate(entity.getRefreshRate());
        dto.setScreenType(entity.getScreenType());
        dto.setScreenQuality(entity.getScreenQuality());
        dto.setSmartTv(entity.getSmartTv());
        dto.setWifi(entity.getWifi());
        dto.setVoiceControl(entity.getVoiceControl());
        dto.setHdr(entity.getHdr());
        dto.setBluetooth(entity.getBluetooth());
        dto.setOriginalStock(entity.getOriginalStock());
        dto.setSold(entity.getSold());
        return  dto;
    }


}
