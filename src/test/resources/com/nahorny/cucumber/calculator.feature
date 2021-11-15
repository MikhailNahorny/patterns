Feature: Calculator
 @my_second_tag @my_first_tag
  Scenario Outline: Power of number
      Given one number <a>
      When we try to find pow of the number
      Then result should be <result>

    Examples:
    | a | result  |
    | 3 | 9       |

@my_first_tag
  Scenario Outline: Sum of the two numbers
    Given two numbers <a> and <b>
    When we try to find sum of our numbers
    Then result should be <result>

  Examples:
  | a | b | result  |
  | 3 | 2 | 5       |
  | 0 | 2 | 2       |
  |-2 | -2| -4      |
  |2 | -2 | 0       |
  |-2 | 2 | 0       |

@my_second_tag
 Scenario Outline: Power of number
     Given one number <a>
     When we try to find pow of the number
     Then result should be <result>

   Examples:
   | a | result  |
   | 3 | 9       |
   | -2| 4       |


