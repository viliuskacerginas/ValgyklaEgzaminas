package com.spring.Valgykla.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "calories")
    private int calories;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "vegan")
    private String vegan;
    @Column(name = "stock")
    private int stock;
    @Column(name = "genre")
    private String genre;
    @Column(name = "reserved")
    private boolean reserved;
    @Column(name = "reservation_id")
    private int reservationId;

    public Menu(String name, int calories, String nationality, String vegan, int stock, String genre, boolean reserved, int reservationId) {
        this.name = name;
        this.calories = calories;
        this.nationality = nationality;
        this.vegan = vegan;
        this.stock = stock;
        this.genre = genre;
        this.reserved = reserved;
        this.reservationId = reservationId;
    }
    public Menu(int id, String name, int calories, String nationality, String vegan, int stock, String genre, boolean reserved, int reservationId) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.nationality = nationality;
        this.vegan = vegan;
        this.stock = stock;
        this.genre = genre;
        this.reserved = reserved;
        this.reservationId = reservationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", nationality='" + nationality + '\'' +
                ", vegan=" + vegan +
                ", stock=" + stock +
                ", genre='" + genre + '\'' +
                ", reserved=" + reserved +
                ", reservationId=" + reservationId +
                '}';
    }

    public Menu() {
    }
    }
