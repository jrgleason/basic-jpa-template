# Prerequisites

## Persistence

1. You need a Postgres Instance and a database created.
1. You need to set the following environmental variables.
  2. **DB_URL**: The url to the server
  2. **DB_PORT**: The port of the database
  2. **DB_NAME**: Database name
  2. **DB_USER**: Database username
  2. **DB_PASSWORD**: Database password

## Authentication

1. You should have an [Auth0](https://auth0.com/signup) account.
        2. **AUTH0_DOMAIN**: The Auth0 domain
        2. **AUTH0_CLIENT_ID**: The Auth0 clientId
        2. **AUTH0_CLIENT_SECRET**: The Auth0 client secret

## AWS IAM

1. Create an IAM user
1. Create the following environmental variables

        2. **AMZN_ACCESS_KEY**: AWS Access Key
  2. **AMZN_SECRET_KEY**: AWS Secret Key