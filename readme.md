### project navi/info

`src/main/kotlin/com.coded.spring.ordering` is where all the packages are

`controller` → `service` (→ `dtos`) → `repository` → `entity`

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
- register user (username & password)
- list accounts
- create new/multiple accounts
- close account
- transfer money to other account
- get user kyc info
- create or update kyc info

### progress
- #### ultimate goal is to catch up!!!!
- [x] exercise 1: welcome (bonus done)
- [x] exercise 2: endpoint to `POST` order
  - [ ] do bonus
    - tried and failed because i didn't know about dtos yet
- [X] exercise 3: create + connect db
  - [ ] do bonus
    - might have to delete and remake dbs?
    - im not good at altering tables ;-;
- [ ] exercise 4: user authentication
- [ ] exercise 5: user profiles
- [ ] exercise 6: unit testing