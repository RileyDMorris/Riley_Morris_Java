![Netflix](https://img.shields.io/badge/Netflix-E50914?style=for-the-badge&logo=netflix&logoColor=white)

Contributors

    Robert Velasquez
    Dickson Afful
    Riley Morris

# REST API Project

In this project, you will work with a team to build a REST API that provides a quote of the day, a word of the day, and Magic 8 Ball services. In addition, you will create a 1 to 3 minute video summary of the project.

## User Stories
- As an API user, I want to request a random quote so that I can expand my knowledge.
- As an API user, I want to request a random word and its definition so that I can expand my vocabulary.
- As an API user, I want to request a random answer to a question so that I can be entertained.

## Requirements
### General Setup and Format
- Your project must be created in an IntelliJ project named `Summative-1-Lastname-Firstname`.
- Your project must be built using Spring Boot and Spring MVC, initialized using start.spring.io.
- Your project must include a series of tests using MockMvc.
- Your project must use in-memory data.
- Your REST API must accept and return data in JSON format where appropriate.
- Your REST API must be documented using Swagger, with the .yaml file saved in the root of the project directory.

### Quote API
- URI: `/quote`
- Method: GET
- Request Body: None
- Response Body: Quote

The Quote model should include the following:
- id
- author
- quote

Your service must contain at least 10 quotes, served up at random.

### Word API
- URI: `/word`
- Method: GET
- Request Body: None
- Response Body: Definition

The Definition model should include the following:
- id
- word
- definition

Your service must contain at least 10 words and definitions, served up at random.

### Magic 8 Ball API
- URI: `/magic`
- Method: POST
- Request Body: Question
- Response Body: Answer

The POST request for the Magic 8 Ball endpoint should include a user-provided question. Note that you are not required to include any model validations for this project, so a response will still be returned even if the POST request does not include a question.

The Answer model should include the following:
- id
- question
- answer

### Video Summary
Create a 1 to 3 minute video summary of the project in MP4 format that includes screen-capture recordings to highlight important parts of the project.

## Grading Requirements

For this project, your grade will consist of a combination of general setup and format requirements and your actual code. Refer to the following criteria for more detailed information.

### General Setup and Format with Video Summary: 10%

- Your project must be created in an IntelliJ project called Summative-1-Lastname-Firstname.
- Your project must be built using Spring Boot and Spring MVC.
  - Initialize the project using start.spring.io.
- Your project must have a series of tests using MockMvc.
- Your project must use in-memory data that follows the pattern demonstrated previously in this module.
- Your REST API must accept and return data in JSON format where appropriate.
- Your REST API must be documented using Swagger.
  - Save the .yaml file in the root of the project directory.
- You must provide a 1 to 3 minute video summary of the project.

### Quote API: 30%

- The code is clean. (It follows general patterns as presented in class.)
- The Quote API provides a quote of the day service and must implement the following route:
  - URI: /quote
  - Method: GET
  - Request Body: None
  - Response Body: Quote
- The Quote model should include the following:
  - id
  - author
  - quote
- Your service must contain at least 10 quotes.
- The quotes must be served up at random.
- You must use MockMvc to test Quote API.

### Word API: 30%

- The code is clean. (It Follows general patterns as presented in class.)
- The Word API provides a word of the day service and must implement the following route:
  - URI: /word
  - Method: GET
  - Request Body: None
  - Response Body: Definition
- The Definition model should include the following:
  - id
  - word
  - definition
- Your service must contain at least 10 words and their corresponding definition.
- The words and definitions must be served at random.
- You must use MockMvc to test Word API.

# Magic 8 Ball API: 30%

## API Endpoint

- **URL**: `/magic`

- **Method**: `POST`

## API Parameters

- `question`: The question that you want to ask the Magic 8 Ball.

## API Response

- `answer`: A string that represents the answer to your question.


## Success Response

- Code: `200 OK`
- Content: The answer to your question, in the format specified in the API Response section.

## Error Response

- Code: `400 Bad Request`
- Content: An error message indicating that the question parameter is missing from the request.

# Video Showing Working Applicaion: 
- As the original video is over 3 minutes long, we have provided a sped up (1.5x) version to satisfy the requirements. However, the original video will be included also. 

3 minute video: https://github.com/fiifi-dev/summative-project-1-group-16/blob/master/3%20minute%20video%20-%201.5%20speed.mp4

5 minute video: https://github.com/fiifi-dev/summative-project-1-group-16/blob/master/5%20min%20video%20-%201.0%20speed.mp4


