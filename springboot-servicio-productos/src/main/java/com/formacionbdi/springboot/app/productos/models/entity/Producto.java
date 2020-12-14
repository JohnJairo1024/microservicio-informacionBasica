package com.formacionbdi.springboot.app.productos.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "productos")
@Data
public class Producto implements Serializable {

    private static final long serialVersionUID = 1285454306356845809L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

//    @Transient
//    private Integer port;

    public Producto() {
    }

    public Producto(String nombre, Double precio, Date createAt) {
        this.nombre = nombre;
        this.precio = precio;
        this.createAt = createAt;
    }
}
