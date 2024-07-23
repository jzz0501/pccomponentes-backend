package com.opinion.service;

import com.api.ClientAPI;
import com.data.client.Client;
import com.data.client.ClientDTO;
import com.data.opinion.Opinion;
import com.data.opinion.OpinionDTO;
import com.opinion.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpinionService implements iOpinionService {

    @Autowired
    ClientAPI clientAPI;

    @Autowired
    OpinionRepository opinionRepository;

    @Override
    public OpinionDTO addOpinion(Opinion opinion) {
        ClientDTO clientDTO = clientAPI.getClientById(opinion.getId_client());
        return new OpinionDTO(opinionRepository.save(opinion), clientDTO);
    }

    @Override
    public void removeOpinionById(Long id_opinion) {
        opinionRepository.deleteById(id_opinion);
    }
}
