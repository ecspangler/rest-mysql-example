Feature: Customer Field Validation

#==========================================================
Scenario Outline: Validate required Customer fields

Given I have a Customer with the following:
| Unique Id   | First Name   | Last Name   | Account Number   | Favorite Color   | 
| <Unique Id> | <First Name> | <Last Name> | <Account Number> | <Favorite Color> | 

When I validate the Customer

Then I expect the following validation errors:
| Error Code   | Error Description   | 
| <Error Code> | <Error Description> |

Examples:
| Unique Id | First Name | Last Name | Account Number   | Favorite Color  | Error Code | Error Description      | 
|           | Camile     | Kim       | 1111000011110000 | Red             | ERR001     | Missing Unique Id      |
| A00002    |            | Smith     | 1111000011110000 | Blue            | ERR002     | Missing First Name     |
| A00003    | Ashok      |           | 1111000011110000 | Green           | ERR003     | Missing Last Name      |
| A00004    | Maria      | Gomez     |                  | Yellow          | ERR004     | Missing Account Number |
| A00005    | Thomas     | Jones     | 1111000011110000 |                 |            |                        |


#==========================================================
Scenario: Validate required Customer fields

Given I have a Customer with the following:
| Unique Id | First Name | Last Name | Account Number   | Favorite Color  | 
|           | Camile     | Kim       | 1111000011110000 | Red             |

When I validate the Customer

Then I expect the following validation errors:
| Error Code   | Error Description         | 
| ERR001       | Missing Unique Id         |