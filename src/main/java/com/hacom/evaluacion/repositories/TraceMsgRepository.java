package com.hacom.evaluacion.repositories;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.hacom.evaluacion.entities.TraceMsg;
import reactor.core.publisher.Flux;

public interface TraceMsgRepository extends ReactiveMongoRepository<TraceMsg, ObjectId> {
	Flux<TraceMsg> findByTsBetween(Date startTimestamp, Date endTimestamp);
}