package com.recordslabel.labelapp.domain;

import com.recordslabel.labelapp.entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("h2")
public class ArtistEntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testPersistAndFindArtist() {
        Artist artist = new Artist();
        artist.setSceneName("Test artist");
        artist.setRealName("Real name");
        artist.setOriginCountry("USA");

        entityManager.persist(artist);
        entityManager.flush();

        Artist artistPersisted = entityManager.find(Artist.class, artist.getId());

        assertNotNull(artistPersisted);
        assertEquals("Test artist", artistPersisted.getSceneName());
        assertEquals("Real name", artistPersisted.getRealName());
    }
}
