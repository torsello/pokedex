# Pokedex Lite

A high-tech portable Java Aplication that Pokemon Trainers carry with them to record tokens of all the various Pokémon species they encounter during their journey as trainers.

## Running

Pokedex lite has two running types.

1. Execute on Docker-Compose path:
```bash
docker-compose up 
```
2. Running pokedexlite.jar
```bash
java -jar pokedexlite.jar
```

Then, execute INSERT.sql from /Database on Postgresdb
## Usage

Go to:
* http://localhost:8080/swagger-ui.html (Running local)\
or
* http://localhost:3000/swagger-ui.html  (Running on container)

```
Username: matias
password: 123456
```
Can be changed from application.properties and application-prod.properties
