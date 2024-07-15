package com.data.opinion;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "opinion")
public class Opinion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "score")
    private Integer score;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "client_id")
    private Long clientId;

}
