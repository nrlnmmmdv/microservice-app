package com.nurlan.ticketservice.repository.es;

import com.nurlan.ticketservice.entity.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {
}
