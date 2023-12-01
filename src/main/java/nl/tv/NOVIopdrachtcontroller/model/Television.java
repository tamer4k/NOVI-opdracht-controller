package nl.tv.NOVIopdrachtcontroller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Table(name="televisions")
@Entity
@Data
@Builder
@Setter
@Getter
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
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;

    // Default constructor
    public Television() {
    }

    // Parameterized constructor
    public Television(Long id, String type, String brand, String name, Double price,
                      AvailableSize availableSize, Double refreshRate, ScreenType screenType,
                      String screenQuality, Boolean smartTv, Boolean wifi,
                      Boolean voiceControl, Boolean hdr, Boolean bluetooth,
                      Boolean ambiLight, Integer originalStock, Integer sold) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.refreshRate = refreshRate;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }



}
