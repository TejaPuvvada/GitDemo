Feature: place the order for products

@PlaceOrder
Scenario Outline: Search experience for products on both home and offers page

Given user is on Green Cart landing page
When user searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to the cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom |
