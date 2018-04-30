# Prerequisites

## Persistence

1. You need a Postgres Instance and a database created.
1. You need to set the following environmental variables
    1. **DB_URL**: The url to the server
    1. **DB_PORT**: The port of the database
    1. **DB_NAME**: Database name
    1. **DB_USER**: Database username
    1. **DB_PASSWORD**: Database password

## Authentication

1. You should have an [Auth0](https://auth0.com/signup) account
    1. **AUTH0_DOMAIN**: The Auth0 domain
    1. **AUTH0_CLIENT_ID**: The Auth0 clientId
    1. **AUTH0_CLIENT_SECRET**: The Auth0 client secret

## AWS IAM

1. Create an IAM user
1. Create the following environmental variables
    1. **AMZN_ACCESS_KEY**: AWS Access Key
    1. **AMZN_SECRET_KEY**: AWS Secret Key