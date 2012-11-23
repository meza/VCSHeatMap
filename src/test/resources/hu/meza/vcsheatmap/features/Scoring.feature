Feature: Rules

  Scenario: one
    Given a history
      | file | user1 |
    Then the score is
      | file | 1 |

  Scenario: two
    Given a history
      | file1 | user1 |
      | file2 | user1 |
    Then the score is
      | file2 | 1 |

  Scenario: three
    Given a history
      | file1       | user1 |
      | file2       | user1 |
      | file2*file3 | user1 |
    Then the score is
      | file2 | 2 |
      | file3 | 1 |

  Scenario: other
    Given a history
      | file1 | user1 |
      | file1 | user2 |
    Then the score is
      | file1 | 4 |

  Scenario: other time
    Given a history
      | file1 | user1 |
      | file1 | user2 |
      | file2 | user1 |
    Then the score is
      | file1 | 3 |
      | file2 | 1 |

  Scenario: other time time
    Given a history
      | file1 | user1 |
      | file1 | user2 |
      | file2 | user1 |
      | file2 | user1 |
      | file2 | user1 |
    Then the score is
      | file2 | 3 |
      | file1 | 1 |
