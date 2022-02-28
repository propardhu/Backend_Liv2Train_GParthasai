package com.liv2train.app.service;

import com.liv2train.app.domain.TrainingCenter;
import com.liv2train.app.repository.TrainingCenterRepository;
import com.liv2train.app.service.dto.TrainingCenterDTO;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public ResponseEntity<TrainingCenter> save(TrainingCenterDTO data) {
        log.debug("model data to be saved-->" + data.toString());
        if (data.getCenterCode() != null) {
            data.setCenterCode(UUID.randomUUID().toString());
        }
        TrainingCenter dbData = new TrainingCenter();
        BeanUtils.copyProperties(data, dbData);
        log.debug("DB data saving-->" + dbData.toString());
        dbData = trainingCenterRepository.save(dbData);
        return ResponseEntity.created(URI.create(new URI("/api/training/") + dbData.getCenterCode())).body(dbData);
    }

    public ResponseEntity<List<TrainingCenter>> getTrainingCenter() {
        log.debug("get all Training centers");
        List<TrainingCenter> result = trainingCenterRepository.findAll();
        if (result.size() == 0) {
            log.debug("empty-Training Centers List");
        }
        return ResponseEntity.ok(result);
    }
}
