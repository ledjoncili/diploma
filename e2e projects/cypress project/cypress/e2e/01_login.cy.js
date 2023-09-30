describe('Identifikimi dhe Hyrja e Përdoruesit', () => {
    it('01.1 - should display an error message for wrong credentials', () => {
        cy.visit('https://www.saucedemo.com/', { retryOnStatusCodeFailure: true, retryOnNetworkFailure: true });

        // Enter the username
        cy.get('#user-name').type('test')

        // Enter the password
        cy.get('#password').type('password')

        // Click the login button
        cy.get('#login-button').click()

        // Assert that the error message is displayed
        cy.get('h3[data-test="error"]').should('contain', 'Epic sadface: Username and password do not match any user in this service') // Replace selector with the appropriate selector for the error message container and adjust the expected error message if necessary
    })


    it('01.2 - Successful Login', () => {
        cy.visit('https://www.saucedemo.com/', { retryOnStatusCodeFailure: true, retryOnNetworkFailure: true });

        // Enter the username
        cy.get('#user-name').type('standard_user')

        // Enter the password
        cy.get('#password').type('secret_sauce')

        // Click the login button
        cy.get('#login-button').click()

        // Assert that the user is redirected to the home page
        cy.url().should('include', '/inventory.html')
    })

    it('01.3 - should display the login page after logging out', () => {
        cy.visit('https://www.saucedemo.com/', { retryOnStatusCodeFailure: true, retryOnNetworkFailure: true });

        // Enter the username
        cy.get('#user-name').type('standard_user')

        // Enter the password
        cy.get('#password').type('secret_sauce')

        // Click the login button
        cy.get('#login-button').click()

        // Assert that the user is redirected to the home page
        cy.url().should('include', '/inventory.html')
    
        // Open the menu
        cy.get('#react-burger-menu-btn').click()
    
        // Click on the Logout button
        cy.get('#logout_sidebar_link').click()
    
        // Assert that the login page is displayed
        cy.url().should('eq', 'https://www.saucedemo.com/')
      })
})
