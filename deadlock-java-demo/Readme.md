# Problem Statement

Try to hit deadlock in database by creating multiple sessions and inducing circular dependency

docker run --name pg-deadlock-demo \
-e POSTGRES_PASSWORD=postgres \
-e POSTGRES_DB=lockdb \
-p 5432:5432 \
-d postgres:16
