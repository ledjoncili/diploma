describe('Sauce Demo E2E Tests', () => {
    beforeEach(() => {
        cy.login('standard_user', 'secret_sauce')
        // Verify that the user is on the product overview page
        cy.url().should('include', '/inventory.html')
    })
  
    it('should perform the checkout process', () => {
      // User navigates to home page
      cy.url().should('include', '/inventory.html')
  
      // User clicks Add to cart button for Sauce Labs Backpack
      cy.contains('.inventory_item_name', 'Sauce Labs Backpack')
        .parents('.inventory_item')
        .find('.btn_inventory')
        .click()
  
      // User clicks shopping cart icon
      cy.get('.shopping_cart_link').click()
  
      // User navigates to shopping cart
      cy.url().should('include', '/cart.html')
  
      // Item is in the cart
      cy.get('.cart_item').should('have.length', 1)
  
      // User clicks checkout button
      cy.contains('button', 'Checkout').click()
  
      // Checkout page is opened
      cy.url().should('include', '/checkout-step-one.html')
  
      // User clicks cancel
      cy.contains('button', 'Cancel').click()
  
      // User is redirected back on shopping cart page
      cy.url().should('include', '/cart.html')
  
      // User clicks again Checkout
      cy.contains('button', 'Checkout').click()
  
      // Checkout page is opened
      cy.url().should('include', '/checkout-step-one.html')
  
      // User fills the form information
      cy.get('#first-name').type('John')
      cy.get('#last-name').type('Doe')
      cy.get('#postal-code').type('12345')
  
      // User clicks continue
      cy.get('#continue').click()
  
      // Checkout details are shown
      cy.url().should('include', '/checkout-step-two.html')
  
      // User clicks on finish button
      cy.contains('button', 'Finish').click()
  
      // Successful order page is shown
      cy.url().should('include', '/checkout-complete.html')
      cy.contains('.complete-header', 'Thank you for your order!')
    })
  })
  