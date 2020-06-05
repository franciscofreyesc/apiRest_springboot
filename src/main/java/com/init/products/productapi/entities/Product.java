package com.init.products.productapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//Declaramos la entidad para ir y volver a la bd bajo esta clase
@Entity
//Tabla de la bd donde vamos a dejar y buscar datos
@Table(name = "products")

//Inicio Lombok
@Data
@NoArgsConstructor
public class Product {

    //Indicar que es el id de la tabla
    @Id
    //Columna de la Tabla
    @Column(name = "id")
    //AutoIncrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
}