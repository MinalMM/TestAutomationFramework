# TestAutomationFramework
Page Object Model/Page Chaining Model + Data Driven Framework + TestNG Framework

Maven Project dependencies- TestNG, Selenium, Allure, Aspectjweaver, Log4j, Apache POI API

Base Layer: TestBase => Driver initialization, reading properties, getting URL

Page Layer: TestBase, LoginPage, HomePage, ContactsPage, LogoutPage => Page factory or object repoistory and page actions are defined here

Test Layer: LoginPageTest, HomePageTest, ContactsPageTest, LogoutPageTest => TestNG annotations are used, respective page methods are called for testingg

Environment variables: config.properties => URL, credentials, browser

Util: TestUtil => Generic functions- screenshot()

Test Data: TestDataForAutomation.xlsx

Test report: Allure listener is used and from commandline report is generated

Resources: testngSuite.xml => To run all clases one by one in one go
