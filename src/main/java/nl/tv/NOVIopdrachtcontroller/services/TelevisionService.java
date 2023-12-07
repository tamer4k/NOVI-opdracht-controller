package nl.tv.NOVIopdrachtcontroller.services;


import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import nl.tv.NOVIopdrachtcontroller.model.dto.GetTelevisionByIdDTO;
import nl.tv.NOVIopdrachtcontroller.model.dto.CreateTelevisionResponseDTO;
import nl.tv.NOVIopdrachtcontroller.model.entity.Television;
import nl.tv.NOVIopdrachtcontroller.model.dto.TelevisionDTO;
import nl.tv.NOVIopdrachtcontroller.repositories.TelevisionRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDTO> getAllTelevision() {

        List<Television> entityList = televisionRepository.findAll();
        List<TelevisionDTO> dtoList = new ArrayList<>();

        for (Television entity : entityList) {
            dtoList.add(TelevisionDTO.fromEntityToDto(entity));
        }
        return dtoList;

    }

    public GetTelevisionByIdDTO getTelevisionById(Long id) {

        Optional<Television> entity = televisionRepository.findById(id);
        GetTelevisionByIdDTO dto;
        if(entity.isEmpty()){
            return null;
        }else
        dto = GetTelevisionByIdDTO.fromEntityTelevisionBrandAndNameDTO(entity.get());
        return dto;
    }

    public CreateTelevisionResponseDTO createTelevision(TelevisionDTO dto) {

        Television entity = televisionRepository.save(Television.fromDtoToEntity(dto));

        return CreateTelevisionResponseDTO.fromEntityToDTO(entity);
    }


    public TelevisionDTO updateTelevision(Long id, TelevisionDTO dto) {
        Optional<Television> entityId = televisionRepository.findById(id);
        if(!entityId.isEmpty()){
            Television entity = televisionRepository.save(Television.fromDtoToEntity(dto));
            return TelevisionDTO.fromEntityToDto(entity);
        }
        return null;
    }


    public boolean deleteTelevision(Long id) {
        Optional<Television> entity = televisionRepository.findById(id);
        if (entity.isEmpty()) {
           return false;
        } else {
            televisionRepository.deleteById(id);
            return true;
        }
    }


}
