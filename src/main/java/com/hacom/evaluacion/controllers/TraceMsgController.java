package com.hacom.evaluacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hacom.evaluacion.entities.TraceMsg;
import com.hacom.evaluacion.services.TraceMsgService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/trace-msgs")
public class TraceMsgController {
    private final TraceMsgService traceMsgService;
    
    private static final Logger logger = LogManager.getLogger(TraceMsgService.class);
    private static int insertCounter = 0;

    @Autowired
    public TraceMsgController(TraceMsgService traceMsgService) {
        this.traceMsgService = traceMsgService;
    }

    @PostMapping
    public Mono<ResponseEntity<TraceMsg>> createTraceMsg(@RequestBody TraceMsg traceMsg) {
        return traceMsgService.createTraceMsg(traceMsg)
                .map(savedTraceMsg -> {
                    logger.info("Inserción exitosa: {}", savedTraceMsg);
                    incrementInsertCounter();
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedTraceMsg);
                });
    }

    private static synchronized void incrementInsertCounter() {
        insertCounter++;
        logger.info("Cantidad de inserciones: {}", insertCounter);
    }

    @GetMapping("/by-timestamp-range")
    public Flux<TraceMsg> getTraceMsgsByTimestampRange(@RequestBody DateRangeRequest dateRangeRequest) {
        return traceMsgService.getTraceMsgsByTimestampRange(dateRangeRequest.getFrom(), dateRangeRequest.getTo());
    }
}