Feature: Search on Booking.com

  Scenario Outline: Search by city criteria
    Given User is looking for '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page
    And Rating of the hotel '<Hotel>' is '<Rating>'

    Examples:
      | City  | Hotel                      | Rating |
      | Minsk | DoubleTree by Hilton Minsk | 9.2    |
      | Brest | Hampton by Hilton Brest    | 9.3    |