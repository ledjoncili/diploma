describe('02 - Listo dhe filtro produktet', () => {
    it('02.1 - should navigate to product details page and return to product overview page', () => {
        cy.login('standard_user', 'secret_sauce')

        // Verify that the user is on the product overview page
        cy.url().should('include', '/inventory.html')

        // Click on the first product item
        cy.get('.inventory_item_img').first().click()

        // Verify that the user is on the product details page
        cy.url().should('include', '/inventory-item.html')

        // Verify the details of the product (e.g., name, description, price, etc.)
        cy.get('.inventory_details_name').should('be.visible')
        cy.get('.inventory_details_price').should('be.visible')

        // Click on the "Back to products" button
        cy.get('.inventory_details_back_button').click()

        // Verify that the user is back on the product overview page
        cy.url().should('include', '/inventory.html')
    })

    it('02.2 - should sort products by price (low to high)', () => {
        cy.login('standard_user', 'secret_sauce')

        // Verify that the user is on the product overview page
        cy.url().should('include', '/inventory.html')

        // Select "Price (low to high)" option from the filter dropdown
        cy.get('.product_sort_container').select('lohi')

        // Verify that the products are sorted by price (low to high)
        cy.get('.inventory_item_price')
            .then(($prices) => {
                const prices = $prices.map((_, el) => parseFloat(el.innerText.replace('$', ''))).toArray()
                const sortedPrices = [...prices].sort((a, b) => a - b)
                expect(prices).to.deep.equal(sortedPrices)
            })
    })
})
