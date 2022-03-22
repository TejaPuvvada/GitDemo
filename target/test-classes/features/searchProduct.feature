Feature: Search and place the order for products

@OffersPage
Scenario Outline: Search experience for products on both home and offers page

Given user is on Green Cart landing page
When user searched with shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page
And validate name in offers page matches with landing page

Examples:
| Name |
| Tom |
| Beet |