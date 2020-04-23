#language:en 

Feature: List item Post

    Background: Use endpoint posts
        Given use endpoint posts

    Scenario: List all itens Post
        When ready all Post item
        Then I view all Post items