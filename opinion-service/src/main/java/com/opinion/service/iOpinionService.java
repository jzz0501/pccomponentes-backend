package com.opinion.service;

import com.data.opinion.Opinion;
import com.data.opinion.OpinionDTO;

public interface iOpinionService {

    OpinionDTO addOpinion(Opinion opinion);

    void removeOpinionById(Long id_opinion);

}
