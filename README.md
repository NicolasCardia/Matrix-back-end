# Atech Desafio encontrar a área do maior retângulo

## Desafio
Desenvolva um backend que receba uma matriz binária 2D de tamanho MxN preenchida com “0” (zero) e “1” (um) em JSON, e retorne o valor da área do maior retângulo formado apenas por “1”.

## Comando para instalar dependências
```
mvn clean install
```

## Comando para rodar o código
```
mvn spring-boot:run
```

## Considerações finais
Configurei o back-end para receber requisições HTTP POST no endpoint /rectangle, onde a matriz binária é enviada como um JSON no corpo da requisição. O serviço processa a matriz e retorna a área do maior retângulo formado por '1's. Utilizei a lógica de processamentos de histogramas e pilhas para conseguir encontrar e calcular a área do retângulo. 

Para testar a API, você pode usar ferramentas como Postman ou insomnia

## Curl
```
curl -X POST http://localhost:8080/rectangle -H "Content-Type: application/json" -d '{
  "matrix": [
    [1, 0, 1, 0, 0],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 1, 1],
    [1, 0, 0, 1, 0]
  ]
}'
```
* Não esqueça de estar o rodando o projeto para poder testar a api localmente
