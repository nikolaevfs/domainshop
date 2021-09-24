# Summary
The project is a search tool, looking for an available domain name and price.

## Definition of done
* all the tests are green
* `mvn clean package` completes successfully

## Description
A user submits a `GET` query to search for an available domain name.
The system checks domain availability across all supported TLD zones _(.com .net .club)_ and returns the registration fee for each domain.

A domain is available for registration if there is no corresponding record in the `domains` table.

Registration fee is stored in the `tlds` table for each top level domain.

### Request format and example
`/domains/available?name=foo`

### Response format
```
[
  {
    domain: string,
    tld: string,
    available: boolean,
    price: decimal
  }
]
```

### Response example
```
[
  { "domain": "foo.com",  tld: "com",  "available": false, "price":  8.99 },
  { "domain": "foo.net",  tld: "net",  "available": true,  "price":  9.99 },
  { "domain": "foo.club", tld: "club", "available": true,  "price": 15.99 }
]
```

## Bonus points
* there is a commit history reflecting the development progress
* custom sorting order _(e.i. ascending or descending)_
* custom sorting field _(e.g. by price or by tld)_
* optional filter _(e.g. price range or tld list)_
* more tests
