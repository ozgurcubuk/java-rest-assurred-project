# Rest-assured Project
## Solution Overview

The project is written on **Java** platform with **Rest-assurred** framework along with **TestNG** framework. **Jackson Core** library is used in order to serialize/deserialize objects. Basically there are 3 packages named as; **body**, **request** and **response**.

Within **body** package we have a single and generic UserBody payload serializer. In order to make it generic @JsonInclude annotation is used in order to accept only set properties(properties those are *null* is not placed in serialized objects).

Within **request** package, @Test methods are placed. Each test classes located in **request** package extends RequestBase class which basically; initialize a RequestSpecification object and sets Content-Type and BaseUri

Within **response** package a single and generic UserReponse JSON de-serializer is placed. This de-serializer is used for all APIs those returns a response body.



## Test Cases
Create User(HappyPath)

Do Not Create User Without First Name

Do Not Create User Without Last Name

Do Not Create User Without User Name

Create User Without Password

Do Not Create With Alphanumeric First Name

Do Not Create With Alphanumeric Last Name

Do Not Create User With One Char First Name

Create User With Two Char First Name

Create User With Fifty Char First Name

Do Not Create User With Fiftyone Char First Name

Do Not Create User With One Char Last Name

Create User With Two Char Last Name

Create User With Fifty Char Last Name

Do Not Create User With Fiftyone Char Last Name

Do Not Create User With Three Char User Name

Create User With Four Char User Name

Create User With Twelve Char User Name

Do Not Create User With Thirteen Char User Name

Delete A User(HappyPath)

Do Not Delete A User With Non Existed UserId

Get A User(HappyPath)

Do Not Get A User With Non Existed User Id

Get User List

Patch A User Activity As True

Patch A User Activity As False

Do Not Patch A User Activity Without isActive Property

Do Not Patch A User Activity With Improper Type Of isActive Property Value

Update A User(HappyPath)

Do Not Update A User With Non-existed userId

Do Not Update A User Without First Name

Do Not Update A User Without Last Name

Do Not Update A User With One Char First Name

Update A User With Two Char First Name

Update A User With Fifty Char First Name

Do Not Update A User With Fiftyone Char First Name

Do Not Update A User With One Char Last Name

Update A User With Two Char Last Name

Update A User With Fifty Char Last Name

Do Not Update A User With Fiftyone Char Last Name

```