package com.palash.energysaving.Repository;

import com.palash.energysaving.Entity.Energy;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnergyRepository extends MongoRepository<Energy , ObjectId> {
}
