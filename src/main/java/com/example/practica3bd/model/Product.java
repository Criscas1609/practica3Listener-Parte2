package org.example.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Product {

    private Long id;
    private String name;
    private LocalDate registerDate;
    private Double price;
    private Category category;

}
