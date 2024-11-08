package org.example.domain.activity;

import java.time.Instant;
import java.util.UUID;


import org.example.utils.InstantUtils;
import org.example.domain.activity.exceptions.DomainException;
import org.example.domain.activity.type.Type;

public class Activity {

    private String id;
    private String nome;
    private String serie;
    private String escola;
    private Type periodo;
    private double valor;
    private Instant data;
    private Instant createdAt;
    private Instant updatedAt;

    private Activity(final String anId, final String aNome, final String aSerie, final String aEscola, final Type aPeriodo, final double aValor, final Instant aData, final Instant aCreatedAt, final Instant anUpdatedAt) {

        this.id = anId;
        this.nome = aNome;
        this.serie = aSerie;
        this.escola = aEscola;
        this.periodo = aPeriodo;
        this.valor = aValor;
        this.data = aData;
        this.createdAt = aCreatedAt;
        this.updatedAt = anUpdatedAt;

        this.validate();

    }

    public static Activity newActivity(final String aNome, final String aSerie, final String aEscola, final Type aPeriodo, final double aValor, final Instant aData) {
        return new Activity (
            UUID.randomUUID().toString().toLowerCase(),
            aNome,
            aSerie,
            aEscola,
            aPeriodo,
            aValor,
            aData,
            InstantUtils.now(),
            InstantUtils.now());
    }

    public static Activity with(final String anId, final String aNome, final String aSerie, final String aEscola, final Type aPeriodo, final double aValor, final Instant aData, final Instant aCreatedAt, final Instant anUpdatedAt) {
        return new Activity(anId, aNome, aSerie, aEscola, aPeriodo, aValor, aData, aCreatedAt, anUpdatedAt);
    }

    private void validate() {
        if(this.id.isBlank()) {
            throw new DomainException("Activity's ID should not be blank");
        }
        else if(this.id.length() != 36) {
           throw new DomainException("Activity's ID should be a valid UUID");
        }
        else if(this.nome.isBlank()) {
            throw new DomainException("Activity's nome should not be blank");
        }
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSerie() {
        return serie;
    }

    public String getEscola() {
        return escola;
    }

    public Type getPeriodo() {
        return periodo;
    }

    public double getValor() {
        return valor;
    }

    public Instant getData() {
        return data;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Activity [id=" + id + ", nome=" + nome + ", serie=" + serie + ", escola=" + escola + ", periodo="
                + periodo + ", valor=" + valor + ", data=" + data + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + "]";
    }



}
