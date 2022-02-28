package com.liv2train.app.web.rest;

import com.liv2train.app.domain.TrainingCenter;
import com.liv2train.app.repository.TrainingCenterRepository;
import com.liv2train.app.service.dto.TrainingCenterDTO;
import com.liv2train.app.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
@Slf4j
public class TrainingCenterResource {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @PostMapping("/training")
    public ResponseEntity<TrainingCenter> save(@Valid @RequestBody TrainingCenterDTO data) throws URISyntaxException {
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

    @GetMapping("/training")
    public ResponseEntity<List<TrainingCenter>> getTrainingCenters() {
        log.debug("get all Training centers");
        List<TrainingCenter> result = trainingCenterRepository.findAll();
        if (result.size() == 0) {
            log.debug("empty----");
        }
        return ResponseEntity.ok(result);
    }
}
