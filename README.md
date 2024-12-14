# CurrencyConverter

Este é um projeto Java desenvolvido no NetBeans para conversão de moedas utilizando a API **ExchangeRate-API** para obter as taxas de câmbio atualizadas. O objetivo é oferecer uma ferramenta simples e eficiente para converter valores entre diferentes moedas.

## 🚀 Funcionalidades

- Conversão entre diferentes moedas em tempo real.
- Interface amigável para entrada e exibição de dados.
- Suporte para múltiplas moedas disponíveis na API.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **NetBeans IDE**: Ambiente de desenvolvimento integrado.
- **ExchangeRate-API**: Serviço de API para obter taxas de câmbio.
- **Gson**: Biblioteca para manipulação de JSON.

## 📦 Estrutura do Projeto
```
CurrencyConverter/
├── src/
│   ├── main/
│   │    └── java/
│   │        └── currencyconverter/
│   │            ├── CurrencyConverter.java  // Classe principal
│   │            └── Requisicao.java // Lógica de conversão e comunicação com a API
|   └── resources/
|       └── config.properties
├── README.md         // Documentação do projeto
└── .gitignore        // Configurações de exclusão do Git
```

## 📝 Pré-requisitos

1. **NetBeans IDE** instalado.
2. **JDK 8+** configurado.
3. Conta e chave de API no [ExchangeRate-API](https://www.exchangerate-api.com/).

## ⚙️ Configuração

1. Clone o repositório:

```bash
git clone https://github.com/CoracaoDeLeao/CurrencyConverter.git
cd CurrencyConverter
```

2. No arquivo `config.properties`, configure sua chave de API:

```properties
API_KEY=YOUR_API_KEY
```

## 💻 Como Executar

1. Abra o projeto no **NetBeans**.
2. Compile o projeto.
3. Execute a aplicação.
4. Insira os valores e selecione as moedas para conversão.

## 🌐 Exemplo de Uso
[![image.png](https://i.postimg.cc/qB3Q28V2/image.png)](https://postimg.cc/0r9psKNN)
[![image.png](https://i.postimg.cc/j5Xx1DBc/image.png)](https://postimg.cc/DJS3Jwv4)

## 📚 Referências

- [ExchangeRate-API](https://www.exchangerate-api.com/)
- [Documentação da Biblioteca Gson](https://github.com/google/gson)
  
---

✨ Desenvolvido por [Isaac](https://github.com/CoracaoDeLeao).
