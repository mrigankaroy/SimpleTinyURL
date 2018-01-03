# SimpleTinyURL

# Create TinyURL
HTTP Method: POST

URL : /createTinyURL

Content-Type : application/json

Request Body : 
```json
{"originalURL":"https://github.com/mrigankaroy/SimpleTinyURL"}
```
Response Body:
```json
{
    "id": "5a4cb825e4b0fece3d734e4a",
    "tinyUrl": "DXUQvDr",
    "originalURL": "https://github.com/mrigankaroy/SimpleTinyURL"
}
```
# Use TinyURL
HTTP Method: GET
URL : /tinyUrl 
```text
Our example http:\\domain\DXUQvDr will redirect us to https://github.com/mrigankaroy/SimpleTinyURL
```
