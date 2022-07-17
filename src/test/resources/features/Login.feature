Feature: Hepsiburada Case Study

  @Smoke
  Scenario: Login with email address
    * User navigates to home page
    * User enters "email_input" to input and clicks login button
    * User enters "password_input" to input and clicks password button
    * User should be logged in

  @Smoke
  Scenario: Login with phone number
    * User navigates to home page
    * User enters "phone_input" to input and clicks login button
    * User enters "otp_input" to input and clicks otp button
    * User should be logged in

  @Smoke
  Scenario: Login with gmail account
    * User navigates to home page
    * User clicks gmail button
    * User enters "password_input" to input and clicks merge button
    * User should be logged in

  @Smoke
  Scenario: Login with gmail account without merging
    * User navigates to home page
    * User clicks gmail button
    * User clicks continue button
    * User enters "gmail_input" to input and clicks login button
    * User enters "password_input" to input and clicks password button
    * User should be logged in

  @Smoke
  Scenario: Login with apple account
    * User navigates to home page
    * User clicks apple button
    * User enters "apple_input" to input and clicks button
    * User enters "password_input" to input and clicks button
    * User should be logged in

  @Smoke
  Scenario: Login with apple account
    * User navigates to home page
    * User clicks apple button
    * User enters "apple_input" to input and clicks button
    * User enters "password_input" to input and clicks button
    * User should be logged in

  @Negative
  Scenario: Login with email which is not registered
    * User navigates to home page
    * User enters "wrong_email" to input and clicks "email_button" button
    * Error alert should be appeared for wrong email address

  @Negative
  Scenario: Login with email which is not valid
    * User navigates to home page
    * User enters "blank_email" to input and clicks login button
    * Error placeholder should be appeared

  @Negative
  Scenario: Login with wrong password
    * User navigates to home page
    * User enters "email_input" to input and clicks login button
    * User enters "wrong_password" to input and clicks login button
    * Error placeholder should be appeared for wrong password

  @Negative
  Scenario: Login with wrong phone number
    * User navigates to home page
    * User enters "wrong_phone" to input and clicks login button
    * Error alert should be appeared for wrong phone number

  @Negative
  Scenario: Login with wrong otp
    * User navigates to home page
    * User enters "phone_input" to input and clicks login button
    * User enters "wrong_otp" to input and clicks otp button
    * Error alert should be appeared for wrong otp code