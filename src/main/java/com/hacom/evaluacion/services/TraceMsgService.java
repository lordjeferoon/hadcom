package com.hacom.evaluacion.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacom.evaluacion.entities.TraceMsg;
import com.hacom.evaluacion.repositories.TraceMsgRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TraceMsgService {
    private final TraceMsgRepository traceMsgRepository;

    @Autowired
    public TraceMsgService(TraceMsgRepository traceMsgRepository) {
        this.traceMsgRepository = traceMsgRepository;
    }

    public Mono<TraceMsg> createTraceMsg(TraceMsg traceMsg) {
        return traceMsgRepository.insert(traceMsg);
    }

    public Flux<TraceMsg> getTraceMsgsByTimestampRange(Date startTimestamp, Date endTimestamp) {
        return traceMsgRepository.findByTsBetween(startTimestamp, endTimestamp);
    }
}