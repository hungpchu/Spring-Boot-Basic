Link google:
1. ```https://docs.google.com/document/d/1RbD23EcdgEbEk4hVVcKyG6antK0F5cDfBKSfaUJHxMI/edit```


How to use:
1. Open the Postman
2. Hit the http://localhost:8080/api/signUp with post method and body of type json 
```
{
	"username":"hchu",
	"password":"123"
}
```
3 Hit the http://localhost:8080/login with post method and body of type form-data
```
username : hchu
password: 123

```
4 Hit the http://localhost:8080/api/random with post method and header with value
```
Authorization with the string return from step 3
```