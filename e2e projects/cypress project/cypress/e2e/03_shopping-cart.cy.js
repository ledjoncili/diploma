describe('Sauce Demo E2E Tests', () => {
    beforeEach(() => {
        cy.login('standard_user', 'secret_sauce')
        // Verify that the user is on the product overview page
        cy.url().should('include', '/inventory.html')
    })

    it('should add an item to the cart and verify details', () => {
        // List of products is shown
        cy.get('.inventory_item').should('have.length', 6)

        // Product name to be added to the cart
        const productName = 'Sauce Labs Backpack'

        // Find the "Add to cart" button based on the product name
        cy.contains('.inventory_item_name', productName)
            .parents('.inventory_item')
            .find('.btn_inventory')
            .click()

        // No 1 pops up in the shopping cart icon on top right
        cy.get('.shopping_cart_badge').should('have.text', '1')

        // User clicks shopping cart icon
        cy.get('.shopping_cart_link').click()

        // Added item is listed in the cart
        cy.get('.cart_item').should('have.length', 1)

        // Verify details of the added item
        cy.get('.cart_item').within(() => {
            cy.get('.inventory_item_name').should('have.text', productName)
            cy.get('.inventory_item_price').should('have.text', '$29.99')
        })

        // User clicks remove button
        cy.get('.cart_item')
            .contains('button', 'Remove')
            .click()

        // Item is removed from shopping cart
        cy.get('.cart_item').should('not.exist')

        // User clicks continue shopping button
        cy.contains('button', 'Continue Shopping').click()

        // Products overview page is opened
        cy.url().should('include', '/inventory.html')

        // User adds to cart Sauce Labs Bike Light
        cy.contains('.inventory_item_name', 'Sauce Labs Bike Light')
            .parents('.inventory_item')
            .find('.btn_inventory')
            .click()

        // User clicks on shopping cart icon
        cy.get('.shopping_cart_link').click()

        // Product is shown in the list
        cy.get('.cart_item').should('have.length', 1)
            .should('contain', 'Sauce Labs Bike Light')
    })
})
