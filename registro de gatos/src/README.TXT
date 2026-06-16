------------------------------------------------------------------------
Este é o arquivo README do projeto.
------------------------------------------------------------------------

TÍTULO DO PROJETO: Registro de Gatos
OBJETIVO DO PROJETO: Gerenciar o cadastro (CRUD) de gatos salvando informações em um banco de dados SQLite por meio do ORMLite e exibindo-as em uma interface gráfica JavaFX.
VERSÃO ou DATA: Versão 1.0 (16/06/2026)
COMO INICIAR O PROJETO:
  1. Pelo BlueJ:
     - Abra a pasta "src" como um projeto.
     - Clique com o botão direito na classe controller.AppController e execute o método "main".
  2. Pelo Terminal (Linux):
     - Certifique-se de compilar o projeto primeiro:
       javac --module-path /usr/lib/jvm/openjfx --add-modules javafx.controls,javafx.fxml -cp "src/libs/*:src" src/model/*.java src/view/*.java src/controller/*.java
     - Depois, execute com o comando:
       LD_PRELOAD=/usr/lib64/libstdc++.so.6 java -Djava.library.path=/usr/lib/jvm/openjfx --module-path /usr/lib/jvm/openjfx --add-modules javafx.controls,javafx.fxml -cp "src/libs/*:src" controller.AppController

AUTORES: Bruno Barreto
INSTRUÇÕES PARA O USUÁRIO:
  - Para adicionar um novo gato: clique no botão "Adicionar", digite os dados nos campos de texto (Nome, Data de Nascimento, Brinquedo Favorito) e clique em "Salvar".
  - Para editar ou excluir: selecione a linha do gato correspondente na tabela. Faça as alterações desejadas nos campos e clique em "Atualizar", ou clique em "Deletar" para excluí-lo do banco de dados.
  - Para cancelar a operação atual: clique em "Cancelar" a qualquer momento para limpar os campos e desmarcar a seleção na tabela.
