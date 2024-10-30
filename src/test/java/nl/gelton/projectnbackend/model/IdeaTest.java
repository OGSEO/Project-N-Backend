package nl.gelton.projectnbackend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdeaTest {

    @Test
    void shouldHaveTitle() {

        //Arrange
        Idea idea = new Idea();

        //Act
        idea.setTitle("Title");

        //Assert
        assertEquals("Title", idea.getTitle());

    }

}