### project navi/info

`src/main/kotlin/com.coded.spring.ordering` is where all the packages are

`dtos` ←→ `controller` → `service` → `repository` → `entity`

`controller` = entry point for http requests (receive requests, process data, determine response)
- `GET`: retrieve data from a server
- `POST`: send data to the server to create a new resource
- `PUT`: update or replace an existing resource
- `DELETE`: remove a resource from the server

`service` = business logic (processes data, makes decisions, eg: save order)

`repository` = database operations (handles communication with db: save, find, delete)

`entity` = domain model (defines what your data is in the system: fields, relationships)

`dto` = data transfer object (cleans request/response json bodies, to avoid returning entities)

### services
- welcome page
- list all orders
- create new order

### progress
#### ultimate goal is to catch up!!!!
- [x] exercise 1: welcome
  - [x] bonus: checked with `curl` command
- [x] exercise 2: endpoint to `POST` order
  - [x] bonus: add `createdAt` column and sort
- [X] exercise 3: create + connect db
  - [x] bonus: create `items` table and connect it to `orders`
- [x] exercise 4: user authentication
  - [ ] bonus: password validation so people can't create a weak password 
    - longer than or equal to 6 letters
    - at least 1 capital letter
    - at least 1 number
- [ ] exercise 5: user profiles
  - [ ] bonus: 
- [ ] exercise 6: unit testing
  - [ ] bonus: 
- [ ] exercise 7: menu endpoint
  - [ ] bonus: 
- [ ] exercise 8: configuration
  - [ ] bonus: 
- [ ] exercise 9: setup swagger
  - [ ] bonus: 
- [ ] exercise 10: refactor to micro services
  - [ ] bonus: 