package org.example.repository.activity.jpa;

import java.time.Instant;
import java.util.List;

import org.example.domain.activity.Activity;
import org.example.domain.activity.type.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "Activity")
@Table(name = "activities")
public class ActivityJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "serie", nullable = false)
    private String serie;

    @Column(name = "escola", nullable = false)
    private String escola;

    @Column(name = "periodo", nullable = false)
    private Integer periodo;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "data", nullable = false)
    private Instant data;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt; 
    
    public ActivityJpaEntity() {

    }

    private ActivityJpaEntity(final String anId, final String aNome, final String aSerie, final String aEscola, final Integer aPeriodo, final Double aValor, final Instant aData, final Instant aCreatedAt, final Instant anUpdatedAt) {
        
        this.id = anId;
        this.nome = aNome;
        this.serie = aSerie;
        this.escola = aEscola;
        this.periodo = aPeriodo;
        this.valor = aValor;
        this.data = aData;
        this.createdAt = aCreatedAt;
        this.updatedAt = anUpdatedAt;
    }
    public static ActivityJpaEntity from(final Activity anActivity) {

        final var aPeriodo = List.of(Type.values()).stream()
            .filter(a -> a.equals(anActivity.getPeriodo()))
            .findFirst()
            .get()
            .ordinal();

        return new ActivityJpaEntity(
            anActivity.getId(), 
            anActivity.getNome(), 
            anActivity.getSerie(), 
            anActivity.getEscola(), 
            aPeriodo, 
            anActivity.getValor(), 
            anActivity.getData(), 
            anActivity.getCreatedAt(), 
            anActivity.getUpdatedAt());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}
