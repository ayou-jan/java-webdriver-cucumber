@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    And I wait for 5 sec
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

    @predefined2
    Scenario: Predefined steps for Yahoo
      Given I open url "https://www.yahoo.com/"
      Then I should see page title as "Yahoo"
      Then element with xpath "//input[@id='header-search-input']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='header-search-input']"
      And I click on element with xpath "//button[contains(@id,'search-button')]"
      Then I wait for element with xpath "//*[@id='web']" to be present
      Then element with xpath "//*[@id='web']" should contain text "cucumber"

    @predefined3
    Scenario: Predefined steps for Bing
      Given I open url "https://www.bing.com/"
      Then I should see page title as "Bing"
      Then element with xpath "//input[@id='sb_form_q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
      And I click on element with xpath "//label[@class='search icon tooltip']//*[local-name()='svg']"
      Then I wait for element with xpath "//ol[@id='b_results']" to be present
      Then element with xpath "//ol[@id='b_results']" should contain text "cucumber"

    @predefined4
    Scenario: Predefined steps for Gibiro
      Given I open url "https://gibiru.com/"
      Then I should see page title contains "Gibiru"
      Then element with xpath "//input[@name='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
      And I click on element with xpath "//button[@id='button-addon2']"
      Then I wait for element with xpath "//div[@class='gsc-wrapper']" to be present
      Then element with xpath "//div[@class='gsc-wrapper']" should contain text "cucumber"

    @predefined6
    Scenario: Predefined steps for Swisscows
      Given I open url "https://swisscows.com/"
      Then I should see page title contains "Swisscows"
      Then element with xpath "//input[@name='query']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
      And I click on element with xpath "//button[@class='search-submit']"
      Then I wait for element with xpath "//div[@class='web-results']" to be present
      Then element with xpath "//div[@class='web-results']" should contain text "cucumber"

      @predefined8
  Scenario: Predefined steps for Startpage1
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage.com - The world's most private search engine"
    And element with xpath "//*[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@id='q']"
    And I click on element with xpath "//*[@class='search-form-home__form__button']"
    And I wait for element with xpath "//*[@class='show-results']" to be present
    And I wait for 2 sec
    Then element with xpath "//*[@class='show-results']" should contain text "cucumber"

    @predefined10
    Scenario: Predefined steps for Boardreader
      #In this search machine no results for "Behavior Driven Development", so I used BDD
      Given I open url "https://boardreader.com/"
      Then I should see page title contains "Boardreader"
      Then element with xpath "//input[@id='title-query']" should be present
      When I type "BDD" into element with xpath "//input[@id='title-query']"
      And I click on element with xpath "//button[@id='title-submit']"
      Then I wait for element with xpath "//li[@class='mdl-list__item']" to be present
      Then element with xpath "//li[@class='mdl-list__item']" should contain text "BDD"

    @predefined11
    Scenario: Responsive UI
      Given I open url "http://skryabin.com/market/quote.html"
      And I resize window to 1280 and 1024
      Then element with xpath "//b[@id='location']" should be displayed
      And I resize window to 800 and 1024
      Then element with xpath "//b[@id='location']" should be displayed
      And I resize window to 400 and 1024
      Then element with xpath "//b[@id='location']" should not be displayed

    @predefined12
    Scenario: Min lenght
      Given I open url "http://skryabin.com/market/quote.html"
      When I type "a" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//*[@id='username-error']" should be displayed
      When I type "b" into element with xpath "//input[@name='username']"
      Then element with xpath "//*[@id='username-error']" should not be displayed

    @predefined13
    Scenario: Valid Email
      Given I open url "http://skryabin.com/market/quote.html"
      When I type "a" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//input[@name='password']"
      Then element with xpath "//label[@id='email-error']" should be displayed
      And I clear element with xpath "//input[@name='email']"
      When I type "a@f" into element with xpath "//input[@name='email']"
      And I wait for 2 sec
      And I click on element with xpath "//input[@name='password']"
      Then element with xpath "//label[@id='email-error']" should not be displayed

     @predefined14
     Scenario: ConfirmPass just after Pass
       Given I open url "http://skryabin.com/market/quote.html"
       Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"
       When I type "a" into element with xpath "//input[@id='password']"
       Then element with xpath "//input[@id='confirmPassword']" should not have attribute "disabled" as "true"
       When I clear element with xpath "//input[@id='password']"
       Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"

     @predefined15
     Scenario: nameDialog
       Given I open url "http://skryabin.com/market/quote.html"
       When I click on element with xpath "//input[@id='name']"
       Then element with xpath "//div[@id='nameDialog']" should be displayed
       When I type "a" into element with xpath "//input[@id='firstName']"
       And I type "b" into element with xpath "//input[@id='middleName']"
       And I type "c" into element with xpath "//input[@id='lastName']"
       And I click on element with xpath "//button[@type='button']/span[text()='Save']"
       Then element with xpath "//input[@id='name']" should have attribute "value" as "a b c"

    @predefined16
    Scenario: Privacy Policy Required
      Given I open url "http://skryabin.com/market/quote.html"
      Then element with xpath "//input[@name='agreedToPrivacyPolicy']/.." should have attribute "aria-required" as "true"
      Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"

    @predefined18
    Scenario: Submit the form and verify the data
      Given I open url "http://skryabin.com/market/quote.html"
      When I type "ab" into element with xpath "//input[@name='username']"
      And I type "a@f" into element with xpath "//input[@name='email']"
      And I type "12345" into element with xpath "//input[@id='password']"
      And I type "12345" into element with xpath "//input[@id='confirmPassword']"
      And I type "St st" into element with xpath "//input[@id='name']"
      And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//legend[@class='applicationResult']" should be displayed
      And element with xpath "//span[text()='Password']/../b" should contain text "entered"














