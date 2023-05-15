package com.epsi.SalleReserver;

import javax.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_salle")
    private int id;

    @Column(name = "nom_salle")
    private String nomSalle;

    @Column(name = "image")
    private String image;

    @Column(name = "capacite")
    private int capacite;

    @Column(name = "equipements_disponibles")
    private String equipementsDisponibles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getEquipementsDisponibles() {
        return equipementsDisponibles;
    }

    public void setEquipementsDisponibles(String equipementsDisponibles) {
        this.equipementsDisponibles = equipementsDisponibles;
    }
}
