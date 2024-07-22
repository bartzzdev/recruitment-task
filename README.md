# Recruitment task
## Overview
This application allows users to list all non-fork Github repositories
for a given username. For each repository, it provides the repository name,
owner login and branch information such as the branch name and the last commit SHA.

Technologies used: **Spring Boot 3, OpenFeign, JUnit 4, Lombok**

## Acceptance Criteria
### Sample request:
GET on `repositories/{username}`

### Sample response:
```json
[
  {
    "repositoryName": "Repository",
    "ownerLogin": "Owner",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "SHA"
      }
    ]
  }
]
```

### Error handling
In case of non-existing github username, the application should return 404 error in the response
handled in the following format:
```json
{
    "status": 404,
    "message": "Username not found"
}
```

## How to test it
The application runs on the default port 8080. 
Run the application and send a following sample request:\
GET on `localhost:8080/api/v1/repositories/{username}` where *username* is the github repositories owner.

### Sample response:
```json
{
    "repositories": [
        {
            "repositoryName": "LightParkour",
            "ownerLogin": "bartzzdev",
            "branches": [
                {
                    "name": "async-query",
                    "lastCommitSha": "3d204511d8c69e8f477d0325a6563f02283323a5"
                },
                {
                    "name": "develop",
                    "lastCommitSha": "4f2987835bdb950d955b6c2c1ccce4f0598c8b35"
                },
                {
                    "name": "master",
                    "lastCommitSha": "adb1fa45dc8815b1851829da8d6b66b7abea9a11"
                }
            ]
        }
    ]
}
```