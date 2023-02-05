# Integração Via Cep
Um breve projeto Java que realiza uma integração com o ViaCep https://viacep.com.br/ 

## 🚀 Começando

Para utilizar este projeto basta clonar o respositório disponível.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

Java Development Kit 11 (https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) 
Apache Maven 3.8.6 (https://maven.apache.org/download.cgi) 
Apache Netbeans (https://netbeans.apache.org/download/index.html)

## 📦 Implantação
Para implantar o sistema basta clonar o mesmo e contruí-lo no netbeans e depois adicionálo como .jar no seu projeto. 
Um exemplo de utilização está abaixo:

ApiCep apiCep = new ApiCep();
ObjetoResposta objetoResposta = apiCep.buscaCep(jFormattedTextFieldCep.getText());
jTextFieldRua.setText(objetoResposta.getLogradouro());
jTextFieldBairro.setText(objetoResposta.getBairro());
jTextFieldUf.setText(objetoResposta.getUf());
jTextFieldNumeroEndereco.requestFocus();
jTextFieldDDD.setText(objetoResposta.getDdd());

## ✒️ Autores
Murilo Nunes dos Santos
