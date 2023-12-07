package nl.tv.NOVIopdrachtcontroller.model.entity;

import jakarta.persistence.*;
import lombok.*;
import nl.tv.NOVIopdrachtcontroller.model.dto.TelevisionDTO;

import javax.validation.constraints.*;


@Table(name="televisions")
@Entity
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public static Television fromDtoToEntity(TelevisionDTO dto) {
        Television entity = new Television();

        entity.setId(dto.getId());
        entity.setType(dto.getType());
        entity.setBrand(dto.getBrand());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setAvailableSize(dto.getAvailableSize());
        entity.setRefreshRate(dto.getRefreshRate());
        entity.setScreenType(dto.getScreenType());
        entity.setScreenQuality(dto.getScreenQuality());
        entity.setSmartTv(dto.getSmartTv());
        entity.setWifi(dto.getWifi());
        entity.setVoiceControl(dto.getVoiceControl());
        entity.setHdr(dto.getHdr());
        entity.setBluetooth(dto.getBluetooth());
        entity.setOriginalStock(dto.getOriginalStock());
        entity.setSold(dto.getSold());
        return entity;
    }
}
