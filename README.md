# Kloeckner Assistant System Acceptance tests

This project is the System Acceptance Tests for Kloeckner Assistant.

## System Dependencies

* [Node.js](http://nodejs.org/) (with NPM 4)
* [Puppeteer](https://pptr.dev/)
* [Jest](https://jestjs.io/)
* [Yarn](https://yarnpkg.com)

## Getting Started
In order to run SAT tests, you should first export all global variables locally for example in [`local_environment.sh`] file.
The following variables need to be set:
- **ACCEPTANCE_TEST_URL**
- **SEND_MAIL_URL**
- **DOCPARSER_CALLBACK_URL**
- **BASICAUTH_USERNAME** and **BASICAUTH_PASSWORD**
- **BASICAUTH_USERNAME_X12** and **BASICAUTH_PASSWORD_X12**

 Then, you can run:
```bash
$ source local_environment.sh
$ yarn install
$ yarn test
```

System Acceptance Tests are triggered automatically after each push in Review or Integration environment.

SATs include end to end test which goes through:
1- Sending email with attachment and checking order reception in KA after 10 sec.
2- Receiving Docparser response and verifying that KA contains the correct data.
3- Approving order and checking X12 file content.

<!-- ## Running tests -->

## Linting
Execute ESLint using the following command:
```bash
$ yarn lint
```
## reports
├── **assistant_sat.xml** : A test suite file containing all test cases with number of failures and execution time.  
├── **network.har** :  We are using puppeteer-har that generates HAR file (HTTP Archive) to track and export captured data of web browser's interaction with KA.  
└── **screenshots**  
&emsp;&emsp;└── screenshot*.png :  A screenshot is generated at the end of each test case.


<!-- ## Code Coverage -->
<!-- ## Deployment -->
