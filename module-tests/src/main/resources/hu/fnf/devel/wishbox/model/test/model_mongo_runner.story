Feature: Model mongodb implementation library

  Scenario Outline: MongoDB library tests
    Given a started REST Service with the library and a mondogdb uploaded with test data
    When a REST <action> with <path> with <payload> is initiated
    Then a <response> is received
    Examples:
      | action | path              | payload                                | response           |
      | GET    | /wish           |                                        | List<Wish>         |
      | GET    | /notification   |                                        | List<Notification> |
      | POST   | /wish/1         | {label:"",events:[], notifications:[]} |                    |
      | POST   | /notification/1 | {}                                     |                    |
