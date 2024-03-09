# Github Repository API

This Spring Boot application which consumes Github API to list public repositories for a given user.

API used:  https://developer.github.com/v3

## API Endpoint

### GET /repositories/{username}

This endpoint retrieves a list of GitHub repositories for the specified `username`. The response includes the repository
name, owner's login, and branches information.

### Request Parameters

- `username` (path variable): GitHub username for which repositories are to be listed.

##### Sample Request

###### GET /repositories/iamruppert

##### Sample Request Response Body

```yaml
[
    {
        "Repository Name": "iamruppert",
        "Owner Login": "iamruppert",
        "Branches": [
            {
                "name": "master",
                "last_commit_sha": "d577fb3cc1bef56bdafccdf13ed33d445adcf6cc"
            }
        ]
    },
    {
        "Repository Name": "offers-forum-app-backend",
        "Owner Login": "iamruppert",
        "Branches": [
            {
                "name": "master",
                "last_commit_sha": "a8ca34783534766836852920e012abeb3a1f4ae4"
            }
        ]
    },
    {
        "Repository Name": "offers-forum-app-front",
        "Owner Login": "iamruppert",
        "Branches": [
            {
                "name": "master",
                "last_commit_sha": "c8a126c196640dc253955539435127040c878a60"
            }
        ]
    },
    {
        "Repository Name": "statistics-app-backend",
        "Owner Login": "iamruppert",
        "Branches": [
            {
                "name": "master",
                "last_commit_sha": "02960c4f5ac1df3c7f84e232206a81df45eec0d2"
            }
        ]
    }
]
```

##### Exception handling

Application provides error handing logging using slf4j.
Error codes handled by are described below:

* `error 404` - endpoint throws 404, if username was not found on github
* `error 400` - endpoint throws 400 in situation, when user made bad request

###### error response body

```yaml
{
    “status”: ${responseCode}
    “message”: ${whyHasItHappened}
}
```