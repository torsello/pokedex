/* Trainers */
INSERT INTO public.trainer (trainer_id , trainer_name, trainer_pass) VALUES ( '42bf3e197adb449ba6c9020890dd278e' , 'Ash', '123456' );
INSERT INTO public.trainer (trainer_id , trainer_name, trainer_pass) VALUES ( '713dc0f4ff0b4c0cb467de92a36f7f5a' , 'Misty', '123456' );

/* Pokemons */
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('b75c1e05d2b14c67b280f66a013f7be4',16,'Bulbasaur',null);
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('41dd053b3f3e4ee582ff7d8cc3fdc7c6',32,'Ivysaur','b75c1e05d2b14c67b280f66a013f7be4');
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('e12ade90aabd467aba97b48bf0919c42',0,'Venusaur','41dd053b3f3e4ee582ff7d8cc3fdc7c6');
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('ce3cfb8f56ed4437b3f6d11bb13b81b1',16,'Charmander',null);
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('55bbcd3d108a46c5bca34300d82e52c5',36,'Charmeleon','ce3cfb8f56ed4437b3f6d11bb13b81b1');
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('846a339de16943eb9cba6cf74430d6e9',0,'Charizard','55bbcd3d108a46c5bca34300d82e52c5');
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('271e2ec877b04ca6a97d3801018d3b44',16,'Squirtle',null);
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('b2d356c20dea4fd5b73c5ede37ea2a46',36,'Wartortle','271e2ec877b04ca6a97d3801018d3b44');
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('488eb110000349029a0774c7b7fcd199',0,'Blastoise','b2d356c20dea4fd5b73c5ede37ea2a46');
INSERT INTO public.pokemon (pokemon_id, evolve_lvl, name, evolves_from_id) VALUES ('f133d2f2b4c84acbb8326d7f2a2a28ad',7,'Caterpie',null);

/* Abilities */
INSERT INTO public.ability ( ability_id , ability) VALUES ( 'fa2f78fe181c46de8103bfee008dc63a' , 'Poison Touch' );
INSERT INTO public.ability ( ability_id , ability) VALUES ( '27e75711b04a4b55a738d9c3ead4c52b' , 'Poison Heal' );
INSERT INTO public.ability ( ability_id , ability) VALUES ( '391ba76c5ecf4520af9061a85742533a' , 'Blaze' );
INSERT INTO public.ability ( ability_id , ability) VALUES ( '89fbfd4b6db246128f57eb29aeeb1a94' , 'Flash Fire' );
INSERT INTO public.ability ( ability_id , ability) VALUES ( '21201deafd084a3982340dbf8d210d41' , 'Water Bubble' );
INSERT INTO public.ability ( ability_id , ability) VALUES ( 'f3e2f53d82354b4d959cf94399b40db4' , 'Water Veil' );

/* Types */
INSERT INTO public.type ( type_id, type) VALUES ( '463d712daa1b45fab7157d1599677b62' , 'Grass' );
INSERT INTO public.type ( type_id, type) VALUES ( 'c5d91ec0aedc499f91cdda0b3845d1a9' , 'Poison' );
INSERT INTO public.type ( type_id, type) VALUES ( '1c794cac1ccb486ba9e2c97b0f44f6f6' , 'Fire' );
INSERT INTO public.type ( type_id, type) VALUES ( '1ab653b02760477294cc2678f3a17019' , 'Flying' );
INSERT INTO public.type ( type_id, type) VALUES ( '32fffed6da7d4bb4a5441bb4dda097eb' , 'Water' );
INSERT INTO public.type ( type_id, type) VALUES ( '74c70a2d9485460eb0b0a28a8ca774a0' , 'Bug' );

/* TrainersPokemons */
INSERT INTO public.trainers_pokemons ( founded_lvl , pokemon_pokemon_id, trainer_trainer_id) VALUES (10, '271e2ec877b04ca6a97d3801018d3b44' , '42bf3e197adb449ba6c9020890dd278e');
INSERT INTO public.trainers_pokemons ( founded_lvl , pokemon_pokemon_id, trainer_trainer_id) VALUES (9, 'b75c1e05d2b14c67b280f66a013f7be4' , '42bf3e197adb449ba6c9020890dd278e');
INSERT INTO public.trainers_pokemons ( founded_lvl , pokemon_pokemon_id, trainer_trainer_id) VALUES (11, 'f133d2f2b4c84acbb8326d7f2a2a28ad' , '713dc0f4ff0b4c0cb467de92a36f7f5a');
INSERT INTO public.trainers_pokemons ( founded_lvl , pokemon_pokemon_id, trainer_trainer_id) VALUES (12, 'ce3cfb8f56ed4437b3f6d11bb13b81b1' , '713dc0f4ff0b4c0cb467de92a36f7f5a');

/* PokemonAbilities */
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'b75c1e05d2b14c67b280f66a013f7be4' , 'fa2f78fe181c46de8103bfee008dc63a');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'b75c1e05d2b14c67b280f66a013f7be4' , '27e75711b04a4b55a738d9c3ead4c52b');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '41dd053b3f3e4ee582ff7d8cc3fdc7c6' , 'fa2f78fe181c46de8103bfee008dc63a');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '41dd053b3f3e4ee582ff7d8cc3fdc7c6' , '27e75711b04a4b55a738d9c3ead4c52b');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'e12ade90aabd467aba97b48bf0919c42' , 'fa2f78fe181c46de8103bfee008dc63a');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'e12ade90aabd467aba97b48bf0919c42' , '27e75711b04a4b55a738d9c3ead4c52b');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'ce3cfb8f56ed4437b3f6d11bb13b81b1' , '391ba76c5ecf4520af9061a85742533a');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'ce3cfb8f56ed4437b3f6d11bb13b81b1' , '89fbfd4b6db246128f57eb29aeeb1a94');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '55bbcd3d108a46c5bca34300d82e52c5' , '391ba76c5ecf4520af9061a85742533a');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '55bbcd3d108a46c5bca34300d82e52c5' , '89fbfd4b6db246128f57eb29aeeb1a94');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '846a339de16943eb9cba6cf74430d6e9' , '391ba76c5ecf4520af9061a85742533a');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '846a339de16943eb9cba6cf74430d6e9' , '89fbfd4b6db246128f57eb29aeeb1a94');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '271e2ec877b04ca6a97d3801018d3b44' , '21201deafd084a3982340dbf8d210d41');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '271e2ec877b04ca6a97d3801018d3b44' , 'f3e2f53d82354b4d959cf94399b40db4');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'b2d356c20dea4fd5b73c5ede37ea2a46' , '21201deafd084a3982340dbf8d210d41');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'b2d356c20dea4fd5b73c5ede37ea2a46' , 'f3e2f53d82354b4d959cf94399b40db4');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '488eb110000349029a0774c7b7fcd199' , '21201deafd084a3982340dbf8d210d41');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( '488eb110000349029a0774c7b7fcd199' , 'f3e2f53d82354b4d959cf94399b40db4');
INSERT INTO public.pokemonsabilities (  pokemon_id, ability_id) VALUES ( 'f133d2f2b4c84acbb8326d7f2a2a28ad' , '27e75711b04a4b55a738d9c3ead4c52b');

/* PokemonTypes */
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('b75c1e05d2b14c67b280f66a013f7be4' , '463d712daa1b45fab7157d1599677b62' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('b75c1e05d2b14c67b280f66a013f7be4' , 'c5d91ec0aedc499f91cdda0b3845d1a9' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('41dd053b3f3e4ee582ff7d8cc3fdc7c6' , '463d712daa1b45fab7157d1599677b62' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('41dd053b3f3e4ee582ff7d8cc3fdc7c6' , 'c5d91ec0aedc499f91cdda0b3845d1a9' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('e12ade90aabd467aba97b48bf0919c42' , '463d712daa1b45fab7157d1599677b62' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('e12ade90aabd467aba97b48bf0919c42' , 'c5d91ec0aedc499f91cdda0b3845d1a9' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('ce3cfb8f56ed4437b3f6d11bb13b81b1' , '1c794cac1ccb486ba9e2c97b0f44f6f6' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('55bbcd3d108a46c5bca34300d82e52c5' , '1c794cac1ccb486ba9e2c97b0f44f6f6' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('846a339de16943eb9cba6cf74430d6e9' , '1c794cac1ccb486ba9e2c97b0f44f6f6' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('846a339de16943eb9cba6cf74430d6e9' , '1ab653b02760477294cc2678f3a17019' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('271e2ec877b04ca6a97d3801018d3b44' , '32fffed6da7d4bb4a5441bb4dda097eb' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('b2d356c20dea4fd5b73c5ede37ea2a46' , '32fffed6da7d4bb4a5441bb4dda097eb' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('488eb110000349029a0774c7b7fcd199' , '32fffed6da7d4bb4a5441bb4dda097eb' );
INSERT INTO public.pokemonstypes (pokemon_id, type_id) VALUES ('f133d2f2b4c84acbb8326d7f2a2a28ad' , '74c70a2d9485460eb0b0a28a8ca774a0' );

