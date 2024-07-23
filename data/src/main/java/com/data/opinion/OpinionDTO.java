package com.data.opinion;

import com.data.client.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpinionDTO {

    private Long id;

    private String createdDate;

    private String comment;

    private Integer score;

    private String username;

    public OpinionDTO(Opinion opinion, ClientDTO clientDTO) {
        this.id = opinion.getId();
        this.createdDate = opinion.getCreatedDate();
        this.comment = opinion.getComment();
        this.score = opinion.getScore();
        this.username = clientDTO.getFullname();
    }

}