# FileShare
This application can share files such as images over the network using a custom protocol.

# Running
1. Install maven, the package manager
1. `cd path/to/FileShare`
1. run the command `mvn package`
    - This command may take a while the first time it is run
1. `java -cp target/FileShare-1.jar com.adam.FileShare.App`

# Network Protocol
This app uses a cutom protocol over TCP.

## Summary Table
|Name|Description|
|-----------|-------------------|
|`FILE`|A file provided to the client or server|
|`GET-FILE`|A request for a file|
|  |  |
|`LIST`|List all files available|
|`AVAILABLE`|List all available files|
|  |  |
|`ERR`|A error, this should be written to a log|
|`MSG`|Display a message to the user|
|  |  |
|`GET-VER`|A request to get the version of the application|
|`VER`|The response to `GET-VER`|

## Syntax
All lines are delimited by `\n`
#  
### `LIST` and `AVAILABLE`
Request:
>LIST

Sample Response:
>AVAILABLE  
>photos/ex1.png  
>photos/ex2.png  
#  
### `FILE` and `GET-FILE`
Request:
>GET-FILE  
>photos/ex1.png  

Sample Response:
>FILE  
>photos/ex1.png  
>1024 {{SIZE IN BYTES}}  
>{{FILE CONTENT}}sdafjklhskldafkhdasfkhldsafjk  
>dskajlfhkldsafhklsdahfkjlhsdaklfhksjldfhdskla

#  
### `GET-VER` and `VER`
Request:
>GET-VER    

Response:
>VER  
>{{String Denoting Client}}  
>{{String Denoting Version}}  
>{{Quick Blurb goes here...}}  

#  
### `ERR` and `MSG`

Request:
>ERR  
>2 {{Number of lines}}  
>Error line 1  
>Error line 2  

Request
>MSG  
>1  
>You cannot access this server.  