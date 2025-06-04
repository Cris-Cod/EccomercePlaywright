Feature: Validate products

  @validateDetailP
  Scenario: Verify All Products and product detail page
    Given user enter the e-commerce page
    When user selects new option to create a "Products"
    And user selects the "firts" product
    Then Verify that detail detail is visible: product name, category, price, availability, condition, brand

  @searchProduct
  Scenario: Search Product
    Given user enter the e-commerce page
    When user selects new option to create a "Products"
    And  user enters "product name" in search input and click search button
    Then verify "SEARCHED PRODUCTS" is visible

  @addProductsCart
  Scenario: Add Products in Cart
    Given user enter the e-commerce page
    When user selects new option to create a "Products"
    And  user Hover over 'first' product and click Add to cart
    And  user clicks Continue Shopping button
    And  user Hover over second 'second' product and click Add to cart
    And  user clicks View Cart button
    Then user verifies both products are added to Cart and verify their "prices", "quantity" and "total price"