/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author duran
 */


@Entity
@Table(name = "Personajes")
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Integer health;

    @Column(name = "intellect")
    private Integer intellect;

    @Column(name = "agility")
    private Integer agility;

    @Column(name = "strength")
    private Integer strength;

    @Column(name = "spirit")
    private Integer spirit;

    // Constructor vacío
    public Personaje() {
    }

    // Constructor con parámetros
    public Personaje(String name, Integer health, Integer intellect, Integer agility, Integer strength, Integer spirit) {
        this.name = name;
        this.health = health;
        this.intellect = intellect;
        this.agility = agility;
        this.strength = strength;
        this.spirit = spirit;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getIntellect() {
        return intellect;
    }

    public void setIntellect(Integer intellect) {
        this.intellect = intellect;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getSpirit() {
        return spirit;
    }

    public void setSpirit(Integer spirit) {
        this.spirit = spirit;
    }

}