For starting the application you need to:

1. Create a DB in PostgreSQL with next parameters:
        		- DB url: jdbc:postgresql://localhost:5432/ads
        		- username: ads_user
        		- password: postgres

2. Add a role ads_user in PostgreSQL

CREATE ROLE ads_user LOGIN
ENCRYPTED PASSWORD 'md543f9a83f1b080a280bf7731fce10fb9a'
SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;

3. Ran a Tomcat server (I used v.8 and 9)

4. To login in a site please use these credentials:
        		 Login  | Password
        		 -----------------
        		- admin   admin
        		- user1   123
        		- user2   123
        		- user3   123