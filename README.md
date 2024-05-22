# Getting Started

## Requirements
- Kotlin(java 17) + SpringWebFlux + Mysql
- The certificate.pem and private_key.pem is located in the resources folder
- Use the lib JOSE (Java Object Signing and Encryption) - org.bitbucket.b_c:jose4j:0.9.6
1. =================
- A get endpoint must be created where a url parameter called {id} will be accepted.
The corresponding record must be retrieved from the database and the response must be encrypted.
- If the record does not exist according to the id passed, a RegisterNotFound exception must be returned, with 404 http code.
- Encryption Details:
  - JWE shall use the "A256GCM" content encryption algorithm.
  - Generate X.509 SHA-256 certificate fingerprint and use as 'kid'
  - JWE must use the `zip` header to indicate the compression algorithm
  - The only supported compression algorithm is `DEF` (deflate)
- Response example:
- {"encryptData":"eyJhbGciOiJSU0EtT0FFUC0yNTYiLCJlbmMiOiJBMjU2R0NNIiwiemlwIjoiREVGIiwia2lkIjoiei9YKzhxak5wOVZpOWdlWG5IdGZtcWZURUtIaVZSWHZIZU9GQ2puNWhzYz0ifQ.HeO73JKClnGO90sJJnz_SmWp1wLl1AesbHeeOraDjihrecF3hjcaely50lYP9ZByj63cX8FIaaRegRVRA2kx5UrPyGCfZulO0fjEVQEzEKGsiBCmNu1fKQ9lz5VSN3OUG6DCYSmjxqSlsPC808isFn1i9UYNdPAa2OIeXiuKF-KWpDAbD_WVlPQ8bJ1brfSr-F7oVJwFPh4LXb1IyTQzbaz-6TbYIzaAUWf7rqW3Mq0-bQVqtg2FGAQw0sLZoDY4hkgaN2sMm8yDAU8HSeZjfiwil4DX9hoj8BQVkAeo5eTfk45BZkZxqJT_qJI6Noa-ONTgqn59EDX5o0BHx-9exQ.ft01FcrDicMl2IdX.QN-4VacgPG6a8z1AxN_YRAvmkKngR9OpZI0pSTNlxx7ljklH5vwD8Ya658KOUunrpMsSZdfh5OyhrbNdfdTx.dq7vYfc_9Dpyj3tF_IynJw"}
2. =================
- A post endpoint(/decrypt-user-data) must be created that must receive the encrypted value via request json body, exactly as per the get endpoint response.
  Decryption must be applied and the data returned clean, as shown below.
Response example:
- {"id": 1, "login": "joaquim.silva@gmail.com","name": "Joaquim da Silva"}



## Docker
docker container run --name db_challenge -e MYSQL_ROOT_PASSWORD=db_challenge -e MYSQL_DATABASE=db_challenge -d -p 3306:3306 mysql:latest

## Script
CREATE TABLE `tb_user` (
`id` bigint NOT NULL AUTO_INCREMENT,
`login` varchar(255) NOT NULL,
`name` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

## Preload
INSERT INTO tb_user (login, name) VALUES('joaquim.silva@gmail.com', 'Joaquim da Silva');

