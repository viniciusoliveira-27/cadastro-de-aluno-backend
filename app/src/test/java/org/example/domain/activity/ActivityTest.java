package org.example.domain.activity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.domain.activity.type.Type;
import org.example.utils.InstantUtils;
import org.junit.jupiter.api.Test;

public class ActivityTest {

    //padrão
    //Given (dado certos parametros/situações)
    //When (quando executando certa coisa)
    //Then (Então se espera certa coisa)

    @Test
    public void givenValidParams_whenBuildingNewActivity_thenReturnNewValidActivity() {

        final var aNome = "Vinicius Ribeiro";
        final var aSerie = "7º serie";
        final var aEscola = "EE Dom Pedro II";
        final var aPeriodo = Type.MANHA;
        final var aValor = 125.55;
        final var aData = InstantUtils.now();

        final var anActivity = Activity.newActivity(aNome, aSerie, aEscola, aPeriodo, aValor, aData);

        assertNotNull(anActivity);
        assertNotNull(anActivity.getId());
        assertTrue(anActivity.getId().length() == 36);
        assertEquals(aNome, anActivity.getNome());
        assertEquals(aSerie, anActivity.getSerie());
        assertEquals(aEscola, anActivity.getEscola());
        assertEquals(aPeriodo, anActivity.getPeriodo());
        assertEquals(aValor, anActivity.getValor(), 0.001);
        assertEquals(aData, anActivity.getData());
        assertNotNull(anActivity.getCreatedAt());
        assertNotNull(anActivity.getUpdatedAt());

    }
    
}
