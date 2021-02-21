Feature: Search on Booking.com

  Scenario: Search by city criteria
    Given User is looking for 'Minsk' city
    When User does search
    Then Hotel 'DoubleTree by Hilton Minsk' should be on the first page
    And Rating of the hotel 'DoubleTree by Hilton Minsk' is '9.2'

  Scenario: Search by city criteria
    Given User is looking for 'Brest' city
    When User does search
    Then Hotel 'Hampton by Hilton Brest' should be on the first page
    And Rating of the hotel 'Hampton by Hilton Brest' is '9.3'